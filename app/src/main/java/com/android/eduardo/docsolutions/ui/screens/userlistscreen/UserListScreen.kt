package com.android.eduardo.docsolutions.ui.screens.userlistscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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
    navigateToNewUserScreen: (Int) -> Unit,
    viewModel: UserListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    when (val userListUiState = viewModel.userListUiState) {
        is UserListUiState.Init ->
            UserListBody(viewModel = viewModel)

        is UserListUiState.Error ->
            UserListBody(viewModel = viewModel)

        is UserListUiState.Success -> {
            UserListBody(viewModel = viewModel)
        }
    }
}

@Composable
fun UserListBody(
    modifier: Modifier = Modifier,
    viewModel: UserListViewModel
) {
    var buscar by remember { mutableStateOf("") }

    val context = LocalContext.current
    if (viewModel.userListUiState == UserListUiState.Error) {
        Toast.makeText(
            context, "Ocurrio un error ",
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
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Ok",
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.1f))
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Nuevo",
                            fontSize = 20.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.size(25.dp))
                LazyColumn {
                    item {
                        Row {
                            Text(text = "Username")
                        }
                    }
                    items(
                        items = listOf(
                            "hol",
                            "hol",
                            "hol",
                            "hol",
                            "hol",
                            "hol",
                            "hol",
                        )
                    ) { user ->
                        Row(
                            modifier = Modifier
                                .background(Color.LightGray)
                                .fillMaxWidth(),

                            ) {
                            Text(text = user)
                        }

                    }
                }
            }
        }
    }
}

