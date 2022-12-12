package com.brandenvennes.aoc22.day3

import cats.data.NonEmptyList
import cats.syntax.all.*
import cats.parse.Parser
import cats.parse.Rfc5234.*

given parseItemType: Parser[ItemType] =
  alpha.map(value => ItemType(value))

given parseRucksack: Parser[Rucksack] =
  parseItemType
    .rep
    .flatMap(itemTypes =>
      Rucksack
        .validated(itemTypes)
        .fold(error => Parser.failWith(error), Parser.pure)
    )

given parseGroup: Parser[Group] =
  (parseRucksack <* lf.?)
    .rep(3, 3)
    .flatMap(rucksacks =>
      Group
        .validated(rucksacks.toList)
        .fold(error => Parser.failWith(error), Parser.pure)
    )

given parseRucksacks: Parser[NonEmptyList[Rucksack]] =
  parseRucksack.repSep(lf)

given parseGroups: Parser[NonEmptyList[Group]] =
  parseGroup.rep
