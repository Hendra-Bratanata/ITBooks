package go.id.itbooks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import go.id.kominfo.ApiRepository.ApiReposirtory
import kotlinx.android.synthetic.main.activity_deatil.*
import kotlinx.android.synthetic.main.item.*

class DeatilActivity : AppCompatActivity(),MainView {
    override fun showDataBuku(buku: Buku) {

        Picasso.get().load(buku.image).into(imgViewDetail)
        tvJudulDetail.text = buku.title
        tvSubJudulDetail.text = buku.subtitle
        tvHargaDetail.text = buku.price
        tvISBNDetail.text = buku.isbn13
        tvDeskripsi.text = buku.desc    }

    override fun showData(listBuku: List<Buku>) {

    }

    lateinit var gson: Gson
    lateinit var apiReposirtory: ApiReposirtory
    lateinit var presenter: Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatil)
        val buku:Buku = intent.extras.getSerializable("data") as Buku
        gson = Gson()
        apiReposirtory = ApiReposirtory()
        presenter = Presenter(this,gson,apiReposirtory)

        presenter.getBukuIsbn(buku.isbn13!!)




    }
}
