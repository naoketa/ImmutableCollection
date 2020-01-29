import org.scalatest.funspec.AnyFunSpec

class ListSpec extends AnyFunSpec {
  describe("List") {
    describe("EmptyList") {
      it("should isEmpty") {
        val xs = List()
        assert(xs.isEmpty)
      }
    }

    describe("NonEmptyList") {
      it("should not isEmpty") {
        val xs = List(1)
        assert(!xs.isEmpty)
      }
    }
  }
}
