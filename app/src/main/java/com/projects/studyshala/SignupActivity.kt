package com.projects.studyshala

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.projects.studyshala.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signupButton.setOnClickListener{
            val email = binding.signupEmail.text.toString().trim()
            val password = binding.signupPassword.text.toString().trim()
            val confirmPassword = binding.signupPassword.text.toString().trim()

            if(email.isNotEmpty() && password.isNotEmpty()){
                if(password==confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task->
                        if(task.isSuccessful){
                            firebaseAuth.currentUser!!.sendEmailVerification()
                            firebaseAuth.signOut()
                            Toast.makeText(this,"Signup Successful. Login here",Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this,"Signup Unsuccessful",Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Please enter email and password",Toast.LENGTH_SHORT).show()
            }
        }

        binding.loginText.setOnClickListener{
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}