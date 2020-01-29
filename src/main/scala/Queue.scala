sealed trait Queue[T] {
  def isEmpty: Boolean

  def enQueue(t: T): Queue[T]

  def deQueue(): Queue[T]

  def head: Option[T]
}

final case class EmptyQueue[T]() extends Queue[T] {
  override def isEmpty: Boolean = true

  override def enQueue(t: T): Queue[T] = ???

  override def deQueue(): Queue[T] = ???

  override def head: Option[Nothing] = ???
}

final case class NonEmptyQueue[T](front: List[T], back: List[T]) extends Queue[T] {
  override def isEmpty: Boolean = false

  override def enQueue(t: T): Queue[T] = ???

  override def deQueue(): Queue[T] = ???

  override def head: Option[T] = ???
}

object Queue {
  def empty[T]: Queue[T] = EmptyQueue()

  def apply[T](items: T*): Queue[T] =
    if (items.isEmpty) EmptyQueue() else NonEmptyQueue(List(items: _*), List())
}