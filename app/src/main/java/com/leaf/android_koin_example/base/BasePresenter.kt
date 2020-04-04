package com.leaf.android_koin_example.base

import android.content.Context

interface BasePresenter<T> {

    val view: T
    var context: Context

    fun setToastMessage()
}