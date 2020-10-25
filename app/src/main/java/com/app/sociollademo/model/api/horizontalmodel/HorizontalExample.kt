package com.app.sociollademo.model.api.horizontalmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HorizontalExample() :Parcelable{
    @SerializedName("photos")
    @Expose
    var photos: HorizontalPhotos? = null

    @SerializedName("stat")
    @Expose
    var stat: String? = null

    constructor(parcel: Parcel) : this() {
        stat = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(stat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HorizontalExample> {
        override fun createFromParcel(parcel: Parcel): HorizontalExample {
            return HorizontalExample(parcel)
        }

        override fun newArray(size: Int): Array<HorizontalExample?> {
            return arrayOfNulls(size)
        }
    }
}