package main.app

class App {

    private var canvas = null;

    fun handleUserInput() {
        while (true) {
            print("enter command:")
            val command = readLine()
            if (!command.isNullOrBlank())
                when {
                    command.startsWith("C") -> println("Not yet implemented")
                    command.startsWith("L") -> println("Not yet implemented")
                    command.startsWith("R") -> println("Not yet implemented")
                    command == "Q" -> return;
                    else -> println("Command not valid, enter Q to quit")
                }
        }
    }

}

fun main() {
    App().handleUserInput()
}
