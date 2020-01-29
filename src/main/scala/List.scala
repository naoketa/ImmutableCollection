sealed trait List[+T] {
  def isEmpty: Boolean

  def add[E >: T](item: E): List[E]

  def head: T

  def tail: List[T]
}

case object EmptyList extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def add[E >: Nothing](item: E): List[E] = NonEmptyList(item, EmptyList)

  override def head: Nothing = throw new NoSuchElementException("EmptyList dose not have any items.")

  override def tail: List[Nothing] = throw new NoSuchElementException("EmptyList dose not have any items.")
}

final case class NonEmptyList[T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  override def add[E >: T](item: E): List[E] = NonEmptyList(item, this)
}

object List {
  def apply[T](items: T*): List[T] =
    if (items.isEmpty) EmptyList else NonEmptyList(items.head, apply(items.tail: _*))
}