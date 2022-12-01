import sbt._

object FS2 {
  val org = "co.fs2"
  val version = "3.4.0"

  val core = org %% "fs2-core" % version
  val io = org %% "fs2-io" % version
}

object Cats {
  object Effect {
    val org = "org.typelevel"
    val version = "3.4.2"

    val core = org %% "cats-effect" % version
  }

  object Parse {
    val org = "org.typelevel"
    val version = "0.3.8"

    val core = org %% "cats-parse" % version
  }
}
