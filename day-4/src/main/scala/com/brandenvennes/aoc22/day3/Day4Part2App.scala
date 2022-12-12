package com.brandenvennes.aoc22.day3

import cats.syntax.all.*
import cats.data.NonEmptyList
import cats.effect.{IO, IOApp}
import com.brandenvennes.aoc22.InputFiles

object Day4Part2App extends IOApp.Simple {
  override def run: IO[Unit] =
    InputFiles.parse[IO, NonEmptyList[RangePair]](day = 4)
      .map(_.count(_.isOverlap))
      .flatMap(count =>
        IO.println(s"Number of overlapping pairs: $count")
      )
}
