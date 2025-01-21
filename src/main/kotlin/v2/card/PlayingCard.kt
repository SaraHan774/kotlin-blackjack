package v2.card

import java.util.*
import kotlin.NoSuchElementException

class PlayingCard private constructor(private val suit: SuitV2, private val denomination: Denomination) {
    val isAce: Boolean = denomination.isAce
    val score: Int = denomination.score

    override fun toString(): String {
        return "PlayingCard(suit=$suit, denomination=$denomination)"
    }

    companion object {
        private val CARDS: MutableMap<String, PlayingCard> = mutableMapOf()

        fun of(suit: SuitV2, denomination: Denomination) : PlayingCard {
            return CARDS[toKey(suit, denomination)] ?: throw NoSuchElementException()
        }

        private fun toKey(
            suit: SuitV2,
            denomination: Denomination,
        ) : String {
            return suit.name + denomination.name
        }

        init {
            for (suit in SuitV2.entries) {
                for (denomination in Denomination.entries)
                    CARDS[toKey(suit, denomination)] = PlayingCard(suit, denomination)
            }
        }
    }
}