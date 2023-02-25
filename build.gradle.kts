plugins {
	java
	id("org.springframework.boot") version "3.0.3"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.openrewrite.rewrite") version "5.36.0"
}

group = "com.github.alexandrenavarro"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

rewrite {
	//activeRecipe("org.openrewrite.java.cleanup.Cleanup")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
