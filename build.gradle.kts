plugins {
    `java-library`
    `maven-publish`
    id("org.jreleaser") version "1.27.0"
}

group = "pl.andrzejressel"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.1.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    withSourcesJar()
    withJavadocJar()
}

tasks.register<GenerateOneOf>("generate") {
    group = "build"
    template = "oneof.ftl"
    key = "oneof"
    dir = project.rootDir.toString()
    count = 9
}

publishing {
    publications {
        create<MavenPublication>("release") {
            artifactId = project.name

            from(components["java"])

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }

            pom {
                name.set(project.name)
                description.set("Easy to use discriminated unions for Java with compile time matching.")
                url.set("https://github.com/andrzej.ressel/oneof")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://mit-license.org/")
                    }
                }
                developers {
                    developer {
                        name.set("Andrzej Ressel")
                        email.set("github@andrzejressel.pl")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/andrzej.ressel/oneof.git")
                    developerConnection.set("scm:git:ssh://github.com/andrzej.ressel/oneof.git")
                    url.set("https://github.com/andrzej.ressel/oneof")
                }
            }
        }
    }
    repositories {
        maven {
            setUrl(layout.buildDirectory.dir("staging-deploy"))
        }
    }
}

jreleaser {
    environment {
        variables = file("jreleaser.toml")
    }
    release {
        project {
            inceptionYear = "2025"
            author("Andrzej Ressel")
        }
        signing {
            active = org.jreleaser.model.Active.ALWAYS
            mode = org.jreleaser.model.Signing.Mode.COMMAND
            armored = true
            verify = true
        }
        deploy {
            maven {
                mavenCentral.create("sonatype") {
                    active = org.jreleaser.model.Active.ALWAYS
                    url = "https://central.sonatype.com/api/v1/publisher"
                    stagingRepository(layout.buildDirectory.dir("staging-deploy").get().toString())
                    setAuthorization("Basic")
                    retryDelay = 60
                    sign = true
                    checksums = true
                    sourceJar = true
                    javadocJar = true
                }
            }
        }
        github {
            enabled = false
        }
    }
}
