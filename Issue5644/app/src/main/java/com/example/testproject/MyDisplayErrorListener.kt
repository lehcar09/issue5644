package com.example.testproject

import android.util.Log
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener
import com.google.firebase.inappmessaging.model.InAppMessage

class MyDisplayErrorListener : FirebaseInAppMessagingDisplayErrorListener {

    override fun displayErrorEncountered(
        inAppMessage: InAppMessage,
        errorReason: FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason
    ) {
        Log.d("Issue5644", "Display Error: $errorReason")
    }
}