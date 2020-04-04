package com.leaf.android_koin_example.presenter

import android.content.Context
import com.leaf.android_koin_example.contract.MainContract

class MainPresenter(override val view: MainContract.View) : MainContract.Presenter {

    override lateinit var context: Context

    override fun setToastMessage() = view.showToast( context,"Hello!")
}