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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.components.*
import com.droidbaza.spotifycompose.components.core.VerticalGrid
import com.droidbaza.spotifycompose.model.Music
import com.droidbaza.spotifycompose.navigation.Router
import com.droidbaza.spotifycompose.repository.DataProvider
import com.droidbaza.spotifycompose.tools.Sizes

@ExperimentalFoundationApi
@Composable
fun HomeScreen(paddingValues: PaddingValues = PaddingValues(), router: Router? = null) {
    val categories = remember {
        DataProvider.categoriesBy()
    }
    val topCategories = categories.subList(0, 6)
    val goDetails: (Music?) -> Unit = {
        router?.goDetails(it)
    }
    val actionClicked: (index: Int) -> Unit = {
        when (it) {
            0 -> router?.goNotification()
            1 -> router?.goHistory()
            2 -> router?.goSettings()
        }
    }

    LazyColumn(
        modifier = Modifier.padding(top = Sizes.MEDIUM),
        contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding())
    ) {
        item {
            TopAppBar(onActionClicked = actionClicked)
        }

        item {
            VerticalGrid(
                modifier = Modifier.padding(horizontal = Sizes.SMALL)
            ) {
                topCategories.forEach {
                    SmallCardItem(
                        image = it.imageRes,
                        title = it.title
                    ) {
                        goDetails(null)
                    }
                }
            }
        }

        items(categories) { category ->
            val author = category.author
            val id = category.id
            val title = category.title
            val data = category.data
            var round: Dp? = 0.dp
            val roundPercent = 100

            if (id == 3 || id == 4 || id == 8) {
                round = null
            } else if (id > 16) {
                round = 8.dp
            }

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                if (author != null) {
                    CardRow(
                        round = round,
                        roundPercent = roundPercent,
                        item = author
                    )
                } else {
                    TextTitle(title, modifier = Modifier.padding(horizontal = 8.dp))
                }
                LazyRow {
                    items(data) {
                        CardColumn(
                            roundPercent = roundPercent,
                            round = round,
                            onClick = goDetails,
                            item = it
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}