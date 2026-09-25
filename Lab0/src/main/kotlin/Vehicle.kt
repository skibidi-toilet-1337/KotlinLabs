open class Vehicle(
    open val speed: Int = 0,
    open val name: String = "Vehicle"
) {
    open fun start() {
        println("$name started moving at $speed km/h.")
    }

    open fun stop() {
        println("$name has stopped.")
    }
}