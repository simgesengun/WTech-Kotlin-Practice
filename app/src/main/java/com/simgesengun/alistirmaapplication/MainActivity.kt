package com.simgesengun.alistirmaapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar
import com.simgesengun.alistirmaapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Toast.makeText(applicationContext, "Merhaba", Toast.LENGTH_LONG).show()

        binding.buttonSnackbar.setOnClickListener {
            Snackbar.make(it, "Mesaj silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet"){
                        Snackbar.make(it,"Mesaj silindi",Snackbar.LENGTH_SHORT).show()
                    }.show()
        }
        binding.buttonAlert.setOnClickListener {
            val design = layoutInflater.inflate(R.layout.custom_alert, null)
            val imageView = design.findViewById<ImageView>(R.id.imageView)

            val ad = AlertDialog.Builder(it.context)
            ad.setMessage("Message")
            ad.setTitle("Title")
            ad.setView(design)
            ad.setPositiveButton("Positive"){ _, _ ->
                Toast.makeText(it.context,"Clicked Positive",Toast.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("Negative"){ _, _ ->
                Toast.makeText(it.context,"Clicked Negative",Toast.LENGTH_SHORT).show()
            }
            ad.setNeutralButton("Neutral"){ _, _ ->
                Toast.makeText(it.context,"Clicked Neutral",Toast.LENGTH_SHORT).show()
            }
            ad.create().show()
        }

        binding.buttonPopup.setOnClickListener {
            val popup = PopupMenu(it.context,it)

            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.action_edit -> {
                        Toast.makeText(it.context,"Clicked Edit",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_delete -> {
                        Toast.makeText(it.context,"Clicked Delete",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }

    }
}