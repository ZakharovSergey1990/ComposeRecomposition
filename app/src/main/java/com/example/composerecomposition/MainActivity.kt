package com.example.composerecomposition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composerecomposition.constant.NavRoute
import com.example.composerecomposition.constant.TipInfo
import com.example.composerecomposition.page.fifth_tip_page.FifthTipPage
import com.example.composerecomposition.page.first_tip_page.FirstTipPage
import com.example.composerecomposition.page.fourth_tip_page.FourthTipPage
import com.example.composerecomposition.page.second_tip_page.SecondTipPage
import com.example.composerecomposition.page.startpage.StartPage
import com.example.composerecomposition.page.third_tip_page.ThirdTipPage
import com.example.composerecomposition.ui.theme.ComposeRecompositionTheme
import com.example.composerecomposition.ui_component.InfoDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeRecompositionTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    InfoDialog(title = "Base information", info = TipInfo.BASE_INFO)
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = NavRoute.START) {
                        composable(NavRoute.START){
                            StartPage(navController = navController)
                        }
                        composable(NavRoute.FIRST_EXAMPLE){
                            FirstTipPage()
                        }
                        composable(NavRoute.SECOND_EXAMPLE){
                            SecondTipPage()
                        }
                        composable(NavRoute.THIRD_EXAMPLE){
                            ThirdTipPage()
                        }
                        composable(NavRoute.FOURTH_EXAMPLE){
                            FourthTipPage()
                        }
                        composable(NavRoute.FIFTH_EXAMPLE){
                            FifthTipPage()
                        }
                    }
                }
            }
        }
    }
}
