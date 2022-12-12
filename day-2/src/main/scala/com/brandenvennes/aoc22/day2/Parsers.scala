package com.brandenvennes.aoc22.day2

import cats.data.NonEmptyList
import cats.parse.Parser
import cats.parse.Rfc5234.*

given parseOpponentMove: Parser[OpponentMove] =
  char
    .mapFilter {
      case 'A' => Some(OpponentMove.Rock)
      case 'B' => Some(OpponentMove.Paper)
      case 'C' => Some(OpponentMove.Scissors)
      case _ => None
    }

given parsePlayerMove: Parser[PlayerMove] =
  char
    .mapFilter {
      case 'X' => Some(PlayerMove.Rock)
      case 'Y' => Some(PlayerMove.Paper)
      case 'Z' => Some(PlayerMove.Scissors)
      case _ => None
    }

given parseRequiredResult: Parser[RequiredResult] =
  char
    .mapFilter {
      case 'X' => Some(RequiredResult.Lose)
      case 'Y' => Some(RequiredResult.Draw)
      case 'Z' => Some(RequiredResult.Win)
      case _ => None
    }

given parseRoundPart1: Parser[RoundPart1] =
  (parseOpponentMove ~ sp ~ parsePlayerMove)
    .map {
      case ((opponentMove, _), playerMove) => RoundPart1(opponentMove, playerMove)
    }

given parseRoundPart2: Parser[RoundPart2] =
  (parseOpponentMove ~ sp ~ parseRequiredResult)
    .map {
      case ((opponentMove, _), requiredResult) =>
        RoundPart2(opponentMove, requiredResult)
    }

given parseNonEmpty[A](using parseA: Parser[A]): Parser[NonEmptyList[A]] =
  parseA.repSep(lf)
