import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(Dependencies.kotlin_stdlib_jdk8)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
    implementation(Dependencies.gson)
    testImplementation(Dependencies.testNg)
    testImplementation(Dependencies.assertJ)
    testImplementation(Dependencies.mockWebServer)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.register<Test>("testProduct") {

    group = "verification"
    description = "Runs set of unit tests against Products Endpoint using mocked responses"

    useTestNG {
        includeGroups("products")
    }
}
