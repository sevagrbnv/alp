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

val jacocoTestReportZ by tasks.registering(JacocoReport::class) {
    dependsOn(tasks.test)
    reports {
        xml.isEnabled = true
        html.isEnabled = false
        csv.isEnabled = false
    }
    executionData(tasks.test.get().outputs.files)
    classDirectories.setFrom(files(sourceSets.main.get().output.classesDirs))
    sourceDirectories.setFrom(files(sourceSets.main.get().allSource.srcDirs))
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
