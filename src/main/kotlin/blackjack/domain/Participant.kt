package blackjack.domain

abstract class Participant(
    private val drawCard: () -> Card,
) {
    private val _cards = mutableListOf<Card>()
    val cards: Cards = Cards(_cards)
    val cardsSum: Int get() = cards.sumValues()
    val profitMoney: ProfitMoney = ProfitMoney()
    val isBlackJackInitially: Boolean

    init {
        repeat(INITIAL_CARD_COUNT) { addCard(drawCard()) }
        isBlackJackInitially = cardsSum == Card.MAX_SUM
    }

    private fun addCard(card: Card) {
        _cards.add(card)
    }

    fun addCardIfAvailable(
        requireCard: () -> Card,
        onDrawCard: () -> Unit,
    ): Boolean {
        if (isAddCardEnabled()) {
            addCard(requireCard())
            onDrawCard()
            return true
        }
        return false
    }

    fun getGameResultWith(dealer: Participant): GameResult {
        return when {
            this.isBlackJackInitially && dealer.isBlackJackInitially.not() -> GameResult.BLACK_JACK
            this.isBlackJackInitially && dealer.isBlackJackInitially -> GameResult.PUSH
            else -> GameResult.fromScores(dealer.cardsSum, this.cardsSum)
        }
    }

    abstract fun isAddCardEnabled(): Boolean

    companion object {
        private const val INITIAL_CARD_COUNT = 2
    }
}
