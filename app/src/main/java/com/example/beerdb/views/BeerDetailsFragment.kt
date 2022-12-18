package com.example.beerdb.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.navigation.fragment.navArgs
import com.example.beerdb.databinding.ActivityMainBinding.inflate
import com.example.beerdb.databinding.FragmentBeerDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeerDetailsFragment : Fragment() {

    private val args: BeerDetailsFragmentArgs by navArgs()

    private lateinit var binding : FragmentBeerDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBeerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //populate the view with arguments from navigation action
        populateView()
    }

    private fun populateView(){
        Picasso.get().load(args.beerImageUrl).into(binding.beerImageBeerFragment)
        binding.beerNameBeerFragment.text = args.beerName
        binding.beerDescriptionBeerFragment.text = args.beerDescription
    }
}