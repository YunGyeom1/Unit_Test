package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.mockito.BDDMockito.given
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class Example5_02_kt {

    @Mock
    lateinit var stub: IDatabase

    @Test
    @Throws(Exception::class)
    fun creatingAReport() {
        // Given
        given(stub.getNumberOfUsers()).willReturn(10)
        val sut = Controller(stub)

        // When
        val report = sut.createReport()

        // Then
        assertThat(report.numberOfUsers).isEqualTo(10)
    }
}