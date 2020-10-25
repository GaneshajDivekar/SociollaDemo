package com.app.sociollademo.model.api.horizontalmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HorizontalPhotos() :Parcelable {
    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("pages")
    @Expose
    var pages: Int? = null

    @SerializedName("perpage")
    @Expose
    var perpage: Int? = null

    @SerializedName("total")
    @Expose
    var total: String? = null

    @SerializedName("photo")
    @Expose
    var photo: List<HorizontalPhoto>? = null

    constructor(parcel: Parcel) : this() {
        page = parcel.readValue(Int::class.java.classLoader) as? Int
        pages = parcel.readValue(Int::class.java.classLoader) as? Int
        perpage = parcel.readValue(Int::class.java.classLoader) as? Int
        total = parcel.readString()
        photo = parcel.createTypedArrayList(HorizontalPhoto)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(page)
        parcel.writeValue(pages)
        parcel.writeValue(perpage)
        parcel.writeString(total)
        parcel.writeTypedList(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HorizontalPhotos> {
        override fun createFromParcel(parcel: Parcel): HorizontalPhotos {
            return HorizontalPhotos(parcel)
        }

        override fun newArray(size: Int): Array<HorizontalPhotos?> {
            return arrayOfNulls(size)
        }
    }
}