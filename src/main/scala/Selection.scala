opaque type Selection[A] = Set[A]

extension [A](s: Selection[A])
  def isEmpty: Boolean          = s.isEmpty
  def isSelected(a: A): Boolean = s.contains(a)

object Selection:
  def empty[A]: Selection[A]        = Set.empty[A]
  def from[A](as: A*): Selection[A] = Set(as*)
