import org.scalatest.funspec.AnyFunSpec

class QueueSpec extends AnyFunSpec {
  describe("Queue") {
    describe("EmptyQueue") {
      it("should isEmpty") {
        val xs = Queue()
        assert(xs.isEmpty)
      }
    }
    describe("NonEmptyQueue") {
      it("should not isEmpty") {
        val xs = Queue(1)
        assert(!xs.isEmpty)
      }
    }
  }
}
