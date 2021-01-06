package com.binitasimbu.assignment5.UserModel


import android.os.Parcel
import android.os.Parcelable

data class UserStory(
    val id: String? =null,
    val name:String?=null,
    val userStoryImg:String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
        (parcel.readValue(Int::class.java.classLoader) as? Int).toString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(userStoryImg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserStory> {
        override fun createFromParcel(parcel: Parcel): UserStory {
            return UserStory(parcel)
        }

        override fun newArray(size: Int): Array<UserStory?> {
            return arrayOfNulls(size)
        }
    }
}