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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.components.*
import com.droidbaza.spotifycompose.components.core.TopBar
import com.droidbaza.spotifycompose.components.core.VerticalGrid
import com.droidbaza.spotifycompose.model.Music
import com.droidbaza.spotifycompose.navigation.Router
import com.droidbaza.spotifycompose.repository.DataProvider
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.tools.Sizes
import com.droidbaza.spotifycompose.ui.theme.Active
import com.droidbaza.spotifycompose.ui.theme.Primary80
import com.droidbaza.spotifycompose.ui.theme.Secondary
import com.droidbaza.spotifycompose.ui.theme.White
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun LibsScreen(
    paddingValues: PaddingValues = PaddingValues(),
    router: Router? = null
) {
    val goAddPersons: () -> Unit = {
        router?.goAddPersons()
    }
    val goAddPodcasts: () -> Unit = {
        router?.goAddPodcasts()
    }

    val tracks = remember {
        DataProvider.itemsBy(4, 20)
    }
    val chipState = remember {
        mutableStateOf(-1)
    }
    val chipSelected = chipState.value != -1
    val chips = remember { DataProvider.tags() }

    val styleState = remember {
        mutableStateOf(true)
    }
    val isGridStyle = styleState.value
    val modalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    val showFilter: () -> Unit = {
        scope.launch {
            if (modalBottomSheetState.isVisible) {
                modalBottomSheetState.hide()
            } else {
                modalBottomSheetState.show()
            }
        }
    }
    ModalBottomSheetLayout(
        sheetBackgroundColor = Secondary,
        scrimColor = Primary80,
        sheetState = modalBottomSheetState,
        sheetContent = {
            SheetContent()
        }
    ) {
        Column {
            TopBar(
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .size(35.dp)
                            .round(100)
                            .color(Color.Blue)
                    ) {
                        TextTitle(
                            text = "V",
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 13.sp
                        )
                    }

                },
                title = {
                    TextTitle(
                        modifier = Modifier
                            .weight(3f)
                            .padding(10.dp),
                        text = "Your Library"
                    )
                },
                actions = {
                    IconBtn(resIcon = R.drawable.ic_search_small)
                    IconBtn(resIcon = R.drawable.ic_baseline_add_24)
                }
            )
            LazyColumn(
                contentPadding = PaddingValues(
                    bottom = paddingValues.calculateBottomPadding(),
                    start = Sizes.MEDIUM,
                    end = Sizes.MEDIUM
                )
            ) {
                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 8.dp),
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

                item {
                    Row(
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconBtn(resIcon = R.drawable.ic_baseline_arrow_downward_24) {
                            showFilter()
                        }
                        Text(
                            text = "Recently played",
                            fontSize = 12.sp,
                            color = Color.White,
                            modifier = Modifier.weight(2f)
                        )

                        IconBtn(
                            resIcon = R.drawable.ic_baseline_list_24,
                            selectedIcon = R.drawable.ic_baseline_grid_view_24,
                            selected = isGridStyle
                        ) {
                            styleState.value = !styleState.value
                        }
                    }
                }

                if (!isGridStyle) {
                    itemsIndexed(tracks) { index, person ->
                        val round: Dp? = if (index % 4 == 0) null else 10.dp
                        CardRow(60.dp, round = round, roundPercent = 100, item = person)
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .padding(Sizes.MEDIUM)
                                .clickableResize(goAddPersons),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            ImageCrop(
                                modifier = Modifier
                                    .round(100)
                                    .size(60.dp)
                                    .background(Color(0x33868686)),
                                data = R.drawable.ic_baseline_add_24,
                            )
                            Text(
                                text = "Add artists",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    top = Sizes.MEDIUM,
                                    start = Sizes.MEDIUM
                                )
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier
                                .padding(Sizes.MEDIUM)
                                .clickableResize(goAddPodcasts),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ImageCrop(
                                modifier = Modifier
                                    .size(60.dp)
                                    .round(10.dp)
                                    .background(Color(0x33868686)),
                                data = R.drawable.ic_baseline_add_24,
                            )
                            Text(
                                text = "Add albums",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    top = Sizes.MEDIUM,
                                    start = Sizes.MEDIUM
                                )
                            )
                        }
                    }
                } else {
                    item {
                        GridContent(items = tracks, goAddPersons)
                    }
                }
            }
        }
    }
}


@Composable
fun GridContent(items: List<Music>, onClick: () -> Unit) {
    VerticalGrid {
        items.forEachIndexed { index, music ->
            val round: Dp? = if (index % 4 == 0) null else 10.dp
            CardColumn(145.dp, round = round, roundPercent = 100, item = music)
        }
        Column(
            modifier = Modifier
                .clickableResize {
                    onClick()
                },
            horizontalAlignment = CenterHorizontally
        ) {
            ImageCrop(
                modifier = Modifier
                    .size(145.dp)
                    .round(100)
                    .background(Color(0x33868686)),
                data = R.drawable.ic_baseline_add_24,
            )
            Text(
                text = "Add artist",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = Sizes.MEDIUM,
                    start = Sizes.MEDIUM
                )
            )
        }

        Column(
            modifier = Modifier
                .clickableResize {
                    onClick()
                },
            horizontalAlignment = CenterHorizontally
        ) {
            ImageCrop(
                modifier = Modifier
                    .size(145.dp)
                    .round(10.dp)
                    .background(Color(0x33868686)),
                data = R.drawable.ic_baseline_add_24,
            )
            Text(
                text = "Add album",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = Sizes.MEDIUM,
                    start = Sizes.MEDIUM
                )
            )
        }
    }

}

@Composable
fun SheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 250.dp)
    ) {
        Box(
            modifier = Modifier
                .height(4.dp)
                .width(30.dp)
                .round(2.dp)
                .align(CenterHorizontally)
                .color(Color.Gray)
        )
        TextTitle()

        LazyColumn {

            item {
                Row {
                    Text(
                        "Item ",
                        color = Active,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_check_24),
                        contentDescription = null,
                        tint = Active
                    )
                }
            }
            items(3) {
                Text(
                    "Item $it",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        TextTitle(
            text = "cancel",
            color = Color.Gray,
            modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
@Preview
fun LibsScreenPreview() {
    LibsScreen()
}