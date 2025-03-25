plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.foodies.app"
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = libs.versions.appId.get()
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = libs.versions.android.versionCode.get().toInt()
        versionName = libs.versions.android.versionName.get()

        testInstrumentationRunner = "com.foodies.app.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {

    implementation(libs.compose.compiler)
    implementation(libs.compose.ui)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.compose.hiltNavigationCompose)
    implementation(libs.compose.material)
    implementation(libs.compose.runtime)
    implementation(libs.compose.navigation)
    implementation(libs.compose.viewModelCompose)
    implementation(libs.compose.activityCompose)
    implementation(libs.compose.composeIcons)

    implementation(libs.hilt.hiltAndroid)
    kapt(libs.hilt.hiltCompiler)

    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":onboarding:onboarding_presentation"))
    implementation(project(":onboarding:onboarding_domain"))
    implementation(project(":home:home_presentation"))
    implementation(project(":home:home_domain"))
    implementation(project(":home:home_data"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.coil.coilCompose)

    implementation(libs.google.material)

    implementation(libs.retrofit.okHttp)
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.okHttpLoggingInterceptor)
    implementation(libs.retrofit.moshiConverter)

    kapt(libs.room.roomCompiler)
    implementation(libs.room.roomKtx)
    implementation(libs.room.roomRuntime)

    implementation(libs.google.accompanist)

    implementation(libs.coroutines.coroutines)

    testImplementation(libs.testing.junit4)
    testImplementation(libs.testing.junitAndroidExt)
    testImplementation(libs.testing.truth)
    testImplementation(libs.testing.coroutines)
    testImplementation(libs.testing.turbine)
    testImplementation(libs.compose.uiTest)
    testImplementation(libs.testing.mockk)
    testImplementation(libs.testing.mockWebServer)

    androidTestImplementation(libs.testing.junit4)
    androidTestImplementation(libs.testing.junitAndroidExt)
    androidTestImplementation(libs.testing.truth)
    androidTestImplementation(libs.testing.coroutines)
    androidTestImplementation(libs.testing.turbine)
    androidTestImplementation(libs.compose.uiTest)
    androidTestImplementation(libs.testing.mockkAndroid)
    androidTestImplementation(libs.testing.mockWebServer)
    androidTestImplementation(libs.testing.hiltTesting)
    kaptAndroidTest(libs.hilt.hiltCompiler)
    androidTestImplementation(libs.testing.testRunner)
}