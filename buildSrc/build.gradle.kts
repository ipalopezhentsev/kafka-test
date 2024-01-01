plugins {
    // Support convention plugins written in Kotlin. Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    val kotlinVer = "1.9.22"
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVer")
    implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinVer")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.2.1")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.4")
}
