package com.example.testproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testproject.ui.theme.Issue5644Theme

import com.google.firebase.inappmessaging.inAppMessaging
import com.google.firebase.Firebase
import com.google.firebase.inappmessaging.FirebaseInAppMessaging
import com.google.firebase.installations.installations

class MainActivity : ComponentActivity() {

    private lateinit var firebaseIam: FirebaseInAppMessaging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Issue5644Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        firebaseIam = Firebase.inAppMessaging

        val listener = MyClickListener()
        firebaseIam.addClickListener(listener)

        val errorListener = MyDisplayErrorListener()
        firebaseIam.addDisplayErrorListener(errorListener)

        firebaseIam.isAutomaticDataCollectionEnabled = true
        firebaseIam.setMessagesSuppressed(false)

        // Get and display/log the installation id
        Firebase.installations.id
            .addOnSuccessListener { id ->
                Log.d(TAG, "Installation ID: $id")
            }
    }

    companion object {

        private const val TAG = "FIAM-Quickstart"

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Issue5644Theme {
        Greeting("Android")
    }
}