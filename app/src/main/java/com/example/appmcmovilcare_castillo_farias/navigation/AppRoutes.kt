package com.example.appmcmovilcare_castillo_farias.navigation

// Define los destinos disponibles de la aplicación.
sealed class AppRoutes(val route: String) {
    object Inicio : AppRoutes("inicio")
    object MisEquipos : AppRoutes("mis_equipos")
    object SolicitarAtencion : AppRoutes("solicitar_atencion")
}