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

      it("should have the list when addAll a list") {
        val list: List[Int] = List(1, 2, 3)
        val xs: List[Int] = List().addAll(list)
        assert(xs.head === 1)
        assert(xs.tail.head === 2)
        assert(xs.tail.tail.head === 3)
      }

      it("should isEmpty when addAll a empty list") {
        val list: List[Int] = List()
        val xs: List[Int] = List().addAll(list)
        assert(xs.isEmpty)
      }

      it("should EmptyList when reversed") {
        val xs: List[Int] = List()
        assert(List.reverse(xs) === EmptyList)
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

    it("should have the list when addAll a list") {
      val list: List[Int] = List(1, 2)
      val xs: List[Int] = List(3, 4).addAll(list)
      assert(xs.head === 1)
      assert(xs.tail.head === 2)
      assert(xs.tail.tail.head === 3)
      assert(xs.tail.tail.tail.head === 4)
    }

    it("should return the reversed list the list when reverse") {
      val xs: List[Int] = List.reverse(List(1, 2, 3, 4))
      assert(xs.head === 4)
      assert(xs.tail.head === 3)
      assert(xs.tail.tail.head === 2)
      assert(xs.tail.tail.tail.head === 1)
    }
  }

}
