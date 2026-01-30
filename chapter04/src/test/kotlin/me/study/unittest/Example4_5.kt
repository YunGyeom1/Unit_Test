package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Example4_5_kt {

    @Test
    @Throws(Exception::class)
    fun test() {
        // Given
        val sut = User()

        // When
        sut.name = "John Smith"

        // Then
        assertThat(sut.name).isEqualTo("John Smith")
    }
}