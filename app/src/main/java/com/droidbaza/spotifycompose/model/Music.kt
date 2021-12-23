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
import com.droidbaza.spotifycompose.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val id: Int = 0,
    val categoryId: Int = 0,
    var genreId:Int = 0,
    var audio: String? = null,
    var image: Int? = null,
    var images: List<Int>? = null,
    var title: String? = null,
    var subtitle: String? = null,
    var description: String? = null,
    var tag: String? = null,
    var likes: String? = null,
    var duration: String? = null,
) : Parcelable {
    companion object {
        val Default = Music(title = "title", subtitle = "subtitle", image = R.drawable.album)
    }


}
