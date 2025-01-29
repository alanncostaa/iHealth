package com.example.ihealth

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ihealth.screen.DrinkDetailScreen
import com.example.ihealth.screen.DrinkScreen
import com.example.ihealth.screen.DrinkingHistoryScreen
import com.example.ihealth.screen.LoginScreen
import com.example.ihealth.screen.MetasScreen
import com.example.ihealth.screen.MetricScreen
import com.example.ihealth.screen.ProfileScreen
import com.example.ihealth.screen.RegisterScreen
import com.example.ihealth.ui.theme.IHealthTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IHealthTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "LoginScreen"){
                    composable(
                        route = "drinkScreen"
                    ){
                        DrinkScreen(navController)
                    }
                    composable(
                        route = "drinkingHistory"
                    ){
                        DrinkingHistoryScreen(navController)
                    }
                    composable(
                        route = "drinkDetail"
                    ){
                        DrinkDetailScreen(navController)
                    }
                    composable(
                        route = "profileScreen"
                    ){
                        ProfileScreen(navController)
                    }
                    composable(
                        route = "metasScreen"
                    ){
                        MetasScreen(navController)
                    }
                    composable(
                        route = "metricScreen"
                    ){
                        MetricScreen(navController)
                    }
                    composable(
                        route = "loginScreen"
                    ){
                        LoginScreen(navController)
                    }

                    composable(
                        route = "registerScreen"
                    ){
                        RegisterScreen(navController)
                    }
                }
            }
        }
    }
}

