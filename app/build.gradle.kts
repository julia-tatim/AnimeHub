plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.animehub"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.animehub"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding {
        enable = true
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Firebase BOM para gerenciar as versões das bibliotecas do Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))

    // Dependências do Firebase
    implementation("com.google.firebase:firebase-auth")

    // Adicionar RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Retrofit e Gson para API
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Biblioteca para carregar imagens
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)

    // Dependências de teste
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

