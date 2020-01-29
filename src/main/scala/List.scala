sealed trait List[+T] {
  def isEmpty: Boolean

  def add[E >: T](item: E): List[E]

  def addAll[E >: T](items: List[E]): List[E]

  def head: T

  def tail: List[T]
}

case object EmptyList extends List[Nothing] {
  override def isEmpty: Boolean = true

  override def add[E >: Nothing](item: E): List[E] = NonEmptyList(item, EmptyList)

  override def addAll[E >: Nothing](items: List[E]): List[E] = items match {
    case EmptyList => this
    case NonEmptyList(x: E, xs: List[E]) => NonEmptyList(items.head, items.tail)
  }

  override def head: Nothing = throw new NoSuchElementException("EmptyList dose not have any items.")

  override def tail: List[Nothing] = throw new NoSuchElementException("EmptyList dose not have any items.")
}

final case class NonEmptyList[T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false

  override def add[E >: T](item: E): List[E] = NonEmptyList(item, this)

  override def addAll[E >: T](items: List[E]): List[E] = items match {
    case EmptyList => this
    case NonEmptyList(x: T, xs: List[T]) => this.addAll(xs).add(x)
  }
}

object List {
  def reverse[T](xs: List[T]): List[T] = xs match {
    case EmptyList => EmptyList
    case NonEmptyList(x: T, xs: List[T]) => NonEmptyList(x, EmptyList).addAll(reverse(xs))
  }

  def apply[T](items: T*): List[T] =
    if (items.isEmpty) EmptyList else NonEmptyList(items.head, apply(items.tail: _*))
}