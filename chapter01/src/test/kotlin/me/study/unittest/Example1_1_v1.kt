package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class Example1_1_v1_kt {

    // Java의 static 메서드에 대응하는 companion object
    companion object {
        fun isStringLong(input: String): Boolean {
            return input.length > 5
        }
    }

    @Test
    fun test() {
        val result = isStringLong("abc")
        assertFalse(result)
    }
}