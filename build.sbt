ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"


libraryDependencies ++= Seq(
  // AI Declare SDK
  "com.ai-declare" %% "sdk" % "1.1.3-SNAPSHOT"

)


lazy val root = (project in file("."))
  .settings(
    name := "highschool-aideclare"
  )
