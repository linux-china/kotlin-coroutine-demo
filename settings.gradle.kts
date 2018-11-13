rootProject.name = "kotlin-coroutine-demo"

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.11.12")
    }

    repositories {
        jcenter()
    }
}

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