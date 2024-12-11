import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Transaksi> transaksiList = new ArrayList<>(); //Penerapan collection menggunakan ArrayList


        boolean loginSuccess = false;
        while (!loginSuccess) {
            System.out.println("Log in");
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username: ");
            String username = scanner.nextLine();


            System.out.print("Password: ");
            String password = scanner.nextLine();


            System.out.print("Captcha (Masukkan CRIA3): ");
            String captcha = scanner.nextLine();


            if (username.equalsIgnoreCase("Fathhy") && password.equals("300305") && captcha.equals("CRIA3")) {
                System.out.println("Login berhasil!\n");
                loginSuccess = true;
            } else {
                System.out.println("Login gagal, silakan coba lagi.\n");
            }
        }


        System.out.println("+-----------------------------------------------------+");
        System.out.println("Selamat Datang di Supermarket Zhafira");


        Barang barang = new Barang("", "", 0.0);
        System.out.println("Tanggal dan Waktu: " + barang.getCurrentDateTime());
        System.out.println("+-----------------------------------------------------+");
        System.out.print("Masukkan Nama Kasir: ");
        String namaKasir = scanner.nextLine();


        try { //blok try
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();


            boolean tambahBarang = true;
            while (tambahBarang) {
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine();


                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine();


                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = scanner.nextDouble();


                System.out.print("Masukkan Jumlah Beli: ");
                int jumlahBeli = scanner.nextInt();
                scanner.nextLine(); // Clear buffer


                if (hargaBarang < 0 || jumlahBeli < 0) { //exception handling
                    throw new IllegalArgumentException("Harga atau jumlah beli tidak boleh negatif.");
                }


                Barang newBarang = new Barang(kodeBarang, namaBarang, hargaBarang);
                Transaksi transaksi = new Transaksi(newBarang, jumlahBeli);
                transaksiList.add(transaksi);


                System.out.print("Tambah barang lain? (y/n): ");
                String pilihan = scanner.nextLine();
                if (!pilihan.equalsIgnoreCase("y")) {
                    tambahBarang = false;
                }
            }


            System.out.println("+-----------------------------------------------------+");
            System.out.println("No. Faktur: " + noFaktur);


            double grandTotal = 0;
            for (Transaksi t : transaksiList) {
                t.displayTransaksi();
                grandTotal += t.total;
                System.out.println("+-----------------------------------------------------+");
            }


            System.out.println("Grand Total: " + grandTotal);
            System.out.println("Kasir: " + namaKasir);
            System.out.println("+-----------------------------------------------------+");


        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
