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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.components.*
import com.droidbaza.spotifycompose.components.core.TopBar
import com.droidbaza.spotifycompose.repository.DataProvider
import com.droidbaza.spotifycompose.tools.Ext.offsetY

@Composable
fun NotificationsScreen(paddingValues: PaddingValues = PaddingValues()) {
    val contentHeight = 150.dp
    val scrollState = rememberLazyListState()
    val offsetY = scrollState.offsetY(contentHeight)
    val alpha = 1f - offsetY.value / contentHeight.value
    val tracks = remember {
        DataProvider.itemsBy(4, 20)
    }
    val tracksNew = tracks.subList(0, 4)
    val chipState = remember {
        mutableStateOf(-1)
    }
    val chipSelected = chipState.value != -1
    val chips = remember { DataProvider.tags() }
    TopBar(
        navigationIcon = {
            IconBtn(resIcon = R.drawable.ic_left)
        },
        title = {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .alpha(1 - alpha),
                text = "Whats new",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
    )

    LazyColumn(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 50.dp),
        state = scrollState,
        contentPadding = PaddingValues(
            bottom = paddingValues.calculateBottomPadding(),
        )
    ) {
        item {
            Box(modifier = Modifier.height(contentHeight)) {
                TextTitle(
                    "Whats new", modifier = Modifier
                        .alpha(alpha)
                        .padding(vertical = 20.dp, horizontal = 8.dp)
                )
                LazyRow(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.BottomStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (chipSelected) {
                        item {
                            BorderBtn(modifier = Modifier.padding(end = 8.dp)) {
                                chipState.value = -1
                            }
                        }
                        item {
                            val selectedChip = chips[chipState.value]
                            ChipTag(selected = true, text = selectedChip) {
                                chipState.value = -1
                            }
                        }
                    } else {
                        itemsIndexed(chips) { index, chip ->
                            ChipTag(modifier = Modifier.padding(end = 8.dp), text = chip) {
                                chipState.value = index
                            }
                        }
                    }
                }
            }
        }
        item {
            TextTitle("New", modifier = Modifier.padding(8.dp))
        }
        itemsIndexed(tracksNew) { index, track ->
            val round: Dp? = if (index % 4 == 0) null else 10.dp
            CardRow(60.dp, round = round, roundPercent = 100, item = track)
        }
        item {
            TextTitle("Early", modifier = Modifier.padding(8.dp))
        }
        items(tracks) { track ->
            CardRow(60.dp, round = 10.dp, item = track)
        }

    }


}

@Composable
@Preview
fun NotificationsScreenPreview() {
    NotificationsScreen()
}