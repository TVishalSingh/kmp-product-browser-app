package presentation.productlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.Product

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

@Composable
fun ProductListScreen(
    uiState: ProductListUiState,
    onProductClick: (Product) -> Unit,
    onSearch: (String) -> Unit
) {


    var query by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        when {

            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            uiState.error != null -> {
                Text(uiState.error!!)
            }

            else -> {

                Column {

                    OutlinedTextField(
                        value = query,
                        onValueChange = {
                            query = it
                            onSearch(it)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        label = {
                            Text("Search Products")
                        },
                        singleLine = true
                    )

                    LazyColumn (
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ){

                        items(uiState.products) { product ->

                            ProductItem(
                                product = product,
                                onClick = onProductClick
                            )

                        }

                    }

                }
            }
        }
    }
}