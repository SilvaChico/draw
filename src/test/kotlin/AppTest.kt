package draw
import io.mockk.*
import kotlin.test.*

class AppTest {
    @Test fun `handle user input Q to quit`() {
        val classUnderTest = App()
        mockkStatic("kotlin.io.ConsoleKt")
        every { readLine() } returns "Q"
        classUnderTest.start()
        val shouldQuitProgram = true
        assertTrue { shouldQuitProgram }
    }

    @Test fun `creates canvas`() {
        val classUnderTest = App()
        mockkStatic("kotlin.io.ConsoleKt")
        every { readLine() } returns "C 20 4" andThen "Q"
        classUnderTest.start()
        val shouldQuitProgram = true
        assertTrue { shouldQuitProgram }
    }

    @Test fun `creates canvas with an invalid value`() {
        val classUnderTest = App()
        mockkStatic("kotlin.io.ConsoleKt")
        every { readLine() } returns "C 20 $" andThen "Q"
        classUnderTest.start()
        val shouldQuitProgram = true
        assertTrue { shouldQuitProgram }
    }

    @Test fun `draws a line`() {
        val classUnderTest = App()
        mockkStatic("kotlin.io.ConsoleKt")
        every { readLine() } returns "L 1 2 6 2" andThen "Q"
        classUnderTest.start()
        val shouldQuitProgram = true
        assertTrue { shouldQuitProgram }
    }

    @Test fun `draws a rectangle`() {
        val classUnderTest = App()
        mockkStatic("kotlin.io.ConsoleKt")
        every { readLine() } returns "R 16 1 20 3" andThen "Q"
        classUnderTest.start()
        val shouldQuitProgram = true
        assertTrue { shouldQuitProgram }
    }
}
