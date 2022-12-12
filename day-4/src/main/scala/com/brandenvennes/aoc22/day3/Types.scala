package com.brandenvennes.aoc22.day3

case class Range private (start: Int, end: Int)

object Range {
  def validated(start: Int, end: Int): Either[String, Range] =
    Either.cond(
      start <= end,
      Range(start, end),
      s"Start $start must be less than or equal to end $end"
    )

}

case class RangePair(first: Range, second: Range) {
  val isSubset: Boolean =
    (
      first.start <= second.start &&
        first.end >= second.end
    ) ||
      (
        second.start <= first.start &&
          second.end >= first.end
      )

  val isOverlap: Boolean =
    isSubset ||
      (
        first.start <= second.start &&
          first.end >= second.start &&
          first.end <= second.end
      ) ||
        (
          first.start >= second.start &&
            first.start <= second.end &&
            first.end >= second.end
        )
}
