package com.perappexamen.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class ApplicationPreferences(context: Context) {

    companion object {
        private const val NAME = "appPreference"
        private const val KEY_TOKEN = "token"
    }

    private val eSharedPreferences: SharedPreferences

    init {
        eSharedPreferences = EncryptedSharedPreferences.create(
            NAME,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    var token: String?
        get() = eSharedPreferences.getString(KEY_TOKEN, null)
        set(value) = eSharedPreferences.edit{putString(KEY_TOKEN, value)}

    fun clearall() {
        token = null
    }

}