package me.study.unittest

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Example3_06_kt {

    private val sut: Calculator = Calculator() // 생성자에서 객체 생성

    @Test
    @Throws(Exception::class) // 예외 던지기
    fun sumOfTwoNumbers() {
        // Given
        val first = 10.0
        val second = 20.0

        // When
        val result = sut.sum(first, second)

        // Then
        assertEquals(30.0, result) // JUnit 5의 assertEquals 사용
    }
}