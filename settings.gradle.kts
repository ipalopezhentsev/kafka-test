plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}
rootProject.name = "kafka"
include(
    "producer-raw", "consumer-raw",
    "producer-spring", "consumer-spring"
)
