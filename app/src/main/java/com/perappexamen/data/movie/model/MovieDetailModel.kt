package com.perappexamen.data.movie.model

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class MovieDetailModel() : Parcelable{

    @JsonProperty
    var title: String = ""

    @JsonProperty
    var description: String = ""

    @JsonProperty
    var img: String = ""

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()!!
        description = parcel.readString()!!
        img = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieDetailModel> {
        override fun createFromParcel(parcel: Parcel): MovieDetailModel {
            return MovieDetailModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieDetailModel?> {
            return arrayOfNulls(size)
        }
    }

}