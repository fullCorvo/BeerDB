package com.example.beerdb.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beerdb.adapters.BeerItemAdapter
import com.example.beerdb.databinding.FragmentHomeBinding
import com.example.beerdb.models.BeerModel
import com.example.beerdb.viewmodels.BeerListViewModel
import com.example.beerdb.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    // Initialize ViewBinding
    private lateinit var binding : FragmentHomeBinding

    // Instantiate ViewModel
    private val viewModel: BeerListViewModel by viewModels()

    // Initialize recyclerView
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.recyclerViewHomeFragment
        val searchView = binding.searchViewHomeFragment

        //Calling the observer
        observeAnyChange()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchBeers(query)
                view.hideKeyboard()         //after search is performed we hide the keyboard
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }


    private fun observeAnyChange() {
        viewModel.getBeers().observe(viewLifecycleOwner, Observer {

            //for any data change retrieve LiveData and populate recyclerView with it
            val beerList = viewModel.getBeers().value

            if (beerList != null) {
                populateView(beerList)
            }
        })
    }

    private fun searchBeers(query: String) {
        viewModel.searchBeers(query)
    }


    //Initializing recyclerView and adding data to it
    private fun populateView(beerList: List<BeerModel>) {

        val beerItemAdapter = BeerItemAdapter()
        beerItemAdapter.setBeerList(beerList)

        recyclerView.adapter = beerItemAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    //function to hide keyboard after search is performed
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}