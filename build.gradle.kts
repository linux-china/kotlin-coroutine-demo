import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.3.60"
val coroutinesVersion = "1.3.2"
val junit5Version = "5.5.2"


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
    kotlin("jvm") version "1.3.60"
    id("kotlinx-atomicfu").version("0.13.1")
}


application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClassName = "demo.DemoKt"
}

dependencies {
    compile("org.jetbrains:annotations:18.0.0")
    compile(kotlin("stdlib", kotlinVersion))
    compile(kotlin("stdlib-jdk8", kotlinVersion))
    compile(kotlin("reflect", kotlinVersion))
    testCompile(kotlin("test-junit5", kotlinVersion))
    compile("org.jetbrains.kotlinx:atomicfu:0.14.1")
    compile("com.squareup.retrofit2:retrofit:2.6.2")
    compile("com.squareup.retrofit2:converter-jackson:2.6.2")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.0")

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