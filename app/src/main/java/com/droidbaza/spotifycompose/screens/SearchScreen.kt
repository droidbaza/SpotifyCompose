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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.components.SearchBar
import com.droidbaza.spotifycompose.components.SearchGradientCard
import com.droidbaza.spotifycompose.components.TextTitle
import com.droidbaza.spotifycompose.repository.DataProvider
import com.droidbaza.spotifycompose.tools.Ext.offsetY
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Sizes

@ExperimentalFoundationApi
@Composable
fun SearchScreen(paddingValues: PaddingValues = PaddingValues()) {
    val categories = remember {
        DataProvider.categoriesBy(14)
    }

    val scrollState = rememberLazyListState()
    val contentHeight = 100.dp
    val offsetY = scrollState.offsetY(contentHeight)

    LazyVerticalGrid(
        state = scrollState,
        modifier = Modifier.padding(top = 70.dp),
        contentPadding = PaddingValues(
            top = 130.dp,
            bottom = paddingValues.calculateBottomPadding()
        ),
        cells = GridCells.Fixed(2)
    ) {
        items(categories) {
            SearchGradientCard(
                it.imageRes,
                it.title
            )
        }
    }
    Column(
        modifier = Modifier.offset(y = -offsetY)
    ) {
        Box(
            modifier = Modifier
                .height(contentHeight)
                .padding(horizontal = Sizes.MEDIUM)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            TextTitle(text = "Search")
        }
        SearchBar(
            modifier = Modifier
                .padding(Sizes.MEDIUM)
                .height(50.dp)
                .clickableResize {

                },
            title = "Artists,songs,or podcasts"
        )
    }
}

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}