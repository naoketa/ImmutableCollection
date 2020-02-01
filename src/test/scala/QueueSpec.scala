import org.scalatest.OptionValues
import org.scalatest.funspec.AnyFunSpec

class QueueSpec extends AnyFunSpec with OptionValues {
  describe("EmptyQueue") {
    it("should isEmpty") {
      val xs = Queue()
      assert(xs.isEmpty)
    }

    it("should be returned when Queue.empty") {
      val xs = Queue.empty
      assert(xs.isEmpty)
    }

    it("should return None when accessed the head") {
      val item = Queue().head
      assert(item === None)
    }

    it("should throw NoSuchElementException when deQueued") {
      intercept[NoSuchElementException] {
        Queue().deQueue()
      }
    }

    it("with enqueued values should return the first enQueued value when accessed the head") {
      val xs = Queue().enQueue(0).enQueue(1)
      assert(xs.head.value === 0)
    }
  }
  describe("NonEmptyQueue") {
    it("should not isEmpty") {
      val xs = Queue(1)
      assert(!xs.isEmpty)
    }

    it("should return the first element when accessed the head") {
      val item = Queue(1, 2).head
      assert(item.value === 1)
    }

    it("should return the tail Queue when deQueued") {
      val xs = Queue(1, 2, 3).deQueue()
      assert(xs.head.value === 2)
    }

    it("should return the first enQueued value when accessed the head") {
      val xs = Queue(0).enQueue(1).enQueue(2)
      assert(xs.head.value === 0)
    }

    it("should return EmptyList when dequeued after enqueud") {
      val xs = Queue(0).enQueue(1).deQueue().deQueue()
      assert(xs.isEmpty)
    }

    it("should return the second enQueued value after dequeued") {
      val xs = Queue(0).enQueue(1).deQueue()
      assert(xs.head.value === 1)
    }

    it("should return the second enQueued value after enqueued and dequeued") {
      val xs = Queue(0).enQueue(1).enQueue(2).deQueue()
      assert(xs.head.value === 1)
    }
  }
}
