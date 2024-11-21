import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.omidtest.producdetail.ProductDetailScreen
import com.omidtest.product.ProductListScreen

@Composable
fun NavigationGraph(context: Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "productList") {
        composable("productList") {
            ProductListScreen(navController)
        }
        composable(
            "productDetail/{productId}/{title}/{price}/{description}/{category}/{productImage}",
            arguments = listOf(
                navArgument("productId") { type = NavType.StringType },
                navArgument("title") { type = NavType.StringType },
                navArgument("price") { type = NavType.StringType },
                navArgument("category") { type = NavType.StringType },
                navArgument("productImage") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val price = backStackEntry.arguments?.getString("price") ?: ""
            val category = backStackEntry.arguments?.getString("category") ?: ""
            val productImage = backStackEntry.arguments?.getString("productImage") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""

            ProductDetailScreen(navController, productId, title, price,description,category,productImage,context)
        }
    }
}
