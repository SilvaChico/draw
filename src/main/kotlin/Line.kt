package draw

import java.lang.Math.*

class Line(val firstPosition: Position, val secondPosition: Position) {

    init {
        validateInputs(firstPosition, secondPosition)
    }

    fun draw(): MutableSet<Position> {
        var linePositions: MutableSet<Position> = mutableSetOf()

        if (this.isHorizontal())
            for (x in getXValues())
                linePositions.add(Position(x, firstPosition.y))

        else if (this.isVertical())
            for (y in getYValues())
                linePositions.add(Position(firstPosition.x, y))

        return linePositions
    }

    private fun isHorizontal(): Boolean {
        return firstPosition.y == secondPosition.y
    }

    private fun isVertical(): Boolean {
        return firstPosition.x == secondPosition.x
    }

    private fun getXValues(): List<Int> {
            val maxX = max(firstPosition.x, secondPosition.x)
            val minX = min(firstPosition.x, secondPosition.x)

            return (minX..maxX).toList()
    }

     private fun getYValues(): List<Int> {
            val maxY = max(firstPosition.y, secondPosition.y)
            val minY = min(firstPosition.y, secondPosition.y)

            return (minY..maxY).toList()
    }

    private fun validateInputs(firstPosition: Position, secondPosition: Position) {
        if (firstPosition.x == secondPosition.x && firstPosition.y == secondPosition.y)
            throw Exception("positions should be different")
        else if (!this.isHorizontal() && !this.isVertical())
            throw Exception("a line can only be horizontal or vertical")
    }
}
