package com.example.vamz_sem_praca.utvary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vamz_sem_praca.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.launch


@Composable
fun VrchnyPanel(
    nazovStrany: String,
    onMenuClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onMenuClick) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
        }
        Text(
            text = nazovStrany,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun MenuPanel(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Green)
                    .padding(horizontal = 16.dp, vertical = 30.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ){
                TextMenu(
                    text = stringResource(R.string.hl_strana),
                    navDestination = "hlavnaStrana",
                    navController = navController,
                    drawerState = drawerState
                )
                TextMenu(
                    text = stringResource(R.string.ranajky),
                    navDestination = "ranajky",
                    navController = navController,
                    drawerState = drawerState
                )
                TextMenu(
                    text = stringResource(R.string.obed),
                    navDestination = "obed",
                    navController = navController,
                    drawerState = drawerState
                )
                TextMenu(
                    text = stringResource(R.string.vecera),
                    navDestination = "vecera",
                    navController = navController,
                    drawerState = drawerState
                )
                TextMenu(
                    text = stringResource(R.string.dezert),
                    navDestination = "dezert",
                    navController = navController,
                    drawerState = drawerState
                )
                TextMenu(
                    text = stringResource(R.string.GnaH),
                    navDestination = "prevodGnaH",
                    navController = navController,
                    drawerState = drawerState
                )
                TextMenu(
                    text = stringResource(R.string.HnaG),
                    navDestination = "prevodHnaG",
                    navController = navController,
                    drawerState = drawerState
                )
            }
        },
        content = { }
    )
}

@Composable
fun TextMenu(
    text: String,
    navDestination: String,
    navController: NavHostController,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(navDestination)
                scope.launch { drawerState.close() }
            }
    )
}