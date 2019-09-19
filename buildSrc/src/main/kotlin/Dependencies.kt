
object Dependencies {

    private const val kotlinVersion = "1.3.50"
    private const val assertJVersion = "3.13.2"
    private const val testNgVersion = "7.0.0"
    private const val okHttpVersion = "4.1.0"
    private const val gsonVersion = "2.8.5"
    private const val ktlintVersion = "0.34.2"
    private const val restAssuredVersion = "4.1.1"

    const val kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val assertJ = "org.assertj:assertj-core:$assertJVersion"
    const val testNg = "org.testng:testng:$testNgVersion"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$okHttpVersion"
    const val ktlint = "com.pinterest:ktlint:$ktlintVersion"
    const val gson = "com.google.code.gson:gson:$gsonVersion"
    const val restAssured = "io.rest-assured:rest-assured:$restAssuredVersion"
    const val restAssuredKotlinExtensions = "io.rest-assured:kotlin-extensions:$restAssuredVersion"
}
