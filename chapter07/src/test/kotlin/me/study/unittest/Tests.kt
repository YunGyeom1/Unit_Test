package me.study.unittest

import me.study.unittest.v4.Company
import me.study.unittest.v4.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

// Chapter 7.3
class Tests {

    @Test
    fun `Changing email without changing user type`() {
        // Given
        val company = Company("mycorp.com", 1)
        val sut = User(1, "user@mycorp.com", UserType.EMPLOYEE)

        // When
        sut.changeEmail("new@mycorp.com", company)

        // Then
        assertThat(company.numberOfEmployees).isEqualTo(1)
        assertThat(sut.email).isEqualTo("new@mycorp.com")
        assertThat(sut.type).isEqualTo(UserType.EMPLOYEE)
    }

    @Test
    fun `Changing email from corporate to non corporate`() {
        // Given
        val company = Company("mycorp.com", 1)
        val sut = User(1, "user@mycorp.com", UserType.EMPLOYEE)

        // When
        sut.changeEmail("new@gmail.com", company)

        // Then
        assertThat(company.numberOfEmployees).isEqualTo(0)
        assertThat(sut.email).isEqualTo("new@gmail.com")
        assertThat(sut.type).isEqualTo(UserType.CUSTOMER)
    }

    @Test
    fun `Changing email from non corporate to corporate`() {
        // Given
        val company = Company("mycorp.com", 1)
        val sut = User(1, "user@gmail.com", UserType.CUSTOMER)

        // When
        sut.changeEmail("new@mycorp.com", company)

        // Then
        assertThat(company.numberOfEmployees).isEqualTo(2)
        assertThat(sut.email).isEqualTo("new@mycorp.com")
        assertThat(sut.type).isEqualTo(UserType.EMPLOYEE)
    }

    @Test
    fun `Changing email to the same one`() {
        // Given
        val company = Company("mycorp.com", 1)
        val sut = User(1, "user@gmail.com", UserType.CUSTOMER)

        // When
        sut.changeEmail("user@gmail.com", company)

        // Then
        assertThat(company.numberOfEmployees).isEqualTo(1)
        assertThat(sut.email).isEqualTo("user@gmail.com")
        assertThat(sut.type).isEqualTo(UserType.CUSTOMER)
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    fun `Differentiates a corporate email from non corporate`(
        domain: String,
        email: String,
        expectedResult: Boolean
    ) {
        // Given
        val sut = Company(domain, 0)

        // When
        val isEmailCorporate = sut.isEmailCorporate(email)

        // Then
        assertThat(isEmailCorporate).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> =
            Stream.of(
                Arguments.of("mycorp.com", "email@mycorp.com", true),
                Arguments.of("mycorp.com", "email@gmail.com", false)
            )
    }
}