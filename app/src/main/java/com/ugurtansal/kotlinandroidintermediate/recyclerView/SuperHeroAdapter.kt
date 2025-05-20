package com.ugurtansal.kotlinandroidintermediate.recyclerView

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurtansal.kotlinandroidintermediate.databinding.ActivityRecyclerViewBinding
import com.ugurtansal.kotlinandroidintermediate.databinding.RecyclerRowBinding

class SuperHeroAdapter (val superheroList: ArrayList<Superhero>): RecyclerView.Adapter<SuperHeroAdapter.SuperheroViewHolder>(){

    inner class SuperheroViewHolder (val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperheroViewHolder {
        val binding= RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false) //Inflate is connecting xml file to class
        return SuperheroViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SuperheroViewHolder,
        position: Int
    ) {
       holder.binding.textViewRecyclerView.text=superheroList.get(position).name
        holder.binding.textViewRecyclerView.setOnClickListener {
            val intent= Intent(holder.itemView.context,DisplayActivity::class.java)
            intent.putExtra("superhero",superheroList.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return superheroList.size;
    }



}