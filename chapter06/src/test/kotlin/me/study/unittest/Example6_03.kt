package me.study.unittest

import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock
import org.mockito.Mockito.only
import org.junit.jupiter.api.Test

class Example6_03_kt {

    @Test
    @Throws(Exception::class)
    fun sendingAGreetingEmail() {
        // Given
        val userEmail = "user@userEmail.com"
        val emailGatewayMock = mock(IEmailGateway::class.java)
        val sut = Controller(emailGatewayMock)

        // When
        sut.greetUser(userEmail)

        // Then
        then(emailGatewayMock).should(only()).sendGreetingsEmail(userEmail)
    }
}