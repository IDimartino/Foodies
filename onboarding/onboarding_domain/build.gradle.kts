plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.foodies.onboarding_domain"
}

dependencies {
    implementation(project(Modules.core))
}