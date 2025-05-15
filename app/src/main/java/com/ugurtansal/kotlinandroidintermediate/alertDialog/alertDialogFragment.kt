package com.ugurtansal.kotlinandroidintermediate.alertDialog

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ugurtansal.kotlinandroidintermediate.R
import com.ugurtansal.kotlinandroidintermediate.databinding.FragmentAlertDialogBinding


class alertDialogFragment : Fragment() {
   private lateinit var binding: FragmentAlertDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAlertDialogBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAlert.setOnClickListener {
            val alert= AlertDialog.Builder(requireContext()); //requireActivity() de kullanılabilir
            alert.setTitle("Save Changes")
            alert.setMessage("Are you sure you want to save changes?")
            alert.setPositiveButton("Yes"){dialog, which->
                //positive butona tıklandığında yapılacak işlemler
                //örneğin veritabanına veri kaydetme işlemi
                Toast.makeText(requireContext(),"Saved",Toast.LENGTH_LONG).show()
            }
            alert.setNegativeButton ("No",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //negative butona tıklandığında yapılacak işlemler
                    //örneğin veritabanına veri kaydetme işlemi iptal edilebilir
                    Toast.makeText(requireContext(),"Not Saved",Toast.LENGTH_LONG).show()
                }
            })
            //Positive butonda yaptığımız ile negative butonda yaptığımız  fonksiyon aynıdır , iki şekilde de yazılabilir
            alert.setNeutralButton("Cancel",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    //neutral butona tıklandığında yapılacak işlemler
                    //örneğin veritabanına veri kaydetme işlemi iptal edilebilir
                    Toast.makeText(requireContext(),"Cancelled",Toast.LENGTH_LONG).show()
                }
            })
            alert.show()
        }
    }

}