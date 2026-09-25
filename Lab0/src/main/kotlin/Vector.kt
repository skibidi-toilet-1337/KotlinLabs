import kotlin.math.sqrt

class Vector(
    val x: Double,
    val y: Double,
    val z: Double
) {

    fun length(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    fun scalarProduct(other: Vector): Double {
        return x * other.x + y * other.y + z * other.z
    }

    infix fun scalar(other: Vector): Double {
        return scalarProduct(other)
    }

    //vector1 * vector2
    operator fun times(other: Vector): Double {
        return scalarProduct(other)
    }
}