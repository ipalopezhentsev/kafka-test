plugins {
    id("org.jetbrains.kotlin.jvm")

//    id("org.springframework.boot")// version "3.0.8"
//    id("io.spring.dependency-management")// version "1.1.0"
//    kotlin("plugin.spring") //version "1.7.22"
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.slf4j:slf4j-api:2.0.9")
        implementation("org.slf4j:slf4j-simple:2.0.9")

    }

    implementation("org.slf4j:slf4j-api")
    implementation("org.slf4j:slf4j-simple")

//    implementation("org.springframework.boot:spring-boot-starter")
//    implementation("org.springframework.kafka:spring-kafka")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("org.springframework.kafka:spring-kafka-test")

    implementation(kotlin("stdlib-jdk8"))

    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

group = "de.iliks"
version = "0.0.1-SNAPSHOT"
