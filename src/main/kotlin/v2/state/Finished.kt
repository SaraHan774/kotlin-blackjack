package v2.state

import v2.Hands
import v2.card.PlayingCard

abstract class Finished(private val hands: Hands) : State {
    override val cards: List<PlayingCard>
        get() = hands.toList()
    init {
        require(hands.size >= 2)
    }

    fun draw(card: PlayingCard) {
        throw IllegalStateException()
    }
}