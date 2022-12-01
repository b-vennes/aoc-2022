package com.brandenvennes.aoc22.day1

import cats.syntax.all.*
import cats.data.NonEmptyList
import cats.parse.Numbers.digits
import cats.parse.Parser
import cats.parse.Rfc5234.lf

given Parser[Inventory] =
  for {
    stringNumbers <- (digits <* lf).rep
    intParsingResults = stringNumbers.map(num => Either.catchNonFatal(num.toInt))
    values <- intParsingResults.traverse(_.fold(
      error => Parser.failWith(error.getMessage),
      value => Parser.pure(value)
    ))
  } yield Inventory(values)

given[A](using Parser: Parser[A]): Parser[NonEmptyList[A]] =
  (Parser <* lf.rep0).rep
