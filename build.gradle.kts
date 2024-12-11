plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.bytecodeprobe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:$version")
    testImplementation("io.kotest:kotest-assertions-core:$version")
    testImplementation("io.kotest:kotest-property:$version")

    implementation("org.ow2.asm:asm:9.7")
    implementation("org.ow2.asm:asm-util:9.7")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(14)
}