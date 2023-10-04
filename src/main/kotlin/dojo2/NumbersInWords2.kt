package dojo2

import Kata

object NumbersInWords2 : Kata {
    override fun main() {
        println("NumbersInWords2 Kata")

        val number = 1500
        println("The raw number is: $number")
        println("The number described with words is: ${number.asWords()}")
    }

    fun Int.asWords(): String {
        val numbers = toString().toCharArray().reversedArray()
        val notations = Notation.values()

        val notationToValueMap = mutableMapOf<Notation, Int>()
        var greatestNotation = Notation.ONES

        numbers.mapIndexed { index, value ->
            val notation = notations[index]
            notationToValueMap[notation] = value.digitToInt()
            greatestNotation = notation
        }

        var words = ""
        val reversedNotations = notations.reversedArray().filter { it.ordinal <= greatestNotation.ordinal }

        reversedNotations.map { notation ->
            val valueAtNotation = notationToValueMap.getValue(notation)

            words +=
                when (notation) {
                    Notation.ONES -> {
                        if (valueAtNotation == 0) {
                            ""
                        } else {
                            valueAtNotation.getSingleDigitWord()
                        }
                    }

                    Notation.TENS -> {
                        if (valueAtNotation == 0) {
                            ""
                        } else {
                            if (notationToValueMap.getValue(Notation.ONES) == 0 || 2 < valueAtNotation) {
                                valueAtNotation.getTensExactWord()
                            } else {
                                valueAtNotation.getTensPrefixWord()
                            }
                        }
                    }

                    Notation.HUNDREDS -> {
                        if (valueAtNotation == 0) {
                            ""
                        } else {
                            if (valueAtNotation == 1) {
                                hundredsPostfix
                            } else {
                                valueAtNotation.getSingleDigitWord() + hundredsPostfix
                            }
                        }
                    }

                    Notation.THOUSANDS -> {
                        if (valueAtNotation == 1 && notationToValueMap[Notation.TEN_THOUSANDS] == null) {
                            thousandsPostfix
                        } else {
                            if (valueAtNotation != 0) {
                                valueAtNotation.getSingleDigitWord() + thousandsPostfix
                            } else {
                                thousandsPostfix
                            }
                        }
                    }

                    Notation.TEN_THOUSANDS -> {
                        if (valueAtNotation == 0) {
                            ""
                        } else {
                            if (notationToValueMap.getValue(Notation.THOUSANDS) == 0 || 2 < valueAtNotation) {
                                valueAtNotation.getTensExactWord()
                            } else {
                                valueAtNotation.getTensPrefixWord()
                            }
                        }
                    }

                    Notation.HUNDRED_THOUSANDS -> {
                        if (valueAtNotation == 0) {
                            ""
                        } else {
                            if (valueAtNotation == 1) {
                                hundredsPostfix
                            } else {
                                valueAtNotation.getSingleDigitWord() + hundredsPostfix
                            }
                        }
                    }

                    Notation.MILLIONS -> {
                        if (valueAtNotation == 0) {
                            ""
                        } else {
                            valueAtNotation.getSingleDigitWord() + millionPostfix
                        }
                    }
                }
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
        } else if (ones == 1) {
            tens.getTensPrefixWord() + ones.getSingleDigitWord()
        } else {
            tens.getTensPrefixWord()
        }
    }

    enum class Notation {
        ONES, TENS, HUNDREDS, THOUSANDS, TEN_THOUSANDS, HUNDRED_THOUSANDS, MILLIONS
    }

    private val singleDigitWords = listOf("egy", "kettő", "három", "négy", "öt", "hat", "hét", "nyolc", "kilenc")
    private val tensExactWords =
        listOf("tíz", "húsz", "harminc", "negyven", "ötven", "hatvan", "hetven", "nyolcvan", "kilencven")
    private val tensPrefixWords =
        listOf("tizen", "huszon")
    private val hundredsPostfix = "száz"
    private val thousandsPostfix = "ezer"
    private val millionPostfix = "millió"
}
