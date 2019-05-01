package go.id.itbooks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import java.util.zip.Inflater

class AdapterBuku(val listBuku : List<Buku>,val data:(Buku)->Unit) : RecyclerView.Adapter<AdapterBuku.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int = listBuku.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(listBuku[position],data)
    }

    class ViewHolder(v : View):RecyclerView.ViewHolder(v) {
        val img : ImageView = v.find(R.id.imgBuku)
        val judul : TextView = v.find(R.id.tvJudul)
        val subJudul : TextView = v.find(R.id.tvSubJudul)
        val isbn : TextView = v.find(R.id.tvISBN)
        val harga: TextView = v.find(R.id.tvHarga)
        fun bind(buku : Buku ,data: (Buku) -> Unit){

            Picasso.get().load(buku.image).into(img)
            judul.text = buku.title
            subJudul.text = buku.subtitle
            isbn.text = buku .isbn13
            harga.text = buku.price

            itemView.setOnClickListener {
                data(buku)
            }



        }

    }

}