package com.brandenvennes.aoc22.day2

import cats.data.NonEmptyList
import cats.effect.{IO, IOApp}
import cats.syntax.all.*
import com.brandenvennes.aoc22.InputFiles
import fs2.io.file.Path

object Day2Part1App extends IOApp.Simple {
  override def run: IO[Unit] =
    InputFiles.parse[IO, NonEmptyList[RoundPart1]](day = 2)
      .flatTap(rounds => IO.println(s"Last round: ${rounds.last}"))
      .map(rounds =>
        rounds.map(_.score).foldl(0)(_ + _)
      )
      .flatMap(result =>
        IO.println(s"Sum of score: $result")
      )
}
