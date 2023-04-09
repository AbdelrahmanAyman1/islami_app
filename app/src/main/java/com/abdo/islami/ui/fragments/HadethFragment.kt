package com.abdo.islami.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.abdo.islami.R
import com.abdo.islami.constants.Constants
import com.abdo.islami.ui.fragments.adapter.Hadeth
import com.abdo.islami.ui.fragments.adapter.HadethNameAdapter
import com.abdo.islami.ui.main.hadethDetails.HadethDetailsActivity

class HadethFragment : Fragment() {
    val hadethNum = listOf(
        "حديث 1",
        "حديث 2",
        "حديث 3",
        "حديث 4",
        "حديث 5",
        "حديث 6",
        "حديث 7",
        "حديث 8",
        "حديث 9",
        "حديث 10",
        "حديث 11",
        "حديث 12",
        "حديث 13",
        "حديث 14",
        "حديث 15",
        "حديث 16",
        "حديث 17",
        "حديث 18",
        "حديث 19",
        "حديث 20",
        "حديث 21",
        "حديث 22",
        "حديث 23",
        "حديث 24",
        "حديث 25",
        "حديث 26",
        "حديث 27",
        "حديث 28",
        "حديث 29",
        "حديث 30",
        "حديث 31",
        "حديث 32",
        "حديث 33",
        "حديث 34",
        "حديث 35",
        "حديث 35",
        "حديث 36",
        "حديث 37",
        "حديث 38",
        "حديث 39",
        "حديث 40",
        "حديث 41",
        "حديث 42",
        "حديث 43",
        "حديث 44",
        "حديث 45",
        "حديث 46",
        "حديث 47",
        "حديث 49",
        "حديث 50"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadethNameAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = requireView().findViewById(R.id.hadeth_num_recyclerview)
        adapter = HadethNameAdapter(getHadethList())
        adapter.onItemClickListener = object : HadethNameAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, item: Hadeth) {
                showHadethDetalis(position, item)
            }
        }
        recyclerView.adapter = adapter

    }

    private fun showHadethDetalis(position: Int, hadeth: Hadeth) {
        val intent = Intent(requireContext(), HadethDetailsActivity()::class.java)
        intent.putExtra(Constants.EXTRA_HADETH_NAME, hadeth.name)
        intent.putExtra(Constants.EXTRA_HADETH_POS, position)
        startActivity(intent)
    }

    private fun getHadethList(): List<Hadeth> {
        val hadethList = hadethNum.map {
            return@map Hadeth(name = it)
        }
        return hadethList
    }
}