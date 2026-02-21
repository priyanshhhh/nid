# Nida – My Personal AI Android App

This document provides instructions for setting up, configuring, and building the "Nida – My Personal AI" Android application.

## Project Structure

The project follows a standard Android project structure with Kotlin and Jetpack Compose for UI.

```
NidaAI/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/com/nida/ai/
│   │   │   │   ├── data/ (for data models and repositories)
│   │   │   │   ├── service/ (for API services like OpenAI)
│   │   │   │   ├── ui/ (for UI components and screens)
│   │   │   │   │   ├── theme/ (for Material You theme definitions)
│   │   │   │   ├── utils/ (for utility classes like SpeechToText)
│   │   │   ├── res/
│   │   │   │   ├── drawable/ (for drawables, including app logo)
│   │   │   │   ├── layout/ (for XML layouts, if any)
│   │   │   │   ├── mipmap-anydpi-v26/ (for adaptive launcher icon)
│   │   │   │   ├── values/ (for colors, strings, themes)
│   │   ├── build.gradle (App-level Gradle configuration)
│   ├── proguard-rules.pro
├── build.gradle (Project-level Gradle configuration)
├── settings.gradle
└── README.md
```

## Setup Instructions

### 1. Android Studio Installation

If you don't have Android Studio installed, download and install it from the official website: [https://developer.android.com/studio](https://developer.android.com/studio)

### 2. Open the Project

1. Launch Android Studio.
2. Select `Open an existing Android Studio project`.
3. Navigate to the `NidaAI` directory and click `Open`.

Android Studio will sync the project and download any necessary dependencies.

### 3. Firebase Configuration

This app uses Firebase for authentication and database. Follow these steps to set up Firebase for your project:

1. **Create a Firebase Project:**
   - Go to the Firebase Console: [https://console.firebase.google.com/](https://console.firebase.google.com/)
   - Click `Add project` and follow the on-screen instructions to create a new project.

2. **Add Android App to Firebase Project:**
   - In your Firebase project, click the Android icon to add an Android app.
   - **Package name:** `com.nida.ai`
   - **App nickname:** `Nida AI` (or any name you prefer)
   - **SHA-1:** (Optional, but recommended for Google Sign-In and other services)
     - To get your SHA-1, open Android Studio, open the `Gradle` tab (usually on the right side), navigate to `app` -> `Tasks` -> `android` -> `signingReport`. Run this task and copy the SHA-1 from the output.

3. **Download `google-services.json`:**
   - After registering your app, download the `google-services.json` file.
   - Place this file in the `app/` directory of your Android project (i.e., `/home/ubuntu/NidaAI/app/google-services.json`).

4. **Enable Firebase Authentication and Firestore:**
   - In the Firebase Console, go to `Build` -> `Authentication` and enable the desired sign-in methods (e.g., Email/Password, Google).
   - Go to `Build` -> `Firestore Database` and create a new database. Choose a starting mode (e.g., `Start in production mode` or `Start in test mode`).

### 4. OpenAI API Key Integration

1. **Obtain an OpenAI API Key:**
   - If you don't have one, create an account and generate an API key from the OpenAI platform: [https://platform.openai.com/account/api-keys](https://platform.openai.com/account/api-keys)

2. **Update `OpenAIService.kt`:**
   - Open the file `/home/ubuntu/NidaAI/app/src/main/java/com/nida/ai/service/OpenAIService.kt`.
   - Replace `
YOUR_OPENAI_API_KEY` with your actual OpenAI API key:

   ```kotlin
   private val OPENAI_API_KEY = "YOUR_ACTUAL_OPENAI_API_KEY"
   ```

### 5. Permissions

The app requires the following permissions, which are already declared in `AndroidManifest.xml`:

- `android.permission.INTERNET`: For network access to Firebase and OpenAI.
- `android.permission.RECORD_AUDIO`: For voice-to-text functionality.
- `android.permission.READ_EXTERNAL_STORAGE` and `android.permission.WRITE_EXTERNAL_STORAGE`: For potential file operations (e.g., saving notes, images).
- `android.permission.USE_BIOMETRIC` and `android.permission.USE_FINGERPRINT`: For biometric authentication (app lock).

## Building the APK

There are two primary ways to build the APK:

### Method 1: Using Android Studio

1. **Open the Project:** Ensure the project is open in Android Studio and has successfully synced.
2. **Build Menu:** Go to `Build` -> `Build Bundle(s) / APK(s)` -> `Build APK(s)`.
3. **Locate APK:** Android Studio will build the debug APK. Once complete, a notification will appear with a link to `locate` the APK. The APK will typically be found in `app/build/outputs/apk/debug/app-debug.apk`.

### Method 2: Using Gradle Command Line

1. **Open Terminal:** Navigate to the root directory of your project (`/home/ubuntu/NidaAI/`) in your terminal.
2. **Run Gradle Build:** Execute the following command:
   ```bash
   ./gradlew assembleDebug
   ```
   For a release build (signed APK), you would use `assembleRelease` after configuring signing information in your `build.gradle` file.
3. **Locate APK:** The generated debug APK will be located at `app/build/outputs/apk/debug/app-debug.apk`.

## Running the App

To run the app on an emulator or a physical device:

### From Android Studio

1. **Select Device:** In Android Studio, select your desired emulator or connected physical device from the toolbar.
2. **Run Button:** Click the `Run` button (green triangle icon) in the toolbar.

### From Command Line (after building APK)

1. **Install APK:** Connect your Android device or start an emulator. Then, use ADB to install the APK:
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```
2. **Launch App:** Once installed, you can launch the app from your device's app drawer.

## Further Development

This project provides the foundational structure and core components. Further development would involve:

- **Implementing remaining features:** Fill in the `TODO` comments in the Kotlin files for all specified features (e.g., emotional support mode, Hinglish support, memory, all personal and utility features, security, advanced features).
- **UI/UX Refinements:** Enhance the Material You design, add smooth animations, and implement the floating AI chat button.
- **Backend Integration:** Fully integrate Firebase for all data storage and authentication needs.
- **Testing:** Write unit and integration tests for robustness.
- **Localization:** Add support for multiple languages.

**Author:** Manus AI
