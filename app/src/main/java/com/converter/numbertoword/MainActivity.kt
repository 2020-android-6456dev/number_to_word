package com.converter.numbertoword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.converter.utils.getDecimalFromString
import com.converter.utils.getNumberInWords

class MainActivity : AppCompatActivity() {

    var tvNumberInWords: TextView? = null
    var etNumberInput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        init()
        setUpListeners()
    }

    private fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setUpListeners() {
        etNumberInput?.addTextChangedListener(TextChangeListener())
    }

    private fun initViews() {
        tvNumberInWords = findViewById(R.id.tv_number_in_words)
        etNumberInput = findViewById(R.id.et_number_input)
    }

    inner class TextChangeListener : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s.isNullOrEmpty()) {
                tvNumberInWords?.text = getString(R.string.txt_label_number_in_words)
            } else {

                try {
                    val num = getDecimalFromString(s.toString())
                    tvNumberInWords?.text = getNumberInWords(num)
                } catch (e: IllegalArgumentException){
                    tvNumberInWords?.text = getString(R.string.txt_error_number_validation)
                }

            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
