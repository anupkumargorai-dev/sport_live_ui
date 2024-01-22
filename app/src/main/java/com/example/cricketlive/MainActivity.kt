package com.example.cricketlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cricketlive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainAdapter.OnItemClick {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.base_color);

        binding.fixture.setOnClickListener {
            onCardClick(binding.fixture,binding.tvFixture)
        }

        binding.result.setOnClickListener {
            onCardClick(binding.result,binding.tvResult)
        }

        binding.viewAll.setOnClickListener {
           onCardClick(binding.viewAll,binding.tvViewAll)
        }


        initRv()
    }

    private fun onCardClick(clickedCard: CardView,tv : TextView) {
        // Reset all cards to black background
        resetCardBackground()

        // Change the background of the clicked card to white
        clickedCard.setCardBackgroundColor(ContextCompat.getColor(this,R.color.white))
        tv.setTextColor(ContextCompat.getColor(this,R.color.text_color))
    }

    private fun resetCardBackground() {
        binding.fixture.setCardBackgroundColor(ContextCompat.getColor(this,R.color.secondary_color))
        binding.result.setCardBackgroundColor(ContextCompat.getColor(this,R.color.secondary_color))
        binding.viewAll.setCardBackgroundColor(ContextCompat.getColor(this,R.color.secondary_color))
        binding.tvFixture.setTextColor(ContextCompat.getColor(this,R.color.white))
        binding.tvResult.setTextColor(ContextCompat.getColor(this,R.color.white))
        binding.tvViewAll.setTextColor(ContextCompat.getColor(this,R.color.white))
    }

    private fun initRv() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(this@MainActivity)
        }
    }

    override fun onItemClick() {
        startActivity(Intent(this@MainActivity,MainActivity2::class.java))
    }
}