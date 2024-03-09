package com.example.retail_shop_app.ui.theme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retail_shop_app.R
import com.example.retail_shop_app.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : BaseActivity(){
    private lateinit var binding:ActivityLoginBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //from login page to signup page on if user don't have an account
        binding.loginToSignup.setOnClickListener {
            startActivity(Intent(this,Sign_up::class.java))
        }
        //initializing auth
        auth= FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email=binding.etEmailLogin.text.toString()
        val pass=binding.etPassLogin.text.toString()
        showProgressBar()
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this)
        {
            hideProgressBar()
            if(it.isSuccessful)
            {
                startActivity(Intent(this,Home_page::class.java))
                finish()
            }
            else{
                snackBar("Log in unsuccessful")
            }
        }
    }
}