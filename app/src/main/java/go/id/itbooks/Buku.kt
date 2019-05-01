package go.id.itbooks

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Buku(

    @SerializedName("title")
    var title: String? = null,
    @SerializedName("subtitle")
    var subtitle: String? = null,
    @SerializedName("isbn13")
    var isbn13: String? = null,
    @SerializedName("price")
    var price: String? = null,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("authors")
    var authors: String? = null,
    @SerializedName("publisher")
    var publisher: String? = null,
    @SerializedName("language")
    var language: String? = null,
    @SerializedName("pages")
    var pages: String? = null,
    @SerializedName("year")
    var year: String? = null,
    @SerializedName("rating")
    var rating: String? = null,
    @SerializedName("desc")
    var desc: String? = null
):Serializable