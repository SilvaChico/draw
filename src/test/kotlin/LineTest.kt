package draw

import kotlin.test.*

class LineTest {

    @Test fun `creates a line`() {
        val firstPosition = Position(0, 0)
        val secondPosition = Position(0, 1)
        val line = Line(firstPosition, secondPosition)
        assertTrue { line.firstPosition == firstPosition }
        assertTrue { line.secondPosition == secondPosition }
    }

    @Test
    fun `cannot create a line if the two positions are the same`() {
        val firstPosition = Position(0, 1)
        val secondPosition = Position(0, 1)
        try {
           Line(firstPosition, secondPosition)
           assertTrue { false }
        } catch (e: Exception) {
            assertTrue { e.message == "positions should be different" }
        }
    }

    @Test fun `cannot create a line that is not vertical or horizontal`() {
        val firstPosition = Position(0, 1)
        val secondPosition = Position(1, 2)
        try {
           Line(firstPosition, secondPosition)
           assertTrue { false }
        } catch (e: Exception) {
            assertTrue { e.message == "a line can only be horizontal or vertical" }
        }
    }

     @Test fun `draws a vertical line`() {
        val firstPosition = Position(1, 0)
        val secondPosition = Position(1, 10)
        val line = Line(firstPosition, secondPosition)
        val linePositions = line.draw()
        for (i in (0..10))
            assertTrue { linePositions.contains(Position(1, i)) }
         assertTrue { linePositions.size == 11 }
    }

     @Test fun `draws a horizontal line`() {
        val firstPosition = Position(0, 1)
        val secondPosition = Position(10, 1)
        val line = Line(firstPosition, secondPosition)
        val linePositions = line.draw()
        for (i in (0..10))
            assertTrue { linePositions.contains(Position(i, 1)) }
        assertTrue { linePositions.size == 11 }
    }
}
