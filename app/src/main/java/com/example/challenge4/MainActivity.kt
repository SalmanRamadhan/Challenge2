package com.example.challenge4



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.core.content.ContextCompat
import com.example.challenge4.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        var isPlay = false


        binding?.ivBatu?.setOnClickListener {
            if (!isPlay) {
                play(1)
                binding?.ivBatu?.setBackgroundResource(R.drawable.layout_bg)
                Log.d("User Input", "User menginputkan batu")
                isPlay = true
            }
        }
        binding?.ivKertas?.setOnClickListener {
            if (!isPlay) {
                play(2)
                binding?.ivKertas?.setBackgroundResource(R.drawable.layout_bg)
                Log.d("User Input", "User menginputkan kertas")
                isPlay = true
            }
        }
        binding?.ivGunting?.setOnClickListener {
            if (!isPlay) {
                play(3)
                binding?.ivGunting?.setBackgroundResource(R.drawable.layout_bg)
                Log.d("User Input", "User menginputkan gunting")
                isPlay = true
            }
        }
        binding?.ivRefresh?.setOnClickListener {
            isPlay = false
            reset()
        }
    }

    private fun play(input: Int) {

        val comSuit = Random.nextInt(1, 4)

        when (comSuit) {
            1 -> {
                binding?.ivBatuCom?.setBackgroundResource(R.drawable.layout_bg)
                Log.d("Computer Randomize", "Computer menggunakan batu")
            }
            2 ->{
                binding?.ivKertasCom?.setBackgroundResource(R.drawable.layout_bg)
                Log.d("Computer Randomize", "Computer menggunakan kertas")
            }
            3 ->{
                binding?.ivGuntingCom?.setBackgroundResource(R.drawable.layout_bg)
                Log.d("Computer Randomize", "Computer menggunakan gunting")
            }
        }
        when {
            input == 1 && comSuit == 3 -> {
                playerWon()
                Log.d("Result", "User menginput batu dan Computer merandom gunting, user menang")
            }
            input == 2 && comSuit == 1 -> {
                playerWon()
                Log.d("Result", "User menginput kertas dan Computer merandom batu, user menang")
            }
            input == 3 && comSuit == 2 -> {
                playerWon()
                Log.d("Result", "User menginput gunting dan Computer merandom kertas, user menang")
            }
            input == comSuit -> {
                binding?.tvResult?.apply {
                    text = getString(R.string.string_draw)
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    setBackgroundColor(ContextCompat.getColor(context, R.color.blue_result))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
                    Log.d("Result", "User input dan hasil dari Computer random adalah sama, Draw")
                }
            }
            else -> {
                binding?.tvResult?.apply {
                    text = getString(R.string.string_com_menang)
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    setBackgroundColor(ContextCompat.getColor(context, R.color.green_result))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                    Log.d("Result", "User tidak menang maupun draw, Com Menang")
                }
            }
        }

    }

    private fun playerWon() {
        binding?.tvResult?.apply {
            text = context.getString(R.string.string_pemain_1_menang)
            setTextColor(ContextCompat.getColor(context, R.color.white))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            setBackgroundColor(ContextCompat.getColor(context, R.color.green_result))
        }
    }

    private fun reset() {

        binding?.ivGunting?.setBackgroundResource(0)
        binding?.ivBatu?.setBackgroundResource(0)
        binding?.ivKertas?.setBackgroundResource(0)
        binding?.ivGuntingCom?.setBackgroundResource(0)
        binding?.ivBatuCom?.setBackgroundResource(0)
        binding?.ivKertasCom?.setBackgroundResource(0)

        binding?.tvResult?.apply {
            setText(R.string.string_vs)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 60f)
            setTextColor(ContextCompat.getColor(context, R.color.red_result))
            setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        }

    }

}