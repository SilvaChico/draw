package draw

 class Canvas(val width: Int, val height: Int) {

    private val maxX = width
    private val maxY = height

    private var points = mutableMapOf<Position, String>()

    init {
        validateInputs(width, height)
    }

    fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {

        val firstPosition = Position(x1, y1)
        val secondPosition = Position(x2, y2)

        if (! isValid(firstPosition) || ! isValid(secondPosition))
            throw Exception("Line should not overflow the canvas")

        try {
            Line(firstPosition, secondPosition).draw().forEach { position ->
                points.put(position, "X")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun drawRectangle(x1: Int, y1: Int, x2: Int, y2: Int) {

        val upperLeftCorner = Position(x1, y1)
        val lowerRightCorner = Position(x2, y2)

        if (! isValid(upperLeftCorner) || ! isValid(lowerRightCorner))
            throw Exception("Rectangle should not overflow the canvas")

        try {
            Rectangle(upperLeftCorner, lowerRightCorner).draw().forEach { position ->
                points.put(position, "X")
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun render() {
        val rows: IntRange = (0..height + 1)
        val columns: IntRange = (0..width + 1)
        var buffer: String

        for (y in rows) {
            for (x in columns) {
                if (isFirstOrLastRow(y)) buffer = "-"
                else if (isFirstOrLastColumn(x)) buffer = "|"
                else buffer = points[Position(x, y)] ?: " "
                print(buffer)
            }
            print("\n")
        }
    }

    private fun isFirstOrLastRow(y: Int): Boolean {
        return y == 0 || y == height + 1
    }

    private fun isFirstOrLastColumn(x: Int): Boolean {
        return x == 0 || x == width + 1
    }

    private fun isValid(position: Position): Boolean {
        return position.x <= maxX && position.y <= maxY && position.x > 0 && position.y > 0
    }

     private fun validateInputs(width: Int, height: Int) {
        if (width <= 0)
            throw Exception("Width must be greater than zero")
        if (height <= 0)
            throw Exception("Height must be greater than zero")
    }
 }
