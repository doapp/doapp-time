rootProject.name = "time"

val doappRepositoryUrl: String by settings
val doappRepositoryUser: String by settings
val doappRepositoryPassword: String by settings

pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenLocal()
    maven(url = doappRepositoryUrl).credentials {
      username = doappRepositoryUser
      password = doappRepositoryPassword
    }
  }
}
