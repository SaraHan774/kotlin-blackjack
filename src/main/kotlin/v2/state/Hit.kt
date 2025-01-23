package v2.state

import v2.Hands
import v2.card.PlayingCard

class Hit(private val hands: Hands) : State {
    override val cards: List<PlayingCard> get() = hands.toList()

    init {
        require(hands.size >= 2) // Hit 상태일때는 기본적으로 카드가 2장 이상이다
    }

    fun draw(card: PlayingCard) : State {
        val hands = hands + card
        return if (hands.score() > 21) Bust(hands)
        else Hit(hands)
    }

    fun stay(): Stay {
        return Stay(hands)
    }
}