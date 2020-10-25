package com.app.sociollademo.model.api.verticalmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example() :Parcelable {
    @SerializedName("photos")
    @Expose
    var photos: Photos? = null

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

    companion object CREATOR : Parcelable.Creator<Example> {
        override fun createFromParcel(parcel: Parcel): Example {
            return Example(parcel)
        }

        override fun newArray(size: Int): Array<Example?> {
            return arrayOfNulls(size)
        }
    }
}