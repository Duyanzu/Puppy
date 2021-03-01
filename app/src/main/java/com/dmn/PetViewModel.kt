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
package com.dmn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dmn.data.Module
import com.dmn.data.Pet
import com.example.androiddevchallenge.R

class PetViewModel : ViewModel() {
    var pets by mutableStateOf(
        listOf(
            Pet("cici", "Ragdoll", "eat,sleep", R.mipmap.ragdoll),
            Pet("sun", "Tabby ", "eat", R.mipmap.tabby),
            Pet("tim", "Golden hair", "play,eat", R.mipmap.golden_hair),
            Pet("cat", "Devon", "play", R.mipmap.devon),
        )
    )

    var openModule: Module? by mutableStateOf(null)

    var currentPet: Pet? by mutableStateOf(null)

    fun startPetDetail(pet: Pet) {
        currentPet = pet
        openModule = Module.PetDetail
    }

    fun closePetDetail() {
        openModule = null
    }
}
