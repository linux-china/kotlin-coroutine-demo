import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.3.40"
val coroutinesVersion = "1.3.0-M2"
val junit5Version = "5.5.0-RC2"


buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.1.0")
    }
}

plugins {
    application
    kotlin("jvm") version "1.3.40"
    id("kotlinx-atomicfu").version("0.12.8")
}


application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClassName = "demo.DemoKt"
}

dependencies {
    compile("org.jetbrains:annotations:17.0.0")
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlin("stdlib-jdk8", kotlinVersion))
    testCompile(kotlin("test-junit5", kotlinVersion))
    compile("org.jetbrains.kotlinx:atomicfu:0.12.8")

    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${coroutinesVersion}")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${coroutinesVersion}")
    testCompile("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testCompile("org.junit.jupiter:junit-jupiter-params:$junit5Version")
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