plugins {
    java
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"

jacoco {
    toolVersion = "0.8.12"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
        html.isEnabled = false
        html.destination = file("$buildDir/reports/coverage")
    }
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                minimum = "0.4".toBigDecimal()
            }
        }
    }
}
