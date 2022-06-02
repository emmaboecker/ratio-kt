package net.stckoverflw.ratio.generator

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import java.nio.file.Path
import java.sql.Types

private val WORD = ClassName("net.stckoverflw.ratio", "Word")
private val CHAINABLE_WORD = ClassName("net.stckoverflw.ratio", "ChainableWord")
private val INNER_CHAINED_WORD = CHAINABLE_WORD.nestedClass("InnerChainedWord")

fun List<WordSpec>.generateTo(path: Path) {
    val supressInspections = listOf("ObjectPropertyName", "ClassName", "DANGEROUS_CHARACTERS")
    val format = "%S,".repeat(supressInspections.size).trimEnd(',')
    val file = FileSpec.builder("net.stckoverflw.ratio", "Words")
        .addAnnotation(AnnotationSpec.builder(Suppress::class)
            .addMember(format, *supressInspections.toTypedArray())
            .build())
        .addWords(this)
        .build()

    file.writeTo(path)
}

private fun FileSpec.Builder.addWords(wordSpecs: List<WordSpec>): FileSpec.Builder {
    val (variables, objects) = wordSpecs.partition { it is LiteralWordSpec }
    variables.forEach {
        addLiteral(it as LiteralWordSpec)
    }
    objects.forEach {
        addChained(it as ChainedWordSpec)
    }

    return this
}

private fun TypeSpec.Builder.addWords(wordSpecs: List<WordSpec>): TypeSpec.Builder {
    val (variables, objects) = wordSpecs.partition { it is LiteralWordSpec }
    variables.forEach {
        addLiteral(it as LiteralWordSpec)
    }
    objects.forEach {
        addChained(it as ChainedWordSpec)
    }

    return this
}

private fun FileSpec.Builder.addChained(wordSpec: ChainedWordSpec) {
    val clazz = TypeSpec.objectBuilder(wordSpec.word)
        .superclass(CHAINABLE_WORD)
        .addSuperclassConstructorParameter("""%S""", wordSpec.word)
        .addWords(wordSpec.children)
        .build()
    addType(clazz)
}

private fun TypeSpec.Builder.addChained(wordSpec: ChainedWordSpec) {
    val clazz = TypeSpec.objectBuilder(wordSpec.word)
        .superclass(INNER_CHAINED_WORD)
        .addWords(wordSpec.children)
        .addSuperclassConstructorParameter("""%S""", wordSpec.word)
        .build()
    addType(clazz)
}

private fun FileSpec.Builder.addLiteral(wordSpec: LiteralWordSpec) = addProperty(wordSpec.toProperty())
private fun TypeSpec .Builder.addLiteral(wordSpec: LiteralWordSpec) = addProperty(wordSpec.toProperty())

private fun LiteralWordSpec.toProperty() = PropertySpec.builder(word, WORD)
    .initializer("""Word("${word}")""")
    .build()