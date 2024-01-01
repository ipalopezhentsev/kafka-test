plugins {
    id("kotlin-common-conventions")
    application
}

dependencies {
    constraints {
        implementation("org.apache.kafka:kafka-clients:3.6.0")
    }

    implementation("org.apache.kafka:kafka-clients")
    implementation("org.slf4j:slf4j-simple") {
        because("otherwise there will be no console logs even on fails")
    }
}