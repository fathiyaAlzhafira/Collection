public class Transaksi {
    Barang barang;
    int jumlahBeli;
    double total;


    public Transaksi(Barang barang, int jumlahBeli) {
        this.barang = barang;
        this.jumlahBeli = jumlahBeli;
        this.total = barang.hargaBarang * jumlahBeli;
    }


    public void displayTransaksi() {
        barang.displayBarang();
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }
}
