package com.example.wayangindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Wayang>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListWayang())
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listWayangAdapter = ListWayangAdaptor(list)
        rvHeroes.adapter = listWayangAdapter
    }

    private fun getListWayang(): ArrayList<Wayang>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataCountry = resources.getStringArray(R.array.data_negara)
        val dataPeriod = resources.getStringArray(R.array.data_perode)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listWayang = ArrayList<Wayang>()
        for(i in dataName.indices){
            val Wayang = Wayang(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataCountry[i], dataPeriod[i])
            listWayang.add(Wayang)
        }
        return listWayang
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val intentAbout = Intent(this@MainActivity, about::class.java)
                startActivity(intentAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}