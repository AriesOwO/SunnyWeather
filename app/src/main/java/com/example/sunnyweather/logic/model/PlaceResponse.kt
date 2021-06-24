package com.example.sunnyweather.logic.model


import com.google.gson.annotations.SerializedName

data class PlaceResponse(
    val status: String,
    val query: String,
    val places: List<Place>
) {
    data class Place(
        val id: String,
        val location: Location,
        @SerializedName("place_id")
        val placeId: String,
        val name: String,
        @SerializedName("formatted_address")
        val formattedAddress: String
    ) {
        data class Location(
            val lat: Double,
            val lng: Double
        )
    }
}