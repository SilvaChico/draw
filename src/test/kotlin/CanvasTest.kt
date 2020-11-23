package draw

import io.mockk.*
import kotlin.test.*

 class CanvasTest {
    @Test
    fun `creates a canvas`() {
        val canvas = Canvas(20, 4)
        assertTrue { canvas.width == 20 }
        assertTrue { canvas.height == 4 }
    }

     @Test
    fun `creates a canvas with negative value`() {
        try {
            val canvas = Canvas(20, -4)
            canvas.render()
            assertTrue { false }
        } catch (e: Exception) {
            assertTrue { e.message == "Height must be greater than zero" }
        }
    }

     @Test
    fun `draws a line`() {
        val canvas = Canvas(6, 4)
        val expectedOutput = "--------\n|      |\n|XXXXXX|\n|      |\n|      |\n--------\n"
        canvas.drawLine(1, 2, 6, 2)
        print(expectedOutput)
        print(canvas.render())
        assertTrue { canvas.render() == expectedOutput }
    }

     @Test
    fun `draws a rectangle`() {
        val canvas = Canvas(6, 4)
        val expectedOutput = "--------\n|      |\n|      |\n|XXXXXX|\n|XXXXXX|\n--------\n"
        canvas.drawRectangle(1, 3, 6, 4)
        assertTrue { canvas.render() == expectedOutput }
    }

    @Test
    fun `draws a line overflowing the canvas`() {
        val canvas = Canvas(20, 4)
        try {
            canvas.drawLine(1, 2, 21, 2)
            assertTrue { false }
        } catch (e: Exception) {
            assertTrue { e.message == "Line should not overflow the canvas" }
        }
    }

        @Test
    fun `draws a rectangle overflowing the canvas`() {
        val canvas = Canvas(20, 4)
        try {
            canvas.drawRectangle(16, 1, 21, 3)
            assertTrue { false }
        } catch (e: Exception) {
            assertTrue { e.message == "Rectangle should not overflow the canvas" }
        }
    }
 }
