package com.perappexamen.ui.useCase.login.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.perappexamen.R
import com.perappexamen.data.token.request.TokenRequest
import com.perappexamen.ui.base.activity.BaseActivity
import com.perappexamen.ui.useCase.login.viewModel.LoginViewModel
import com.perappexamen.ui.useCase.main.activity.MainActivity
import com.perappexamen.util.extension.validateEmail
import com.perappexamen.util.extension.validateEmpty
import com.perappexamen.util.extension.validateLength
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    override val layoutResourceId: Int
        get() = R.layout.activity_login

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addListeners()
    }

    private fun addListeners() {
        login.setOnClickListener {if(validate()) login()}
    }

    private fun login(){
        login.startAnimation()
        viewModel.getToken(TokenRequest(email.text.toString(), pass.text.toString()))
            .observe(this,
                Observer { response ->
                    when(response){
                        null -> unknownError(null)
                        else ->{
                            if(response.dataResponse != null){
                                if(response.dataResponse.isSuccessful){
                                    applicationPreferences.token = response.dataResponse.body()!!.data.token
                                    login.stopAnimation()
                                    startActivity(Intent(this, MainActivity::class.java))
                                    finish()
                                }else errorCode(response.dataResponse.code())
                            }else errorConnection(response.throwable!!)
                        }
                    }
                    login.revertAnimation()
                })
    }

    private fun validate(): Boolean{
        var evaluate = true

        if(!email.validateEmpty(R.string.error_login_email_valid)) evaluate = false
        if(!email.validateEmail(R.string.error_login_email_format)) evaluate = false
        if(!pass.validateEmpty(R.string.error_login_password_valid)) evaluate = false
        if(!pass.validateLength(6, R.string.error_login_password_lenght)) evaluate = false

        return evaluate
    }
}