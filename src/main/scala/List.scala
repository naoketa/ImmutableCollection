sealed trait List[+T] {
  def isEmpty: Boolean
}

case object EmptyList extends List[Nothing] {
  override def isEmpty: Boolean = true
}

final case class NonEmptyList[T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}

object List {
  def apply[T](items: T*): List[T] =
    if (items.isEmpty) EmptyList else NonEmptyList(items.head, apply(items.tail: _*))
}