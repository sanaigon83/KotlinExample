@file:JvmName("Test")
package com.example.kotlin.ex3.strings

import java.lang.StringBuilder

fun <T> joinToString(
    collection: Collection<T>,
    seperator: String,
    prefix: String,
    postfix: String
): String {

    val result = StringBuilder(prefix)
    collection.forEachIndexed { idx, element ->
        if (idx > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

var opCount = 0
val UNIX_LINE_SEPERATOR ="\n"

fun <T> Collection<T>.join(seperator: String,
                           prefix: String,
                           postfix: String): String {
    val result = StringBuilder(prefix)
    forEachIndexed{ idx, element ->
        if (idx > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

