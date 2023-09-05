package dojo1

import Kata

object WordWrap : Kata {
    override fun main() {
        println("WordWrap Kata")

        val text = "This is a long text that has to be processed by the wrapper and have " +
                "the proper line breaks at the right positions."
        val columns = 30

        println("Columns to wrap at: $columns")
        println("The raw text is:\n$text")

        println("\nThe processed text is:\n${wrap(text, columns)}")
    }

    fun wrap(text: String, columns: Int): String {
        return if (text.length <= columns) {
            text
        } else {
            val currentLine = text.substring(0, columns)
            val lastSpaceIndex = currentLine.lastIndexOf(' ')
            val nextLineStartsWithSpace = text.substring(columns, columns + 1) == " "

            val (wrapAt, nextLineOffset) = if (nextLineStartsWithSpace) {
                columns to 1
            } else if (lastSpaceIndex != -1) {
                lastSpaceIndex to 1
            } else {
                columns to 0
            }

            val wrappedLine = text.substring(0, wrapAt) + "\n"
            val restOfTheText = text.substring(wrapAt + nextLineOffset)

            wrappedLine + wrap(restOfTheText, columns)
        }
    }
}
