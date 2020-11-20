package draw

class Line(val firstPosition: Position, val secondPosition: Position) {

    init {
        validateInputs(firstPosition, secondPosition)
    }

    fun draw(): MutableSet<Position> {
        var linePositions: MutableSet<Position> = mutableSetOf()
        if (this.isHorizontal())
            for (i in firstPosition.x..secondPosition.x)
                linePositions.add(Position(i, firstPosition.y))
        else if (this.isVertical())
                for (j in firstPosition.y..secondPosition.y)
                linePositions.add(Position(firstPosition.x, j))
        return linePositions
    }

    private fun isHorizontal(): Boolean {
        return firstPosition.y == secondPosition.y
    }

    private fun isVertical(): Boolean {
        return firstPosition.x == secondPosition.x
    }

    private fun validateInputs(firstPosition: Position, secondPosition: Position) {
        if (firstPosition.x == secondPosition.x && firstPosition.y == secondPosition.y)
            throw Exception("positions should be different")
        else if (!this.isHorizontal() && !this.isVertical())
            throw Exception("a line can only be horizontal or vertical")
    }
}
