package net.stckoverflw.ratio

public interface Word {
    public val value: String

    public operator fun plus(word: Word): WordGroup = WordGroup(setOf(this, word))

    public operator fun plus(group: WordGroup): WordGroup = WordGroup(setOf(this) + group.value)
}

public fun Word(value: String): Word = LiteralWord(value)

@JvmInline
private value class LiteralWord(override val value: String) : Word {
    override fun toString(): String = value
}
