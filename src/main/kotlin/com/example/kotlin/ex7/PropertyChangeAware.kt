package com.example.kotlin.ex7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.util.*

/**
 * Listener 추가와 제거를 담당하는 클래스
 */
open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

