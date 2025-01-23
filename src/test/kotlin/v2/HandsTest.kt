package v2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import v2.state.CLUBS_ACE
import v2.state.CLUBS_TEN
import v2.state.CLUBS_TWO

class HandsTest {
    @Test
    fun two() {
        val hands = Hands(listOf(CLUBS_TWO))
        hands.score() shouldBe 2
    }

    @Test
    fun twelve() {
        val hands = Hands(listOf(CLUBS_TWO, CLUBS_TEN))
        hands.score() shouldBe 12
    }

    @Test
    fun eleven() {
        val hands = Hands(listOf(CLUBS_ACE))
        hands.score() shouldBe 11
    }

    @Test
    fun twentyOne() {
        val hands = Hands(listOf(CLUBS_ACE, CLUBS_TEN))
        hands.score() shouldBe 21
    }

    @Test
    fun twoAce() {
        val hands = Hands(listOf(CLUBS_ACE, CLUBS_ACE, CLUBS_TEN))
        hands.score() shouldBe 12 // 이 경우에는 1점으로 에이스가 계산되어야 한다.
    }
}