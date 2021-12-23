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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidbaza.spotifycompose.tools.Ext.color
import com.droidbaza.spotifycompose.tools.Ext.gradient
import com.droidbaza.spotifycompose.tools.Ext.round
import com.droidbaza.spotifycompose.ui.theme.PremiumEnd
import com.droidbaza.spotifycompose.ui.theme.PremiumStart

const val DEFAULT_DESCRIPTION =
    "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\""
const val DEFAULT_TITLE = "Premium for you"

@Composable
fun PremiumCard(
    title: String = DEFAULT_TITLE,
    description: String = DEFAULT_DESCRIPTION,
    startColor: Color = PremiumStart,
    endColor: Color = PremiumEnd,
) {
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .round(8.dp)
            .gradient(listOf(startColor,endColor))
            .padding(horizontal = 30.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextTitle(
                modifier = Modifier
                    .width(100.dp), text = title, maxLines = 2
            )

            Spacer(modifier = Modifier.weight(2f))
            Column {
                TextTitle("FREE")
                TextSubtitle(text = "3 months", color = Color.LightGray)
            }

        }
        TextTitle(modifier = Modifier.padding(10.dp), fontSize = 17.sp, text = "1 Premium-account")

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .round(100)
                .color(Color.White)
                .padding(14.dp),
            textAlign = TextAlign.Center,
            text = "TRY 3 MONTHS",
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )

        Text(
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 14.sp,
            text = description,
            color = Color.LightGray,
            maxLines = 4
        )

    }

}

@Composable
@Preview
fun PremiumCardPreview() {
    PremiumCard()
}