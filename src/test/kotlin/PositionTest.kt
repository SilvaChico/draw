package draw
import io.mockk.*
import kotlin.test.*

class PositionTest {
    @Test fun `position x should be 0 and position y should be 1`() {
        val position = Position(0, 1)
        assertTrue { position.x == 0 && position.y == 1 }
    }

     @Test fun `position can take negative values`() {
        val position = Position(-1, 1)
        assertTrue { position.x == -1 }
    }
}
