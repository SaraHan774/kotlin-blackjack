package v2.state

import io.kotest.matchers.collections.shouldContainAnyOf
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import v2.Hands

/**
 * - [] Hit - 카드 1장 -> Hit
 * - [] Hit - 카드 1장 -> Bust
 * - [] Hit -> Stay
 */
class HitTest {
    @Test
    fun constructor() {
        assertThrows<IllegalArgumentException> { Hit(Hands()) }
        assertThrows<IllegalArgumentException> { Hit(Hands(CLUBS_ACE)) }
    }

    @Test
    fun hit() {
        val state = Hit(Hands(CLUBS_TWO, CLUBS_THREE))
        val actual = state.draw(CLUBS_TEN)
        actual.shouldBeInstanceOf<Hit>()
        actual.cards.shouldContainAnyOf(CLUBS_TWO, CLUBS_THREE, CLUBS_TEN)
    }

    @Test
    fun bust() {
        val state = Hit(Hands(CLUBS_TWO, CLUBS_KING))
        val actual = state.draw(CLUBS_TEN)
        actual.shouldBeInstanceOf<Bust>()
        actual.cards.shouldContainAnyOf(CLUBS_TWO, CLUBS_KING, CLUBS_TEN)
    }

    @Test
    fun stay() {
        val state = Hit(Hands(CLUBS_TWO, CLUBS_KING))
        val actual = state.stay()
        actual.shouldBeInstanceOf<Stay>()
        actual.cards.shouldContainAnyOf(CLUBS_TWO, CLUBS_KING)
    }
}