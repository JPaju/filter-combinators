package fi.jpaju

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

  def contramap[B](f: B => A): Filter[B] =
    b => self.passes(f(b))

end extension

object Filter:

  def fromPredicate[A](predicate: A => Boolean): Filter[A] =
    predicate

  def fromEquals[A](a: A): Filter[A] =
    fromPredicate(_ == a)

  def always[A](willPass: Boolean): Filter[A] =
    fromPredicate(_ => willPass)

  def pass[A]: Filter[A] =
    always(true)

  def fail[A]: Filter[A] =
    always(false)

  def all[A](filters: Filter[A]*): Filter[A] =
    filters.foldLeft(pass)(_ && _)

  def any[A](filters: Filter[A]*): Filter[A] =
    filters.foldLeft(fail)(_ || _)

// Filter syntax
extension [A](a: A)
  def passes(filter: Filter[A]): Boolean = filter.passes(a)
  def ?(filter: Filter[A]): Boolean      = filter.passes(a)
