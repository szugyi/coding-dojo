import dojo1.WordWrap
import dojo2.NumbersInWords
import dojo2.NumbersInWords2
import dojo3.PagingSeven

private val katas = listOf(WordWrap, NumbersInWords, NumbersInWords2, PagingSeven)
fun main() {
    katas.forEachIndexed { i, kata ->
        if (0 < i) {
            println("\n--------------------------------\n")
        }
        kata.main()
    }
}
