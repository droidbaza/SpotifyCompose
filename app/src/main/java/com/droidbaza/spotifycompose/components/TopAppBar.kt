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

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.tools.Sizes.DEFAULT
import com.droidbaza.spotifycompose.tools.Sizes.SMALL
import com.droidbaza.spotifycompose.ui.theme.Notification

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String = "Good evening",
    onActionClicked: (pos: Int) -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = SMALL),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextTitle(
            modifier = Modifier
                .padding(horizontal = DEFAULT)
                .weight(1f),
            text = title,
        )
        Box {
            IconBtn(resIcon = R.drawable.ic_notification) {
                onActionClicked(0)
            }
            Icon(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 14.dp, bottom = 12.dp),
                tint = Notification,
                painter = painterResource(id = R.drawable.ic_dot),
                contentDescription = null
            )
        }

        IconBtn(resIcon = R.drawable.ic_history) {
            onActionClicked(1)
        }
        IconBtn(resIcon = R.drawable.ic_settings) {
            onActionClicked(2)
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}