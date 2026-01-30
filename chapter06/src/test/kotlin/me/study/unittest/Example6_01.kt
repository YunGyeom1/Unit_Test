package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Example6_01_kt {

    @Test
    @Throws(Exception::class)
    fun discountOfTwoProducts() {
        // Given
        val product1 = Product("Hand wash")
        val product2 = Product("Shampoo")
        val sut = PriceEngine()

        // When
        val discount = sut.calculateDiscount(product1, product2)

        // Then
        assertThat(discount).isEqualTo(0.02)
    }
}