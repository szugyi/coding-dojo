package dojo3

import Kata

object PagingGeneral : Kata {
    private const val MORE_SEPARATOR = "…"

    override fun main() {
        println("PagingGeneral Kata")

        val page = 1
        val totalPages = 5
        println("page: $page, totalPages: $totalPages")
        println(Pager(7).createPaging(page, totalPages))
    }

    class Pager(private val pagingLimit: Int = 7) {
        fun createPaging(selectedPage: Int, total: Int): String {
            val range = 1..total
            var inMoreSeparatorGroup = false

            val pages = range.mapNotNull { pageNumber ->
                if (shouldPrintNumber(pageNumber, range, selectedPage)) {
                    inMoreSeparatorGroup = false
                    formatNumber(selectedPage, pageNumber)
                } else if (!inMoreSeparatorGroup) {
                    inMoreSeparatorGroup = true
                    MORE_SEPARATOR
                } else {
                    null
                }
            }

            return pages.joinToString(separator = " ")
        }

        private fun shouldPrintNumber(pageNumber: Int, range: IntRange, selectedPage: Int): Boolean {
            val neighbours = pagingLimit - 4 - 1 // (4 = first, last, in between separator x 2, 1 = current page)
            val neighboursPerSide = neighbours / 2
            val neighbourRange = selectedPage.minus(neighboursPerSide)..selectedPage.plus(neighboursPerSide)

            val sideLimit = neighbours + 1

            return range.last <= pagingLimit ||
                    pageNumber == range.first ||
                    pageNumber == range.last ||
                    neighbourRange.contains(pageNumber) ||
                    (selectedPage - range.first < sideLimit && pageNumber <= range.first + sideLimit) ||
                    (range.last - selectedPage < sideLimit && range.last - sideLimit <= pageNumber)
        }

        private fun formatNumber(selectedPage: Int, pageNumber: Int) = if (pageNumber == selectedPage) {
            formatCurrentPage(pageNumber)
        } else {
            pageNumber.toString()
        }

        private fun formatCurrentPage(currentPage: Int) = "($currentPage)"
    }
}
