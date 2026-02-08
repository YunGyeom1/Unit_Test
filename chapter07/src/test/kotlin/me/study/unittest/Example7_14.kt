package me.study.unittest

import me.study.unittest.v6.Company
import me.study.unittest.v6.EmailChangedEvent
import me.study.unittest.v6.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Example7_14 {

    @Test
    fun `Changing email from corporate to non corporate`() {
        // Given
        val company = Company("mycorp.com", 1)
        val sut = User(
            1,
            "user@mycorp.com",
            UserType.EMPLOYEE,
            false
        )

        // When
        sut.changeEmail("new@gmail.com", company)

        // Then
        assertThat(company.numberOfEmployees).isEqualTo(0)
        assertThat(sut.email).isEqualTo("new@gmail.com")
        assertThat(sut.type).isEqualTo(UserType.CUSTOMER)
        assertThat(sut.emailChangedEvents).containsExactly(
            EmailChangedEvent(1, "new@gmail.com")
        )
    }
}