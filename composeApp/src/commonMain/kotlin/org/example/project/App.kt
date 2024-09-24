package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.example.project.core.navigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        navigator()

        /*var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
    }
}
//1. Избавиться от static data
//2. Перенести Navigator в core
// 3. Переиминовать более точно один из разделов функций
// 4. Не использовать просто так прошедшее время в иминовании функцйий и переменных