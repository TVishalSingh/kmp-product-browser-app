package presentation.productlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import coil3.compose.AsyncImage
import domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    onClick: (Product) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick(product)
            },
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "$${product.price}")
            }
        }


        Row(
            modifier = Modifier.padding(12.dp)
        ) {

          /*  AsyncImage(
                model = product.thumbnail,
                contentDescription = product.title,
                modifier = Modifier.size(80.dp)
            )*/

            Spacer(modifier = Modifier.width(12.dp))

            Column {

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$${product.price}"
                )
            }
        }
    }
}