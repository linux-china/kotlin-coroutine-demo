import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.4.30"
val coroutinesVersion = "1.4.2"
val junit5Version = "5.7.1"


buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.2.0")
    }
}

plugins {
    application
    kotlin("jvm") version "1.4.30"
    id("kotlinx-atomicfu").version("0.15.1")
    id("com.github.ben-manes.versions").version("0.36.0")
}


application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClass.value("demo.DemoKt")
}

dependencies {
    implementation("org.jetbrains:annotations:20.1.0")
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    implementation(kotlin("reflect", kotlinVersion))
    testImplementation(kotlin("test-junit5", kotlinVersion))
    implementation("org.jetbrains.kotlinx:atomicfu:0.15.1")
    implementation("io.projectreactor:reactor-core:3.4.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${coroutinesVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")
}

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        javaParameters = true
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
    }
}