import java.text.SimpleDateFormat;
import java.util.Date;


public class Barang {
    String kodeBarang;
    String namaBarang;
    double hargaBarang;


    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }


    public void displayBarang() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: " + hargaBarang);
    }


    public String getCurrentDateTime() { //penggunaan metode String dan Date
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }
}
