/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dmn.ui

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
import com.dmn.PetViewModel
import com.dmn.data.Pet

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
