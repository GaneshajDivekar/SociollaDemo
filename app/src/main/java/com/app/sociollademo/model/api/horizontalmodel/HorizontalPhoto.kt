package com.app.sociollademo.model.api.horizontalmodel

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HorizontalPhoto() :Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("owner")
    @Expose
    var owner: String? = null

    @SerializedName("secret")
    @Expose
    var secret: String? = null

    @SerializedName("server")
    @Expose
    var server: String? = null

    @SerializedName("farm")
    @Expose
    var farm: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("ispublic")
    @Expose
    var ispublic: Int? = null

    @SerializedName("isfriend")
    @Expose
    var isfriend: Int? = null

    @SerializedName("isfamily")
    @Expose
    var isfamily: Int? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        owner = parcel.readString()
        secret = parcel.readString()
        server = parcel.readString()
        farm = parcel.readValue(Int::class.java.classLoader) as? Int
        title = parcel.readString()
        ispublic = parcel.readValue(Int::class.java.classLoader) as? Int
        isfriend = parcel.readValue(Int::class.java.classLoader) as? Int
        isfamily = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(owner)
        parcel.writeString(secret)
        parcel.writeString(server)
        parcel.writeValue(farm)
        parcel.writeString(title)
        parcel.writeValue(ispublic)
        parcel.writeValue(isfriend)
        parcel.writeValue(isfamily)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HorizontalPhoto> {
        override fun createFromParcel(parcel: Parcel): HorizontalPhoto {
            return HorizontalPhoto(parcel)
        }

        override fun newArray(size: Int): Array<HorizontalPhoto?> {
            return arrayOfNulls(size)
        }
    }
}