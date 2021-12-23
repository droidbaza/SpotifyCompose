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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.components.core.BaseColumn
import com.droidbaza.spotifycompose.model.Music
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Sizes.MEDIUM

@Composable
fun CardColumn(
    imageSize: Dp = 145.dp,
    round: Dp? = null,
    roundPercent: Int = 0,
    item: Music = Music.Default,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.Vertical = Arrangement.Center,
    onClick: (Music) -> Unit = {},
) {
    var finalAlignment = horizontalAlignment
    if (round != null) {
        finalAlignment = Alignment.Start
    }
    val title = item.title
    val subtitle = item.subtitle
    val tag = item.tag
    val description = item.description
    var paddingSubtitle = 0.dp
    if (title == null && tag == null) {
        paddingSubtitle = 8.dp
    }
    BaseColumn(
        modifier = Modifier
            .padding(MEDIUM)
            .width(imageSize)
            .clickableResize { onClick(item) },
        imageSize = imageSize,
        imageRes = item.image,
        round = round,
        roundPercent = roundPercent,
        horizontalAlignment = finalAlignment,
        verticalArrangement = verticalArrangement,
    ) {

        tag?.let {
            TextTag(text = it, modifier = Modifier.padding(top = 8.dp))
        }
        title?.let {
            TextTitle(text = it)
        }
        subtitle?.let {
            TextSubtitle(text = it, modifier = Modifier.padding(top = paddingSubtitle))
        }
        description?.let {
            TextSubtitle(text = it, maxLines = 5)
        }
    }
}