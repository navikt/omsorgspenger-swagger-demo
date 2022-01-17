import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val mainClass = "no.nav.omsorgspenger.SwaggerDemoApplicationKt"

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "no.nav.omsorgspenger"
version = "0.0.1-SNAPSHOT"
java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven("https://jitpack.io")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.4")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {

	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = "17"
	}

	named<KotlinCompile>("compileTestKotlin") {
		kotlinOptions.jvmTarget = "17"
	}

	withType<Test> {
		useJUnitPlatform()
		testLogging {
			events("passed", "skipped", "failed")
		}
	}

	withType<ShadowJar> {
		archiveBaseName.set("app")
		archiveClassifier.set("")
		manifest {
			attributes(
				mapOf(
					"Main-Class" to mainClass
				)
			)
		}
	}

	withType<Wrapper> {
		gradleVersion = "7.3.3"
	}
}