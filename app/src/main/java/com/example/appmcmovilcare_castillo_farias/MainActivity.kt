package com.example.appmcmovilcare_castillo_farias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appmcmovilcare_castillo_farias.ui.HomeScreen
import com.example.appmcmovilcare_castillo_farias.ui.theme.AppMCmovilCare_Castillo_FariasTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // Define lo que mostrará la aplicación.
        setContent {

            // Aplica los colores y estilos del proyecto.
            AppMCmovilCare_Castillo_FariasTheme {

                // Muestra nuestra pantalla de inicio.
                HomeScreen()
            }
        }
    }
}