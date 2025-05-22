plugins {
    id("java")
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.opencsv:opencsv:5.7.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    /*
    implementation("com.opencsv:opencsv:5.7.1") {
        exclude(group = "commons-logging", module = "commons-logging")
        exclude(group = "commons-beanutils", module = "commons-beanutils")
    }
     */

    configurations.all {
        exclude(group = "commons-logging", module = "commons-logging")
    }
}

tasks.test {
    useJUnitPlatform()
}