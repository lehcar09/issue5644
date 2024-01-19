package com.example.testproject

import android.util.Log
import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener
import com.google.firebase.inappmessaging.model.Action
import com.google.firebase.inappmessaging.model.InAppMessage

class MyClickListener : FirebaseInAppMessagingClickListener {

    override fun messageClicked(inAppMessage: InAppMessage, action: Action) {
        // Determine which URL the user clicked
        val url = action.actionUrl
        Log.d("Issue5644", "Clicked URL: $url" )
    }
}