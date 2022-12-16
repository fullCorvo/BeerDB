package com.example.beerdb.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.beerdb.R
import com.example.beerdb.models.BeerModel
import com.example.beerdb.views.BeerDetailsNavigationListener
import com.example.beerdb.views.HomeFragmentDirections
import com.squareup.picasso.Picasso

class BeerItemAdapter(private val beerDetailsNavigationListener: BeerDetailsNavigationListener)  : RecyclerView.Adapter<BeerItemAdapter.ViewHolder>() {

    private var beersList : List<BeerModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beer_item, parent, false)
        return ViewHolder(view, beerDetailsNavigationListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count: ${beersList.size}")

        return holder.bind(beersList[position])
    }

    override fun getItemCount(): Int {
        return beersList.size
    }

    fun setBeerList(beersList : List<BeerModel>) {
        this.beersList = beersList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, private val beerDetailsNavigationListener: BeerDetailsNavigationListener) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView = itemView.findViewById(R.id.beerImageBeerItem)
        var beerName: TextView = itemView.findViewById(R.id.beerNameBeerItem)
        var tagline: TextView = itemView.findViewById(R.id.beerTaglineBeerItem)
        var abvValue: TextView = itemView.findViewById(R.id.abvValueTextViewBeerItem)
        // var starImage: ImageView = itemView.findViewById(R.id.starIconImageViewCardView)

        fun bind(beer: BeerModel) {
            Picasso.get().load(beer.image_url).into(imageView)
            beerName.text = beer.name
            tagline.text = beer.tagline
            abvValue.text = beer.abv.toString()

            itemView.setOnClickListener {

                beerDetailsNavigationListener.navigateToBeerDetails(beer)
            }

        /*
            //check if beer is in favourites list to show/hide star symbol
            val sharedPreferences = context.getSharedPreferences("myPreferences",
                Context.MODE_PRIVATE
            )

            if(sharedPreferences.contains("ID ${beer?.id}")){
                starImage.visibility = View.VISIBLE
            }

            else starImage.visibility = View.INVISIBLE

         */
        }
    }
}