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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.ui.theme.Active
import com.droidbaza.spotifycompose.ui.theme.ActiveBorder

@Composable
fun ChipTag(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    text: String = "Empty",
    onChipSelected: () -> Unit = {},
) {
    Surface(
        color = when {
            selected -> Active
            else -> Color.Transparent
        },
        contentColor = Color.Transparent,
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> ActiveBorder
                else -> Color.LightGray
            }
        ),
        modifier = modifier.clickable {
            onChipSelected()
        }
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            fontSize = 12.sp,
            color = Color.White
        )

    }
}

@Composable
@Preview
fun TagChipPreview() {
    ChipTag()
}