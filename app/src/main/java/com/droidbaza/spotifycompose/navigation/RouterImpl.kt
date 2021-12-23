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

import androidx.navigation.NavHostController
import com.droidbaza.spotifycompose.navigation.Routes.ROUTE_HOME
import com.droidbaza.spotifycompose.tools.Ext.putArgs

class RouterImpl(
    private val navHostController: NavHostController,
    private val startDestination: String = ROUTE_HOME
) : Router {

    override fun goDetails(arg: Any?) {
        navigate(Screen.HomeDetails)
    }

    override fun goAddPersons() {
        navigate(Screen.AddPersons)
    }

    override fun goAddPodcasts() {
        navigate(Screen.AddPodcasts)
    }

    override fun goHome() {
        navigate(Screen.Home, removeFromHistory = true, singleTop = true)
    }

    override fun goHistory() {
        navigate(Screen.History)
    }

    override fun goBack() {
        navHostController.apply {
            navigateUp()
            navigate(startDestination) {
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    override fun goSettings() {
        navigate(Screen.Settings)
    }

    override fun goNotification() {
        navigate(Screen.Notifications)
    }

    override fun goProfile() {
        navigate(Screen.Profile)
    }

    override fun goSplash() {
        navigate(Screen.Splash, true)
    }

    override fun goPlayerFull(arg: Any?) {
        navigate(Screen.PlayerFull)
    }

    private fun navigate(
        screen: Screen,
        removeFromHistory: Boolean = false,
        singleTop: Boolean = false
    ) {
        navHostController.apply {
            navigate(screen.route) {
                if (removeFromHistory) {
                    if (singleTop) {
                        popUpTo(Screen.Home.route)
                    } else {
                        popUpTo(0) {
                            saveState = false
                        }
                    }

                } else {
                    restoreState = true
                }
                launchSingleTop = singleTop
            }
        }
    }

    private fun checkArgsAndNavigate(it: Any?, screen: Screen): () -> Unit = {
        it?.let {
            navHostController.putArgs(Pair(screen.tag, it))
        }
        navigate(screen)
    }

    override fun <T : Any> getArgs(tag: String): T? {
        return try {
            navHostController.previousBackStackEntry?.arguments?.get(tag) as T?
        } catch (ex: Exception) {
            null
        }
    }

}