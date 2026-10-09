package com.example.appmcmovilcare_castillo_farias.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmcmovilcare_castillo_farias.ui.screens.HomeCompactScreen
import com.example.appmcmovilcare_castillo_farias.ui.screens.HomeExpandedScreen
import com.example.appmcmovilcare_castillo_farias.ui.screens.HomeMediumScreen
import com.example.appmcmovilcare_castillo_farias.ui.theme.AppMCmovilCare_Castillo_FariasTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    anchoVentana: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    onMisEquipos: () -> Unit = {},
    onSolicitarAtencion: () -> Unit = {}
) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Menú lateral con los destinos de la aplicación.
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "MCmovil Care",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(24.dp)
                )

                HorizontalDivider()

                NavigationDrawerItem(
                    label = { Text("Inicio") },
                    selected = true,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 8.dp
                    )
                )

                NavigationDrawerItem(
                    label = { Text("Mis equipos") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            onMisEquipos()
                        }
                    },
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                NavigationDrawerItem(
                    label = { Text("Solicitar atención") },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            onSolicitarAtencion()
                        }
                    },
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 8.dp
                    )
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("MCmovil Care")
                    },
                    navigationIcon = {
                        TextButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Text(
                                text = "Menú",
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)

            // Conserva los tres diseños adaptables de Inicio.
            when (anchoVentana) {
                WindowWidthSizeClass.Compact -> {
                    HomeCompactScreen(
                        modifier = modifier,
                        onMisEquipos = onMisEquipos,
                        onSolicitarAtencion = onSolicitarAtencion
                    )
                }

                WindowWidthSizeClass.Medium -> {
                    HomeMediumScreen(
                        modifier = modifier,
                        onMisEquipos = onMisEquipos,
                        onSolicitarAtencion = onSolicitarAtencion
                    )
                }

                else -> {
                    HomeExpandedScreen(
                        modifier = modifier,
                        onMisEquipos = onMisEquipos,
                        onSolicitarAtencion = onSolicitarAtencion
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun HomeScreenPreview() {
    AppMCmovilCare_Castillo_FariasTheme {
        HomeScreen()
    }
}