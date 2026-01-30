package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Example3_07_kt {

    private val store: Store = Store().apply { addInventory(Product.Shampoo, 10) }
    private val sut: Customer = Customer()

    @Test
    @Throws(Exception::class) // 예외 던지기
    fun `Purchase succeeds when enough inventory`() {
        val success = sut.purchase(store, Product.Shampoo, 5)
        assertTrue(success)
        assertSame(5, store.getInventory(Product.Shampoo))
    }

    @Test
    @Throws(Exception::class) // 예외 던지기
    fun `Purchase fails when not enough inventory`() {
        val success = sut.purchase(store, Product.Shampoo, 15)
        assertFalse(success)
        assertSame(10, store.getInventory(Product.Shampoo))
    }
}