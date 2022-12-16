package com.example.beerdb.views

import com.example.beerdb.models.BeerModel

interface BeerDetailsNavigationListener {

    fun navigateToBeerDetails(beer: BeerModel)
}