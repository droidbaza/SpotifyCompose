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

package com.droidbaza.spotifycompose.navigation

import androidx.annotation.DrawableRes
import com.droidbaza.spotifycompose.R
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_HISTORY
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_HOME
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_HOME_DETAILS
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_LIBS
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_NOTIFICATION
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_PERSONS
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_PLAYER_FULL
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_PODCASTS
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_PREMIUM
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_PROFILE
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_SEARCH
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_SETTINGS
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_SPLASH
import com.droidbaza.spotifycompose.navigation.Routes.fullScreenRoutes

object Routes {
    const val ROUTE_HOME = "ROUTE_HOME"
    const val ROUTE_SEARCH = "ROUTE_SEARCH"
    const val ROUTE_LIBS = "ROUTE_LIBS"
    const val ROUTE_PREMIUM = "ROUTE_PREMIUM"
    const val ROUTE_HOME_DETAILS = "ROUTE_HOME_DETAILS"
    const val ROUTE_SPLASH = "ROUTE_SPLASH"
    const val ROUTE_PERSONS = "ROUTE_PERSONS"
    const val ROUTE_PODCASTS = "ROUTE_PODCASTS"
    const val ROUTE_PLAYER_FULL = "ROUTE_PLAYER_FULL"
    const val ROUTE_NOTIFICATION = "ROUTE_NOTIFICATION"
    const val ROUTE_SETTINGS = "ROUTE_SETTINGS"
    const val ROUTE_HISTORY = "ROUTE_HISTORY"
    const val ROUTE_PROFILE = "ROUTE_PROFILE"

    val fullScreenRoutes = listOf(
        ROUTE_SPLASH,
        ROUTE_PERSONS,
        ROUTE_PODCASTS,
        ROUTE_PLAYER_FULL
    )
}

sealed class Screen(
    val route: String,
    var tag: String = route,
    val title: String = "",
    @DrawableRes val icon: Int = 0
) {

    object Home : Screen(route = ROUTE_HOME, title = "Home", icon = R.drawable.ic_home_filled)
    object Search : Screen(route = ROUTE_SEARCH, title = "Search", icon = R.drawable.ic_search_big)
    object Libs :
        Screen(route = ROUTE_LIBS, title = "Your Library", icon = R.drawable.ic_library_big)

    object Premium : Screen(route = ROUTE_PREMIUM, title = "Premium", icon = R.drawable.ic_premium)

    object Splash : Screen(route = ROUTE_SPLASH)
    object HomeDetails : Screen(route = ROUTE_HOME_DETAILS)
    object PlayerFull : Screen(route = ROUTE_PLAYER_FULL)
    object AddPersons : Screen(route = ROUTE_PERSONS)
    object AddPodcasts : Screen(route = ROUTE_PODCASTS)
    object Notifications : Screen(route = ROUTE_NOTIFICATION)
    object Profile : Screen(route = ROUTE_PROFILE)
    object Settings : Screen(route = ROUTE_SETTINGS)
    object History : Screen(route = ROUTE_HISTORY)

    companion object {
        fun isFullScreen(route: String?): Boolean {
            return fullScreenRoutes.contains(route)
        }
    }

}