package v2.state

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import v2.Hands

class StayTest {
    @Test
    fun constructor() {
        assertThrows<IllegalArgumentException> { Stay(Hands()) }
        assertThrows<IllegalArgumentException> { Stay(Hands(CLUBS_ACE)) }
    }
}