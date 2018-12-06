import org.jetbrains.kotlin.config.AnalysisFlag.Flags.experimental
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.11"
    id("kotlinx-atomicfu").version("0.11.12")
}

application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClassName = "demo.DemoKt"
}

dependencies {
    compile("org.jetbrains:annotations:16.0.3")
    compile(kotlin("stdlib", "1.3.11"))
    compile(kotlin("stdlib-jdk8", "1.3.11"))
    testCompile(kotlin("test-junit5", "1.3.11"))
    compile("org.jetbrains.kotlinx:atomicfu:0.11.12")

    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.0.1")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.0.1")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.3.1")
}

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        javaParameters = true
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}