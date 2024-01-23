package com.dfl.comunicationdriveserver.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dfl.comunicationdriveserver.domain.model.ProductModel
import com.dfl.comunicationdriveserver.ui.theme.ComunicationDriveServerTheme
import dagger.hilt.android.AndroidEntryPoint

private val testUI = listOf(
    ProductModel(
        "account", "nomina", "1111", 2342423L, "open"
    ), ProductModel(
        "credit", "Visa", "12222", 22223L, "close"
    )
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComunicationDriveServerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateList(
                        viewModel.productsUser?.products ?: testUI
                    ) { viewModel.sendDelivery(it) }
                }
            }
        }
        viewModel.getInformation()
        //observer
    }
}

@Composable
fun CreateList(productModels: List<ProductModel>, function: (ProductModel) -> Unit) {
    LazyColumn {
        items(productModels) { product ->
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .animateContentSize()
                    .padding(all = 8.dp)
                    .clickable {
                        function.invoke(product)
                    }
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = product.type)
                        Text(text = "$ ${product.balance}")
                    }
                    Text(text = product.name)
                    Text(text = product.number)
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComunicationDriveServerTheme {
        CreateList(testUI) { }
    }
}