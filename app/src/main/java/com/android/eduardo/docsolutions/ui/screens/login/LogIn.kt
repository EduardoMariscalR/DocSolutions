package com.android.eduardo.docsolutions.ui.screens.login

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.eduardo.docsolutions.R
import com.android.eduardo.docsolutions.ui.AppViewModelProvider
import com.android.eduardo.docsolutions.ui.navegation.Navigationdestination

object LogInDestination : Navigationdestination {
    override val route = "login"
    override val titleRes = R.string.app_name
}

@Composable
fun LogInScreen(
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
            navigateToUserListScreen(1)
        }
    }
}





@Composable
fun LogIn(
    modifier: Modifier = Modifier,
    viewModel: LogInViewModel
) {

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    if (viewModel.logInUiState == LogInUiState.Error){
        Toast.makeText(context,"Sus datos son incorrectos, verifique su información e intente nuevamente",Toast.LENGTH_SHORT).show()
    }

    Scaffold(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Inicio de sesión",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(25.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Usuario:",
                        fontSize = 22.sp,

                        )
                    OutlinedTextField(
                        value = user,
                        onValueChange = {
                            user = it
                        }
                    )
                }
                Spacer(modifier = Modifier.size(25.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Contraseña:",
                        fontSize = 22.sp,
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                        }
                    )
                }
                Spacer(modifier = Modifier.size(25.dp))

                Button(
                    onClick = {
                        viewModel.logIn(user = user, password = password)
                        Log.i("Eduardo","Se preciona el boton")
                    }
                ) {
                    Text(text = "OK")

                }

            }
        }
    }
}
