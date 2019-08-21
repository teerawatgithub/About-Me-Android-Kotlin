package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener{
            updateNickname(it)
        }
    }

    private fun addNickname(view: View) {
        val editText = binding.nicknameEdit
        val nicknameTextView = binding.nicknameText
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val doneButton = binding.doneButton
        doneButton.visibility = View.GONE


        //Hide KeyBoard after click done
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        val editText = binding.nicknameEdit
        val nicknameTextView = binding.nicknameText
        editText.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE

        val doneButton = binding.doneButton
        doneButton.visibility = View.VISIBLE

        editText.requestFocus()
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.showSoftInput(editText, 0)
    }
}
