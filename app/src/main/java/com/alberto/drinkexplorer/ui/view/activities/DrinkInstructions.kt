package com.alberto.drinkexplorer.ui.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.alberto.drinkexplorer.databinding.ActivityDrinkInstructionsBinding
class DrinkInstructions : AppCompatActivity() {

    lateinit var binding : ActivityDrinkInstructionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDrinkInstructionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = 0

        var instructions = intent.extras?.getString("INSTRUCTIONS")

        val parts = instructions?.split(".") ?: emptyList()

        val instructionsSize = if (parts?.size == 1) 1 else parts?.size

        for (part in parts){
            part.trim()
        }

        binding.tvInstructionNumber.text = (i+1).toString()
        binding.tvInstructions.text = parts[i]

        if (instructionsSize <= 2){
            binding.btnInstructionsFwd.visibility = View.GONE
            binding.btnDone.isVisible = true
        }

        binding.btnInstructionsFwd.setOnClickListener {
            i++
            if (i < instructionsSize-1) {
                binding.tvInstructionNumber.text = (i + 1).toString()
                binding.tvInstructions.text = parts[i]
                if (i > 0){
                    binding.btnInstructionsBack.isVisible = true
                }
                if (i == instructionsSize - 2) {
                    binding.btnInstructionsFwd.visibility = View.GONE
                    binding.btnDone.isVisible = true
                }
            }
        }

        binding.btnInstructionsBack.setOnClickListener {
            i--
            if (i < 1){
                binding.btnInstructionsBack.visibility = View.GONE
            }
            if (i != instructionsSize - 2){
                binding.btnInstructionsFwd.isVisible = true
                binding.btnDone.visibility = View.GONE
            }
            binding.tvInstructionNumber.text = (i + 1).toString()
            binding.tvInstructions.text = parts[i]
        }

        binding.btnDone.setOnClickListener {
            finish()
        }

    }

}

