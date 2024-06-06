package com.example.vamz_sem_praca.utvary

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SrdceButton() {
    var isFavorite by remember { mutableStateOf(false) }

    IconButton(
        onClick = { isFavorite = !isFavorite },
        ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Obľúbený",
            tint = if (isFavorite) Color.Red else Color.Gray,
            modifier = Modifier.size(48.dp)
        )
    }
}
