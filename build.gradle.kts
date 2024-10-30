import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

val kotlinVersion = "2.0.21"
val coroutinesVersion = "1.9.0"
val junit5Version = "5.11.3"


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
  kotlin("jvm") version "2.0.21"
  id("org.jetbrains.kotlin.plugin.atomicfu").version("2.0.21")
  id("com.github.ben-manes.versions").version("0.51.0")
}


application {
  group = "org.mvnsearch"
  version = "1.0.0-SNAPSHOT"
  mainClass.value("demo.DemoKt")
}

dependencies {
  implementation("org.jetbrains:annotations:26.0.1")
  implementation(kotlin("stdlib", kotlinVersion))
  implementation(kotlin("reflect", kotlinVersion))
  testImplementation(kotlin("test-junit5", kotlinVersion))
  implementation("org.jetbrains.kotlinx:atomicfu:0.26.0")
  implementation("io.projectreactor:reactor-core:3.6.11")
  implementation("com.squareup.retrofit2:retrofit:2.11.0")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.1")
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


kotlin {
  compilerOptions {
    jvmTarget.set(JvmTarget.JVM_21)
    apiVersion.set(KotlinVersion.KOTLIN_2_0)
    javaParameters.set(true)
    freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
  }
}
