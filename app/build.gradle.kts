/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.3/userguide/building_java_projects.html
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    
    java
    
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.1.1-jre")
    
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-platform:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-box2d-platform:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-bullet-platform:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-freetype-platform:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-tools:1.10.0")
	implementation("com.badlogicgames.gdx:gdx:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-box2d:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-bullet:1.10.0")
	implementation("com.badlogicgames.gdx:gdx-freetype:1.10.0")
	implementation("com.badlogicgames.box2dlights:box2dlights:1.5")
	implementation("com.badlogicgames.gdx:gdx-platform:1.10.0:natives-desktop")
	
	implementation("org.jgrapht:jgrapht-core:1.5.1")
}

application {
    // Define the main class for the application.
    mainClass.set("royale.emulator.App")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<Test> {
        // Enables JUnit 5 Jupiter module
        useJUnitPlatform()
    }
}

