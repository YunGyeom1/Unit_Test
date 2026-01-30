package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito.never
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class Example5_04_kt {

    @Mock
    lateinit var storeMock: IStore

    @Test
    @Throws(Exception::class)
    fun purchaseSucceedsWhenEnoughInventory() {
        // Given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(false)
        val sut = Customer()

        // When
        val success = sut.purchase(storeMock, Product.Shampoo, 5)

        // Then
        assertThat(success).isFalse()
        then(storeMock).should(never()).removeInventory(Product.Shampoo, 5)
    }
}