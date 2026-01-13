package me.study.unittest

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class Example1_2_kt {

    companion object {
        // Java의 public static 필드에 대응 (변경 가능하므로 var 사용)
        @JvmField // 다른 Java 코드에서 직접 접근해야 한다면 추가, 아니면 생략 가능
        var wasLastStringLong: Boolean = false

        fun isStringLong(input: String): Boolean {
            val result = input.length > 5
            wasLastStringLong = result
            return result
        }
    }

    @Test
    fun test() {
        val result = isStringLong("abc")
        assertFalse(result)
    }
}