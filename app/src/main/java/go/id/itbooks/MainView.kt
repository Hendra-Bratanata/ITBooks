package go.id.itbooks

interface MainView {
    fun showData(listBuku: List<Buku>)
    fun showDataBuku(buku: Buku)
}