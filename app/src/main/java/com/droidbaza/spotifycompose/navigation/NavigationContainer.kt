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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droidbaza.spotifycompose.screens.*

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun NavigationContainer(
    router: Router,
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    val startDestination = remember { mutableStateOf(Screen.Splash.route) }
    LaunchedEffect(startDestination) {
        if (startDestination.value == Screen.Home.route) {
            router.goHome()
        }
    }
    NavHost(
        navController = navController,
        startDestination = startDestination.value,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(paddingValues, router)
        }
        composable(Screen.Search.route) {
            SearchScreen(paddingValues)
        }
        composable(Screen.Libs.route) {
            LibsScreen(paddingValues, router)
        }
        composable(Screen.Premium.route) {
            PremiumScreen(paddingValues)
        }
        composable(Screen.Splash.route) {
            SplashScreen(
                goBack = {
                    startDestination.value = Screen.Home.route
                }
            )
        }
        composable(Screen.HomeDetails.route) {
            DetailsScreen(paddingValues)
        }

        composable(Screen.Notifications.route) {
            NotificationsScreen(paddingValues)
        }
        composable(Screen.Settings.route) {
            NotificationsScreen(paddingValues)
        }
        composable(Screen.Profile.route) {
            NotificationsScreen(paddingValues)
        }
        composable(Screen.History.route) {
            NotificationsScreen(paddingValues)
        }
        composable(Screen.AddPodcasts.route) {
            AddPodcastsScreen()
        }
        composable(Screen.AddPersons.route) {
            AddPersonsScreen()
        }
        composable(Screen.PlayerFull.route) {
            PlayerFullScreen()
        }
    }
}