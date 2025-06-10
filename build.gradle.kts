plugins {
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22" // Kotlin 사용 안 할 경우 제거
    kotlin("plugin.spring") version "1.9.22"
    kotlin("kapt") version "1.9.22"
}

group = "com.farukgenc"
version = "3.4.0"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
}

val jwtVersion = "4.4.0"
val mapstructVersion = "1.6.3"
val lombokMapstructBindingVersion = "0.2.0"
val openapiSwaggerVersion = "2.7.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("com.auth0:java-jwt:$jwtVersion")

    runtimeOnly("org.postgresql:postgresql")

    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")
    kapt("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$openapiSwaggerVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
