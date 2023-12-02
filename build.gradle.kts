import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "2.0.0-Beta1"
val coroutinesVersion = "1.8.0-RC"
val junit5Version = "5.10.1"


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
    kotlin("jvm") version "2.0.0-Beta1"
    id("org.jetbrains.kotlin.plugin.atomicfu").version("2.0.0-Beta1")
    id("com.github.ben-manes.versions").version("0.50.0")
}


application {
    group = "org.mvnsearch"
    version = "1.0.0-SNAPSHOT"
    mainClass.value("demo.DemoKt")
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation(kotlin("stdlib", kotlinVersion))
    implementation(kotlin("reflect", kotlinVersion))
    testImplementation(kotlin("test-junit5", kotlinVersion))
    implementation("org.jetbrains.kotlinx:atomicfu:0.23.1")
    implementation("io.projectreactor:reactor-core:3.6.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${coroutinesVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${coroutinesVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")
}

val compiler = javaToolchains.compilerFor {
    languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
        javaParameters = true
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all", "-language-version=2.0")
    }
}
