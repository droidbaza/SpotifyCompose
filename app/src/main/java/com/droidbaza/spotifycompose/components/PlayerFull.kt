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

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.round

@Composable
fun PlayerFull() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        IconBtn(resIcon = R.drawable.ic_h_outline)
        IconBtn(resIcon = R.drawable.ic_player_back, modifier = Modifier.weight(1f))
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .size(65.dp)
                .round(100)
                .color(Color.White),
            contentAlignment = Alignment.Center
        ) {
            IconBtn(resIcon = R.drawable.ic_player_pause, tint = Color.Black)
        }
        IconBtn(resIcon = R.drawable.ic_player_skip, modifier = Modifier.weight(1f))
        IconBtn(resIcon = R.drawable.ic_remove)
    }
}

@Composable
@Preview
fun PlayerFullPreview() {
    PlayerFull()
}