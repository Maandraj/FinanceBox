package com.maandraj.core_ui.util

interface PinCodeClickListener {
    fun onClickCell()

    class Base(private val onClick : () -> Unit) : PinCodeClickListener{
        override fun onClickCell() {
            onClick()
        }
    }
}