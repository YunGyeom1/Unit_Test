package me.study.unittest

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.util.stream.Stream

class Example3_11_kt {

    @ParameterizedTest
    @MethodSource("provideArguments")
    fun `Can detect an invalid delivery date`(daysFromNow: Int, expected: Boolean) {
        // Given
        val sut = DeliveryService()
        val deliveryDate = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery(deliveryDate)

        // When
        val isValid = sut.isDeliveryValid(delivery)

        // Then
        assertSame(expected, isValid)
    }

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true)
            )
        }
    }
}