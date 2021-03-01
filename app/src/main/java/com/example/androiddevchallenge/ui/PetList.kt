package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.PetViewModel
import com.example.androiddevchallenge.data.Pet

@Composable
fun PetList(viewModel: PetViewModel) {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            PetList(viewModel.pets, viewModel = viewModel)
        }
    }
}

@Composable
fun PetList(pets: List<Pet>, viewModel: PetViewModel) {
    LazyColumn(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    ) {
        itemsIndexed(pets) { index, pet ->
            PetItem(modifier = Modifier, pet, viewModel = viewModel)
            if (index < pets.size - 1) {
                Divider(
                    startIndent = 68.dp,
                    color = MaterialTheme.colors.background,
                    thickness = 0.8f.dp
                )
            }
        }
    }
}
