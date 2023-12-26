plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("kotlin-common-conventions")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

dependencies {
    constraints {
        implementation("org.apache.kafka:kafka-clients:3.6.0")
    }

    implementation("org.apache.kafka:kafka-clients")
}