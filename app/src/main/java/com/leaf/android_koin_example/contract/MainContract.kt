package com.leaf.android_koin_example.contract

import com.leaf.android_koin_example.base.BasePresenter
import com.leaf.android_koin_example.base.BaseView

class MainContract {
    interface View: BaseView<Presenter>

    interface Presenter: BasePresenter<View>
}