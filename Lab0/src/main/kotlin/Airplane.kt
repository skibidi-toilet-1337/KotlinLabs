class Airplane : Vehicle(
    speed = 800,
    name = "Airplane"
) {
    override fun start() {
        println("$name started flying at $speed km/h.")
    }

    override fun stop() {
        println("$name has landed and stopped.")
    }
}