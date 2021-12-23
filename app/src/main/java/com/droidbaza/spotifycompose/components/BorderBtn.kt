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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.R


@Composable
fun BorderBtn(
    modifier: Modifier = Modifier,
    resIcon: Int = R.drawable.ic_baseline_close_24,
    tint: Color = Color.LightGray,
    onClick: () -> Unit = {},
) {
    Surface(
        color = Color.Transparent,
        contentColor = Color.Transparent,
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
        modifier = modifier
            .clickable {
            onClick()
        }
    ) {

        Icon(
            modifier = Modifier.padding(4.dp),
            painter = painterResource(id = resIcon),
            contentDescription = null,
            tint = tint
        )

    }
}


@Composable
@Preview
fun PreviewBorderBtn() {
    BorderBtn()
}