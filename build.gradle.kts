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
    implementation("org.ow2.asm:asm:9.7")
    implementation("org.ow2.asm:asm-util:9.7")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(14)
}