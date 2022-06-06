@file:Suppress("ObjectPropertyName","ClassName","DANGEROUS_CHARACTERS")

package net.stckoverflw.ratio

import kotlin.Suppress
import kotlin.js.JsName

public val L: Word = Word("L")

public val basic: Word = Word("basic")

public val triggered: Word = Word("triggered")

public val donowalled: Word = Word("donowalled")

@JsName("youre")
public val `you're*`: Word = Word("you're*")

public val reported: Word = Word("reported")

@JsName("GG")
public val `GG!`: Word = Word("GG!")

public val cancelled: Word = Word("cancelled")

public val lol: Word = Word("lol")

public val irrelevant: Word = Word("irrelevant")

public val cope: Word = Word("cope")

public val jealous: Word = Word("jealous")

@JsName("dont")
public object `don't` : ChainableWord("don't") {
  public val care: Word = Word("care")

  public val swear: Word = Word("swear")
}

@JsName("didnt")
public object `didn't` : ChainableWord("didn't") {
  public val ask: Word = Word("ask")
}

public object cry : ChainableWord("cry") {
  public object about : ChainableWord.InnerChainedWord("about") {
    public val it: Word = Word("it")
  }
}

public object stay : ChainableWord("stay") {
  public val mad: Word = Word("mad")
}

public object mald : ChainableWord("mald") {
  public object seethe : ChainableWord.InnerChainedWord("seethe") {
    public object cope : ChainableWord.InnerChainedWord("cope") {
      public val harder: Word = Word("harder")
    }
  }
}

public object hoes : ChainableWord("hoes") {
  public val mad: Word = Word("mad")
}

public object skill : ChainableWord("skill") {
  public val issue: Word = Word("issue")
}

public object ratio : ChainableWord("ratio") {
  public val again: Word = Word("again")
}

public object you : ChainableWord("you") {
  public object fell : ChainableWord.InnerChainedWord("fell") {
    public val off: Word = Word("off")
  }
}

public object the : ChainableWord("the") {
  public val audacity: Word = Word("audacity")
}

public object any : ChainableWord("any") {
  public val askers: Word = Word("askers")
}

public object `get` : ChainableWord("get") {
  public val good: Word = Word("good")

  public object a : ChainableWord.InnerChainedWord("a") {
    public val life: Word = Word("life")
  }
}

public object ok : ChainableWord("ok") {
  @JsName("and")
  public val `and?`: Word = Word("and?")
}

public object cringe : ChainableWord("cringe") {
  public val again: Word = Word("again")
}

public object touch : ChainableWord("touch") {
  public val grass: Word = Word("grass")
}

public object not : ChainableWord("not") {
  public val based: Word = Word("based")

  public object funny : ChainableWord.InnerChainedWord("funny") {
    @JsName("didnt")
    public object `didn't` : ChainableWord.InnerChainedWord("didn't") {
      public val laugh: Word = Word("laugh")
    }
  }
}

public object go : ChainableWord("go") {
  public val outside: Word = Word("outside")
}

public object ask : ChainableWord("ask") {
  public val deez: Word = Word("deez")
}

public object ez : ChainableWord("ez") {
  public val clap: Word = Word("clap")
}

public object straight : ChainableWord("straight") {
  public val cash: Word = Word("cash")
}

public object rip : ChainableWord("rip") {
  public val bozo: Word = Word("bozo")
}
