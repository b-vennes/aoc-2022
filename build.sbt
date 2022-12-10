ThisBuild / scalaVersion := "3.2.1"

lazy val core = project
  .settings(
    libraryDependencies ++= Seq(
      FS2.core,
      FS2.io,
      Cats.Effect.core,
      Cats.Parse.core
    )
  )

lazy val `day-1` = project.dependsOn(core)
lazy val `day-2` =  project.dependsOn(core)
lazy val `day-3` =  project.dependsOn(core)
