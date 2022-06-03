package net.stckoverflw.ratio

import kotlin.js.JsName

public inline val youReStar: Word get() = `you're*`

@JsName("ggAlias")
public inline val GG: Word get() = `GG!`

@JsName("dontAlias")
public inline val dont: `don't` get() = `don't`
@JsName("didntAlias")
public inline val didnt: `didn't` get() = `didn't`

@Suppress("unused")
public inline val not.funny.didnt: not.funny.`didn't` get() = not.funny.`didn't`

public inline val ok.and: Word get() = `and?`
