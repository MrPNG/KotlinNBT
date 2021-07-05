import org.jetbrains.kotlin.gradle.dsl.*

plugins {
	java
	kotlin("jvm") version "1.5.10"
}

group = "io.github.mrpng"
version = "1.0.0"

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation(kotlin("stdlib", kotlinVersion))
}

val compileKotlinOptions: KotlinJvmOptions.() -> Unit = {
	jvmTarget = "16"
	languageVersion = "1.5.10"
	
	suppressWarnings = true
}

tasks.compileKotlin {
	kotlinOptions(compileKotlinOptions)
}

tasks.compileTestKotlin {
	kotlinOptions(compileKotlinOptions)
}
