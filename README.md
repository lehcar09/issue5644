# Issue 5644
### Github Issue Link
- https://github.com/firebase/firebase-android-sdk/issues/5644

### Summary
- Event Listener (FirebaseInAppMessagingDisplayErrorListener) is not triggered when an error in display (i.e image display error) is encountered.
  
### Prerequisite:
- add `google-services.json` file in app

### Steps to reproduce
1. Add FirebaseInAppMessagingDisplayErrorListener via FirebaseInAppMessaging.getInstance().addDisplayErrorListener().
1. Create a new campaign with a jpeg whose format is unsupported and make it display in the app (i.e You can create a non-jpeg file(e.g. .log, .txt, or others...). Modify its' filename extension from .log/.txt/... to .jpg)
1. DisplayErrorListener won't be triggered while displaying error in-app messaging.
