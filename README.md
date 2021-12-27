![](art/header.png)

# Spotify Compose (:construction:work in progres :construction:)
 Spotify UI built with Jetpack Compose.

# Try now

[![SpotifyCompose](https://github.com/droidbaza/SpotifyCompose/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png)](https://github.com/droidbaza/SpotifyCompose/raw/master/app/release/app-release.apk)
👈 click to download :rocket::rocket::rocket:

# Preview
![SpotifyCompose](art/preview.gif)

## :fire::fire::fire: Useful extensions

```kotlin
/**
 * putting and getting args for navHostController.
 */
 fun <T : Any> NavHostController.putArgs(args: Pair<String, T>) {
        val key = args.first
        val value = args.second
        currentBackStackEntry?.arguments?.apply {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Short -> putShort(key, value)
                is Long -> putLong(key, value)
                is Byte -> putByte(key, value)
                is ByteArray -> putByteArray(key, value)
                is Char -> putChar(key, value)
                is CharArray -> putCharArray(key, value)
                is CharSequence -> putCharSequence(key, value)
                is Float -> putFloat(key, value)
                is Bundle -> putBundle(key, value)
                // is Serializable -> putSerializable(key, value)
                is Parcelable -> putParcelable(key, value)
                else -> throw IllegalStateException("Type ${value.javaClass.canonicalName} is not supported now")
            }
        }
    }
    
inline fun <reified T : Any> NavHostController.getArgs(tag: String): T? {
    return try {
        previousBackStackEntry?.arguments?.get(tag) as T?
    } catch (ex: Exception) {
        null
    }
}
```

```kotlin
/**
 * rounding.
 */
fun Modifier.round(
        radius: Dp? = null,
        percent: Int = 0
    ): Modifier {
        return if (radius != null) {
            this.clip(RoundedCornerShape(radius))
        } else {
            this.clip(RoundedCornerShape(percent))
        }
    }
    
fun Modifier.round(
        percent: Int = 0
    ): Modifier {
        return this.clip(RoundedCornerShape(percent = percent))
    }
```

```kotlin
/**
 * change color.
 */
fun Modifier.color(
        colorHex: Int = 0
    ): Modifier {
        return this.background(Color(colorHex))
    }

fun Modifier.color(
        color: Color = Color.Transparent
    ): Modifier {
        return this.background(color)
    }
```

```kotlin
/**
 * gradient color.
 */
 enum class GradientType {
        HORIZONTAL, VERTICAL, LINEAR, RADIAL, SWEEP
    }
    
 fun Modifier.gradient(
        colors: List<Color>,
        gradientType: GradientType = GradientType.LINEAR
    ): Modifier {
        return this.background(
            brush = when (gradientType) {
                GradientType.HORIZONTAL -> {
                    Brush.horizontalGradient(colors = colors)
                }
                GradientType.VERTICAL -> {
                    Brush.verticalGradient(colors = colors)
                }
                GradientType.LINEAR -> {
                    Brush.linearGradient(colors = colors)
                }
                GradientType.RADIAL -> {
                    Brush.radialGradient(colors = colors)
                }
                GradientType.SWEEP -> {
                    Brush.sweepGradient(colors = colors)
                }
            }
        )
    }
```

