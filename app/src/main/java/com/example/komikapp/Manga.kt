package com.example.komikapp

import android.os.Parcel
import android.os.Parcelable

data class Manga(
    var title: String? = "",
    var author: String? = "",
    var countView: String? = "",
    var chapter:String?="",
    var photo:Int=0,
    var genre:String?="",
    var score:String?="",
    var sinopsis:String?="",
    var release:String?=""
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(countView)
        parcel.writeString(chapter)
        parcel.writeInt(photo)
        parcel.writeString(genre)
        parcel.writeString(score)
        parcel.writeString(sinopsis)
        parcel.writeString(release)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Manga> {
        override fun createFromParcel(parcel: Parcel): Manga {
            return Manga(parcel)
        }

        override fun newArray(size: Int): Array<Manga?> {
            return arrayOfNulls(size)
        }
    }
}