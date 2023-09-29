package dojo2

import dojo2.NumbersInWords.asWords
import dojo2.NumbersInWords.getSingleDigitWord
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class NumbersInWordsTest {

    @Test
    fun `asWords returns the proper word for single digit numbers`() {
        assertEquals("egy", 1.asWords())
        assertEquals("kettő", 2.asWords())
        assertEquals("három", 3.asWords())
        assertEquals("négy", 4.asWords())
        assertEquals("öt", 5.asWords())
        assertEquals("hat", 6.asWords())
        assertEquals("hét", 7.asWords())
        assertEquals("nyolc", 8.asWords())
        assertEquals("kilenc", 9.asWords())
    }

    @Test
    fun `asWords returns the proper word for two digit numbers`() {
        assertEquals("tíz", 10.asWords())
        assertEquals("tizenegy", 11.asWords())
        assertEquals("tizenkettő", 12.asWords())
        assertEquals("tizenhárom", 13.asWords())
        assertEquals("tizennégy", 14.asWords())
        assertEquals("tizenöt", 15.asWords())
        assertEquals("tizenhat", 16.asWords())
        assertEquals("tizenhét", 17.asWords())
        assertEquals("tizennyolc", 18.asWords())
        assertEquals("tizenkilenc", 19.asWords())
        assertEquals("húsz", 20.asWords())
        assertEquals("huszonegy", 21.asWords())
        assertEquals("harminc", 30.asWords())
        assertEquals("harmincegy", 31.asWords())
        assertEquals("negyven", 40.asWords())
        assertEquals("negyvenegy", 41.asWords())
        assertEquals("ötven", 50.asWords())
        assertEquals("ötvenegy", 51.asWords())
        assertEquals("hatvan", 60.asWords())
        assertEquals("hatvanegy", 61.asWords())
        assertEquals("hetven", 70.asWords())
        assertEquals("hetvenegy", 71.asWords())
        assertEquals("nyolcvan", 80.asWords())
        assertEquals("nyolcvanegy", 81.asWords())
        assertEquals("kilencven", 90.asWords())
        assertEquals("kilencvenegy", 91.asWords())
    }

    @Test
    fun `asWords returns the proper word for three digit numbers`() {
        assertEquals("száz", 100.asWords())
        assertEquals("száznegyvenkettő", 142.asWords())
        assertEquals("kettőszáz", 200.asWords())
        assertEquals("háromszáz", 300.asWords())
        assertEquals("négyszáz", 400.asWords())
        assertEquals("ötszáz", 500.asWords())
        assertEquals("hatszáz", 600.asWords())
        assertEquals("hétszáz", 700.asWords())
        assertEquals("hétszázötvenkilenc", 759.asWords())
        assertEquals("nyolcszáz", 800.asWords())
        assertEquals("kilencszáz", 900.asWords())
    }

    @Test
    fun `asWords returns the proper word for four digit numbers`() {
        assertEquals("ezer", 1000.asWords())
        assertEquals("ezerszáztizenegy", 1111.asWords())
        assertEquals("ezerkettőszázkilencvennyolc", 1298.asWords())
        assertEquals("ezerháromszáz", 1300.asWords())
        assertEquals("kettőezer", 2000.asWords())
        assertEquals("háromezer", 3000.asWords())
        assertEquals("négyezer", 4000.asWords())
        assertEquals("ötezer", 5000.asWords())
        assertEquals("hatezer", 6000.asWords())
        assertEquals("hétezer", 7000.asWords())
        assertEquals("nyolcezer", 8000.asWords())
        assertEquals("kilencezer", 9000.asWords())
    }

    @Test
    fun `asWords returns the proper word for five digit numbers`() {
        assertEquals("tízezer", 10000.asWords())
        assertEquals("tizenegyezer", 11000.asWords())
        assertEquals("húszezer", 20000.asWords())
        assertEquals("harmincezer", 30000.asWords())
        assertEquals("negyvenezer", 40000.asWords())
        assertEquals("ötvenezer", 50000.asWords())
        assertEquals("hatvanezer", 60000.asWords())
        assertEquals("hetvenezer", 70000.asWords())
        assertEquals("nyolcvanezer", 80000.asWords())
        assertEquals("kilencvenezer", 90000.asWords())
    }

    @Test
    fun `getSingleDigitWord returns the proper word for single digit numbers`() {
        assertEquals("egy", 1.getSingleDigitWord())
        assertEquals("kettő", 2.getSingleDigitWord())
        assertEquals("három", 3.getSingleDigitWord())
        assertEquals("négy", 4.getSingleDigitWord())
        assertEquals("öt", 5.getSingleDigitWord())
        assertEquals("hat", 6.getSingleDigitWord())
        assertEquals("hét", 7.getSingleDigitWord())
        assertEquals("nyolc", 8.getSingleDigitWord())
        assertEquals("kilenc", 9.getSingleDigitWord())
    }
}