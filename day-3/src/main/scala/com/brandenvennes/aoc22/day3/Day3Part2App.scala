package com.brandenvennes.aoc22.day3

import cats.data.NonEmptyList
import cats.effect.{IO, IOApp}
import com.brandenvennes.aoc22.InputFiles

object Day3Part2App extends IOApp.Simple {
  override def run: IO[Unit] =
    InputFiles.parse[IO, NonEmptyList[Group]](day = 3)
      .map(groups =>
        groups
          .map(group => group.badgeType)
          .toList
          .map(_.priority)
          .sum
      )
      .flatMap(result =>
        IO.println(s"Total priority sum: $result")
      )
}
