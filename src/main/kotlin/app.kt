package draw

fun main() {
    App().start()
}

class App {

    private var canvas: Canvas? = null

    fun start() {
        while (true) {
            print("enter command:")
            val command = readLine()
            if (!command.isNullOrEmpty())
                when {
                    command.startsWith("C") -> createCanvas(command)
                    command.startsWith("L") -> println("Not yet implemented")
                    command.startsWith("R") -> println("Not yet implemented")
                    command == "Q" -> return
                    else -> println("Command not valid, enter Q to quit or try again")
                }
            val localCanvas = canvas
            if (localCanvas != null)
                localCanvas.render()
            }
        }

        private fun createCanvas(command: String) {
            try {
                val width = command.split(" ")[1].toInt()
                val height = command.split(" ")[2].toInt()
                if (! isValidValue(width) || ! isValidValue(height))
                    println("Input values are not valid")
                else
                    canvas = Canvas(width, height)
                } catch (e: Exception) {
                    println("Input values are not valid")
                    println(e.message)
                }
            }

        // private fun isValidCommand(command: String?): Boolean {
            //     if (command.isNullOrBlank()) return false
    //     if (command.startsWith("C") || 
    //     ((command.startsWith("L") || command.startsWith("R")) && !canvas.isNullOrBlank())
    //         return true
    //     return false
    // }

    private fun isValidValue(value: Int): Boolean {
        return value >= 0
    }
}
