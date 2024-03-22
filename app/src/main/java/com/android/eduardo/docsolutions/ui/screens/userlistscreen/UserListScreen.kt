package com.android.eduardo.docsolutions.ui.screens.userlistscreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.eduardo.docsolutions.R
import com.android.eduardo.docsolutions.ui.AppViewModelProvider
import com.android.eduardo.docsolutions.ui.navegation.Navigationdestination

object UserListScreenDestination : Navigationdestination {
    override val route = "userlist"
    override val titleRes = R.string.resultados
}

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    navigateToNewUserScreen: () -> Unit,
    viewModel: UserListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var buscar by remember { mutableStateOf("") }
    val context = LocalContext.current
    Scaffold(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    placeholder = { Text(text = "Buscar") },
                    value = buscar,
                    onValueChange = {
                        buscar = it
                    }
                )
                Spacer(modifier = Modifier.size(25.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            if (buscar.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "No escibio nada en la barra de busqueda",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                viewModel.searchUsers(buscar)
                            }
                        }
                    ) {
                        Text(
                            text = "Ok",
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick =  navigateToNewUserScreen
                    ) {
                        Text(
                            text = "Nuevo",
                            fontSize = 20.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                when (val userListUiState = viewModel.userListUiState) {
                    is UserListUiState.Error ->
                        Toast.makeText(
                            context,
                            "No hay datos disponibles para esa busqueda",
                            Toast.LENGTH_SHORT
                        ).show()

                    is UserListUiState.Init ->
                        Text(text = "Inicie una busqueda para mostrar los datos")

                    is UserListUiState.Success ->
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(
                                items = userListUiState.data.body
                            ) { user ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(text = "Username:", modifier = Modifier.weight(1.5f))
                                        Text(text = user.username, modifier = Modifier.weight(2f))
                                    }
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(text = "Name:", modifier = Modifier.weight(1.5f))
                                        Text(text = user.name, modifier = Modifier.weight(2f))
                                    }
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(text = "LastName:", modifier = Modifier.weight(1.5f))
                                        Text(
                                            text = user.fatherLastName,
                                            modifier = Modifier.weight(2f)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(
                                            text = "CreationDate:",
                                            modifier = Modifier.weight(1.5f)
                                        )
                                        Text(
                                            text = user.creationDate,
                                            modifier = Modifier.weight(2f)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(text = "Email:", modifier = Modifier.weight(1.5f))
                                        Text(
                                            text = user.email ?: "N/A",
                                            modifier = Modifier.weight(2f)
                                        )
                                    }
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    ) {
                                        Text(
                                            text = "PhoneNumber:",
                                            modifier = Modifier.weight(1.5f)
                                        )
                                        Text(
                                            text = user.phoneNumber ?: "N/A",
                                            modifier = Modifier.weight(2f)
                                        )
                                    }
                                }
                            }
                        }
                }
            }
        }
    }
}

