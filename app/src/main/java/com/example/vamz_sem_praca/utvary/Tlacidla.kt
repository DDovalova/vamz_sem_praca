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
fun PlusButton(
    navController: NavHostController
) {
    FloatingActionButton(
        onClick = { navController.navigate("novyRecept")},
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(top = 480.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.vytvorit)
        )
    }
}

@Composable
fun SrdceButton() {
    var isFavorite by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        IconButton(
            onClick = { isFavorite = !isFavorite }
            ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Obľúbený",
                tint = if (isFavorite) Color.Red else Color.Gray,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}