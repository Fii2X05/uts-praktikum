import java.util.ArrayList;
import java.util.Scanner;

public class ProgramManajemenNilaiSiswa18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> nilaiSiswa = new ArrayList<>();
        ArrayList<String> namaSiswa = new ArrayList<>();

        String input;
        double totalNilai = 0;
        int jumlahSiswa = 0;

        while (true) {
            System.out.print("Masukkan nama siswa (atau ketik 'selesai' untuk berhenti): ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("selesai")) {
                break;
            }
            namaSiswa.add(input);

            System.out.print("Masukkan nilai siswa: ");
            double nilai = sc.nextDouble();
            sc.nextLine();  

            nilaiSiswa.add(nilai);
            totalNilai += nilai;
            jumlahSiswa++;
        }

        if (jumlahSiswa > 0) {
            double rataRata = totalNilai / jumlahSiswa;
            
            System.out.println("Rata-rata nilai kelas adalah : " + rataRata);

            int diAtasRatarata = 0, diBawahRatarata = 0;
            for (double nilai : nilaiSiswa) {
                if (nilai > rataRata) {
                    diAtasRatarata++;
                } else if (nilai < rataRata) {
                    diBawahRatarata++;
                }
            }

            System.out.println("Jumlah Mahasiswa diatas rata-rata adalah: " + diAtasRatarata);
            System.out.println("Jumlah Mahasiswa dibawah rata-rata adalah: " +diBawahRatarata);

            if (diAtasRatarata > (jumlahSiswa / 2)) {
                System.out.println("Mayoritas siswa memiliki nilai di atas rata-rata.");
            } else {
                System.out.println("Mayoritas siswa memiliki nilai di bawah rata-rata");
            }
        } else {
            System.out.println("Tidak ada data yang dimasukkan ");
        }
        
        sc.close();
     }
}