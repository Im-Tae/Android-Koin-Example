package com.leaf.android_koin_example.base

import android.content.Context

interface BaseView<T> {

    val presenter: T

    fun showToast(context: Context, message: String)
}