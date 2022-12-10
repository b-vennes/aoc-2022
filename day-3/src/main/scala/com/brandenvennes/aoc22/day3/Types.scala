package com.brandenvennes.aoc22.day3

import cats.data.NonEmptyList
import cats.syntax.all.*

case class Compartment(value: List[ItemType]) {
  def contains(value: ItemType): Boolean =
    this.value
      .exists(itemType => value.value === itemType.value)

  def distinct: List[ItemType] =
    value.distinctBy(_.value)
}

case class Rucksack(left: Compartment, right: Compartment) {
  val intersection: Option[ItemType] = left.value.find(right.contains)
}

object Rucksack {
  def validated(itemTypes: NonEmptyList[ItemType]): Either[String, Rucksack] =
    Either.cond(
      itemTypes.length % 2 === 0,
      {
        val compartmentLength = itemTypes.length / 2
        Rucksack(
          Compartment(itemTypes.take(compartmentLength)),
          Compartment(itemTypes.toList.drop(compartmentLength))
        )
      },
      "The number of items must be even"
    )
}

case class ItemType(value: Char) {
  val priority: Int = value.toInt match {
    case num if num < 97  => num - 38
    case num              => num - 96
  }
}

case class Group(rucksacks: List[Rucksack]) {
  val badgeType: ItemType =
    ItemType(
      rucksacks
        .flatMap(r => r.left.distinct ++ r.right.distinct)
        .groupMapReduce(_.value)(_ => 1)(_ + _)
        .toList
        .maxBy(_._2)
        ._1
    )
}

object Group {

  def validated(rucksacks: List[Rucksack]): Either[String, Group] =
      Either.cond(
        rucksacks.length === 3,
        Group(rucksacks),
        "Must be 3 rucksacks in a group"
      )
}
