package presentation.productlist.productdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import domain.model.Product

@Composable
fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Button(
            onClick = onBack
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = 8.dp
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Brand: ${product.brand}"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Rating: ⭐ ${product.rating}"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Price: $${product.price}",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Description",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(product.description)

            }

        }
    }
}