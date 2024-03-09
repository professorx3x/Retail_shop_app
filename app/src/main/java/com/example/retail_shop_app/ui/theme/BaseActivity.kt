package com.example.retail_shop_app.ui.theme

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.retail_shop_app.R
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {
    private lateinit var DialogBox:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
    @SuppressLint("ResourceAsColor")
    fun snackBar(message:String)
    {
        val snack=Snackbar.make(findViewById(android.R.id.content),message,Snackbar.LENGTH_LONG)
        snack.view.setBackgroundColor(ContextCompat.getColor(this,R.color.my_primary))
        snack.show()
    }
    fun showProgressBar()
    {
        DialogBox= ProgressDialog(this)
        DialogBox.setMessage("Please Wait")
        DialogBox.show()
    }
    fun hideProgressBar()
    {
        DialogBox.dismiss()
    }

}