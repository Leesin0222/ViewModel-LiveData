package com.yongjincompany.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yongjincompany.viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvTextView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBooleanText.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText() {
        binding.btnButton.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0

        }
    }
}