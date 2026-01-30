package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Example3_08_kt {

    @Test
    fun `Purchase succeeds when enough inventory`() {
        // Given
        val store = createStoreWithInventory(Product.Shampoo, 10)
        val sut = createCustomer()

        // When
        val success = sut.purchase(store, Product.Shampoo, 5)

        // Then
        assertTrue(success)
        assertSame(5, store.getInventory(Product.Shampoo))
    }

    @Test
    fun `Purchase fails when not enough inventory`() {
        // Given
        val store = createStoreWithInventory(Product.Shampoo, 10)
        val sut = createCustomer()

        // When
        val success = sut.purchase(store, Product.Shampoo, 15)

        // Then
        assertFalse(success)
        assertSame(10, store.getInventory(Product.Shampoo))
    }

    private fun createStoreWithInventory(product: Product, quantity: Int): Store {
        val store = Store()
        store.addInventory(product, quantity)
        return store
    }

    private fun createCustomer(): Customer = Customer()
}