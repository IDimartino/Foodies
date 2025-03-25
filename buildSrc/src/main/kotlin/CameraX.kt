import org.gradle.api.internal.artifacts.dsl.dependencies.DependenciesExtensionModule.module

object CameraX {
    private const val camera = "1.4.1"

    const val cameraCore = "androidx.camera:camera-core:$camera"

    const val cameraCamera2 = "androidx.camera:camera-camera2:$camera"

    const val cameraLifecycle = "androidx.camera:camera-lifecycle:$camera"

    const val cameraView = "androidx.camera:camera-view:$camera"
}