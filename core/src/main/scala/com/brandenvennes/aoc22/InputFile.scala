package com.brandenvennes.aoc22

import cats.syntax.all.*
import cats.effect.kernel.Async
import cats.parse.Parser
import fs2.text
import fs2.io.file.{Files, Path}

object InputFile {
  def parse[F[_], A](day: Int)(using F: Async[F], Parser: Parser[A]): F[A] =
    Files[F]
      .readAll(inputFilePathForDay(day))
      .through(text.utf8.decode)
      .compile
      .foldMonoid
      .map(Parser.parse)
      .flatMap {
        case Right((_, value)) => value.pure[F]
        case Left(error) => F.raiseError[A](new Throwable(error.show))
      }

  private def inputFilePathForDay(day: Int): Path =
    Path(
      s"./day-$day/src/main/resources/input"
    )
}
