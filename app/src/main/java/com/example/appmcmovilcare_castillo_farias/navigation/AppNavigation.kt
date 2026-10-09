package com.example.appmcmovilcare_castillo_farias.navigation

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmcmovilcare_castillo_farias.ui.HomeScreen
import com.example.appmcmovilcare_castillo_farias.ui.screens.MisEquiposScreen
import com.example.appmcmovilcare_castillo_farias.ui.screens.SolicitarAtencionScreen
import com.example.appmcmovilcare_castillo_farias.viewmodel.NavigationViewModel

@Composable
fun AppNavigation(
    anchoVentana: WindowWidthSizeClass,
    navigationViewModel: NavigationViewModel = viewModel()
) {
    val navController = rememberNavController()
    val lifecycleOwner = LocalLifecycleOwner.current

    // Recibe los eventos del ViewModel cuando la interfaz está activa.
    LaunchedEffect(navController, lifecycleOwner, navigationViewModel) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            navigationViewModel.navigationEvents.collect { event ->
                when (event) {
                    is NavigationEvent.NavigateTo -> {
                        navController.navigate(event.destination.route) {
                            // Conserva Inicio como base y evita acumular pantallas.
                            popUpTo(AppRoutes.Inicio.route) {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }

                    NavigationEvent.NavigateBack -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }

    // Relaciona cada ruta con su pantalla.
    NavHost(
        navController = navController,
        startDestination = AppRoutes.Inicio.route
    ) {
        composable(AppRoutes.Inicio.route) {
            HomeScreen(
                anchoVentana = anchoVentana,
                onMisEquipos = {
                    navigationViewModel.navegarA(AppRoutes.MisEquipos)
                },
                onSolicitarAtencion = {
                    navigationViewModel.navegarA(AppRoutes.SolicitarAtencion)
                }
            )
        }

        composable(AppRoutes.MisEquipos.route) {
            MisEquiposScreen(
                onVolver = {
                    navigationViewModel.volver()
                },
                onSolicitarAtencion = {
                    navigationViewModel.navegarA(AppRoutes.SolicitarAtencion)
                }
            )
        }

        composable(AppRoutes.SolicitarAtencion.route) {
            SolicitarAtencionScreen(
                onInicio = {
                    navigationViewModel.navegarA(AppRoutes.Inicio)
                },
                onMisEquipos = {
                    navigationViewModel.navegarA(AppRoutes.MisEquipos)
                },
                onVolver = {
                    navigationViewModel.volver()
                }
            )
        }
    }
}