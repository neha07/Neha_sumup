package com.sumup.challenge.toastcatalog.ui.items

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sumup.challenge.toastcatalog.R

class ItemsActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemViewModel
    private lateinit var adapter: ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_items)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        // Setup adapter and recycler view
        adapter = ItemsAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Setup ViewModel
        viewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        // Observe data and submit to adapter
        viewModel.items.observe(this) { itemList ->
            Log.d("ItemsActivity", "Received item list: $itemList")
            adapter.submitList(itemList)
        }

        // Trigger data load
        viewModel.loadItems()
    }
}
