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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.components.*
import com.droidbaza.spotifycompose.components.core.BaseRaw
import com.droidbaza.spotifycompose.components.core.TopBar
import com.droidbaza.spotifycompose.components.core.VerticalGrid
import com.droidbaza.spotifycompose.repository.DataProvider
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.offsetY
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.tools.Sizes
import com.droidbaza.spotifycompose.tools.Sizes.MEDIUM
import com.droidbaza.spotifycompose.ui.theme.Active

@Composable
fun DetailsScreen(paddingValues: PaddingValues = PaddingValues()) {
    val tracks = remember {
        DataProvider.itemsBy(3)
    }
    val albums = remember {
        DataProvider.itemsBy(6)
    }

    val playPadding = 25.dp
    val contentHeight = 350.dp
    val scrollState = rememberLazyListState()
    val offsetY = scrollState.offsetY(contentHeight)
    val alpha = 1f - offsetY.value / contentHeight.value

    val offset = contentHeight - offsetY
    val playOffset = if (offset < playPadding) {
        playPadding
    } else {
        offset
    }
    LazyColumn(
        state = scrollState,
        modifier = Modifier.padding(
            top = 50.dp,
            start = 20.dp,
            end = 10.dp
        ),
        contentPadding = PaddingValues(
            bottom = paddingValues.calculateBottomPadding()
        )
    ) {
        item {
            Column(
                modifier = Modifier
                    .height(contentHeight)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Bottom
            ) {
                ImageCrop(
                    modifier = Modifier
                        .size(180.dp)
                        .alpha(alpha)
                        .scale(alpha)
                        .align(Alignment.CenterHorizontally),
                    data = R.drawable.album
                )
                TextTitle(text = "Title")
                TextSubtitle(text = "SUBTITLE", fontSize = 20.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconBtn(resIcon = R.drawable.ic_h_outline)
                    IconBtn(resIcon = R.drawable.ic_dots, tint = Color.Gray)
                    Spacer(modifier = Modifier.weight(2f))
                }
            }
        }
        items(tracks) {
            BaseRaw(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MEDIUM)
                    .clickableResize {},
                imageSize = 50.dp,
                imageRes = it.image,
                contentEnd = {
                    IconBtn(
                        resIcon = R.drawable.ic_dots,
                        tint = Color.Gray
                    )
                }
            ) {
                TextTitle(
                    text = it.title ?: "title",
                    fontSize = 22.sp
                )
                TextSubtitle(
                    text = it.subtitle ?: "subtitle",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
            }
        }
        item {
            TextTitle(
                modifier = Modifier
                    .padding(Sizes.DEFAULT),
                text = "Title",
            )
            VerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                albums.forEach {
                    CardColumn(roundPercent = 100, item = it)
                }
            }
        }
    }

    Box {
        TopBar(
            navigationIcon = {
                IconBtn(resIcon = R.drawable.ic_left)
            },
            title = {
                TextTitle(text = "AUTHOR", fontSize = 18.sp)
            }
        )

        PlayBtn(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(y = playOffset)
        )
    }
}

@Composable
fun PlayBtn(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        IconBtn(
            modifier = Modifier
                .padding(end = 12.dp)
                .size(50.dp)
                .round(100)
                .color(Active),
            resIcon = R.drawable.ic_baseline_play_arrow_24,
            tint = Color.Black
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_player_shuffle),
            contentDescription = null,
            tint = Active,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(20.dp)
                .round(100)
                .color(Color.DarkGray)
                .padding(4.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen()
}