package net.stckoverflw.ratio.generator

interface WordSpec

data class LiteralWordSpec(val word: String) : WordSpec

data class ChainedWordSpec(val word: String, val children: List<WordSpec>) : WordSpec
