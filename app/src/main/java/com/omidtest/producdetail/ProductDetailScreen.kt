package com.omidtest.producdetail

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.domain.product.result.ProductList
import com.omidtest.R

@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: String,
    productTitle: String,
    productPrice: String,
    productDescription: String,
    productCategory: String,
    productImage: String,
    context: Context
) {
    val isBookmarked = remember { mutableStateOf(BookmarkManager.isBookmarked(context, productId)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = productImage,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = productTitle ?: "No title",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Price: $${productPrice ?: "N/A"}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Category: ${productCategory ?: "N/A"}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Description: ${productDescription ?: "N/A"}",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        IconButton(
            onClick = {
                BookmarkManager.toggleBookmark(context, productId)
                isBookmarked.value = !isBookmarked.value
            }
        ) {
            Icon(
                painter = painterResource(id = if (isBookmarked.value) R.drawable.filled_bookmark else R.drawable.outlined_bookmark),
                contentDescription = if (isBookmarked.value) "Remove Bookmark" else "Add Bookmark"
            )
        }
    }
}
