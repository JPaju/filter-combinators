import scala.math.Ordering.Implicits.*

opaque type Range[A] = RangeInternal[A]

case class RangeInternal[A: Numeric](from: A, to: A):
  def isInRange(a: A) = from <= a && a <= to

extension [A](r: Range[A])
  def toFilter: Filter[A] =
    Filter.fromPredicate(r.isInRange)

object Range:
  def create[A: Numeric](from: A, to: A): Range[A] =
    RangeInternal(from, to)
