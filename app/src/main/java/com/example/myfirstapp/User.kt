package com.example.myfirstapp

import android.text.Editable


data class User(var age: Editable, var FirstName: Editable, var SecondName: Editable)
{
   override fun toString(): String {
      return "age of person is $age," +
              " First name of person is $FirstName," +
              " Second name of person is $SecondName "
   }
}


