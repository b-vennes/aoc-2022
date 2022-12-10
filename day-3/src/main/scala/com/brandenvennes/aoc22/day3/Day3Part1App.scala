package com.brandenvennes.aoc22.day3

import cats.syntax.all.*
import cats.data.NonEmptyList
import cats.effect.{IO, IOApp}
import com.brandenvennes.aoc22.InputFiles

object Day3Part1App extends IOApp.Simple {
  override def run: IO[Unit] =
    InputFiles.parse[IO, NonEmptyList[Rucksack]](day = 3)
      .map(rucksacks =>
        rucksacks
          .traverse(_.intersection.map(_.priority))
          .fold(0)(value => value.toList.sum)
      )
      .flatMap(IO.println)
}
