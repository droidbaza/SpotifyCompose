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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.components.CardColumn
import com.droidbaza.spotifycompose.components.SearchBar
import com.droidbaza.spotifycompose.components.TextTitle
import com.droidbaza.spotifycompose.repository.DataProvider
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.gradient
import com.droidbaza.spotifycompose.tools.Ext.offsetY
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.tools.GradientTypeVertical
import com.droidbaza.spotifycompose.tools.Sizes
import com.droidbaza.spotifycompose.ui.theme.Primary30

@ExperimentalFoundationApi
@Composable
fun AddPodcastsScreen() {
    val podcasts = remember {
        DataProvider.itemsBy(5, 20)
    }
    val scrollState = rememberLazyListState()
    val contentHeight = 100.dp
    val offsetY = scrollState.offsetY(contentHeight)

    Box {
        Column(
            modifier = Modifier.offset(y = -offsetY)
        ) {
            Box(
                modifier = Modifier
                    .height(contentHeight)
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomStart
            ) {

                TextTitle(
                    modifier = Modifier.padding(Sizes.DEFAULT),
                    text = "Search albums",
                )
            }
            SearchBar(
                modifier = Modifier
                    .padding(Sizes.MEDIUM)
                    .height(50.dp)
                    .clickableResize {}
            )
        }

        LazyVerticalGrid(
            state = scrollState,
            modifier = Modifier.padding(top = 70.dp),
            contentPadding = PaddingValues(top = 130.dp, bottom = 80.dp),
            cells = GridCells.Fixed(3)
        ) {

            items(podcasts) {
                CardColumn(100.dp, round = 8.dp, item = it)
            }
        }
        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .gradient(
                    listOf(Color.Transparent, Primary30),
                    GradientTypeVertical()
                )
        ) {
            Text(
                modifier = Modifier
                    .width(100.dp)
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 10.dp)
                    .round(100)
                    .color(Color.White)
                    .padding(vertical = 10.dp, horizontal = 20.dp),
                textAlign = TextAlign.Center,
                text = "title",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
@Preview
fun AddPodcastsScreenPreview() {
    AddPodcastsScreen()
}