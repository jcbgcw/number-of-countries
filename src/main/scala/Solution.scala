object Solution {

  var count = 0
  var codes: Array[Int] = _

  def solve(a: Array[Array[Int]]): Int = {
    count = 0
    codes = new Array[Int](a(0).length)
    travelRow(a(0))
    a.indices.tail.foreach(i => travelRow(a(i), a(i - 1)))
    count
  }

  private def travelRow(row: Array[Int], prevRow: Array[Int] = null): Unit = {
    var startIndex = 0
    while (startIndex < row.length) {
      val endIndex = countryEndIndex(row, startIndex)
      travelCountry(row, prevRow, startIndex, endIndex)
      startIndex = endIndex + 1
    }
  }

  private def travelCountry(row: Array[Int], prevRow: Array[Int], start: Int, end: Int): Unit = {
    val set = scala.collection.mutable.Set[Int]()
    if (prevRow != null) {
      for (i <- start to end) {
        if (row(i) == prevRow(i)) {
          set.add(codes(i))
        }
      }
    }
    count = count + 1 - set.size
    for (i <- start to end)
      codes(i) = if (set.isEmpty) count else set.head
  }

  private def countryEndIndex(r: Array[Int], start: Int): Int = {
    for (i <- start + 1 until r.length) {
      if (r(i) != r(i - 1))
        return i - 1
    }
    r.length - 1
  }

}
