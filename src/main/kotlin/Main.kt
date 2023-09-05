import dojo1.WordWrap

val katas = listOf<Kata>(WordWrap)
fun main(args: Array<String>) {
    katas.forEach {
        it.main()
    }
}
