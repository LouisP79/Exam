package com.perappexamen.ui.useCase.main.activity

import android.content.Intent
import android.os.Bundle
import com.perappexamen.R
import com.perappexamen.ui.base.activity.BaseActivity
import com.perappexamen.ui.useCase.login.activity.LoginActivity
import com.perappexamen.ui.useCase.main.viewModel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))

        if(applicationPreferences.token == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }
    }
}