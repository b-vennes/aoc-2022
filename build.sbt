val scala3 = "3.2.0"

lazy val core = project
  .settings(
    scalaVersion := scala3,
    libraryDependencies ++= Seq(
      LibraryDependencies.FS2.core,
      LibraryDependencies.FS2.io,
      LibraryDependencies.Cats.Effect.core,
      LibraryDependencies.Cats.Parse.core
    )
  )

lazy val `day-1` = project
  .settings(
    scalaVersion := scala3
  )
  .dependsOn(core)
