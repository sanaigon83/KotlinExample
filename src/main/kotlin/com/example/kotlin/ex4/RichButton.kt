package com.example.kotlin.ex4

open class RichButton : Clickable {
    fun disable() {} // 이 함수는 final이므로 하위 클래스가 이 메소드를 오버라이드 할 수 없다.
    open fun animate() {} // 이 함수는 하위 클래스에서 오버라이드 할 수 있다.
    override fun click() {} // override한 메소드를 기본적으로 open이다.
}