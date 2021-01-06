package com.binitasimbu.assignment5.UserModel

import android.os.Parcel
import android.os.Parcelable

data class UserPost(
    val userId: String? =  null,
    val userName:String?= null,
    val userProfileImg: String? = null,
    val userPostImg: String? =  null,
    val postlikeImg: String? = null,
    val postcmntImg: String? = null,
    val postshareImg: String? = null,
    val threedotImg: String? = null,
): Parcelable {
    constructor(parcel: Parcel) : this(
        (parcel.readValue(Int::class.java.classLoader) as? Int).toString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(userId)
        parcel.writeString(userName)
        parcel.writeString(userProfileImg)
        parcel.writeString(userPostImg)
        parcel.writeString(postlikeImg)
        parcel.writeString(postcmntImg)
        parcel.writeString(postshareImg)
        parcel.writeString(threedotImg)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserPost> {
        override fun createFromParcel(parcel: Parcel): UserPost {
            return UserPost(parcel)
        }

        override fun newArray(size: Int): Array<UserPost?> {
            return arrayOfNulls(size)
        }
    }

}