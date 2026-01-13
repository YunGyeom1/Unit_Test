package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class Example1_1_v2_kt {

    companion object {
        // Java의 public static boolean isStringLong과 동일한 역할
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