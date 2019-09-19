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

tasks.register<Test>("testapi") {

    group = "verification"
    description = "Runs set of unit tests against Products Endpoint using mocked responses"

    useTestNG {
        includeGroups("api")
    }
}
