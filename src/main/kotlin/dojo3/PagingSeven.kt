package dojo3

import Kata

object PagingSeven : Kata {
    private const val MORE_SEPARATOR = "…"

    override fun main() {
        println("PagingSeven Kata")

        val page = 1
        val totalPages = 5
        println("page: $page, totalPages: $totalPages")
        println(createPaging(page, totalPages))
    }

    fun createPaging(currentPage: Int, total: Int): String {
        val pages = if (total <= 7) {
            shortPaging(currentPage, total)
        } else {
            longPaging(currentPage, total)
        }

        return pages.joinToString(separator = " ")
    }

    private fun shortPaging(currentPage: Int, total: Int): List<String> {
        val range = 1..total

        val pages = range.map { pageNumber ->
            formatNumber(currentPage, pageNumber)
        }

        return pages
    }

    private fun longPaging(currentPage: Int, total: Int): List<String> {
        val range = 1..total
        var inMoreSeparatorGroup = false

        val pages = range.mapNotNull { pageNumber ->
            if (shouldPrintNumber(pageNumber, range, currentPage)) {
                inMoreSeparatorGroup = false
                formatNumber(currentPage, pageNumber)
            } else if (!inMoreSeparatorGroup) {
                inMoreSeparatorGroup = true
                MORE_SEPARATOR
            } else {
                null
            }
        }

        return pages
    }

    private fun shouldPrintNumber(pageNumber: Int, range: IntRange, currentPage: Int) =
        pageNumber == range.first ||
                pageNumber == range.last ||
                pageNumber == currentPage ||
                pageNumber == currentPage.minus(1) ||
                pageNumber == currentPage.plus(1) ||
                (currentPage - range.first <= 3 && pageNumber <= range.first + 4) ||
                (range.last - currentPage <= 3 && range.last - 4 <= pageNumber)

    private fun formatNumber(currentPage: Int, pageNumber: Int) = if (pageNumber == currentPage) {
        formatCurrentPage(pageNumber)
    } else {
        pageNumber.toString()
    }

    private fun formatCurrentPage(currentPage: Int) = "($currentPage)"
}
