package dojo3

import dojo3.PagingSeven.createPaging
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PagingSevenKtTest {

    @Test
    fun `simple paging`() {
        assertEquals("1 (2) 3 4 5", createPaging(2, 5))
        assertEquals("1 2 3 4 5 (6) 7", createPaging(6, 7))
    }

    @Test
    fun `long paging`() {
        assertEquals("1 … 41 (42) 43 … 100", createPaging(42, 100))
        assertEquals("1 … 4 (5) 6 … 9", createPaging(5, 9))
    }

    @Test
    fun `long paging in first part`() {
        assertEquals("1 (2) 3 4 5 … 9", createPaging(2, 9))
        assertEquals("1 2 3 (4) 5 … 9", createPaging(4, 9))
    }

    @Test
    fun `long paging in second part`() {
        assertEquals("1 … 5 6 7 (8) 9", createPaging(8, 9))
        assertEquals("1 … 5 (6) 7 8 9", createPaging(6, 9))
    }
}
