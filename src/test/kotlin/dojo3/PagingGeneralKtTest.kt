package dojo3

import dojo3.PagingGeneral.Pager
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PagingGeneralKtTest {

    @Test
    fun `simple paging`() {
        val pager = Pager(7)

        assertEquals("1 (2) 3 4 5", pager.createPaging(2, 5))
        assertEquals("1 2 3 4 5 (6) 7", pager.createPaging(6, 7))
        assertEquals("(1) 2 3 4 5 6 7", pager.createPaging(1, 7))
        assertEquals("1 2 3 4 5 6 (7)", pager.createPaging(7, 7))

        val pagerNine = Pager(9)
        assertEquals("1 (2) 3 4 5", pagerNine.createPaging(2, 5))
        assertEquals("1 2 3 4 5 (6) 7 8 9", pagerNine.createPaging(6, 9))
        assertEquals("(1) 2 3 4 5 6 7 8 9", pagerNine.createPaging(1, 9))
        assertEquals("1 2 3 4 5 6 7 8 (9)", pagerNine.createPaging(9, 9))
    }

    @Test
    fun `long paging`() {
        val pager = Pager(7)

        assertEquals("1 … 41 (42) 43 … 100", pager.createPaging(42, 100))
        assertEquals("1 … 4 (5) 6 … 9", pager.createPaging(5, 9))

        val pagerNine = Pager(9)
        assertEquals("1 … 40 41 (42) 43 44 … 100", pagerNine.createPaging(42, 100))
        assertEquals("1 2 3 4 (5) 6 7 8 9", pagerNine.createPaging(5, 9))
    }

    @Test
    fun `long paging in first part`() {
        val pager = Pager(7)

        assertEquals("1 (2) 3 4 5 … 9", pager.createPaging(2, 9))
        assertEquals("1 2 3 (4) 5 … 9", pager.createPaging(4, 9))
        assertEquals("(1) 2 3 4 5 … 9", pager.createPaging(1, 9))

        val pagerNine = Pager(9)
        assertEquals("1 (2) 3 4 5 6 7 … 11", pagerNine.createPaging(2, 11))
        assertEquals("1 2 3 4 (5) 6 7 … 11", pagerNine.createPaging(5, 11))
        assertEquals("(1) 2 3 4 5 6 7 … 11", pagerNine.createPaging(1, 11))
    }

    @Test
    fun `long paging in second part`() {
        val pager = Pager(7)

        assertEquals("1 … 5 6 7 (8) 9", pager.createPaging(8, 9))
        assertEquals("1 … 4 (5) 6 … 9", pager.createPaging(5, 9))
        assertEquals("1 … 5 (6) 7 8 9", pager.createPaging(6, 9))
        assertEquals("1 … 5 6 7 8 (9)", pager.createPaging(9, 9))

        val pagerNine = Pager(9)
        assertEquals("1 … 5 6 7 (8) 9 10 11", pagerNine.createPaging(8, 11))
        assertEquals("1 … 4 5 (6) 7 8 … 11", pagerNine.createPaging(6, 11))
        assertEquals("1 … 5 6 (7) 8 9 10 11", pagerNine.createPaging(7, 11))
        assertEquals("1 … 5 6 7 8 9 10 (11)", pagerNine.createPaging(11, 11))
    }
}
