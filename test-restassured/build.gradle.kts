import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(Dependencies.kotlin_stdlib_jdk8)
    implementation(Dependencies.gson)
    implementation(Dependencies.restAssured)
    implementation(Dependencies.restAssuredKotlinExtensions)
    testImplementation(Dependencies.testNg)
    testImplementation(Dependencies.assertJ)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
