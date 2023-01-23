![](art/header.png)

# Spotify Compose (:construction:work in progres :construction:)
 Spotify UI built with Jetpack Compose. Warning navigation extension functions used in this project is deprecated. More powerfull and valid way descripted in navigationBooster project: (https://github.com/droidbaza/NavigationBooster) 

# Try now

[![SpotifyCompose](https://github.com/droidbaza/SpotifyCompose/blob/master/app/src/main/res/mipmap-hdpi/ic_launcher.png)](https://github.com/droidbaza/SpotifyCompose/raw/master/app/release/app-release.apk)
👈 click to download :rocket::rocket::rocket:

# Preview
![SpotifyCompose](art/preview.gif)

## :fire::fire::fire: Useful extensions


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

