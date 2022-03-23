package com.example.kotlin.ex4

import java.io.File

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File?, o2: File?): Int {
        return o1?.path?.compareTo(o2?.path ?: throw NullPointerException(""), ignoreCase = true) ?: 0
    }
}