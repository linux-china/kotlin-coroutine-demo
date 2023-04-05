import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.8.20"
val coroutinesVersion = "1.7.0-Beta"
val junit5Version = "5.9.2"


buildscript {
    repositories {
        mavenCentral()
    }
}

repositories {
    mavenCentral()
}

plugins {
    application
    kotlin("jvm") version "1.8.20"
    id("org.jetbrains.kotlin.plugin.atomicfu").version("1.8.20")
    id("com.github.ben-manes.versions").version("0.46.0")
}


application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClass.value("demo.DemoKt")
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.1")
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("reflect", kotlinVersion))
    testImplementation(kotlin("test-junit5", kotlinVersion))
    implementation("org.jetbrains.kotlinx:atomicfu:0.20.1")
    implementation("io.projectreactor:reactor-core:3.5.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${coroutinesVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")
}

val compiler = javaToolchains.compilerFor {
    languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        javaParameters = true
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all", "-Xuse-k2")
    }
}