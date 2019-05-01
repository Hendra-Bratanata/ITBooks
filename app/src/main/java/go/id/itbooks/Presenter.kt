package go.id.itbooks

import com.google.gson.Gson
import go.id.kominfo.ApiRepository.ApiReposirtory
import go.id.kominfo.ApiRepository.PromoAPI
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class Presenter(val view : MainView ,val gson: Gson,val apiReposirtory: ApiReposirtory){
    fun getNewBuku(){
        doAsync {
            val data = gson.fromJson(apiReposirtory.doRequest(PromoAPI.getNewBook()),BukuResponse::class.java)

            uiThread {
                view.showData(data.books)
            }
        }
    }
    fun getBukuIsbn( isbn:String){
        doAsync {
            val data = gson.fromJson(apiReposirtory.doRequest(PromoAPI.getBookByIsbn(isbn)),Buku::class.java)

            uiThread {
                view.showDataBuku(data)
            }
        }
    }
}