package com.brandenvennes.aoc22.day1

import cats.data.{Chain, NonEmptyList}
import cats.effect.{IO, IOApp}
import cats.parse.Parser
import cats.parse.Rfc5234.{crlf, lf}
import cats.syntax.all.*
import com.brandenvennes.aoc22.InputFile

object Day1Part2App extends IOApp.Simple {

  override def run: IO[Unit] =
    InputFile.parse[IO, NonEmptyList[Inventory]](day = 1)
      .map(_.map(_.calories).sortBy(-_).take(3).sum)
      .flatMap(top3Sum => IO.println(s"Largest 3 Inventory Sum: $top3Sum"))
}
