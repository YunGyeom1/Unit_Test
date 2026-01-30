package me.study.unittest

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.util.stream.Stream

class Example3_13_kt {

    @ParameterizedTest
    @MethodSource("provideArguments")
    fun `Can detect an invalid delivery date`(deliveryDate: LocalDateTime, expected: Boolean) {
        // Given
        val sut = DeliveryService()
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
                Arguments.of(LocalDateTime.now().minusDays(1L), false),
                Arguments.of(LocalDateTime.now(), false),
                Arguments.of(LocalDateTime.now().plusDays(1L), false),
                Arguments.of(LocalDateTime.now().plusDays(2L), true)
            )
        }
    }
}