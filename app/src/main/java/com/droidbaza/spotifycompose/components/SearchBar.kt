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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.tools.Sizes.DEFAULT
import com.droidbaza.spotifycompose.tools.Sizes.SMALL

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    title: String = "Title",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
            .padding(vertical = SMALL, horizontal = SMALL),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconBtn(
            resIcon = R.drawable.ic_search_small,
            tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .padding(10.dp)
        )
        TextTitle(
            modifier = Modifier
                .padding(horizontal = DEFAULT)
                .weight(1f),
            text = title,
            color = Color.DarkGray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar()
}