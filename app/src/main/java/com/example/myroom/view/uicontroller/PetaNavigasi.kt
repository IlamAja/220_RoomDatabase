package com.example.myroom.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myroom.view.DetailScreen
import com.example.myroom.view.EntrySiswaScreen
import com.example.myroom.view.HomeScreen
import com.example.myroom.view.route.DestinasiDetail
import com.example.myroom.view.route.DestinasiEntry
import com.example.myroom.view.route.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(route = DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(route = DestinasiEntry.route) },
                navigateToItemDetail = { id ->
                    navController.navigate("${DestinasiDetail.route}/$id")
                }
            )
        }

        composable(route = DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.siswaIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEditItem = { /*TODO*/ }
            )
        }
    }
}