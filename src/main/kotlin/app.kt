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
                    command.startsWith("L") -> if (canvas != null) drawLine(command) else println("First create a canvas")
                    command.startsWith("R") -> if (canvas != null) drawRectangle(command) else println("First create a canvas")
                    command == "Q" -> return
                    else -> println("Command not valid, enter Q to quit or try again")
                }
                if (canvas != null)
                print(canvas ?.render())
            }
        }

        private fun createCanvas(command: String) {
            try {
                val (width, height) = command.split(" ").drop(1).map { it.toInt() }
                    canvas = Canvas(width, height)
                } catch (e: Exception) {
                    println("Input values are not valid")
                    println(e.message)
                }
        }

        private fun drawLine(command: String) {
            try {
                val (x1, y1, x2, y2) = getValues(command)
                canvas ?.drawLine(x1, y1, x2, y2)
                } catch (e: Exception) {
                    println("Input values are not valid")
                    println(e.message)
                }
        }

        private fun drawRectangle(command: String) {
            try {
                val (x1, y1, x2, y2) = getValues(command)
                canvas ?.drawRectangle(x1, y1, x2, y2)
                } catch (e: Exception) {
                    println("Input values are not valid")
                    println(e.message)
                }
        }

        private fun getValues(command: String): List<Int> {
            var inputValues: List<Int>
            try {
                 inputValues = command.split(" ").drop(1).map { it.toInt() }
            } catch (e: Exception) {
                throw throw Exception("Please insert 4 positive numeric values ")
            }
            return inputValues
        }
}
