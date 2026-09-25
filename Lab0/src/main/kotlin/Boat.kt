class Boat : Vehicle(
    speed = 30,
    name = "Boat"
) {
    override fun start() {
        println("$name started sailing at $speed km/h.")
    }

    override fun stop() {
        println("$name has stopped sailing.")
    }
}