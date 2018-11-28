plugins {
    `java-library`

    id("ncm.gradle.repos") version "5.1"
    id("ncm.gradle.version") version "5.1"
    id("ncm.gradle.publish") version "5.1"

    id("jmfayard.github.io.gradle-kotlin-dsl-libs") version "0.2.6"
}

group = "com.doapps"
version = "DEV-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {
    api(Libs.joda_time)

    testImplementation(Libs.junit)
    testImplementation(Libs.hamcrest_integration)
}


/*
group 'com.doapps'
version "DEV-SNAPSHOT"

apply plugin: 'java'
apply plugin: 'maven-publish'

sourceCompatibility = 1.6

repositories {
    jcenter()
}

task sourceJar(type: Jar, dependsOn: classes) {
    from sourceSets.main.allSource
}

publishing {
    publications {
        maven(MavenPublication) {
            artifactId 'time'
            from components.java
            version tagname()

            artifact sourceJar { classifier "sources" }
        }
    }

    repositories {
        maven {
            url doappRepositoryUrl
            credentials {
                username doappRepositoryUser
                password doappRepositoryPassword
            }
        }
    }
}

dependencies {
    compile 'joda-time:joda-time:2.3'
    
    testCompile 'junit:junit:4.11'
    testCompile 'org.hamcrest:hamcrest-integration:1.3'
}

//---------- git interactions ------------

ext {
    ERROR_MODIFIED_FILES = "ERROR: Unable to publish with un-committed files"
    ERROR_NO_TAG = "ERROR: Unable to publish without a release tag"

    tagname = {
        def buffer = new ByteArrayOutputStream()

        def modified = exec {
            commandLine 'git', 'diff-index', '--quiet', 'HEAD', '--'
            ignoreExitValue = true
        }

        def result = exec {
            commandLine 'git', 'describe', '--tags', '--exact-match'
            standardOutput = buffer
            errorOutput = new ByteArrayOutputStream()
            ignoreExitValue = true
        }

        if (modified.exitValue != 0) ERROR_MODIFIED_FILES
        else if (result.exitValue != 0) ERROR_NO_TAG
        else buffer.toString().trim()
    }
}

task verifyReleaseVersion() {
    doLast {
        def publishVersion = publishing.publications.maven.version

        if (publishVersion == ERROR_MODIFIED_FILES || publishVersion == ERROR_NO_TAG)
            throw new GradleException(publishVersion)
    }
}

tasks.withType(PublishToMavenRepository) {
    it.dependsOn verifyReleaseVersion
}
*/