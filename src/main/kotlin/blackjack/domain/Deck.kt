package blackjack.domain

class Deck(
    suits: List<Suit> = Suit.entries,
    private val ranks: List<Rank> = Rank.entries,
) {
    // Card 상태 변경
    private val cards: MutableList<Card> =
        suits.flatMap { suit -> // Suit -> Rank 쌍 만들기
            ranks.map { rank -> Card(rank, suit) }
        }.toMutableList()

    fun draw(): Card {
        if (cards.isEmpty()) throw IllegalStateException("No more cards")
        cards.shuffle()
        return cards.removeAt(0)
    }
}
