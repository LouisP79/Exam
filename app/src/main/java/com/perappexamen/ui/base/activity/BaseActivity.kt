package com.perappexamen.ui.base.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavInflater
import androidx.navigation.fragment.NavHostFragment

import com.perappexamen.R
import com.perappexamen.preferences.ApplicationPreferences
import com.perappexamen.util.core.UtilConnectionInterceptor
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.ext.android.inject
import java.net.HttpURLConnection

abstract class BaseActivity : AppCompatActivity() {

    val applicationPreferences: ApplicationPreferences by inject()

    lateinit var compositeDisposable: CompositeDisposable
    private var navHostFragment: NavHostFragment? = null
    var navInflater: NavInflater? = null

    protected abstract val layoutResourceId: Int
    protected abstract fun addListeners()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)

        nav_host_fragment?.let {
            navHostFragment = nav_host_fragment as NavHostFragment
            navInflater = navHostFragment?.navController?.navInflater
        }

        compositeDisposable = CompositeDisposable()
        addListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showToast(message: Int) {
        Toast.makeText(this, getString(message), Toast.LENGTH_LONG).show()
    }

    fun errorCode(code: Int){
        when(code){
            HttpURLConnection.HTTP_BAD_REQUEST -> showToast(R.string.user_error)
            HttpURLConnection.HTTP_UNAUTHORIZED -> showToast(R.string.user_error)
        }
    }

    fun errorConnection(t: Throwable) {
        if(t is UtilConnectionInterceptor.NoConnectivityException)
            showToast(t.message)
        else unknownError(t)
    }

    fun unknownError(t: Throwable?){
        showToast(R.string.error_internet)
        if(t!=null)
            Log.e("SERVICE ERROR", t.message!!)
        else
            Log.e("SERVICE ERROR", getString(R.string.unknown_error))
    }
}