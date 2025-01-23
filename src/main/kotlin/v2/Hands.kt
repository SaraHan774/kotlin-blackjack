package v2

import v2.card.PlayingCard

class Hands(private val cards: List<PlayingCard> = emptyList()) : List<PlayingCard> by cards {
    constructor(vararg cards: PlayingCard) : this(cards.toList())

    // List 의 .size 라든가 contains 연산이라든가 모두 사용할 수 있게 됨. List인데 이름만 Hands 인 느낌.
    fun score(): Int {
        val weight = if (isSoft()) ACE_WEIGHT else 0
        val sum = cards.sumOf { it.score }
        val total = sum + weight
        return sum.takeIf { sum + weight > BLACK_JACK_SCORE } ?: total
    } // 점수를 계산하는 로직에 에이스 예외를 추가한다
    // 어떤 경우에 weight 를 적용해야 하는가 ?

    operator fun plus(card: PlayingCard): Hands = Hands(cards + card)

    fun isBlackJackScore() : Boolean = score() == BLACK_JACK_SCORE

    private fun isSoft() = cards.any { it.isAce }

    companion object {
        private const val ACE_WEIGHT = 10
        private const val BLACK_JACK_SCORE = 21
    }
}