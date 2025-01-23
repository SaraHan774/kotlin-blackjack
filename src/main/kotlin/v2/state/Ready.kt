package v2.state

import v2.Hands
import v2.card.PlayingCard

class Ready(
    private val hands: Hands = Hands(),
) : State {
    override val cards: List<PlayingCard> get() = hands.toList()
    constructor(card: PlayingCard) : this(Hands(listOf(card)))

    fun draw(card: PlayingCard): State {
        val hands = hands + card // Hands 를 굳이 만들 필요가 없다
        if (hands.size < NEXT_STATE_HANDS_SIZE) return Ready(card)
        // 점수 계산은 복잡한 규칙이기 떄문에, 잠시 Hands 라는 애를 만들어 보자.
        if (hands.isBlackJackScore()) return BlackJack(hands)
        return Hit(hands)
    }

    companion object {
        private const val NEXT_STATE_HANDS_SIZE: Int = 2
    }
}