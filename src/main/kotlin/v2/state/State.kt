package v2.state

import v2.card.PlayingCard

interface State {
    val cards: List<PlayingCard>
}