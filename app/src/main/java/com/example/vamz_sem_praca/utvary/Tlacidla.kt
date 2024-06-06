package com.example.vamz_sem_praca.utvary

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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import com.example.vamz_sem_praca.data.FavRecepty
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.ui.theme.Mangova

@Composable
fun NavigateButton(
    navController: NavHostController,
    destination: String,
    buttonText: String
) {
    Button(
        onClick = { navController.navigate(destination) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 0.dp, horizontal = 15.dp)
    ) {
        Text(buttonText)
    }
}

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

@Composable
fun SrdceButton(viewModel: FavReceptyViewModel, recepty: FavRecepty) {
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
                contentDescription = "Obľúbený",
                tint = if (isFavorite) Color.Red else Color.DarkGray,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

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
                contentDescription = "Add",
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
