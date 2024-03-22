package com.android.eduardo.docsolutions.ui.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.eduardo.docsolutions.ui.screens.login.LogInDestination
import com.android.eduardo.docsolutions.ui.screens.login.LogInScreen
import com.android.eduardo.docsolutions.ui.screens.newuserscreen.NewUserScreen
import com.android.eduardo.docsolutions.ui.screens.newuserscreen.NewUserScreenDestination
import com.android.eduardo.docsolutions.ui.screens.userlistscreen.UserListScreen
import com.android.eduardo.docsolutions.ui.screens.userlistscreen.UserListScreenDestination

@Composable
fun  DocSolutionsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = LogInDestination.route,
        modifier = modifier
    ){
        composable(route = LogInDestination.route ) {
            LogInScreen(
                navigateToUserListScreen = { navController.navigate(UserListScreenDestination.route)}
            )
        }
        composable(route= UserListScreenDestination.route) {
            UserListScreen(
                navigateToNewUserScreen = { navController.navigate(NewUserScreenDestination.route)}
            )
        }
        composable(route = NewUserScreenDestination.route){
            NewUserScreen(
                navigateToUserListScreen={navController.navigate(UserListScreenDestination.route)}
            )
        }

    }
}