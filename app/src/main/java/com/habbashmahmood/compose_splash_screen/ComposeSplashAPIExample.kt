package com.habbashmahmood.compose_splash_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.habbashmahmood.compose_splash_screen.ui.theme.ComposeSplashAPIExampleAppTheme
import com.habbashmahmood.compose_splash_screen.ui.theme.DarkRed

class ComposeSplashAPIExample : ComponentActivity() {

    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                splashScreenViewModel.sync.value
            }
        }

        setContent {
            ComposeSplashAPIExampleAppTheme {
                val systemUiController = rememberSystemUiController()
                if (!isSystemInDarkTheme()) {
                    SideEffect {
                        systemUiController.setStatusBarColor(
                            color = DarkRed,
                            darkIcons = false
                        )
                    }
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieBookingScreen()
                }
            }
        }
    }
}

