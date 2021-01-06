package com.binitasimbu.assignment5.UserModel

import android.os.Parcel
import android.os.Parcelable

class AddPost (val name:String?=null,
    val postimg:String?=null,
    val profileimg:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(postimg)
        parcel.writeString(profileimg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddPost> {
        override fun createFromParcel(parcel: Parcel): AddPost {
            return AddPost(parcel)
        }

        override fun newArray(size: Int): Array<AddPost?> {
            return arrayOfNulls(size)
        }
    }
}