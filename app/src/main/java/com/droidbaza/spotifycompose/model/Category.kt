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

package com.droidbaza.spotifycompose.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Int = 0,
    var title: String = "Empty title",
    var subtitle: String? = null,
    var author: Music? = null,
    var imageRes: Int? = null,
    var data: List<Music> = emptyList(),
) : Parcelable {
    companion object {
        val Default = Category(0, subtitle = "empty subtitle")
    }
}

// written with solid principles(open-closed)
fun Category.authors(): List<String> {
    return data.map { it.title ?: "" }
}
