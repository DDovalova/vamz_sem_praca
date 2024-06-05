package com.example.vamz_sem_praca

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigacia() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "uvodnaStrana") {
        composable("uvodnaStrana") { UvodnaStrana().UvodStrana(navController) }
        composable("hlavnaStrana") { HlavnaStrana().HlStrana(navController) }
        composable("obed") { Obed().ObedStrana(navController) }
        composable("novyRecept") { NovyRecept().VytvorRecepty(navController) }
    }
}
/*enum class NavigaciaStran(@StringRes val title: Int) {
    UvodnaStrana(title = R.string.app_name),
    Obed(title = R.string.obed),
    NovyRecept(title = R.string.novy_recept),
    PrevodJednotiekGram(title = R.string.prevod_jednotiek),
    PrevodHnaG(title = R.string.prevod_jednotiek)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VrchnyPanelNovy(
    currentScreen: NavigaciaStran,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.tlacislo_spat)
                    )
                }
            }
        }
    )
}

@Composable
fun MojeReceptyApp() {

}*/