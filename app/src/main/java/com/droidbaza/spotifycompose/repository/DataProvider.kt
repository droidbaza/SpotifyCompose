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

package com.droidbaza.spotifycompose.repository

import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.model.Category
import com.droidbaza.spotifycompose.model.Music
import kotlin.random.Random

object DataProvider {

    fun categoriesBy(count: Int = 20): List<Category> {
        return arrayOfNulls<Int>(count).mapIndexed { index, _ ->
            categoryBy(index)
        }
    }

    fun tags(): List<String> {
        return listOf("Playlists", "Persons", "Podcasts", "Albums")
    }

    fun categoryBy(categoryId: Int): Category {
        return Category(categoryId).apply {
            when (categoryId) {
                0 -> {
                    imageRes = R.drawable.img20
                    title = "Recently played"
                }
                1 -> {
                    imageRes = R.drawable.img1
                    title = "To get you started"
                }
                2 -> {
                    imageRes = R.drawable.img2
                    title = "Try something else"
                }
                3 -> {
                    imageRes = R.drawable.img3
                    title = "More like"
                    author = Music(
                        0,
                        categoryId,
                        image = R.drawable.img3,
                        title = "POPULAR ARTIST",
                        subtitle = "MORE LIKE"
                    )
                }
                4 -> {
                    imageRes = R.drawable.img4
                    title = "MORE LIKE"
                    author = Music(
                        0,
                        categoryId,
                        image = R.drawable.img4,
                        title = "POPULAR ARTIST",
                        subtitle = "MORE LIKE"
                    )
                }
                5 -> {
                    imageRes = R.drawable.img5
                    title = "Recomended for today"
                }
                6 -> {
                    imageRes = R.drawable.img6
                    title = "Suggested artists"
                }
                7 -> {
                    imageRes = R.drawable.img7
                    title = "Sing-along"
                }
                8 -> {
                    imageRes = R.drawable.img8
                    title = "MORE LIKE"
                    author = Music(
                        0,
                        categoryId,
                        image = R.drawable.img8,
                        title = "POPULAR ARTIST",
                        subtitle = "MORE LIKE"
                    )
                }
                9 -> {
                    imageRes = R.drawable.img9
                    title = "Chill"
                }
                10 -> {
                    imageRes = R.drawable.img10
                    title = "Instrumental"
                }
                11 -> {
                    imageRes = R.drawable.img11
                    title = "Mood"
                }
                12 -> {
                    imageRes = R.drawable.img12
                    title = "ThrowBack"
                }
                13 -> {
                    imageRes = R.drawable.img13
                    title = "Workout"
                }
                14 -> {
                    imageRes = R.drawable.img14
                    title = "Featured Charts"
                }
                15 -> {
                    imageRes = R.drawable.img15
                    title = "Todays biggest hits"
                }
                16 -> {
                    imageRes = R.drawable.img16
                    title = "Fresh new music"
                }
                17 -> {
                    imageRes = R.drawable.img18
                    title = "Some title 17"
                    author = Music(
                        0,
                        categoryId,
                        image = R.drawable.img18,
                        title = "Read a lot",
                        subtitle = "POPULAR WITH LISTENERS OF"
                    )
                }

                18 -> {
                    imageRes = R.drawable.img19
                    title = "Some title 18"
                    author = Music(
                        0,
                        categoryId,
                        image = R.drawable.img19,
                        title = "Conversations",
                        subtitle = "POPULAR WITH LISTENERS OF"
                    )
                }
                else -> {
                    imageRes = R.drawable.img20
                    title = "Some title 19"
                    author = Music(
                        0,
                        categoryId,
                        image = R.drawable.img20,
                        title = "Business and life",
                        subtitle = "POPULAR WITH LISTENERS OF"
                    )
                }
            }
            data = itemsBy(id)
        }
    }

    fun itemBy(index: Int = 0, categoryId: Int, image: Int): Music {
        val h = Random.nextInt(0, 24)
        val m = Random.nextInt(0, 59)
        val l = Random.nextInt(0, 1000000)

        val duration = "$h h $m min"
        val likes = "$l likes"
        var title: String? = null
        var tag: String? = null
        var description: String? = null
        val subtitle = "#Some subtitle $index"
        if (categoryId in 4..6) {
            title = "Some title $index"
        }
        if (categoryId in 17..20) {
            tag = "Some tag $index"
            description = "Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit." +
                    " Vivamus laoreet condimentum " +
                    "tincidunt. Phasellus eu mi libero." +
                    " Praesent aliquam dictum eros, " +
                    "sit amet placerat odio imperdiet non. " +
                    "Etiam eu placerat velit. Donec venenatis" +
                    " dapibus enim quis ullamcorper. Phasellus" +
                    " mauris mauris, commodo non justo nec, congue " +
                    "consectetur arcu. Quisque lobortis vehicula orci" +
                    " in feugiat. Mauris mollis odio vitae nisl vestibulum, " +
                    "in faucibus nisi varius. Maecenas interdum nulla quis ante " +
                    "rutrum gravida. Phasellus condimentum est tortor," +
                    " non pellentesque mauris rhoncus a."
        }

        return Music(
            categoryId = categoryId,
            image = image,
            title = title,
            tag = tag,
            description = description,
            subtitle = subtitle,
            duration = duration,
            likes = likes
        )
    }

    fun itemsBy(categoryId: Int, childCount: Int = 10): List<Music> {
        val endIndex = if (childCount > 20) {
            20
        } else {
            childCount
        }
        val images = listOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16,
            R.drawable.img17,
            R.drawable.img18,
            R.drawable.img19,
            R.drawable.img20,
        )

        return images.shuffled().subList(0, endIndex).mapIndexed { index, i ->
            itemBy(index, categoryId, i)
        }

    }


}