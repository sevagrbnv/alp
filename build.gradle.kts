plugins {
    java
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

jacoco {
    toolVersion = "0.8.12"
    reportsDir = file("$buildDir/reports/jacoco")
}

tasks.test {
    finalizedBy("jacocoTestReport")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

