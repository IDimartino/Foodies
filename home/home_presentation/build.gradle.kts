plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.foodies.home_presentation"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":home:home_domain"))

    implementation(libs.coil.coilCompose)
    implementation(libs.camerax.cameraCore)
    implementation(libs.camerax.cameraCamera2)
    implementation(libs.camerax.cameraView)
    implementation(libs.camerax.cameraLifecycle)
    implementation(libs.google.accompanist)
}