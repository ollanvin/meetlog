package app.meetlog.mobile

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.meetlog.mobile.feature.billing.BillingScreen
import app.meetlog.mobile.feature.settings.SettingsScreen
import app.meetlog.mobile.ui.home.HomeScreen

private const val ROUTE_HOME = "home"
private const val ROUTE_SETTINGS = "settings"
private const val ROUTE_BILLING = "billing"

@Composable
fun MeetLogNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE_HOME) {
        composable(ROUTE_HOME) {
            HomeScreen(
                onOpenSettings = { navController.navigate(ROUTE_SETTINGS) },
                onOpenBilling = { navController.navigate(ROUTE_BILLING) }
            )
        }
        composable(ROUTE_SETTINGS) { SettingsScreen() }
        composable(ROUTE_BILLING) { BillingScreen() }
    }
}
