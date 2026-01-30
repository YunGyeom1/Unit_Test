package me.study.unittest

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class Example3_09_kt : IntegrationTests() {

    @Test
    @Throws(Exception::class) // 예외 던지기
    fun testWithExtends() {
        assertNotNull(database)
    }
}