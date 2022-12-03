package day1
import scala.io.Source
import scala.util.Using


@main def part1(): Unit =
  val textSource = Source.fromFile("input/day1")
  val input = textSource.mkString
  textSource.close()
  val answer = part1(input)
  println(s"The solution for part 1 is $answer")

@main def part2(): Unit =
  val textSource = Source.fromFile("input/day1")
  val input = textSource.mkString
  textSource.close()
  val answer = part2(input)
  println(s"The solution for part 2 is $answer")


def part1(input: String): Int =
  val depths = input.linesIterator.map(_.toInt)
  var increase_cnt = 0
  var prev = 0
  var cur = 0
  for (v <- depths) {
    prev = cur
    cur = v
    if (prev == 0) {
      increase_cnt += 0
    }
    else if (prev < cur) {
      increase_cnt += 1
    }
  }

  increase_cnt
//  val pairs = depths.sliding(2).map(arr => (arr(0), arr(1)))
//  pairs.count((prev, next) => prev < next)


def part2(input: String): Int =
  val depths = input.linesIterator.map(_.toInt)
  var p3 = 0
  var p2 = 0
  var p1 = 0
  var p0 = 0
  var cnt = 0

  var prev = 0
  var cur = 0

  for (v <- depths) {
    p3 = p2
    p2 = p1
    p1 = p0
    p0 = v

    if (p3 == 0) {
      cnt += 0
    }
    else {
    prev = p1 + p2 + p3
    cur = p0 + p1 + p2
    if (cur > prev) {
      cnt += 1
    }
    }
  }
  cnt
