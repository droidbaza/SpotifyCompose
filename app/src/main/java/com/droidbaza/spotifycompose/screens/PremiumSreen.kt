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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.components.ImageCrop
import com.droidbaza.spotifycompose.components.PremiumCard
import com.droidbaza.spotifycompose.components.TextTitle
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.gradient
import com.droidbaza.spotifycompose.tools.Ext.offsetY
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.tools.GradientTypeVertical
import com.droidbaza.spotifycompose.ui.theme.Primary


@Composable
fun PremiumScreen(paddingValues: PaddingValues = PaddingValues()) {
    val contentHeight = 320.dp
    val scrollState = rememberLazyListState()
    val offsetY = scrollState.offsetY(contentHeight)
    val alpha = 1f - offsetY.value / contentHeight.value
    val imageScale = if (alpha <= 0.5) {
        1f
    } else {
        alpha + 0.5f
    }

    LazyColumn(
        state = scrollState,
        contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding())
    ) {
        item {
            Box(
                modifier = Modifier
                    .height(contentHeight)
                    .alpha(alpha),
                contentAlignment = Alignment.BottomStart
            ) {
                ImageCrop(
                    modifier = Modifier
                        .fillMaxSize()
                        .clipToBounds()
                        .scale(imageScale),
                    data = R.drawable.premium_image
                )
                Column(
                    Modifier.gradient(
                        listOf(Color.Transparent, Primary),
                        GradientTypeVertical()
                    )
                ) {
                    Surface(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Color(0x33FFFFFF)
                    ) {
                        Row(
                            modifier = Modifier.padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                Modifier
                                    .padding(end = 8.dp)
                                    .size(8.dp)
                                    .round(100)
                                    .color(Color(0xFF0780BB))
                            )
                            TextTitle(
                                "LIMITED TIME OFFER",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }
                    }

                    TextTitle(
                        "Get 3 months of Premium for free",
                        modifier = Modifier.padding(8.dp),
                        maxLines = 2
                    )
                }

            }
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .round(100)
                    .color(Color.White)
                    .padding(14.dp),
                textAlign = TextAlign.Center,
                text = "GET 3 MONTHS FREE",
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
        items(5) {
            PremiumCard()
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .height(30.dp)
            .alpha(alpha)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_premium),
            contentDescription = null,
            tint = Color.White
        )
        TextTitle(
            text = "Premium",
            fontSize = 13.sp,
            modifier = Modifier.padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun PremiumScreenPreview() {
    PremiumScreen()
}