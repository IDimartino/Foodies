plugins {
    `android-library`
    `kotlin-android`
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.foodies.home_domain"
}

dependencies {
    implementation(project(Modules.core))
    implementation(Coroutines.coroutines)
}