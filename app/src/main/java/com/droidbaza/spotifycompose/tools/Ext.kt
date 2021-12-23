/*
 *  Created by droidbaza on 23.12.2021
 *
 *  Copyright (c) 2021 . All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.droidbaza.spotifycompose.tools

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.palette.graphics.Palette
import kotlinx.coroutines.delay

object Ext {

    inline fun Bitmap.dominantColor(crossinline color: (Color) -> Unit): Int {
        Palette.Builder(this).generate {
            it?.let { palette ->
                val dominantColor = palette.getDominantColor(0)
                color(Color(dominantColor))
            }
        }
        return 1
    }

    inline fun Bitmap.vibrantColor(crossinline color: (Color) -> Unit): Int {
        Palette.Builder(this).generate {
            it?.let { palette ->
                val dominantColor = palette.getVibrantColor(0)
                color(Color(dominantColor))
            }
        }
        return 1
    }

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


    @SuppressLint("UnnecessaryComposedModifier")
    fun Modifier.clickableResize(
        onClick: () -> Unit
    ): Modifier = composed {
        val state = remember { mutableStateOf(1f) }
        this
            .scale(state.value)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        onClick()
                    },
                    onPress = {
                        state.value = 0.95f
                        delay(50)
                        state.value = 1f
                    }
                )
            }

    }

    private fun Modifier.changeSize(resize: Boolean = false, minScale: Float) {
        Log.d("CLICKKK", "changed $resize")
        val scaleResize = if (resize) {
            minScale
        } else {
            1f
        }
        this.scale(scaleResize)
    }


    fun Modifier.round(
        percent: Int = 0
    ): Modifier {
        return this.clip(RoundedCornerShape(percent = percent))
    }

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


    @Composable
    fun LazyListState.offsetY(contentHeight: Dp): Dp {
        return if (firstVisibleItemIndex != 0) {
            contentHeight
        } else with(LocalDensity.current) { firstVisibleItemScrollOffset.toDp() }
    }

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

    fun NavHostController.isLifecycleResumed() =
        this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
}