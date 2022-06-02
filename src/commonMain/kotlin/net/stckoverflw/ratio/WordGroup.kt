package net.stckoverflw.ratio

@JvmInline
public value class WordGroup(public val value: Set<Word>) {
    override fun toString(): String = value.joinToString(" + ")

    public operator fun plus(word: Word): WordGroup = WordGroup(value + word)
    public operator fun plus(group: WordGroup): WordGroup = WordGroup(value + group.value)
}