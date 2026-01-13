package me.study.unittest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Example2_1_kt {

    @Test
    fun `Purchase succeeds when enough inventory`() {
        // Given
        val store = Store()
        store.addInventory(Product.Shampoo, 10)
        val customer = Customer()

        // When
        val success = customer.purchase(store, Product.Shampoo, 5)

        // Then
        assertTrue(success)
        // Kotlin에서는 정수 비교 시 assertSame 대신 assertEquals를 주로 사용합니다.
        assertEquals(5, store.getInventory(Product.Shampoo))
    }

    @Test
    fun `Purchase fails when not enough inventory`() {
        // Given
        val store = Store()
        store.addInventory(Product.Shampoo, 10)
        val customer = Customer()

        // When
        val success = customer.purchase(store, Product.Shampoo, 15)

        // Then
        assertFalse(success)
        assertEquals(10, store.getInventory(Product.Shampoo))
    }
}