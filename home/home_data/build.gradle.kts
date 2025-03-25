plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.foodies.home_data"
}


dependencies {
    implementation(project(":core"))
    implementation(project(":home:home_domain"))

    implementation(libs.retrofit.okHttp)
    implementation(libs.retrofit.retrofit)
    implementation(libs.retrofit.okHttpLoggingInterceptor)
    implementation(libs.retrofit.moshiConverter)

    "kapt"(libs.room.roomCompiler)
    implementation(libs.room.roomKtx)
    implementation(libs.room.roomRuntime)
    implementation(libs.coroutines.coroutines)
}