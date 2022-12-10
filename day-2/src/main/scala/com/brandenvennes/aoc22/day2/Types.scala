package com.brandenvennes.aoc22.day2

enum OpponentMove {
  case Rock, Paper, Scissors
}

enum PlayerMove {
  case Rock, Paper, Scissors
}

enum RequiredResult {
  case Lose, Draw, Win
}

case class RoundPart1(opponentMove: OpponentMove, playerMove: PlayerMove) {
  val score: Int =
    (opponentMove, playerMove) match {
      case (OpponentMove.Rock, PlayerMove.Rock) => 4
      case (OpponentMove.Rock, PlayerMove.Paper) => 8
      case (OpponentMove.Rock, PlayerMove.Scissors) => 3
      case (OpponentMove.Paper, PlayerMove.Rock) => 1
      case (OpponentMove.Paper, PlayerMove.Paper) => 5
      case (OpponentMove.Paper, PlayerMove.Scissors) => 9
      case (OpponentMove.Scissors, PlayerMove.Rock) => 7
      case (OpponentMove.Scissors, PlayerMove.Paper) => 2
      case (OpponentMove.Scissors, PlayerMove.Scissors) => 6
    }
}

case class RoundPart2(opponentMove: OpponentMove, required: RequiredResult) {
  val score: Int =
    (opponentMove, required) match {
      case (OpponentMove.Rock, RequiredResult.Lose) => 3 + 0
      case (OpponentMove.Rock, RequiredResult.Draw) => 1 + 3
      case (OpponentMove.Rock, RequiredResult.Win) => 2 + 6
      case (OpponentMove.Paper, RequiredResult.Lose) => 1 + 0
      case (OpponentMove.Paper, RequiredResult.Draw) => 2 + 3
      case (OpponentMove.Paper, RequiredResult.Win) => 3 + 6
      case (OpponentMove.Scissors, RequiredResult.Lose) => 2 + 0
      case (OpponentMove.Scissors, RequiredResult.Draw) => 3 + 3
      case (OpponentMove.Scissors, RequiredResult.Win) => 1 + 6
    }
}
