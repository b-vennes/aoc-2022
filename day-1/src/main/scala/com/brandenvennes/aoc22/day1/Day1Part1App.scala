package com.brandenvennes.aoc22.day1

import cats.syntax.all.*
import cats.data.{Chain, NonEmptyList}
import cats.effect.{IO, IOApp}
import cats.parse.Parser
import cats.parse.Rfc5234.{crlf, lf}

import com.brandenvennes.aoc22.InputFile

object Day1Part1App extends IOApp.Simple {

  override def run: IO[Unit] =
    InputFile.parse[IO, NonEmptyList[Inventory]](day = 1)
      .map(_.map(_.calories).sortBy(-_).head)
      .flatMap(largest => IO.println(s"Largest Inventory Calories: $largest"))
}
