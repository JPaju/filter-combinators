opaque type Range[A] = RangeImpl[A]

case class RangeImpl[A: Ordering](from: A, to: A):
  import scala.math.Ordering.Implicits.*

  def isInRange(a: A) = from <= a && a < to

extension [A](r: Range[A])
  def toFilter: Filter[A] =
    Filter.fromPredicate(r.isInRange)

object Range:
  def create[A: Ordering](from: A, to: A): Range[A] =
    RangeImpl(from, to)
