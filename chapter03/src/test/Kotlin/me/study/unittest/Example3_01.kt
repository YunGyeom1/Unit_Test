package me.study.unittest

import org.junit.jupiter.api.Assertions.assertEquals // JUnit 5에서 assertEquals 임포트
import org.junit.jupiter.api.Test

class Example3_01_kt {

    @Test
    @Throws(Exception::class) // 예외 던지기
    fun sumOfTwoNumbers() {
        // Given
        val first = 10.0
        val second = 20.0
        val calculator = Calculator()

        // When
        val result = calculator.sum(first, second)

        // Then
        assertEquals(30.0, result) // JUnit 5의 assertEquals 사용
    }
}