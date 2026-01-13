package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class Example2_2_kt {

    @Mock
    lateinit var storeMock: Store // 코틀린에서 Mock은 lateinit var로 선언합니다.

    @Test
    fun `Purchase succeeds when enough inventory`() {
        // Given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(true)
        val customer = Customer()

        // When
        val success = customer.purchase(storeMock, Product.Shampoo, 5)

        // Then
        assertTrue(success)
        then(storeMock).should(times(1)).removeInventory(Product.Shampoo, 5)
    }

    @Test
    fun `Purchase fails when not enough inventory`() {
        // Given
        given(storeMock.hasEnoughInventory(Product.Shampoo, 5)).willReturn(false)
        val customer = Customer()

        // When
        val success = customer.purchase(storeMock, Product.Shampoo, 5)

        // Then
        assertFalse(success)
        then(storeMock).should(never()).removeInventory(Product.Shampoo, 5)
    }
}