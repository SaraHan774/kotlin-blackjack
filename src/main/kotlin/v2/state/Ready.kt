package v2.state

import v2.card.PlayingCard

class Ready(
    override val cards: List<PlayingCard> = emptyList(),
) : State {
    constructor(card: PlayingCard) : this(listOf(card))

    fun draw(card: PlayingCard): State {
        val hands = cards + card
        if (hands.size >= 2) return Hit(hands)
        return Ready(card)
    }
}