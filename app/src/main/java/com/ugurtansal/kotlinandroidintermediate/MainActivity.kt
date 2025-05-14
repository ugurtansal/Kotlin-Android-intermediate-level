package com.ugurtansal.kotlinandroidintermediate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ugurtansal.kotlinandroidintermediate.databinding.ActivityMainBinding
import com.ugurtansal.kotlinandroidintermediate.databinding.FragmentLifeCycleBinding
import com.ugurtansal.kotlinandroidintermediate.lifecycle.SecondActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        println("onCreate called")
    }



        override fun onStart() {
            //Fragment görünür hale gelmeden önce çağrılır.Çok kısa bir süreliğine çalışır

            //Son uygulamalarda silmeden tekrar açma işlemi yapıldığında cycle buradan başlar
            super.onStart()
            println("onStart called")
        }

        override fun onResume() {
            //Fragment görünür hale geldiğinde çağrılır
            super.onResume()
            println("onResume called")
        }

        override fun onPause() {
            //Start gibidir onStopa hazırlık yapar

            super.onPause()
            println("onPause called")
        }

        override fun onStop() {
            //Fragment görünür olmaktan çıktığında çağrılır
            //Genelde veri kaydetme işlemleri burada yapılır
            //orta tuşla çıkma işlemi yapıldığında çağrılır(Son uygulamalarda görünür ,ramde çalışmaya devam eder)
            super.onStop()
            println("onStop called")
        }

        override fun onDestroy() {
            //Son uygulamalarda silince çalışır
            //Fragment yok olurken çağrılır

            super.onDestroy()
            println("onDestroy called")
        }

        fun nextPage(view: View){


//            val userInput=binding.editText.text.toString()
//            binding.textView.text="Name: $userInput"

            //Intent
            val intent= Intent(this, SecondActivity::class.java) //SecondActivity::class.java => SecondActivity'e referans veriyoruz
            startActivity(intent)
        }

    }
