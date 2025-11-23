package com.example.prosync.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prosync.Screens.AddNote
import com.example.prosync.Screens.AddTask
import com.example.prosync.Screens.DashboardScreen
import com.example.prosync.Screens.Login
import com.example.prosync.Screens.Nodedetail
import com.example.prosync.Screens.OnboardingScreen
import com.example.prosync.Screens.Profile
import com.example.prosync.Screens.Registration
import com.example.prosync.Screens.notelist
import com.example.prosync.Screens.settingscreen
import com.example.prosync.Screens.splashscreen
import com.example.prosync.Screens.taskdetail
import com.example.prosync.Screens.tasklist


@Composable
fun appnavigation(){
    val navController=rememberNavController()
    NavHost(navController=navController, startDestination = "Login"){
        composable("Splashscreen"){
            splashscreen()
        }
        composable("AddNote"){
            AddNote(navController)
        }
        composable("AddTask"){
            AddTask(navController)
        }
        composable("DashboardScreen"){
            DashboardScreen(navController)
        }
        composable("Login"){
            Login(navController)
        }
        composable("Nodedetail"){
            Nodedetail(navController)
        }
        composable("notelist"){
            notelist(navController)
        }
        composable("OnboardingScreen"){
            OnboardingScreen(navController)
        }
        composable("Profile"){
            Profile(navController)
        }
        composable("Registration"){
            Registration(navController)
        }
        composable("settingscreen"){
            settingscreen(navController)
        }
        composable("taskdetail"){
            taskdetail(navController)
        }
        composable("tasklist"){
            tasklist(navController)
        }


    }
}