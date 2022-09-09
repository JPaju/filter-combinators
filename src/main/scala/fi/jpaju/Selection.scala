package fi.jpaju

opaque type Selection[A] = Set[A]

extension [A](self: Selection[A])
  def isEmpty: Boolean          = self.isEmpty
  def isSelected(a: A): Boolean = self.contains(a)

  def toSelectionFilter: Filter[A] =
    if self.isEmpty then Filter.pass
    else Filter.fromPredicate(isSelected)

object Selection:
  def fromCollection[A](c: Iterable[A]): Selection[A] = c.toSet
  def singleton[A](a: A): Selection[A]                = fromCollection(Set(a))
  def empty[A]: Selection[A]                          = fromCollection(Set.empty[A])
