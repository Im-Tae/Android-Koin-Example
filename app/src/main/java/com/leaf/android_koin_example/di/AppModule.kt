package com.leaf.android_koin_example.di

import com.leaf.android_koin_example.contract.MainContract
import com.leaf.android_koin_example.presenter.MainPresenter
import org.koin.dsl.module

val appModule = module {

    factory<MainContract.Presenter> { (view: MainContract.View) -> MainPresenter(view) }
}