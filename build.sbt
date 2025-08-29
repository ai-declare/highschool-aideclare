ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

resolvers += "GitHub Packages" at "https://maven.pkg.github.com/ai-declare/aideclare"

libraryDependencies ++= Seq(
  "io.github.ai-declare" %% "sdk" % "0.1.0-BETA"
)

lazy val root = (project in file("."))
  .settings(
    name := "highschool-aideclare"
  )
