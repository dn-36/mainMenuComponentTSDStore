package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.readText
import org.example.project.core.Navigation
import org.example.project.core.NotesApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMz" +
                "FmMjEyNTljYTMwOWU0YTRiMDU5NWMyODQ0ZmIzMWM4MDY0YTE5YmZlZGYwYjA4OWYwYmQzYjU1ZDljZGMwO" +
                "DlkNDRiMDFmZjA3ZTgwNmEiLCJpYXQiOjE3MjYyNDAwOTcuODkyODYyLCJuYmYiOjE3MjYyNDAwOTcuODky" +
                "ODY1LCJleHAiOjE3NTc3NzYwOTcuODU4NzQyLCJzdWIiOiIyNTQiLCJzY29wZXMiOlsidXNlcl9zZXJ2aWN" +
                "lIl19.zfXlDgMPv3YeW-CJ_0851uuPR3PJuVCFBEjtq7FGcAVaShmy6xI9ZAAveKTvN5_8VOVWlZOTgu9_Y" +
                "2b2FjuRWiKmzcZChbHUFy7PGhVUJC33sL7-er9eav50I-dMdP7w7J5KlCqZqru8x4TCqaR0VgOihurz8cWJ" +
                "0j9qEipUe8aj9g2DAymzI7Cv7J5LgMbz8iCpAlhzEjJ7-u3mN0mMFjWvSbXqMT6KmxYVPbDjC1NHJ_wXKaA" +
                "7dMTN32seXW0OQgQsx2hMm6WB3GWZpY-szyiSPNqG4c6fZEjfMUH2mVAjCpUvvJasva6_TdrInQpnf-aYXI" +
                "e27qgCFHMD8X0WfAj4RdWAZ3bZFzEik4n5ZFzT8Bg7Hu3BRUVWFZuSVekGPn7hrvF3yhrZLHF_jXVL0Y-Hv" +
                "ywbxvNrTPYI1QW5J744NUKY423ninLKflPxnIiSzPFGLj-iHL-3qPOQKPz6F_fzcx-SdwSROPl244mNUnlf" +
                "jJq7CeQKYyzLHK7ZoDXYQycpAV7dIKrZHoW-2F0FC49YyAKf8dHKLfkjX-rYrmg_QeAtng31rSpADtpimug" +
                "H9Gzv6Ak3lOvSHHJAfDFPvPpbNxixgt36y5DvCZPlPcFpp-KUhqIfqPYRFUAO_qCamaAALpQyknOYCB1zW" +
                "cedzSX-j_oyMEQcECcu9Y2MjpE"

        Navigation.navigator()

        val notesApi = NotesApi(token)

        LaunchedEffect(Unit){
            val notesResponse = notesApi.getNotes()
           println("Notes: ${notesResponse}")
        }
        // Получение списка заметок


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
//2. Перенести Navigator в core +
// 3. Переиминовать более точно один из разделов функций +
// 4. Не использовать просто так прошедшее время в иминовании функцйий и переменных +