plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.wallet"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.wallet"
        minSdk = 26
        targetSdk = 33
        versionCode = 3
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val dagger_hilt_version = "2.44"
    val room_version = "2.5.2"
    val retrofit_version = "2.9.0"
    val okhttp_version = "3.14.9"
    val gson_version = "2.9.0"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Dagger-Hilt
    implementation("com.google.dagger:hilt-android:$dagger_hilt_version")
    implementation("androidx.fragment:fragment-ktx:1.5.7")
    kapt("com.google.dagger:hilt-android-compiler:$dagger_hilt_version")

    //Room
    implementation("androidx.room:room-runtime:$room_version")
    implementation("androidx.room:room-ktx:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //OkHttp
    implementation("com.squareup.okhttp3:okhttp:$okhttp_version")

    //Gson
    implementation("com.google.code.gson:gson:$gson_version")

    //Material
    implementation("com.google.android.material:material:1.9.0")

    //Constraint Layout for compose
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    //Jetpack Compose Icons
    implementation("androidx.compose.material:material-icons-extended:1.4.3")

    //Live data with compose
    implementation("androidx.compose.runtime:runtime-livedata:1.5.1")

    //Lottie animations
    implementation("com.airbnb.android:lottie-compose:6.0.0")

    //Splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    //FlowLayout
    implementation("com.google.accompanist:accompanist-flowlayout:0.27.0")
}

kapt {
    correctErrorTypes = true
}