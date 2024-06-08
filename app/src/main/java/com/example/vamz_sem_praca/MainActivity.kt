package com.example.vamz_sem_praca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.vamz_sem_praca.data.FavReceptyViewModel
import com.example.vamz_sem_praca.navigacia.Navigacia
import com.example.vamz_sem_praca.ui.theme.Vamz_sem_pracaTheme

class MainActivity : ComponentActivity() {
    private val favReceptyViewModel by lazy { ViewModelProvider(this).get(FavReceptyViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Vamz_sem_pracaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigacia(viewModel = favReceptyViewModel)
                }
            }
        }
    }
}
