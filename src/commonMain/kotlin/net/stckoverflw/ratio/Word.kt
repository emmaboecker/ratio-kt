package net.stckoverflw.ratio

import kotlin.jvm.JvmInline

public interface Word {
    public val value: String

    public operator fun plus(word: Word): WordGroup = WordGroup(setOf(this, word))

    public operator fun plus(group: WordGroup): WordGroup = WordGroup(setOf(this) + group.value)

    public operator fun div(other: Word): WordGroup = Word("$value\n") + other
    public operator fun div(other: WordGroup): WordGroup = Word("$value\n") + other
}

public fun Appendable.append(word: Word): Appendable = append(word.toString())
public fun Appendable.append(word: WordGroup): Appendable = append(word.toString())

public fun Word(value: String): Word = LiteralWord(value)

@JvmInline
private value class LiteralWord(override val value: String) : Word {
    override fun toString(): String = value
}
