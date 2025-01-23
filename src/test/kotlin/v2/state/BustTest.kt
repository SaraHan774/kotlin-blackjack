package v2.state

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import v2.Hands

class BustTest {
    @Test
    fun constructor() {
        assertThrows<IllegalArgumentException> { Bust(Hands()) } // No card
        assertThrows<IllegalArgumentException> { Bust(Hands(CLUBS_TWO)) } // One Card
    }

    @Test
    fun draw() {
        val state = Bust(Hands(CLUBS_TWO, CLUBS_TEN, CLUBS_KING))
        assertThrows<IllegalStateException> { state.draw(CLUBS_KING) } // 1개 더 뽑을 수 없다
    }
}