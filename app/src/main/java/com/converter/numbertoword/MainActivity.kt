package com.converter.numbertoword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.converter.convert.getNumberInWords

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNumberInWords(12)
    }
}
