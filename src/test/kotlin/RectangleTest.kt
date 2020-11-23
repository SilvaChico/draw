package draw

import kotlin.test.*

class RectangleTest {

    @Test fun `creates a rectangle (square)`() {
        val topLeft = Position(0, 1)
        val bottomRight = Position(1, 0)
        val rectangle = Rectangle(topLeft, bottomRight)
        assertTrue { rectangle.draw().contains(Position(0, 1)) }
        assertTrue { rectangle.draw().contains(Position(1, 1)) }
        assertTrue { rectangle.draw().contains(Position(1, 0)) }
        assertTrue { rectangle.draw().contains(Position(0, 0)) }
        assertTrue { rectangle.draw().size == 4 }
    }

    @Test fun `creates a rectangle`() {
        val topLeft = Position(0, 2)
        val bottomRight = Position(3, 0)
        val rectangle = Rectangle(topLeft, bottomRight)
        assertTrue { rectangle.draw().size == 10 }
        assertTrue { rectangle.draw().contains(Position(0, 0)) }
        assertTrue { rectangle.draw().contains(Position(0, 1)) }
        assertTrue { rectangle.draw().contains(Position(0, 2)) }
        assertTrue { rectangle.draw().contains(Position(1, 0)) }
        assertTrue { rectangle.draw().contains(Position(2, 0)) }
        assertTrue { rectangle.draw().contains(Position(3, 0)) }
        assertTrue { rectangle.draw().contains(Position(3, 1)) }
        assertTrue { rectangle.draw().contains(Position(3, 2)) }
        assertTrue { rectangle.draw().contains(Position(2, 2)) }
        assertTrue { rectangle.draw().contains(Position(1, 2)) }
    }

    @Test fun `creates a rectangle with a negative position`() {
        val topLeft = Position(-1, 1)
        val bottomRight = Position(1, -1)
        val rectangle = Rectangle(topLeft, bottomRight)
        assertTrue { rectangle.draw().size == 8 }
    }

    @Test fun `creates a rectangle with inverted top left and bottom right positions`() {
        val bottomRight = Position(-1, 1)
        val topLeft = Position(1, -1)
        val rectangle = Rectangle(topLeft, bottomRight)
        assertTrue { rectangle.draw().size == 8 }
    }

    @Test fun `creates a rectangle with same position for top left and bottom right`() {
        try {
            val topLeft = Position(1, 1)
            val bottomRight = Position(1, 1)
            val rectangle = Rectangle(topLeft, bottomRight)
            rectangle.draw()
        } catch (e: Exception) {
            assertTrue { e.message == "positions should be different" }
        }
    }
}
