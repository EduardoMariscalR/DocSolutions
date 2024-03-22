package com.android.eduardo.docsolutions

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.eduardo.docsolutions.ui.navegation.DocSolutionsNavHost

@Composable
fun DocSolutionsApp(
    navController: NavHostController = rememberNavController()
) {
    DocSolutionsNavHost(navController = navController)
}