package com.android.eduardo.docsolutions.ui.screens.newuserscreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.eduardo.docsolutions.R
import com.android.eduardo.docsolutions.ui.AppViewModelProvider
import com.android.eduardo.docsolutions.ui.navegation.Navigationdestination
import com.android.eduardo.docsolutions.ui.screens.login.LogIn
import com.android.eduardo.docsolutions.ui.screens.login.LogInUiState
import com.android.eduardo.docsolutions.ui.screens.login.LogInViewModel

object NewUserScreenDestination: Navigationdestination {
    override val route = "newuser"
    override val titleRes = R.string.newuser
}

@Composable
fun NewUserScreen(
    modifier: Modifier = Modifier,
    navigateToUserListScreen: (Int) -> Unit,
    viewModel: LogInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    when(val logInUiState = viewModel.logInUiState){
        is LogInUiState.Init ->
            LogIn(viewModel = viewModel)

        is LogInUiState.Error ->
            LogIn(viewModel = viewModel)

        is LogInUiState.Success -> {
            navigateToUserListScreen
        }
    }
}

//@Composable
//fun NewUserScreen(
//    modifier: Modifier = Modifier
//) {
//    Scaffold(
//        modifier = modifier
//    ) {
//        Surface(
//            modifier = Modifier.fillMaxSize()
//        ) {
////            Column(
////                modifier = Modifier
////                    .padding(it),
////                verticalArrangement = Arrangement.Center,
////                horizontalAlignment = Alignment.CenterHorizontally
////
////            ) {
////                Text(
////                    text = "Inicio de sesión",
////                    fontSize = 32.sp,
////                    fontWeight = FontWeight.Bold
////                )
////                Spacer(modifier = Modifier.size(25.dp))
////                Row(
////                    modifier = Modifier
////                        .fillMaxWidth(),
////                    horizontalArrangement = Arrangement.Start,
////                    verticalAlignment = Alignment.CenterVertically
////                ) {
////                    Text(
////                        text = "Usuario:",
////                        fontSize = 22.sp,
////
////                        )
////                    OutlinedTextField(
////                        value = user,
////                        onValueChange = {
////                            user = it
////                        }
////                    )
////                }
////                Spacer(modifier = Modifier.size(25.dp))
////                Button(
////                    onClick = {
////                        viewModel.logIn(user = user, password = password)
////                        Log.i("Eduardo","Se preciona el boton")
////                    }
////                ) {
////                    Text(text = "OK")
////
////                }
////
////            }
//        }
//    }
//}