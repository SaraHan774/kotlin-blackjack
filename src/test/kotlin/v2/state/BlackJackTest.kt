package v2.state

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import v2.Hands

class BlackJackTest {
    @Test
    fun constructor() {
        assertThrows<IllegalArgumentException> { BlackJack(Hands()) }
        assertThrows<IllegalArgumentException> { BlackJack(Hands(CLUBS_ACE)) }
    }
}