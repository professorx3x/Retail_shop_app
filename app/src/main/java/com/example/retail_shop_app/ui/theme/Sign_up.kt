package com.example.retail_shop_app.ui.theme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retail_shop_app.R
import com.example.retail_shop_app.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Sign_up : BaseActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= Firebase.auth
        binding.btnSignUp.setOnClickListener {
            sign_up_user()
        }
    }

    private fun sign_up_user() {
        var email=binding.etEmailSignup.text.toString()
        var pass=binding.etPassSignup.text.toString()
        var confirm_pass=binding.etConfirmPassSignup.text.toString()
        if(email.isBlank()||pass.isBlank()||confirm_pass.isBlank())
        {
            snackBar("Enter all the details")
            finish()
            return
        }
        if(pass!=confirm_pass)
        {
            snackBar("password did not match")
            return
        }
        else{
            showProgressBar()
            auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this)
            {
                hideProgressBar()
                if(it.isSuccessful)
                {
                    Toast.makeText(this," you have"+" successfully registered ", Toast.LENGTH_LONG).show()
                    FirebaseAuth.getInstance().signOut()
                    finish()
                }
                else
                {
                    snackBar(" signup failed ")
                }
            }
        }
    }
}