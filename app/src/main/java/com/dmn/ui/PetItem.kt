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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dmn.PetViewModel
import com.dmn.data.Pet

@Composable
fun PetItem(modifier: Modifier = Modifier, pet: Pet, viewModel: PetViewModel) {
    Row(
        modifier
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(
                onClick = {
                    viewModel.startPetDetail(pet = pet)
                }
            )
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(150.dp, 150.dp),
        ) {
            Image(
                painterResource(pet.avatar), "avatar",
                Modifier
                    .fillMaxSize()
                    .padding(2.dp, 2.dp, 2.dp, 2.dp)
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically),
        ) {
            Text(text = "Name:${pet.name}", fontWeight = FontWeight.Bold)
            Text(text = "Varieties:${pet.varieties}", style = MaterialTheme.typography.body2)
            Text(text = "Hobby:${pet.hobby}", style = MaterialTheme.typography.body2)
        }
    }
}
