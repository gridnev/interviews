/*
Implement mergesort.
*/

object MergeSort extends App {

  def merge[A](as: List[A], bs: List[A])(implicit ordering: Ordering[A]): List[A] =
    (as, bs) match {
      case (Nil, Nil) => Nil
      case (_, Nil) => as
      case (Nil, _) => bs
      case (a :: atail, b :: btail) =>
        if (ordering.lt(a, b)) a :: merge(atail, bs)
        else b :: merge(as, btail)
    }

  def mergesort[A](as: List[A])(implicit ordering: Ordering[A]): List[A] = {
    if (as.size <= 1) as
    else {
      val (left, right) = as.splitAt(as.size / 2)
      merge(mergesort(left), mergesort(right))
    }
  }

  // test
  println(mergesort(List(1, -3, 7, 3, 2, 4, -3)))
}
