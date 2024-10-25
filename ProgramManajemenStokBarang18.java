import java.util.ArrayList;
import java.util.Scanner;

public class ProgramManajemenStokBarang18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> namaBarang = new ArrayList<>();
        ArrayList<Integer> stokBarang = new ArrayList<>();
        ArrayList<Double> hargaBarang = new ArrayList<>();

        String input;

        while (true) {
            System.out.print("Masukkan nama barang (atau ketik 'selesai' untuk berhenti): ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("selesai")) {
                break;
            } 
            namaBarang.add(input);

            System.out.print("Masukkan jumlah stok barang: ");
            int stok = sc.nextInt();
            stokBarang.add(stok);

            System.out.print("Masukkan harga per unit barang: ");
            double harga = sc.nextDouble();
            sc.nextLine();
            hargaBarang.add(harga);
            
        }
        
        while (true) {
            System.out.print("\nApakah Anda ingin melakukan penyesuaian stok? (ya/tidak): ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("tidak")) {
                break;
            }
            
            System.out.print("Masukkan nama barang yan ingin disesuaikan: ");
            String nama = sc.nextLine();
            int index = namaBarang.indexOf(nama);

            if (index != -1) {
                System.out.print("Masukkan jumlah permintaan barang: ");
                int permintaan = sc.nextInt();
                sc.nextLine();

                if (permintaan <= stokBarang.get(index)) {
                    System.out.println("Permintaan dapat dipenuhi. ");
                    stokBarang.set(index, stokBarang.get(index) - permintaan);
                } else {
                    System.out.println("Stok tidak mencukupi.");
                }
                
                System.out.println("Sisa stok barang '" + nama + "': " + stokBarang.get(index));
            } else {
                System.out.println("Barang tidak ditemukan.");
            }
       }

       System.out.println("\nInformasi Barang Toko: ");
       for (int i = 0; i < namaBarang.size(); i++) {
        double totalNilaiStok = stokBarang.get(i) * hargaBarang.get(i);
        System.out.println("Barang: " + namaBarang.get(i));
        System.out.println("Stok: " + stokBarang.get(i));
        System.out.println("Harga per unit: " + hargaBarang.get(i));
        System.out.println("Total nilai stok: " + totalNilaiStok);
        System.out.println("---------------------------");
       } 
    }
}