package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Example6_02_kt {

    @Test
    @Throws(Exception::class)
    fun addingAProductToAnOrder() {
        // Given
        val product = Product("Hand wash")
        val sut = Order()

        // When
        sut.addProduct(product)

        // Then
        assertThat(sut.products().size).isEqualTo(1)
        assertThat(sut.products()[0]).isEqualTo(product)
    }
}