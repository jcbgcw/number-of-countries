import org.scalatest.FunSuite

class SolutionTest extends FunSuite {

  test("problem basic") {
    val map = Array(
      Array(5, 4, 4),
      Array(4, 3, 4),
      Array(3, 2, 4),
      Array(2, 2, 2),
      Array(3, 3, 4),
      Array(1, 4, 4),
      Array(4, 1, 1))
    assert(Solution.solve(map) === 11)
  }

  test("custom case") {
    val map = Array(
      Array(1, 2, 1, 3, 1),
      Array(4, 1, 1, 1, 1),
      Array(1, 1, 5, 1, 6),
      Array(1, 1, 1, 1, 1))
    assert(Solution.solve(map) === 7)
  }

}
