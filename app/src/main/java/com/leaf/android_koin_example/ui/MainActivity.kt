package com.leaf.android_koin_example.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.leaf.android_koin_example.R
import com.leaf.android_koin_example.base.BaseActivity
import com.leaf.android_koin_example.contract.MainContract
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity(), MainContract.View {

    override val presenter : MainContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.context = this
        presenter.setToastMessage()
    }

    override fun showToast(context: Context, message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
