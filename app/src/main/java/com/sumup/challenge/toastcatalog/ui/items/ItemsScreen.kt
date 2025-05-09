package com.sumup.challenge.toastcatalog.ui.items

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumup.challenge.toastcatalog.ui.items.state.ItemUiState

@Composable
fun ItemScreen(viewModel: ItemViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.observeAsState(ItemUiState.Loading)

    LaunchedEffect(Unit) {
        viewModel.loadItems() // Load items when the screen is first composed
    }

    when (uiState) {
        is ItemUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator() // Show loading indicator
            }
        }

        is ItemUiState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = (uiState as ItemUiState.Error).message, // Show error message
                    color = MaterialTheme.colorScheme.error
                )
            }
        }

        is ItemUiState.Success -> {
            val items = (uiState as ItemUiState.Success).items
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items) { item ->
                    ItemRow(item = item) // Display items in a row
                }
            }
        }
    }
}