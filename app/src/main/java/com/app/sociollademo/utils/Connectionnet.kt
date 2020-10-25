package com.app.sociollademo.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.widget.Toast
import com.app.sociollademo.R


class Connectionnet : Activity() {
    fun isConnected(context: Context): Boolean {
        val manager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                ?: return false
        val info = manager.activeNetworkInfo
        return info != null && info.isConnected
    }

    fun showNetworkToastMessage(context: Context?) {
        val toast: Toast = Toast.makeText(context, R.string.no_internet, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }

    fun showLoingmsg(context: Context?, message: String?) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }

    companion object {
        private var connectionnet: Connectionnet? = null
        @JvmStatic
        val connectionnetInstance: Connectionnet?
            get() {
                if (connectionnet == null) {
                    connectionnet = Connectionnet()
                }
                return connectionnet
            }
    }
}