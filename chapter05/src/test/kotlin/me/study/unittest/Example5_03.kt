package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito.only
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class Example5_03_kt {

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
        then(stub).should(only()).getNumberOfUsers() // over-specification
    }
}