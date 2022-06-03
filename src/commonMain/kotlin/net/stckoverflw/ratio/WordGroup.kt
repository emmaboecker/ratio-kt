package net.stckoverflw.ratio

import kotlin.jvm.JvmInline

@JvmInline
public value class WordGroup(public val value: Set<Word>) {
    override fun toString(): String = value.joinToString("+") { word ->
        buildString {
            if (value.indexOf(word) != 0) {
                append(' ')
            }
            append(word.value)
            if (!word.value.endsWith("\n")) {
                append(' ')
            }
        }
    }

    public operator fun plus(word: Word): WordGroup = WordGroup(value + word)
    public operator fun plus(group: WordGroup): WordGroup = WordGroup(value + group.value)

    public operator fun div(other: Word): WordGroup = Word("$value\n") + other
    public operator fun div(other: WordGroup): WordGroup = Word("$value\n") + other
}
