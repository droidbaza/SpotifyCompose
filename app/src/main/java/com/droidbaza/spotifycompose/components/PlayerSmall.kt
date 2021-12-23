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

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.ui.theme.Primary
import com.droidbaza.spotifycompose.ui.theme.Primary30

@Composable
fun PlayerSmall(modifier: Modifier = Modifier) {

    Box(modifier.fillMaxWidth().round(8.dp).color(Color.DarkGray)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 6.dp),
        verticalAlignment = Alignment.CenterVertically) {
            ImageCrop(modifier = Modifier.size( 40.dp).round(5.dp), data = R.drawable.album)
            Column(Modifier.weight(4f).padding(horizontal = 8.dp)) {
                Text(text = "text", color = Color.White)
                Text(text = "text",color=Color.Gray, fontWeight = FontWeight.Light)
            }
            IconBtn(resIcon = R.drawable.ic_sound)
            IconBtn(resIcon = R.drawable.ic_h_outline)
            IconBtn(resIcon = R.drawable.ic_baseline_play_arrow_24)
        }
        LinearProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().height(2.dp).padding(horizontal = 8.dp), progress = 0.8f, color = Color.White, backgroundColor = Primary30)
    }



}

@Preview
@Composable
fun PreviewSound(){
    PlayerSmall()
}