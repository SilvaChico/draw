package draw

class Rectangle(private val upperLeftCorner: Position, private val lowerRightCorner: Position) {

    private val upperRightCorner = Position(lowerRightCorner.x, upperLeftCorner.y)
    private val lowerLeftCorner = Position(upperLeftCorner.x, lowerRightCorner.y)

    private val topLine = Line(upperLeftCorner, upperRightCorner)
    private val bottomLine = Line(lowerLeftCorner, lowerRightCorner)
    private val leftLine = Line(upperLeftCorner, lowerLeftCorner)
    private val rightLine = Line(lowerRightCorner, upperRightCorner)

    private val rectangleLines = listOf(topLine, bottomLine, leftLine, rightLine)

    fun draw(): MutableSet<Position> {

        var rectanglePositions: MutableSet<Position> = mutableSetOf()

        rectangleLines.forEach { line ->
            rectanglePositions.addAll(line.draw())
        }

        return rectanglePositions
    }
}
