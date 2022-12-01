val scala3 = "3.2.0"

lazy val core = project
  .settings(
    scalaVersion := scala3,
    libraryDependencies ++= Seq(
      FS2.core,
      FS2.io,
      Cats.Effect.core,
      Cats.Parse.core
    )
  )

lazy val `day-1` = project
  .settings(
    scalaVersion := scala3
  )
  .dependsOn(core)
