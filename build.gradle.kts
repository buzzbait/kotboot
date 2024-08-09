plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	kotlin("plugin.jpa") version "1.9.24"
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}
group = "com.buzzbait"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

val jdslVersion = "3.5.1"
val kotestVersion = "5.9.1"
dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.postgresql:postgresql:42.7.3")
	implementation("io.github.microutils:kotlin-logging:1.12.5")

	implementation("com.linecorp.kotlin-jdsl:jpql-dsl:${jdslVersion}")
	implementation("com.linecorp.kotlin-jdsl:jpql-render:${jdslVersion}")
	implementation("com.linecorp.kotlin-jdsl:spring-data-jpa-support:${jdslVersion}")
	//순서보장 UUID 생성 라이브러리
	implementation("com.github.f4b6a3:ulid-creator:5.2.3")

	compileOnly("org.projectlombok:lombok:1.18.34")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	//kotest 프레임워크
	testImplementation("io.kotest:kotest-assertions-core-jvm:${kotestVersion}")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:${kotestVersion}")
	//springboot test 를 위한 종속성
	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.3.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
