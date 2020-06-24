package com.example.livedatasimpletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        var count: LiveData<Int> = mainActivityViewModel.getResult()
        count.observe(this, Observer {
            Log.e("Test", it.toString())
            result.setText(it.toString())
        })


        val btn:Button = findViewById(R.id.button)
        btn.setOnClickListener{
            mainActivityViewModel.updateNumbers(
                numb1 = numb1.text.toString().toInt(),
                numb2 = numb2.text.toString().toInt())
        }
    }

}