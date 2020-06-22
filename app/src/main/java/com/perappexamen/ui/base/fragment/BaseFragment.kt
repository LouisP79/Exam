package com.perappexamen.ui.base.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.perappexamen.preferences.ApplicationPreferences
import com.perappexamen.ui.base.activity.BaseActivity
import org.koin.android.ext.android.inject

abstract class BaseFragment : Fragment() {

    val applicationPreferences: ApplicationPreferences by inject()

    protected abstract val layoutResourceId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResourceId, container, false)
    }

    fun unknownError(t: Throwable?) = (activity as BaseActivity).unknownError(t)
    fun errorCode(code: Int) = (activity as BaseActivity).errorCode(code)
    fun errorConnection(t: Throwable) = (activity as BaseActivity).errorConnection(t)
}
