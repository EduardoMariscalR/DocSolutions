package com.android.eduardo.docsolutions.ui.screens.newuserscreen

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

object NewUserScreenDestination : Navigationdestination {
    override val route = "newuser"
    override val titleRes = R.string.newuser
}

@Composable
fun NewUserScreen(
    modifier: Modifier = Modifier,
    navigateToUserListScreen: () -> Unit,
    viewModel: NewUserViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    when (val newUserUiState = viewModel.newUserUiState) {
        is NewUserUiState.Init ->
            NewUserBody(viewModel = viewModel, message = "")

        is NewUserUiState.Error ->
            NewUserBody(viewModel = viewModel, message = newUserUiState.data)

        is NewUserUiState.Success -> {
            navigateToUserListScreen()
        }
    }
}

@Composable
fun NewUserBody(
    modifier: Modifier = Modifier,
    viewModel: NewUserViewModel,
    message: String
) {


    var name by remember { mutableStateOf("") }
    var lastNameF by remember { mutableStateOf("") }
    var lastNameM by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var password1 by remember { mutableStateOf("") }
    var pasword2 by remember { mutableStateOf("") }

    var button by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current
    if (message.isNotEmpty()) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    Scaffold(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Nuevo Usuario",
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
                        text = "Nombre:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Apellido P:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = lastNameF,
                        onValueChange = {
                            lastNameF = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Apellido M:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = lastNameM,
                        onValueChange = {
                            lastNameM = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Email:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Telefono:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = phone,
                        onValueChange = {
                            phone = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Usuario:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = user,
                        onValueChange = {
                            user = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Password:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = password1,
                        onValueChange = {
                            password1 = it
                        },
                        modifier = Modifier.weight(2.5f)
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
                        text = "Password:",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    OutlinedTextField(
                        value = pasword2,
                        onValueChange = {
                            pasword2 = it
                        },
                        modifier = Modifier.weight(2.5f)
                    )
                }
                Spacer(modifier = Modifier.size(25.dp))

                if (
                    name.isNotEmpty() &&
                    lastNameF.isNotEmpty() &&
                    lastNameM.isNotEmpty() &&
                    email.isNotEmpty() &&
                    phone.isNotEmpty() &&
                    user.isNotEmpty()&&
                    password1.isNotEmpty()&&
                    password1== pasword2){
                    button = true
                }
                    Button(
                        enabled = button,
                        onClick = {
                            viewModel.setNewUser(
                                userName = user,
                                name = name,
                                lastNameF = lastNameF,
                                lastNameM = lastNameM,
                                email = email,
                                password = password1,
                                phoneNumber = phone
                            )
                        }
                    ) {
                        Text(text = "Guardar")

                    }

            }
        }
    }
}