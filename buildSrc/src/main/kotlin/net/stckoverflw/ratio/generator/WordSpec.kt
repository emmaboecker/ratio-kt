package net.stckoverflw.ratio.generator

interface WordSpec {
    val word: String
}

data class LiteralWordSpec(override val word: String) : WordSpec

data class ChainedWordSpec(override val word: String, val children: List<WordSpec>) : WordSpec
