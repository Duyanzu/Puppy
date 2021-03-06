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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.IntOffset
import com.dmn.ui.PetDetail
import com.dmn.ui.PetList
import com.dmn.ui.theme.MyTheme
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    val viewModel: PetViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel)
                val openOffset by animateFloatAsState(
                    if (viewModel.openModule == null) {
                        1f
                    } else {
                        0f
                    }
                )
                if (viewModel.currentPet != null) {
                    PetDetail(
                        Modifier.percentOffsetX(openOffset),
                        pet = viewModel.currentPet,
                        viewModel = viewModel
                    ) {
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        if (viewModel.openModule != null) {
            viewModel.closePetDetail()
        } else {
            super.onBackPressed()
        }
    }
}

fun Modifier.percentOffsetX(percent: Float) = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(IntOffset((placeable.width * percent).roundToInt(), 0))
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: PetViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        PetList(viewModel)
    }
}

@Composable
fun LightPreview(viewModel: PetViewModel) {
    MyTheme {
        MyApp(viewModel)
    }
}

@Composable
fun DarkPreview(viewModel: PetViewModel) {
    MyTheme(darkTheme = true) {
        MyApp(viewModel)
    }
}
