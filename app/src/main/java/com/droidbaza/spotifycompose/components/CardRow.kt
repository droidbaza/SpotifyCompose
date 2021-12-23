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

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.components.core.BaseRaw
import com.droidbaza.spotifycompose.model.Music
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Sizes.MEDIUM

@Composable
fun CardRow(
    imageSize: Dp = 55.dp,
    round: Dp? = null,
    roundPercent: Int = 0,
    item: Music = Music.Default,
    onClick: (Music) -> Unit = {},
) {
    BaseRaw(
        modifier = Modifier
            .padding(MEDIUM)
            .clickableResize {
                onClick(item)
            },
        imageSize = imageSize,
        imageRes = item.image,
        round = round,
        roundPercent = roundPercent,
        content = {
            item.subtitle?.let {
                TextSubtitle(
                    text = it
                )
            }
            item.title?.let {
                TextTitle(
                    text = it,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    )
}