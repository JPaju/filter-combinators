opaque type Filter[A] = A => Boolean

extension [A](self: Filter[A])
  def passes(a: A): Boolean =
    self(a)

  def &&(other: Filter[A]): Filter[A] =
    a => self(a) && other(a)

  def ||(other: Filter[A]): Filter[A] =
    a => self(a) || other(a)

  def unary_! : Filter[A] =
    a => !self(a)

end extension

object Filter:

  def always[A](b: Boolean): Filter[A] =
    _ => b

  def alwaysPass[A]: Filter[A] =
    always(true)

  def alwaysFail[A]: Filter[A] =
    always(false)

  def matches[A](a: A): Filter[A] =
    _ == a

  def fromPredicate[A](predicate: A => Boolean): Filter[A] =
    predicate

  def fromSelection[A](s: Selection[A]): Filter[A] =
    if s.isEmpty then Filter.alwaysPass
    else s.isSelected(_)

  def contraMap[A, B](f: B => A)(filter: Filter[A]): Filter[B] =
    b => filter(f(b))

  def all[A](filters: Filter[A]*): Filter[A] =
    filters.foldLeft(alwaysPass[A])(_ && _)

  def any[A](filters: Filter[A]*): Filter[A] =
    filters.foldLeft(alwaysFail[A])(_ || _)

// Filter syntax
extension [A](a: A)
  def passes(filter: Filter[A]): Boolean = filter.passes(a)
  def ?(filter: Filter[A]): Boolean      = filter.passes(a)
