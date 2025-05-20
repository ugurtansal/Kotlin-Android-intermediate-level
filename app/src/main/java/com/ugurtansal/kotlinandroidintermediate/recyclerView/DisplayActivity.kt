package com.ugurtansal.kotlinandroidintermediate.recyclerView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ugurtansal.kotlinandroidintermediate.R
import com.ugurtansal.kotlinandroidintermediate.databinding.ActivityDisplayBinding

class DisplayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       // val dataFromAdapter=intent.getSerializableExtra("superhero", Superhero::class.java)  //For new versions

        val dataFromAdapter=intent.getSerializableExtra("superhero") as Superhero

        binding.imageView.setImageResource(dataFromAdapter.image)
        binding.tvName.text=dataFromAdapter.name
        binding.tvJob.text=dataFromAdapter.job

    }
}