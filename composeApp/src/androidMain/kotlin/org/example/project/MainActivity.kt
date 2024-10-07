package org.example.project

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.project.chats.ChatScreensApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.mp.KoinPlatform.getKoin

class MainActivity : ComponentActivity() {

    companion object{
        lateinit var context: MainActivity
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this
        initKoin {
            androidContext(this@MainActivity.applicationContext)
        }


       /*initKoin {
            androidContext(this@MainActivity.applicationContext)
        }*/
        setContent {
            App()
          //  chatScreen.ChatsScreen().Content()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

