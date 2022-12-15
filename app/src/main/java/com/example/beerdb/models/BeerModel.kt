package com.example.beerdb.models

import java.io.Serializable

data class BeerModel(
    val abv: Double,
    val attenuation_level: Double,
    val boil_volume: BoilVolume,
    val brewers_tips: String,
    val contributed_by: String,
    val description: String,
    val ebc: Double,
    val first_brewed: String,
    val food_pairing: List<String>,
    val ibu: Double,
    val id: Int,
    val image_url: String,
    val ingredients: Ingredients,
    val method: Method,
    val name: String,
    val ph: Double,
    val srm: Double,
    val tagline: String,
    val target_fg: Double,
    val target_og: Double,
    val volume: Volume
): Serializable {

    data class BoilVolume(
        val unit: String,
        val value: Int
    ) : Serializable

    data class Ingredients(
        val hops: List<Hops>,
        val malt: List<Malt>,
        val yeast: String
    ) : Serializable {

        data class Malt(
            val amount: Amount,
            val name: String
        ) : Serializable {

            data class Amount(
                val unit: String,
                val value: Double
            ) : Serializable
        }

        data class Hops(
            val name: String,
            val amount: Amount,
            val add: String,
            val attribute: String
        ) : Serializable {

            data class Amount(
                val unit: String,
                val value: Double
            ) : Serializable
        }
    }

    data class Method(
        val fermentation: Fermentation,
        val mash_temp: List<MashTemp>,
        val twist: Any
    ) : Serializable {
        data class Fermentation(
            val temp: Temp
        ) : Serializable {

            data class Temp(
                val unit: String,
                val value: Double
            ) : Serializable
        }

        data class MashTemp(
            val duration: Int,
            val temp: Temp
        ) : Serializable {

            data class Temp(
                val unit: String,
                val value: Int
            ) : Serializable
        }
    }

    data class Volume(
        val unit: String,
        val value: Int
    ) : Serializable
}
