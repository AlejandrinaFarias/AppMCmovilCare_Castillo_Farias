package com.example.appmcmovilcare_castillo_farias.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmcmovilcare_castillo_farias.R
import com.example.appmcmovilcare_castillo_farias.ui.theme.AppMCmovilCare_Castillo_FariasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // Estructura de la pantalla con una barra superior.
    Scaffold(
        topBar = {
            // Barra superior con los colores del tema.
            TopAppBar(
                title = {
                    Text("MCmovil Care")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->

        // Ordena los elementos verticalmente.
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen provisional del proyecto.
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                contentDescription = "Imagen de la aplicación",
                modifier = Modifier.size(100.dp)
            )

            // Título de bienvenida centrado.
            Text(
                text = "Bienvenido a MCmovil Care",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Descripción con el estilo y color del tema.
            Text(
                text = "Consulta el estado y cuidado de tus equipos",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Resumen con datos ficticios.
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Equipos: 2")
                Text("Pendientes: 1")
            }

            // Las acciones se implementarán más adelante.
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Mis equipos")
            }

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Solicitar atención")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppMCmovilCare_Castillo_FariasTheme {
        HomeScreen()
    }
}