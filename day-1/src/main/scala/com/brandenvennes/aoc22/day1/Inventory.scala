package com.brandenvennes.aoc22.day1

import cats.data.NonEmptyList
import cats.syntax.all.*

case class Inventory(snacks: NonEmptyList[Int]) {
  def calories: Int = snacks.foldl(0)(_ + _)
}
