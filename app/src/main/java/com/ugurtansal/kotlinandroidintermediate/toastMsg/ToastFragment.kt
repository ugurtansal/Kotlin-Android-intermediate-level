package com.ugurtansal.kotlinandroidintermediate.toastMsg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ugurtansal.kotlinandroidintermediate.R
import com.ugurtansal.kotlinandroidintermediate.databinding.FragmentToastBinding


class ToastFragment : Fragment() {
    private lateinit var binding: FragmentToastBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentToastBinding.inflate(inflater, container, false)


        Toast.makeText(requireContext(),"Welcome", Toast.LENGTH_LONG).show() //Fragment açıldığında toast mesajı gösterir
        //Burada fragment içerisinde çalıştığından dolayı requireContext() kullanıldı, bu sayede bağlı olduğu activitynin contextini alır
        //Eğer activityde olsaydı this kullanılırdı

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToast.setOnClickListener {
            Toast.makeText(requireContext(),"Button clicked", Toast.LENGTH_LONG).show() //Fragment içerisinde butona tıklandığında toast mesajı gösterir
        }
    }




}