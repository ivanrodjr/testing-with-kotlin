import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50" apply false
    base
}

allprojects {

    group = "com.hoolitest.test"
    version = "1.0-SNAPSHOT"

    repositories {
        jcenter()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
