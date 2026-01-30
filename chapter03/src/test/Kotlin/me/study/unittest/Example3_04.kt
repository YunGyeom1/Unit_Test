package me.study.unittest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Example3_04_kt {

    @Test
    @Throws(Exception::class) // 예외 던지기
    fun sumOfTwoNumbers() {
        // Given
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        // When
        val result = sut.sum(first, second)

        // Then
        assertEquals(30.0, result) // JUnit 5의 assertEquals 사용
    }
}