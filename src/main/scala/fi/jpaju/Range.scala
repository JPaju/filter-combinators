package fi.jpaju

opaque type Range[A] = RangeImpl[A]

case class RangeImpl[A: Ordering](from: A, to: A):
  import scala.math.Ordering.Implicits.*

  def isInRange(a: A) = from <= a && a < to

extension [A](self: Range[A])
  def toRangeFilter: Filter[A] =
    Filter.fromPredicate(self.isInRange)

object Range:
  def create[A: Ordering](from: A, to: A): Range[A] =
    RangeImpl(from, to)
