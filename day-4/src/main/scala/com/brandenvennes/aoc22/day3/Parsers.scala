package com.brandenvennes.aoc22.day3

import cats.syntax.all.*
import cats.parse.Parser
import cats.parse.Rfc5234.*
import cats.data.NonEmptyList

given parsePosNumber: Parser[Int] =
  digit.rep.string
    .flatMap(value =>
      Either
        .catchNonFatal(
          value.toInt
        )
        .fold(
          error => Parser.failWith(s"Invalid number - $value : ${error.getMessage}"),
          Parser.pure
        )
    )

given parseDash: Parser[Unit] =
  char.filter(_ === '-').void

given parseComma: Parser[Unit] =
  char.filter(_ === ',').void

given parseRange: Parser[Range] =
  ((parsePosNumber <* parseDash) ~ parsePosNumber)
    .flatMap(range =>
      Range.validated(range._1, range._2)
        .fold(
          error => Parser.failWith(error),
          Parser.pure
        )
    )

given parseRangePair: Parser[RangePair] =
  ((parseRange <* parseComma) ~ parseRange)
    .map(ranges => RangePair(ranges._1, ranges._2))

given Parser[NonEmptyList[RangePair]] =
  parseRangePair.repSep(lf)
