package com.example.wayangindonesia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val dataWayang = intent.getParcelableExtra<Wayang>("key_wayang") as Wayang

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvNamaNegara: TextView = findViewById(R.id.Edt_Nama_Negara)
        val tvPeriodeMenjabat: TextView = findViewById(R.id.Edt_Periode_Menjabat)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        tvDetailName.text = dataWayang.name
        tvNamaNegara.text = dataWayang.country
        tvPeriodeMenjabat.text = dataWayang.periode
        tvDetailDescription.text = dataWayang.description
        ivDetailPhoto.setImageResource(dataWayang.photo)

        val backToHome: ImageView = findViewById(R.id.back)
        backToHome.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when (v?.id){
            R.id.back -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}