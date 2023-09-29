package dojo2

import Kata

object NumbersInWords : Kata {
    override fun main() {
        println("NumbersInWords Kata")

        val number = 1500
        println("The raw number is: $number")
        println("The number described with words is: ${number.asWords()}")
    }

    fun Int.asWords(): String {
        val tenThousands = this / 10_000
        val thousands = this / 1_000 % 10
        val hundreds = this / 100 % 10
        val tens = this / 10 % 10
        val ones = this % 10

        var words = ""

        if (tenThousands != 0) {
            words += (this / 1_000 % 100).getTenThousandsWord()
        }

        if (thousands != 0) {
            words += thousands.getThousandsWord()
        }

        if (hundreds != 0) {
            words += hundreds.getHundredsWord()
        }

        if (tens != 0) {
            words += (this % 100).getTensWord()
        }

        if (ones != 0) {
            words += ones.getSingleDigitWord()
        }

        return words
    }

    fun Int.getSingleDigitWord() = singleDigitWords[this - 1]
    fun Int.getTensWord(): String {
        val tens = this / 10
        val ones = this % 10

        return if (ones == 0) {
            tens.getTensExactWord()
        } else {
            tens.getTensPrefixWord()
        }
    }

    fun Int.getTensExactWord() = tensExactWords[this - 1]
    fun Int.getTensPrefixWord() = tensPrefixWords[this - 1]
    fun Int.getHundredsWord(): String {
        return if (this == 1) {
            hundredsPostfix
        } else {
            getSingleDigitWord() + hundredsPostfix
        }
    }

    fun Int.getThousandsWord(): String {
        return if (this == 1) {
            thousandsPostfix
        } else {
            getSingleDigitWord() + thousandsPostfix
        }
    }

    fun Int.getTenThousandsWord(): String {
        val tens = this / 10
        val ones = this % 10

        return if (ones == 0) {
            tens.getTensExactWord() + thousandsPostfix
        } else if(ones == 1){
            tens.getTensPrefixWord() + ones.getSingleDigitWord()
        }else {
            tens.getTensPrefixWord()
        }
    }

    private val singleDigitWords = listOf("egy", "kettő", "három", "négy", "öt", "hat", "hét", "nyolc", "kilenc")
    private val tensExactWords =
        listOf("tíz", "húsz", "harminc", "negyven", "ötven", "hatvan", "hetven", "nyolcvan", "kilencven")
    private val tensPrefixWords =
        listOf("tizen", "huszon", "harminc", "negyven", "ötven", "hatvan", "hetven", "nyolcvan", "kilencven")
    private val hundredsPostfix = "száz"
    private val thousandsPostfix = "ezer"
}
