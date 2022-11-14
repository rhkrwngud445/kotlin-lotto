package lotto

const val FIRST_PLACE_COUNT = 6
const val FIRST_PLACE_INDEX = 0
const val SECOND_PLACE_COUNT = 5
const val SECOND_PLACE_INDEX = 1
const val WINNINGS_COUNT_MIN = 3
const val LOTTO_SIZE=6

class LottoCalculator(
    private val consumerLottos: List<List<Int>>,
    private val winningLotto: Lotto,
    private val bonusNumber: Int
) {
    fun calculateLotto(): List<Int> {
        val winnings = mutableListOf<Int>(0, 0, 0, 0, 0)
        for (consumerLotto in consumerLottos) {
            val correctCount = compareNumbers(consumerLotto)
            if (correctCount == SECOND_PLACE_COUNT && consumerLotto.contains(bonusNumber)) {
                winnings[SECOND_PLACE_INDEX]++
            } else if (correctCount == FIRST_PLACE_COUNT) {
                winnings[FIRST_PLACE_INDEX]++
            } else if (correctCount >= WINNINGS_COUNT_MIN) {
                winnings[7 - correctCount]++
            }
        }
        return winnings
    }

    private fun compareNumbers(consumerLotto: List<Int>): Int {
        var count = 0
        for (i in 0 until LOTTO_SIZE) {
            if (winningLotto.contains(consumerLotto[i])) {
                count++
            }
        }
        return count
    }
}