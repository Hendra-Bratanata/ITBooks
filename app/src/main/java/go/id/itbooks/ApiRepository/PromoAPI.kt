package go.id.kominfo.ApiRepository

import android.util.Log
import go.id.itbooks.BuildConfig

object PromoAPI {
    fun getNewBook(): String {
        val Url = BuildConfig.BASE_URL + "new"
        Log.d("data", Url)
        return Url
    }
    fun getBookByIsbn(isbn: String): String {
        val Url = BuildConfig.BASE_URL + "books/$isbn"
        Log.d("data", Url)
        return Url
    }
}