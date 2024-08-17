package com.example.expandablelistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expandablelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),MyExpandAdapter.ExpandAction {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var map:HashMap<String,ArrayList<String>>
    lateinit var titelList:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        val adapter=MyExpandAdapter(titelList,map,this)
        binding.expand.setAdapter(adapter)
    }

    private fun loadData() {
        titelList= ArrayList()
        titelList.add("Mobiles")
        titelList.add("Laptops")
        titelList.add("Computers Accessories")
        titelList.add("TVs by brend")

        map= HashMap()
        map[titelList[0]]= arrayListOf("Mi","RealMe","Samsung","Infinix","Iphone","Honor")
        map[titelList[1]]= arrayListOf("Aser","Dell","Mac Bock","HP","Asus")
        map[titelList[2]]= arrayListOf("Pendrive","Bag","Mause","Keybord")
        map[titelList[3]]= arrayListOf("Samsung","Artel","LG")
    }

    override fun childClick(name: String) {
        val intent=Intent(this,MalumotActivity::class.java)
        startActivity(intent)
    }
}
