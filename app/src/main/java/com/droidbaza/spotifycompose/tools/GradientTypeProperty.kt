/*
 *  Created by droidbaza on 29.12.2021
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

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Created by tfakioglu on 29.December.2021
 */
interface GradientTypeProperty {
    fun getGradientType(colors: List<Color>): Brush
}

class GradientTypeHorizontal(): GradientTypeProperty {
    override fun getGradientType(colors: List<Color>): Brush = Brush.horizontalGradient(colors = colors)
}

class GradientTypeVertical(): GradientTypeProperty {
    override fun getGradientType(colors: List<Color>): Brush = Brush.verticalGradient(colors = colors)
}

class GradientTypeLinear(): GradientTypeProperty {
    override fun getGradientType(colors: List<Color>): Brush = Brush.linearGradient(colors = colors)
}

class GradientTypeRadial(): GradientTypeProperty {
    override fun getGradientType(colors: List<Color>): Brush = Brush.radialGradient(colors = colors)
}

class GradientTypeSweep(): GradientTypeProperty {
    override fun getGradientType(colors: List<Color>): Brush = Brush.sweepGradient(colors = colors)
}