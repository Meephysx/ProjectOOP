import java.util.Scanner;

public class appBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Jangan gunakan try-with-resources di sini

        System.out.println("=== Selamat Datang di Bank XYZ ===");
        System.out.println("Pilih jenis rekening:");
        System.out.println("1. Rekening Umum");
        System.out.println("2. Tabungan");
        System.out.println("3. Giro");
        System.out.print("Masukkan pilihan (1-3): ");

        try {
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Menangani newline setelah nextInt()

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Rekening: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo awal: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine(); // Menangani newline

                    Rekening rekening = new Rekening(nama, noRek, saldo);

                    System.out.print("Masukkan jumlah setor: ");
                    double setor = scanner.nextDouble();
                    scanner.nextLine();
                    rekening.setor(setor);

                    System.out.print("Masukkan jumlah tarik: ");
                    double tarik = scanner.nextDouble();
                    scanner.nextLine();
                    rekening.tarik(tarik);

                    rekening.tampilkanInfo();
                    break;

                case 2:
                    System.out.print("Masukkan Nama Pemilik: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Rekening: ");
                    noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo awal: ");
                    saldo = scanner.nextDouble();
                    System.out.print("Masukkan Bunga Tahunan (dalam persen): ");
                    double bungaTahunan = scanner.nextDouble();
                    scanner.nextLine();

                    Tabungan tabungan = new Tabungan(nama, noRek, saldo, bungaTahunan);

                    System.out.print("Masukkan jumlah setor: ");
                    setor = scanner.nextDouble();
                    scanner.nextLine();
                    tabungan.setor(setor);

                    System.out.print("Masukkan jumlah tarik: ");
                    tarik = scanner.nextDouble();
                    scanner.nextLine();
                    tabungan.tarik(tarik);

                    System.out.print("Masukkan periode (bulan) untuk hitung bunga: ");
                    int bulan = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Bunga yang didapat: " + tabungan.hitungBunga(bulan));

                    tabungan.tampilkanInfo();
                    break;

                case 3:
                    System.out.print("Masukkan Nama Pemilik: ");
                    nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Rekening: ");
                    noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo awal: ");
                    saldo = scanner.nextDouble();
                    System.out.print("Masukkan Limit Penarikan: ");
                    double limit = scanner.nextDouble();
                    scanner.nextLine();

                    Giro giro = new Giro(nama, noRek, saldo, limit);

                    System.out.print("Masukkan jumlah setor: ");
                    setor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Apakah setor ini dari transfer? (true/false): ");
                    boolean transfer = scanner.nextBoolean();
                    scanner.nextLine();

                    if (transfer) {
                        giro.setor(setor, true);
                    } else {
                        giro.setor(setor);
                    }

                    System.out.print("Masukkan jumlah tarik: ");
                    tarik = scanner.nextDouble();
                    scanner.nextLine();
                    giro.tarik(tarik);

                    giro.tampilkanInfo();
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close(); // Scanner tetap ditutup di finally untuk menghindari kebocoran resource
        }
    }
}
