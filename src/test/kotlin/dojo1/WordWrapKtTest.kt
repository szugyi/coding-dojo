package dojo1

import dojo1.WordWrap.wrap
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WordWrapKtTest {

    @Test
    fun `wrap returns the same string if there are less letters than the column number`() {
        val text = "short text"
        val columns = 10
        val result = wrap(text, columns)

        assertEquals(text, result)
    }

    @Test
    fun `wrap adds line break before columns index is reached`() {
        val text = "short text"
        val columns = 8
        val result = wrap(text, columns)

        assertEquals("short\ntext", result)
    }

    @Test
    fun `wrap adds line break at columns index if there are no spaces in the row`() {
        val text = "thisisalongword"
        val columns = 8
        val result = wrap(text, columns)

        assertEquals("thisisal\nongword", result)
    }

    @Test
    fun `wrap adds line break on multiple rows`() {
        // Note: This is an excellent test case. The second line has to be wrapped at
        // the end of a word, so we should not be looking for the last space,
        // instead, we should just wrap and remove the first space from the next line
        val text =
            "This is a long text that has to be processed by the wrapper and have the proper line breaks at the right positions."
        val columns = 30
        val result = wrap(text, columns)

        assertEquals(
            "This is a long text that has\n" +
                    "to be processed by the wrapper\n" +
                    "and have the proper line\n" +
                    "breaks at the right positions.", result
        )
    }
}
