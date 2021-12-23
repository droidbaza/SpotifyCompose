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

package com.droidbaza.spotifycompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.tools.Ext.vibrantColor



@Composable
fun SearchGradientCard(
    image: Int? = null,
    title: String = "Title",
    onClick: () -> Unit = {}
) {
    val res = image ?: R.drawable.album
    val context = LocalContext.current
    val stateColors: MutableState<Color> =
        remember(res) { mutableStateOf(Color.Transparent) }

    val imageBitmap = remember(res) {
        ImageBitmap.imageResource(context.resources, res).asAndroidBitmap()
    }

    remember(res) {
        imageBitmap.vibrantColor { stateColors.value = it }
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickableResize(onClick)
            .height(90.dp)
            .round(8.dp)
            .clipToBounds()
            .background(stateColors.value),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextTitle(
            text = title,
            modifier = Modifier
                .padding(10.dp)
                .weight(1f),
            color = Color.White,
        )
        ImageCrop(
            data = res,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.Bottom)
                .graphicsLayer(translationX = 60f, rotationZ = 32f, shadowElevation = 15f)
        )
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun SearchGradientPreview() {
    SearchGradientCard()
}