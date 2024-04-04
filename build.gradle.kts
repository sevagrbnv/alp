plugins {
    java
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

jacoco {
    toolVersion = "0.8.12"
    reportsDir = file("$buildDir/jacoco") // Customize report directory (optional)
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

tasks.register<JacocoReport>("jacocoTestReportZ") {
    // Adjust paths as needed
    classDirectories.setFrom(files(classDirectories.files))
    sourceDirectories.setFrom(files("${project.projectDir}/src/main/java")) // Location of execution data file
    reports {
        xml.setEnabled(true) // Enable XML report generation
        html.setEnabled(false) // Optional: disable HTML report (if not needed)
    }
}

