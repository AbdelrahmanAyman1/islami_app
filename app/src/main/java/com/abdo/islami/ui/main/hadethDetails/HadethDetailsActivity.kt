package com.abdo.islami.ui.main.hadethDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.abdo.islami.R
import com.abdo.islami.constants.Constants


class HadethDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadethAdapter
    lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        recyclerView = findViewById(R.id.hadeth_verses)
        titleTextView = findViewById(R.id.title_of_hadeth)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        adapter = HadethAdapter()
        recyclerView.adapter = adapter
        val hadethName: String = intent.getStringExtra(Constants.EXTRA_HADETH_NAME)
                as String
        val ahadeth = intent.getIntExtra(Constants.EXTRA_HADETH_POS, -1)
        titleTextView.text = hadethName
        readHadethContent("${ahadeth + 115}.txt")

    }

    private fun readHadethContent(fileName: String) {
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val lines: List<String> = fileContent.split("\n")
        adapter.changeData(lines)
    }

    override fun onSupportNavigateUp():
            Boolean {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("هل تريد الخروج")
        builder.setPositiveButton("نعم") { dialog, which ->
            finish()
        }

        builder.setNegativeButton("لا") { dialog, which ->

            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()

        return true
    }
}