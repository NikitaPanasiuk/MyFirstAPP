package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

 open class MainActivity : AppCompatActivity() {
    private val userList = mutableListOf<User>()
    fun getUserList():List<User>{
        return  userList
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstName: EditText = findViewById(R.id.FirstName)
        val secondName: EditText = findViewById(R.id.SecondName)
        val age: EditText = findViewById(R.id.Age)
        val createUser: Button = findViewById(R.id.CreateUser)
        val showUser: Button = findViewById(R.id.ShowUser)
        val text1 = "This user already created!"
        val duration1 = Toast.LENGTH_SHORT
        val toast1 = Toast.makeText(applicationContext, text1, duration1)
        val text2 = "All field must be full!"
        val duration2 = Toast.LENGTH_SHORT
        val toast2 = Toast.makeText(applicationContext, text2, duration2)
        val text3 = "No user created"
        val duration3 = Toast.LENGTH_SHORT
        val toast3 = Toast.makeText(applicationContext, text3, duration3)
        createUser.setOnClickListener {
            if (age.text.isNotEmpty() && firstName.text.isNotEmpty() && secondName.text.isNotEmpty()) {
                val user = User(age.text, firstName.text, secondName.text)
                if (userList.isNotEmpty()) {
                    userList.forEach {
                        if (user == (it)) {
                            toast1.show()
                        } else {
                            userList.add(user)
                        }
                    }
                }
                userList.add(user)
            } else {
                toast2.show()
            }
            showUser.setOnClickListener {
                val intent = Intent(this@MainActivity , ShowUser::class.java)
                 startActivity(intent)
            }
        }
        showUser.setOnClickListener {
            if (userList.isEmpty()) {
                toast3.show()
            }
        }
    }
}


