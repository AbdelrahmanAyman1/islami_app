package com.abdo.islami.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.abdo.islami.Constants
import com.abdo.islami.R
import com.abdo.islami.ui.main.suraDetails.VersesAdapter

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter
    lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        recyclerView = findViewById(R.id.quran_verses)
        titleTextView = findViewById(R.id.title_text_view)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
        val suraName: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
                as String
        val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POS, -1)
        titleTextView.text = suraName
        readSuraContent("${suraPos + 1}.txt")

    }

    fun readSuraContent(fileName: String) {
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val lines: List<String> = fileContent.split("\n")
        adapter.changeData(lines)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}