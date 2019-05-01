package go.id.itbooks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.google.gson.Gson
import go.id.kominfo.ApiRepository.ApiReposirtory
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(),MainView {
    override fun showDataBuku(buku: Buku) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showData(listBuku: List<Buku>) {
        listBukuBaru.clear()
        listBukuBaru.addAll(listBuku)
        adapterBuku.notifyDataSetChanged()
        rvList.adapter = adapterBuku

    }

    lateinit var gson: Gson
    lateinit var presenter: Presenter
    lateinit var apiReposirtory: ApiReposirtory
    lateinit var listBukuBaru: MutableList<Buku>
    lateinit var adapterBuku: AdapterBuku



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gson = Gson()
        apiReposirtory = ApiReposirtory()
        presenter = Presenter(this,gson,apiReposirtory)
        listBukuBaru = mutableListOf()
        adapterBuku = AdapterBuku(listBukuBaru,{
            startActivity<DeatilActivity>("data" to it)
        })




        rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvList.adapter =adapterBuku

        presenter.getNewBuku()





    }
}
