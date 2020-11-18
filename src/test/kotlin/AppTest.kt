package main.app
import io.mockk.*
import kotlin.test.*

class AppTest {
    @Test fun `handle user input Q to quit`() {
        val classUnderTest = App();
        mockkStatic("kotlin.io.ConsoleKt")
        every { readLine() } returns "Q"
        classUnderTest.handleUserInput()
        val shouldQuitProgram = true
        assertTrue { shouldQuitProgram }
    }
}
