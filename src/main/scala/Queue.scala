sealed trait Queue[T] {
  def isEmpty: Boolean

  def enQueue(t: T): Queue[T]

  def deQueue(): Queue[T]

  def head: Option[T]
}

final case class EmptyQueue[T]() extends Queue[T] {
  override def isEmpty: Boolean = true

  override def enQueue(item: T): Queue[T] = NonEmptyQueue(List(item), List())

  override def deQueue(): Queue[T] = throw new NoSuchElementException("EmptyQueue dose not have any items.")

  override def head: Option[Nothing] = None
}

final case class NonEmptyQueue[T](front: List[T], back: List[T]) extends Queue[T] {
  override def isEmpty: Boolean = false

  override def enQueue(item: T): Queue[T] = NonEmptyQueue(front, back.add(item))

  override def deQueue(): Queue[T] = (front, back) match {
    case (EmptyList, NonEmptyList(_, EmptyList)) => EmptyQueue()
    case (EmptyList, _) => NonEmptyQueue(List.reverse(back).tail, List())
    case (NonEmptyList(_, EmptyList), EmptyList) => EmptyQueue()
    case (NonEmptyList(_, EmptyList), _) => NonEmptyQueue(List.reverse(back), List())
    case _ => NonEmptyQueue(front.tail, back)
  }

  override def head: Option[T] = front match {
    case EmptyList => None
    case NonEmptyList(x: T, _: List[T]) => Option(x)
  }
}

object Queue {
  def empty[T]: Queue[T] = EmptyQueue()

  def apply[T](items: T*): Queue[T] =
    if (items.isEmpty) EmptyQueue() else NonEmptyQueue(List(items: _*), List())
}