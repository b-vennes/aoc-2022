package com.brandenvennes.aoc22.day2

import cats.data.NonEmptyList
import cats.effect.{IO, IOApp}
import cats.syntax.all.*
import com.brandenvennes.aoc22.InputFiles
import fs2.io.file.Path

object Day2Part2App extends IOApp.Simple {
  override def run: IO[Unit] =
    InputFiles.parse[IO, NonEmptyList[RoundPart2]](day = 2)
      .map(rounds =>
        rounds
          .map(_.score)
          .foldLeft(0)(_ + _)
      )
      .flatMap(result =>
        IO.println(s"Sum of scores: $result")
      )
}
