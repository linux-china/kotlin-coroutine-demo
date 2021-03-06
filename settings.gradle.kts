rootProject.name = "kotlin-coroutine-demo"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlinx-atomicfu" -> {
                    useModule("org.jetbrains.kotlinx:atomicfu-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}
