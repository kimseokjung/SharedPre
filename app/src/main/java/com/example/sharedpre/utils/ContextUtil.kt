package com.example.sharedpre.utils

import android.content.Context
import android.provider.ContactsContract
import android.text.Editable

class ContextUtil {

    companion object {

        private val prefName = "TestPref"

        private val AUTO_LOGIN = "AUTO_LOGIN"
        private val SAVE_EMAIL = "SAVE_EMAIL"

        fun setAutoLogin(context: Context, autoLogin: Boolean){
            //앱에서 저장할수있는 공간을 여는 작업
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putBoolean(AUTO_LOGIN,autoLogin).apply()
        }
        fun getAutoLogin(context: Context): Boolean{
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getBoolean(AUTO_LOGIN, false)
        }

        fun setEmailSave(context: Context, email: Editable){
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(SAVE_EMAIL, email.toString()).apply()
        }
        fun getEmailSave(context: Context): String? {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return  pref.getString(SAVE_EMAIL, "hoing")
        }

    }
}