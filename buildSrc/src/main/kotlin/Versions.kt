import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew syncLibs`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
    const val jmfayard_github_io_gradle_kotlin_dsl_libs_gradle_plugin: String = "0.2.6" 

    const val joda_time: String = "2.10.1"

    const val junit: String = "4.12"

    const val ncm_gradle_publish_gradle_plugin: String = "5.1" 

    const val ncm_gradle_repos_gradle_plugin: String = "5.1" 

    const val ncm_gradle_version_gradle_plugin: String = "5.1" 

    const val hamcrest_integration: String = "1.3" //available: "1.4-atlassian-1" 

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.0"

        const val currentVersion: String = "5.0"

        const val nightlyVersion: String = "5.1-20181128000036+0000"

        const val releaseCandidate: String = ""
    }
}
