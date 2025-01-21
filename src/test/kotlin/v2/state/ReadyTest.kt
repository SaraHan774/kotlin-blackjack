package v2.state

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAnyOf
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldNotBeInstanceOf
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read
import org.junit.jupiter.api.Test
import v2.card.Denomination
import v2.card.PlayingCard
import v2.card.SuitV2

/**
 * Ready -카드1장 -> Ready
 * Ready -카드2장 -> Hit
 * Ready -카드2장 -> BlackJack
 */
class ReadyTest {
    @Test
    fun ready() {
        val state = Ready()
        val actual = state.draw(CLUBS_TWO)
        actual.shouldBeInstanceOf<Ready>()
        actual.cards shouldContain CLUBS_TWO
    }

    @Test
    fun hit() {
        val state = Ready(CLUBS_TWO)
        val actual = state.draw(CLUBS_TEN)
        actual.shouldBeInstanceOf<Hit>()
        actual.cards.shouldContainAnyOf(CLUBS_TWO, CLUBS_TEN) // listOf 가 들어있다고 shouldContaint 쓰면 안됨
    }

    fun blackJack() {
        val state = Ready(CLUBS_ACE)
        val actual = state.draw(CLUBS_TEN)
        actual.shouldBeInstanceOf<BlackJack>()
        actual.cards.shouldContainAnyOf(CLUBS_TEN, CLUBS_ACE)
    }
}

val CLUBS_TWO = PlayingCard.of(SuitV2.CLUBS, Denomination.TWO)
val CLUBS_TEN = PlayingCard.of(SuitV2.CLUBS, Denomination.TEN)
val CLUBS_ACE = PlayingCard.of(SuitV2.CLUBS, Denomination.ACE)
