plugins {
    `java-library`
    `maven-publish`
    id("org.jreleaser") version "1.17.0"
}

group = "dev.upwake"
version = "2.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:26.0.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

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
                url.set("https://github.com/nolequen/oneof")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://mit-license.org/")
                    }
                }
                developers {
                    developer {
                        name.set("Anton Potsyus")
                        email.set("nolequen@gmail.com")
                        url.set("http://www.nlq.su/")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/nolequen/oneof.git")
                    developerConnection.set("scm:git:ssh://github.com/nolequen/oneof.git")
                    url.set("https://github.com/nolequen/oneof")
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
            author("@nolequen")
        }
        signing {
            active = org.jreleaser.model.Active.ALWAYS
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
