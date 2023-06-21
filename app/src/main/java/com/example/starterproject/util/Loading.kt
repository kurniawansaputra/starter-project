package com.example.starterproject.util

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.starterproject.R

private var dialogBuilder: AlertDialog? = null

fun showLoading(context: Context) {
    val dialogView = LayoutInflater.from(context).inflate(R.layout.layout_loading, null)
    dialogBuilder = AlertDialog.Builder(context)
        .setView(dialogView)
        .setCancelable(false)
        .create()
    dialogBuilder?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    dialogBuilder?.show()
}

fun hideLoading() {
    if (dialogBuilder != null){
        dialogBuilder?.dismiss()
    }
}

fun setLoading(context: Context, isLoading: Boolean) {
    if (isLoading) {
        showLoading(context)
    } else {
        hideLoading()
    }
}