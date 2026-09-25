class Tank : Vehicle(
    speed = 60,
    name = "Tank"
) {
    override fun start() {
        println("$name started moving at $speed km/h.")
    }

    override fun stop() {
        println("$name has stopped moving.")
    }
}