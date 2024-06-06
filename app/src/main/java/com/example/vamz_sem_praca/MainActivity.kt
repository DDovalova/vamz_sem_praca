package com.example.vamz_sem_praca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.navigacia.Navigacia
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme

class MainActivity : ComponentActivity() {
    private val viewModel by lazy { FavReceptyViewModel() }
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Vamz_sem_pracaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigacia(viewModel = viewModel)
                }
            }
        }
    }
}



