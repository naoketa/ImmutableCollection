import org.scalatest.funspec.AnyFunSpec

class ListSpec extends AnyFunSpec {
  describe("List") {
    describe("EmptyList") {
      it("should isEmpty") {
        val xs = List()
        assert(xs.isEmpty)
      }

      it("with a element should not isEmpty") {
        val xs: List[Int] = List().add(1)
        assert(!xs.isEmpty)
      }

      it("should throw NoSuchElementException when head") {
        val xs: List[Int] = List()
        intercept[NoSuchElementException] {
          xs.head
        }
      }

      it("should throw NoSuchElementException when tail") {
        val xs: List[Int] = List()
        intercept[NoSuchElementException] {
          xs.tail
        }
      }
    }
  }

  describe("NonEmptyList") {
    it("should not isEmpty") {
      val xs = List(1)
      assert(!xs.isEmpty)
    }

    it("should return first value when head") {
      val xs = List(1)
      assert(xs.head === 1)
    }

    it("should return value without head when tail") {
      val xs = List(1).add(2)
      assert(xs.tail.head === 1)
      assert(xs.tail.tail == EmptyList)
    }
  }

}
