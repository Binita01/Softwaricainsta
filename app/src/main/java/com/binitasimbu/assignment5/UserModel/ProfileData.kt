package com.binitasimbu.assignment5.UserModel


import android.os.Parcel
import android.os.Parcelable

class ProfileData(
    val cuid:Int?=null,
    val fname:String?=null,
    val lname:String?=null,
    val uname:String?=null,
    val password:String?=null,
    val batch:String?=null,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(cuid)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(uname)
        parcel.writeString(password)
        parcel.writeString(batch)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProfileData> {
        override fun createFromParcel(parcel: Parcel):ProfileData {
            return ProfileData(parcel)
        }

        override fun newArray(size: Int): Array<ProfileData?> {
            return arrayOfNulls(size)
        }
    }

}