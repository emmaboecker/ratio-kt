package net.stckoverflw.ratio

public sealed class ChainableWord(final override val value: String) : Word {

    override fun toString(): String = value

    public abstract inner class InnerChainedWord(myValue: String) : ChainableWord("$value $myValue")

    protected fun Word(name: String): Word = net.stckoverflw.ratio.Word("$value $name")
}