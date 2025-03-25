plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.foodies.onboarding_presentation"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":home:home_domain"))
}