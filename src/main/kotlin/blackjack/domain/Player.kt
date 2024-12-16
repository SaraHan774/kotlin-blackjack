package blackjack.domain

import java.math.BigDecimal

class Player(
    val name: String,
    private val betMoney: BetMoney,
    private val drawCard: () -> Card,
) : Participant(drawCard = drawCard) {
    fun play(
        isDrawCard: (String) -> Boolean,
        onDrawCard: () -> Unit,
        onExitPlay: () -> Unit,
    ) {
        var shouldContinue = shouldContinueDrawing(isDrawCard)
        while (shouldContinue) {
            val isCardAdded = addCardIfAvailable(requireCard = drawCard, onDrawCard = onDrawCard)
            shouldContinue = isCardAdded && shouldContinueDrawing(isDrawCard)
        }
        onExitPlay()
    }

    fun setProfitMoneyFromGameResult(result: GameResult) {
        val betMoney = getBetMoneyFromGameResult(result)
        profitMoney.set(betMoney)
    }

    private fun getBetMoneyFromGameResult(gameResult: GameResult): BigDecimal {
        return when (gameResult) {
            GameResult.BLACK_JACK -> betMoney.getAmountOnBlackJack()
            GameResult.WIN -> betMoney.getOriginalBetAmount()
            GameResult.PUSH -> betMoney.getOriginalBetAmount()
            GameResult.LOSE -> betMoney.getAmountOnLose()
            GameResult.BUST -> betMoney.getAmountOnBust()
        }
    }

    private fun shouldContinueDrawing(isDrawCard: (String) -> Boolean): Boolean {
        return isDrawCard(name)
    }

    override fun isAddCardEnabled(): Boolean {
        return cardsSum < Card.MAX_SUM
    }
}
