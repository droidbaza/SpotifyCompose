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

package com.droidbaza.spotifycompose.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.droidbaza.spotifycompose.components.NavigationBar
import com.droidbaza.spotifycompose.components.PlayerSmall
import com.droidbaza.spotifycompose.navigation.NavigationContainer
import com.droidbaza.spotifycompose.navigation.Screen
import com.droidbaza.spotifycompose.navigation.Router
import com.droidbaza.spotifycompose.navigation.RouterImpl
import com.droidbaza.spotifycompose.tools.Ext.clickableResize
import com.droidbaza.spotifycompose.tools.Ext.gradient
import com.droidbaza.spotifycompose.tools.GradientTypeVertical

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreen(finish: () -> Unit) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val route = navBackStackEntry?.destination?.route ?: Screen.Splash.route
    val router: Router = remember { RouterImpl(navController, route) }
    val isFullScreen = Screen.isFullScreen(route)

    if (route == Screen.Home.route) {
        BackHandler {
            finish()
        }
    }
    Scaffold(
        bottomBar = {
            if (!isFullScreen) {
                Column(
                    modifier = Modifier
                        .gradient(
                            listOf(Color.Transparent, Color.Black),
                            GradientTypeVertical()
                        )
                        .padding(top = 20.dp)
                ) {
                    PlayerSmall(
                        modifier = Modifier
                            .clickableResize {
                                router.goPlayerFull(null)
                            }
                    )
                    NavigationBar(route) { target ->
                        navController.apply {
                            navigate(target) {
                                restoreState = true
                                launchSingleTop = true
                                graph.startDestinationRoute?.let { route ->
                                    popUpTo(route = route) {
                                        saveState = true
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    ) {
        NavigationContainer(navController = navController, paddingValues = it, router = router)
    }
}

