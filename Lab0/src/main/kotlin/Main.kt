import kotlin.math.sqrt

fun main() {

    while (true) {
        println()
        println("----MENU----")
        println("1.Task 1")
        println("2.Task 2")
        println("3.Task 3")
        println("4.Task 4")
        println("5.Task 5")
        println("6.Task 6")
        println("7.Task 7")
        println("8.Task 8")
        println("9.Task 9")
        println("10.Task 10")
        println("0. Exit")
        println("------------")
        print("Choose a task: ")

        when (readln().toInt()) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            6 -> task6()
            7 -> task7()
            8 -> task8()
            9 -> task9()
            10 -> task10()
            0 -> {
                println("Exiting program")
                return
            }
            else -> println("Invalid task number")
        }
    }
}

fun task1() {
    while (true) {
        print("Enter a positive integer: ")

        val input = readlnOrNull()

        if (input.isNullOrBlank()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val number = input.toLongOrNull()

        if (number == null) {
            println("Try again. Enter an integer.")
            continue
        }

        if (number <= 0) {
            println("Try again. The number must be positive.")
            continue
        }

        val lastDigit = number % 10
        var temp = number

        while (temp >= 10) {
            temp /= 10
        }

        val firstDigit = temp

        println("Sum of the first and last digits: ${firstDigit + lastDigit}")
        break
    }
}

fun task2() {
    var count = 0
    var sum = 0.0

    while (true) {
        print("Enter a number (0 to stop): ")

        val input = readlnOrNull()

        if (input.isNullOrBlank()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val number = input.toDoubleOrNull()

        if (number == null) {
            println("Try again. Enter a valid number.")
            continue
        }

        if (number == 0.0) {
            break
        }

        count++
        sum += number
    }

    if (count == 0) {
        println("No numbers were entered.")
    } else {
        val average = sum / count

        println("Number of entered numbers: $count")
        println("Total sum: $sum")
        println("Arithmetic mean: $average")
    }
}

fun task3() {
    val a = (0..10).random()

    println("Try to guess a number between 0 and 10")

    while (true) {
        print("Enter your number: ")

        val input = readlnOrNull()

        if (input.isNullOrBlank()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val b = input.toIntOrNull()

        if (b == null) {
            println("Try again. Enter an integer.")
            continue
        }

        if (b !in 0..10) {
            println("Try again. The number must be between 0 and 10.")
            continue
        }

        if (b > a) {
            println("Too much")
        } else if (b < a) {
            println("Too little")
        } else {
            println("You guessed it")
            break
        }
    }
}

fun task4() {
    while (true) {
        print("Enter the number of prime numbers to display: ")

        val input = readlnOrNull()

        if (input.isNullOrBlank()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val n = input.toIntOrNull()

        if (n == null) {
            println("Try again. Enter an integer.")
            continue
        }

        if (n < 1) {
            println("Try again. The number must be at least 1.")
            continue
        }

        var count = 0
        var number = 2

        while (count < n) {
            var isPrime = true
            var divisor = 2

            while (divisor < number) {
                if (number % divisor == 0) {
                    isPrime = false
                    break
                }

                divisor++
            }

            if (isPrime) {
                count++
                println("$count prime number: $number")
            }

            number++
        }

        break
    }
}

fun createArray(minSize: Int = 1): IntArray {
    while (true) {
        println()
        println("How do you want to create the array?")
        println("1. Enter manually")
        println("2. Generate randomly")
        print("Choose an option: ")

        when (readlnOrNull()) {
            "1" -> {
                var size: Int

                while (true) {
                    print("Enter array size: ")

                    val input = readlnOrNull()
                    size = input?.toIntOrNull() ?: -1

                    if (size < minSize) {
                        println("Try again. Array size must be at least $minSize.")
                    } else {
                        break
                    }
                }

                val array = IntArray(size)

                for (i in array.indices) {
                    while (true) {
                        print("Enter element ${i + 1}: ")

                        val input = readlnOrNull()
                        val number = input?.toIntOrNull()

                        if (number == null) {
                            println("Try again. Please enter an integer.")
                        } else {
                            array[i] = number
                            break
                        }
                    }
                }

                return array
            }

            "2" -> {
                var size: Int

                while (true) {
                    print("Enter array size: ")

                    val input = readlnOrNull()
                    size = input?.toIntOrNull() ?: -1

                    if (size < minSize) {
                        println("Try again. Array size must be at least $minSize.")
                    } else {
                        break
                    }
                }

                return IntArray(size) {
                    (-10..10).random()
                }
            }

            else -> {
                println("Try again. Choose 1 or 2.")
            }
        }
    }
}

fun task5() {
    val array = createArray(3)

    println()
    println("Array:")
    println(array.joinToString(" "))

    // menu for loop
    while (true) {
        println()
        println("Choose the algorithm:")
        println("1. for loop")
        println("2. while loop")
        println("3. forEach")
        print("Choose an option: ")

        when (readlnOrNull()) {
            "1" -> {
                println()
                println("Elements greater than both neighbors:")

                for (i in 1 until array.size - 1) {
                    if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                        println(array[i])
                    }
                }

                break
            }

            "2" -> {
                println()
                println("Elements greater than both neighbors:")

                var i = 1

                while (i < array.size - 1) {
                    if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                        println(array[i])
                    }

                    i++
                }

                break
            }

            "3" -> {
                println()
                println("Elements greater than both neighbors:")

                array.forEachIndexed { i, value ->
                    if (i > 0 && i < array.size - 1) {
                        if (value > array[i - 1] && value > array[i + 1]) {
                            println(value)
                        }
                    }
                }

                break
            }

            else -> {
                println("Try again. Choose 1, 2 or 3")
            }
        }
    }
}

fun task6() {
    val array = createArray(3)

    println()
    println("Array:")
    println(array.joinToString(" "))

    //calc
    while (true) {
        println()
        println("Calculation method:")
        println("1. for loop")
        println("2. while loop")
        println("3. forEach")
        println("4. reduce()")
        println("5. min() and max()")
        print("Choose an option: ")

        when (readlnOrNull()) {
            "1" -> {
                var product = 1L
                var min = array[0]
                var max = array[0]

                for (i in array.indices) {
                    product *= array[i]

                    if (array[i] < min) min = array[i]
                    if (array[i] > max) max = array[i]
                }

                println("Product: $product")
                println("Min: $min")
                println("Max: $max")
                break
            }

            "2" -> {
                var product = 1L
                var min = array[0]
                var max = array[0]
                var i = 0

                while (i < array.size) {
                    product *= array[i]

                    if (array[i] < min) min = array[i]
                    if (array[i] > max) max = array[i]

                    i++
                }

                println("Product: $product")
                println("Min: $min")
                println("Max: $max")
                break
            }

            "3" -> {
                var product = 1L
                var min = array[0]
                var max = array[0]

                array.forEach { number ->
                    product *= number

                    if (number < min) min = number
                    if (number > max) max = number
                }

                println("Product: $product")
                println("Min: $min")
                println("Max: $max")
                break
            }

            "4" -> {
                val product = array.reduce { acc, number ->
                    acc * number
                }

                println("Product: $product")
                println("Min: ${array.min()}")
                println("Max: ${array.max()}")
                break
            }

            "5" -> {
                println("Product: ${array.reduce { acc, number -> acc * number }}")
                println("Min: ${array.min()}")
                println("Max: ${array.max()}")
                break
            }

            else -> println("Try again. choose a number from 1 to 5.")
        }
    }
}

fun sqr(n: Double): Double {
    return n * n
}

fun discriminant(a: Double, b: Double, c: Double): Double {
    return sqr(b) - 4 * a * c
}

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val d = discriminant(a, b, c)

    return when {
        d > 0 -> 2
        d == 0.0 -> 1
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    val d = discriminant(a, b, c)
    val roots = rootsNumber(a, b, c)

    when (roots) {
        2 -> {
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)

            println("Two roots:")
            println("x1 = $x1")
            println("x2 = $x2")
        }

        1 -> {
            val x = -b / (2 * a)

            println("One root:")
            println("x = $x")
        }

        0 -> {
            println("No real roots.")
        }
    }
}

fun task7() {
    println("Equation: ax^2 + bx + c = 0")

    val a: Double

    while (true) {
        print("Enter a: ")
        val input = readlnOrNull()?.trim()

        if (input.isNullOrEmpty()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val value = input.toDoubleOrNull()

        if (value == null) {
            println("Try again. Enter a number.")
            continue
        }

        if (value == 0.0) {
            println("Try again. a can't be 0. The equation must be quadratic.")
            continue
        }

        a = value
        break
    }

    val b: Double

    while (true) {
        print("Enter b: ")
        val input = readlnOrNull()?.trim()

        if (input.isNullOrEmpty()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val value = input.toDoubleOrNull()

        if (value == null) {
            println("Try again. Enter a number.")
            continue
        }

        b = value
        break
    }

    val c: Double

    while (true) {
        print("Enter c: ")
        val input = readlnOrNull()?.trim()

        if (input.isNullOrEmpty()) {
            println("Try again. Input can't be empty.")
            continue
        }

        val value = input.toDoubleOrNull()

        if (value == null) {
            println("Try again. Enter a number.")
            continue
        }

        c = value
        break
    }

    val d = discriminant(a, b, c)
    val roots = rootsNumber(a, b, c)

    println("\nDiscriminant = $d")
    println("Number of roots = $roots")

    quadraticRoot(a, b, c)
}

fun task8() {

    val array = createArray()

    println()
    println("Array:")
    println(array.joinToString(" "))

    val numbers = NumberArray(array)

    println("\nResults:")
    println("Sum of positive elements: ${numbers.positiveSum()}")
    println("Product of elements: ${numbers.product()}")
    println("Average: ${numbers.average()}")}

fun scalarProduct(v1: Vector, v2: Vector): Double {
    return v1.x * v2.x +
           v1.y * v2.y +
           v1.z * v2.z
}

fun readDouble(prompt: String): Double {
    while (true) {
        print(prompt)

        val input = readlnOrNull()?.trim()
        val value = input?.toDoubleOrNull()

        if (value != null) {
            return value
        }

        println("Try again. Please enter a number.")
    }
}

fun task9() {
    println("\nEnter coordinates of the first vector:")
    val x1 = readDouble("x1 = ")
    val y1 = readDouble("y1 = ")
    val z1 = readDouble("z1 = ")

    println("\nEnter coordinates of the second vector:")
    val x2 = readDouble("x2 = ")
    val y2 = readDouble("y2 = ")
    val z2 = readDouble("z2 = ")

    val vector1 = Vector(x1, y1, z1)
    val vector2 = Vector(x2, y2, z2)

    println("\nVector 1: ($x1, $y1, $z1)")
    println("Vector 2: ($x2, $y2, $z2)")

    println("\nLength of vector 1: ${vector1.length()}")
    println("Length of vector 2: ${vector2.length()}")

    println("\nScalar product using method:")
    println(vector1.scalarProduct(vector2))

    println("\nScalar product using infix:")
    println(vector1 scalar vector2)

    println("\nScalar product using operator *:")
    println(vector1 * vector2)

    println("\nScalar product using external function:")
    println(scalarProduct(vector1, vector2))
}

fun task10() {
    println("\n--- Task 10: Vehicles ---")

    val boat = Boat()
    val airplane = Airplane()
    val tank = Tank()

    println("\nBoat:")
    boat.start()
    boat.stop()

    println("\nAirplane:")
    airplane.start()
    airplane.stop()

    println("\nTank:")
    tank.start()
    tank.stop()
}