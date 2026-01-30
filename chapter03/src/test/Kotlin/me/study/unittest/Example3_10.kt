package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class Example3_10_kt {

    @Test
    fun `Delivery with a past date is invalid`() {
        // Given
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().minusDays(1L)
        val delivery = Delivery(pastDate)

        // When
        val isValid = sut.isDeliveryValid(delivery)

        // Then
        assertFalse(isValid)
    }
}