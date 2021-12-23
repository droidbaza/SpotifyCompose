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

package com.droidbaza.spotifycompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.components.*
import com.droidbaza.spotifycompose.components.core.TopBar
import com.droidbaza.spotifycompose.tools.Ext
import com.droidbaza.spotifycompose.tools.Ext.gradient
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.tools.Sizes.MEDIUM

const val DEFAULT_DESCRIPTION =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

@Composable
fun PlayerFullScreen() {
    val scrollState = rememberScrollState()
    val sliderPosition = remember { mutableStateOf(0f) }
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .gradient(
                listOf(Color.Red, Color.Transparent, Color.Transparent),
                Ext.GradientType.VERTICAL
            )
    ) {
        TopBar(
            navigationIcon = {
                IconBtn(resIcon = R.drawable.ic_down)
            },
            title = {
                Column(
                    modifier = Modifier.weight(2f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "playlist", color = Color.White)
                    TextTitle(text = "AUTHOR", fontSize = 18.sp)
                }
            },
            actions = {
                IconBtn(resIcon = R.drawable.ic_dots)
            }
        )
        Column(Modifier.padding(horizontal = 22.dp)) {
            ImageCrop(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 60.dp)
                    .height(300.dp),
                data = R.drawable.album
            )

            TextTitle()
            TextSubtitle()

            Slider(
                modifier = Modifier
                    .padding(top = MEDIUM)
                    .height(25.dp),
                colors = customSliderColors(),
                value = sliderPosition.value,
                onValueChange = {
                    sliderPosition.value = it
                },
            )
            Row(
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(text = "0:00", color = Color.White, fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(2f))
                Text(text = "3:00", color = Color.White, fontSize = 12.sp)
            }
            PlayerFull()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconBtn(resIcon = R.drawable.ic_sound)
                Spacer(modifier = Modifier.weight(2f))
                IconBtn(resIcon = R.drawable.ic_baseline_share_24)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 80.dp)
                    .round(8.dp)
                    .background(Color.Red)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Text",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White,
                )
                Text(
                    text = DEFAULT_DESCRIPTION,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    maxLines = 8,
                    modifier = Modifier.padding(vertical = 20.dp)
                )


                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .align(Alignment.End),
                    contentColor = Color.Transparent,
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.LightGray
                    ),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_share_24),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = "SHARE",
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun customSliderColors(): SliderColors = SliderDefaults.colors(
    inactiveTrackColor = Color(0x337C7C7C),
    activeTrackColor = Color.White,
    thumbColor = Color.White
)

@Composable
@Preview
fun PlayerFullScreenPreview() {
    PlayerFullScreen()
}