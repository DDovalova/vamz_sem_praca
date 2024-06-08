package com.example.vamz_sem_praca.utvary

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vamz_sem_praca.R
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.launch
import com.example.vamz_sem_praca.ui.theme.Mangova
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import com.example.vamz_sem_praca.data.FavRecepty


@Composable
fun VrchnyPanel(
    nazovStrany: String,
    onMenuClick: () -> Unit,
    //onSearchClick: (String?) -> Unit,
    navController: NavHostController,
    //destination: () -> String,
    //recepty: FavRecepty
) {
    var zobrazHladajField by remember { mutableStateOf(false) }
    var hladanyText by remember { mutableStateOf("") }
    //var hladanyRecept by remember { mutableStateOf("") }

   // val destination  = destination(recepty.nazovR)
    val lievanceString = stringResource(R.string.lievance)
    val milkshakeString = stringResource(R.string.milkshake)
    val cestovinyString = stringResource(R.string.cestoviny)
    val polievkaString = stringResource(R.string.paradajkova_polievka)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Mangova)
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Filled.Menu, contentDescription = stringResource(R.string.menu))
            }
        }
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (zobrazHladajField) {
                TextField(
                    value = hladanyText,
                    onValueChange = { hladanyText = it },
                    modifier = Modifier
                        .background(Mangova)
                        .padding(horizontal = 10.dp, vertical = 0.dp),
                    placeholder = { Text(stringResource(R.string.vyhladaj_recept)) }
                )
            } else {
                Text(
                    text = nazovStrany,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        Row(
            modifier = Modifier.align(Alignment.TopEnd),
            verticalAlignment = Alignment.Bottom
        ) {
            IconButton(onClick = {
                if (zobrazHladajField && hladanyText.isNotBlank()) {
                    val destination = when (hladanyText) {
                        lievanceString -> "lievance"
                        milkshakeString -> "milkshake"
                        cestovinyString -> "cestoviny"
                        polievkaString -> "polievka"
                        else -> "hlavnaStrana"
                    }
                    navController.navigate(destination)
                }
                zobrazHladajField = !zobrazHladajField
            }) {
                Icon(Icons.Filled.Search, contentDescription = stringResource(R.string.hladaj))
            }
        }
    }
}

@Composable
fun MenuPanel(
    navController: NavHostController,
    drawerState: DrawerState
) {
    val rozsah = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Mangova)
                    .statusBarsPadding()
                    .verticalScroll(rememberScrollState())
                    .horizontalScroll(rememberScrollState())
                    .safeDrawingPadding()
                    .padding(horizontal = 16.dp, vertical = 30.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("hlavnastrana") }) {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = stringResource(R.string.home)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.hl_strana),
                        navDestination = "hlavnaStrana",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("oblubene") }) {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = stringResource(R.string.oblubene)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.oblubene),
                        navDestination = "oblubene",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("ranajky")}) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = stringResource(R.string.sipka)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.ranajky),
                        navDestination = "ranajky",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("obed") }) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = stringResource(R.string.sipka)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.obed),
                        navDestination = "obed",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("vecera")}) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = stringResource(R.string.sipka)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.vecera),
                        navDestination = "vecera",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("dezert")}) {
                        Icon(
                            Icons.Filled.KeyboardArrowRight,
                            contentDescription = stringResource(R.string.sipka)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.dezert),
                        navDestination = "dezert",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("prevodGnaH")}) {
                        Icon(
                            Icons.Filled.Star,
                            contentDescription = stringResource(R.string.sipka)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.GnaH),
                        navDestination = "prevodGnaH",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate("prevodHnaG") }) {
                        Icon(
                            Icons.Filled.Star,
                            contentDescription = stringResource(R.string.sipka)
                        )
                    }
                    TextMenu(
                        text = stringResource(R.string.HnaG),
                        navDestination = "prevodHnaG",
                        navController = navController,
                        drawerState = drawerState
                    )
                }
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
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate(navDestination)
                scope.launch { drawerState.close() }
            }
    )
}
