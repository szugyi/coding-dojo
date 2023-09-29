import dojo1.WordWrap
import dojo2.NumbersInWords

private val katas = listOf(WordWrap, NumbersInWords)
fun main() {
    katas.forEachIndexed { i, kata ->
        if (0 < i) {
            println("\n--------------------------------\n")
        }
        kata.main()
    }
}
