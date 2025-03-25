plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.foodies.home_presentation"
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.trackerDomain))

    implementation(Coil.coilCompose)
    implementation(CameraX.cameraCore)
    implementation(CameraX.cameraCamera2)
    implementation(CameraX.cameraView)
    implementation(CameraX.cameraLifecycle)
    implementation(Google.accompanist)
    implementation("androidx.camera:camera-view:1.4.1")
}