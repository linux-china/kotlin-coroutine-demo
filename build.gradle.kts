import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.30"
    id("kotlinx-atomicfu").version("0.12.3")
}

application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClassName = "demo.DemoKt"
}

dependencies {
    compile("org.jetbrains:annotations:17.0.0")
    compile(kotlin("stdlib", "1.3.30"))
    compile(kotlin("stdlib-jdk8", "1.3.30"))
    testCompile(kotlin("test-junit5", "1.3.30"))
    compile("org.jetbrains.kotlinx:atomicfu:0.12.3")

    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.0")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.2.0")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.2.0")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.4.2")
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