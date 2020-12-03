package algorithms.divideAndConquer

object Mergesort {
  val halfInt = (x: Int) => x / 2

  def mergeSortInt(list: List[Int]): List[Int] = {
    def merge(left: List[Int], right: List[Int], z: List[Int]): List[Int] =
      (left, right) match {
        case (x :: xs, y :: ys) =>
          if (x <= y) merge(xs, right, z :+ x)
          else merge(left, ys, z :+ y)
        case (_ :: _, Nil) => z ::: left
        case (Nil, _ :: _) => z ::: right
        case (Nil, Nil) => z
      }

    list match {
      case _ :: _ :: _ => {
        val splitted = list.splitAt(halfInt(list.length))
        val left = mergeSortInt(splitted._1)
        val right = mergeSortInt(splitted._2)
        if (left.last <= right.head) left ::: right else merge(left, right, Nil)
      }
      case _ => list
    }
  }
}
object MergesortTest extends App {
  val a = List(4, 8, 32, 33, 456, 67, 56, 3, 1, 6, 4, 574, 76, 9, 65, 788, 45, 4)
  val b = Mergesort.mergeSortInt(a)
  val c = Mergesort.mergeSortInt(a).partition(_ % 2 != 0)

  try {
    assert(b == List(1, 3, 4, 5, 4, 6, 8, 9, 32, 33, 45, 56, 65, 67, 76, 456, 574, 788))
    assert(a.length == b.length)
    assert(c == (List(1, 3, 9, 33, 45, 65, 67), List(4, 4, 4, 6, 8, 32, 56, 76, 456, 574, 788)))
    print("Test passed!")
  } catch {
    case e: AssertionError => print("Test Failed!");
  }
}
