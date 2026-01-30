package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Example4_6_kt {

    @Test
    @Throws(Exception::class)
    fun getByIdExecutesCorrectSQLCode() {
        // Given
        val sut = UserRepository()

        // When
        val user = sut.getById(5)

        // Then
        assertThat(sut.getLastExecutedSqlStatement()).isEqualTo("dummy SQL")
    }
}