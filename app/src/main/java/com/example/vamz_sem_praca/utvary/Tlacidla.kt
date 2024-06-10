package com.example.vamz_sem_praca.utvary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vamz_sem_praca.R
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.vamz_sem_praca.data.FavRecepty
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.ui.theme.Mangova
import androidx.compose.material3.TextButton

/**
 * Komponent pre navigačné tlačidlo.
 *
 * @param navController - navigácia medzi obrazovkami v aplikácii
 * @param destination - funkcia, ktorá vracia cieľovú obrazovku ako reťazec
 * @param buttonText - text zobrazený na tlačidle
 */
@Composable
fun NavigateButton(
    navController: NavHostController,
    destination: () -> String,
    buttonText: String
) {
    Button(
        onClick = { navController.navigate(destination()) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp, horizontal = 15.dp)
    ) {
        Text(buttonText)
    }
}


/**
 * Komponent pre navigačné tlačidlo s obľúbeným receptom.
 *
 * @param recepty - obľúbený recept
 * @param navController - navigácia medzi obrazovkami v aplikácii
 * @param destination - funkcia, ktorá prijíma názov receptu a vracia cieľovú obrazovku
 * @param buttonText - text zobrazený na tlačidle
 */
@Composable
fun NavigateButtonFavRecept(
    recepty: FavRecepty,
    navController: NavHostController,
    destination: (String) -> String,
    buttonText: String
) {
    Button(
        onClick = {
            val destination  = destination(recepty.nazovR)
            navController.navigate(destination)
         },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp, horizontal = 15.dp)
    ) {
        Text(buttonText)
    }
}

/**
 * Komponent pre tlačidlo na vytvorenie nového receptu.
 *
 * @param navController - navigácia medzi obrazovkami v aplikácii
 */
@Composable
fun VytvorButton(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = { navController.navigate("novyRecept") },
            shape = MaterialTheme.shapes.medium,
            containerColor = Mangova,
            contentColor = Color.White,
            modifier = Modifier
                .padding(top = 400.dp)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Create,
                contentDescription = stringResource(R.string.vytvorit),
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}

/**
 * Komponenta pre tlačidlo "Srdce" pre obľúbené recepty.
 *
 * @param viewModel Inštancia [FavReceptyViewModel]
 * @param recepty - recept, ktorý môže byť označený ako obľúbený
 * @param navController - navigácia medzi obrazovkami v aplikácii
 */
@Composable
fun SrdceButton(
    viewModel: FavReceptyViewModel,
    recepty: FavRecepty,
    navController: NavHostController
) {
    var isFavorite by remember { mutableStateOf(viewModel.isFavorite(recepty)) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(
            onClick = {
                isFavorite = !isFavorite
                viewModel.PrepinacOblubene(recepty)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = stringResource(R.string.oblubene),
                tint = if (isFavorite) Color.Red else Color.Black,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

/**
 * Komponenta pre tlačidlo "Viac" s pridaním novej položky.
 *
 * @param onClick - funkcia vykonaná po kliknutí na tlačidlo
 */
@Composable
fun ViacButton(onClick: () -> Unit) {
    FloatingActionButton(
         onClick = onClick,
         containerColor = Mangova,
         contentColor = Color.White,
         modifier = Modifier
             .padding(16.dp)
    ) {
    Icon(
         Icons.Filled.Add,
         contentDescription = stringResource(R.string.pridaj),
         modifier = Modifier
             .size(30.dp)
        )
    }
}

/**
 * Komponenta pre tlačidlo s tromi bodkami a dialógom.
 *
 * @param modifier - modifikátor pre prispôsobenie vzhľadu komponentu
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreVertButton(modifier: Modifier = Modifier) {
    val (zobrazUlozButton, setZobrazUlozButton) = remember { mutableStateOf(false) }
    val (zobrazDialog, setZobrazDialog) = remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd
    ) {
        if (zobrazUlozButton) {
            Button(
                onClick = {
                    setZobrazDialog(true)
                    setZobrazUlozButton(false)
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = stringResource(R.string.ulozit))
            }
        } else {
            IconButton(
                onClick = { setZobrazUlozButton(true) }
            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = stringResource(R.string.bodky),
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        if (zobrazDialog) {
            AlertDialog(
                onDismissRequest = { setZobrazDialog(false) },
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(stringResource(R.string.recept_ulozeny))
                    TextButton(
                        onClick = { setZobrazDialog(false)}
                    ) {
                        Text(text = stringResource(R.string.ok),
                            modifier = Modifier
                                .padding(top = 90.dp)
                                .size(40.dp)
                        )
                    }
                }
            }
        }
    }
}
