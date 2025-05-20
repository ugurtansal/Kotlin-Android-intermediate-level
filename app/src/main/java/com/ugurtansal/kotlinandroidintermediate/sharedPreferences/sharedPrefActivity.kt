package com.ugurtansal.kotlinandroidintermediate.sharedPreferences

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ugurtansal.kotlinandroidintermediate.R
import com.ugurtansal.kotlinandroidintermediate.databinding.ActivitySharedPrefBinding

class sharedPrefActivity : AppCompatActivity() {
     lateinit var sharedPref: SharedPreferences
     private lateinit var binding: ActivitySharedPrefBinding
     var savedName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

         sharedPref=getSharedPreferences("com.ugurtansal.kotlinandroidintermediate", MODE_PRIVATE)
        //first parameter name of the shared preference, we usually use the package name , second parameter is the mode

        savedName=sharedPref.getString("name","") //second parameter is the default value

        if(savedName!=null && savedName!=""){
            binding.txtSavedName.text="Saved Name: $savedName"
        }
        else{
            binding.txtSavedName.text="Saved Name: "
        }

    }

    fun save(view: View){
        val userName=binding.nameTxt.text.toString();

        if(userName==""){
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
        }
        else{
            sharedPref.edit().putString("name",userName).apply() //name is the key , when we want to get the value we will use this key
            //apply is used to save the data in the shared preference
            binding.txtSavedName.text="Saved Name: $userName"
        }


    }


    fun delete(view: View){
        savedName=sharedPref.getString("name","")
        if(savedName!=null && savedName!=""){
            sharedPref.edit().remove("name").apply()
        }
        binding.txtSavedName.text="Saved Name: "

    }
}