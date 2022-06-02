package net.stckoverflw.ratio.generator

import java.nio.file.Path
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

private val wordGroupRegex = "[a-zA-Z'*!?]+".toRegex()

abstract class GenerateTask : DefaultTask() {
    @get:Input
    abstract val words: ListProperty<String>

    @get:OutputDirectory
    abstract val output: Property<Path>

    @TaskAction
    fun generate() {
        val result = words.get().asSequence()
            .map {
                wordGroupRegex.findAll(it).map(MatchResult::value).toList()
            }
            .asIterable()
            .groupByFirst()
            .toList()

        result.generateTo(output.get())
    }
}

private fun Iterable<List<String>>.groupByFirst(): List<WordSpec> = groupBy {
    it[0]
}.mapValues {
    it.value.mapNotNull { child ->
        if (child.size == 2) {
            LiteralWordSpec(child[1])
        } else {
            child.drop(1).ifEmpty { null }?.let { newList ->
                listOf(newList).groupByFirst()
            }
        }
    }
}.map {
    if (it.value.isEmpty()) {
        LiteralWordSpec(it.key)
    } else {
        ChainedWordSpec(it.key, it.value.flatMap {
            if (it is List<*>) {
                it.map { it as WordSpec }
            } else {
                listOf(it as WordSpec)
            }
        })
    }
}
