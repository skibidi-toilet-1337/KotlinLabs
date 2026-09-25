class NumberArray(private val array: IntArray) {

    fun positiveSum(): Int {
        var sum = 0

        for (number in array) {
            if (number > 0) {
                sum += number
            }
        }

        return sum
    }

    fun product(): Long {
        var product = 1L

        for (number in array) {
            product *= number
        }

        return product
    }

    fun average(): Double {
        var sum = 0L

        for (number in array) {
            sum += number
        }

        return sum.toDouble() / array.size
    }
}