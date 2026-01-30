package me.study.unittest

import org.mockito.BDDMockito.then
import org.mockito.Mockito.only
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class Example5_01_kt {

    @Mock
    lateinit var mock: IEmailGateway

    @Test
    @Throws(Exception::class)
    fun sendingAGreetingsEmail() {
        // Given
        val email = "user@email.com"
        val sut = Controller(mock)

        // When
        sut.greetUser(email)

        // Then
        then(mock).should(only()).sendGreetingsEmail(email)
    }
}