package com.ugurtansal.kotlinandroidintermediate.recyclerView

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurtansal.kotlinandroidintermediate.R
import com.ugurtansal.kotlinandroidintermediate.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var superheroList: ArrayList<Superhero>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superMan= Superhero("Superman", "Journalist", R.drawable.superman)
        val batMan= Superhero("Batman", "Businessman", R.drawable.batman)
        val ironMan= Superhero("Ironman", "Businessman", R.drawable.ironman)
        val aquaman= Superhero("Aquaman", "King", R.drawable.aquaman)

        superheroList=arrayListOf(superMan,batMan,ironMan,aquaman);

        val adapter= SuperHeroAdapter(superheroList)
        binding.superHeroRv.layoutManager= LinearLayoutManager(this) //GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

        binding.superHeroRv.adapter=adapter



    }
}