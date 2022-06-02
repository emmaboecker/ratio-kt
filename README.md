# Ratio-Kt
ratio + don't care, in your kotlin code

## Installation
Add this to your `build.gradle.kts`
```kotlin
repositories {
    mavenCentral()
    maven("https://maven.stckoverflw.net/releases")
}
```

```kotlin
dependencies {
    implementation("net.stckoverflw", "ratio-kt", "1.0")
}
```

## Usage

Here's an example on how to use this really useful library
```kotlin
import net.stckoverflw.ratio.didnt
import net.stckoverflw.ratio.dont
import net.stckoverflw.ratio.ratio

fun main() {
    println(ratio + dont.care + didnt.ask)
}
```

The Output of this would be: 
```text
ratio + don't care + didn't ask
```

You can find all supported "word groups"/"phrases" in [words.txt](https://github.com/StckOverflw/ratio-kt/blob/main/words.txt)

### Credit
Thanks to [DrSchlaubi](https://github.com/DrSchlaubi/) for making the Kotlin code generator, 
without him I'd have to implement all the "phrases" myself!
