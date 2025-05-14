package com.ugurtansal.kotlinandroidintermediate.lifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurtansal.kotlinandroidintermediate.R
import com.ugurtansal.kotlinandroidintermediate.databinding.FragmentLifeCycleBinding


class lifeCycleFragment : Fragment() {
    private lateinit var binding: FragmentLifeCycleBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentLifeCycleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        //View olusturulmadan önce çağrılır
        //Genelde veri hazırlama işlemleri burada yapılır
        super.onCreate(savedInstanceState)
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



}