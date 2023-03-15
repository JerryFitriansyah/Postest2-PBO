import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    static InputStreamReader input = new InputStreamReader(System.in);
    static BufferedReader inputkan = new BufferedReader(input);
    static ArrayList<Box> data = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int pilih = 0;
        boolean ulang = true;
        while (ulang) {
            while (true){
                try{
                    Clearscreen();
                    System.out.println("|=======================|");
                    System.out.println("|Pendataan Box Pizza Hut|");
                    System.out.println("|=======================|");
                    System.out.println("|1. Tambah Data BOX     |");
                    System.out.println("|2. Lihat Data BOX      |");
                    System.out.println("|3. Ubah Data BOX       |");
                    System.out.println("|4. Hapus Data BOX      |");
                    System.out.println("|5. Keluar              |");
                    System.out.println("|=======================|");
                    System.out.print("Masukan inputan: ");
                    pilih = Integer.parseInt(inputkan.readLine());
                    break;
                }catch (Exception e) {
                    Clearscreen();
                    System.out.println("INPUTAN SALAH, ULANGI LAGI!!!");
                }
            }           
            switch (pilih) {
                case 1:
                    Clearscreen();
                    create();
                    break;
                case 2:
                    Clearscreen();
                    read();
                    break;
                case 3:
                    Clearscreen();
                    update();
                    break;
                case 4:
                    Clearscreen();
                    delete();
                    break;
                case 5:
                    Clearscreen();
                    ulang = false;
                    break;
        }

        }
    }

    public static void create() throws NumberFormatException, IOException{
        String nama, ukuran;
        int jumlah;
        Clearscreen();

        System.out.println("==========================================================");
        System.out.println("|                      Tambah Data BOX                   |");
        System.out.println("==========================================================");
        System.out.print(" Nama BOX           : "); nama = inputkan.readLine();
        System.out.print(" Ukuran BOX         : "); ukuran = inputkan.readLine();
        System.out.print(" Jumlah BOX         : "); jumlah = Integer.parseInt(inputkan.readLine());
        Box addBox = new Box(nama, ukuran, jumlah);
        data.add(addBox);
        System.out.println("               Pesanan Berhasil Ditambahkan               ");
        System.out.println("==========================================================");
        System.out.println("Tekan enter untuk melanjutkan"); inputkan.readLine();       
    }

    public static void read() throws IOException{
        int isiArray = data.size();
        if (isiArray == 0) {
            System.out.println(" Data Pesanan Masih Kosong ");
        } else{
            System.out.println("==========================================================");
            System.out.println("|                    Tampilan Data BOX                   |");
            System.out.println("==========================================================");
            for (int i = 0; i < isiArray; i++) {
                data.get(i).isDisplay();
            }
        }
        System.out.println("Tekan enter untuk melanjutkan"); inputkan.readLine();
    }

 public static void update() throws NumberFormatException, IOException{
        System.out.println("==========================================================");
        System.out.println("|                       Ubah Data BOX                    |");
        System.out.println("==========================================================");
        System.out.print("Masukan Nama BOX : "); String cariNama = inputkan.readLine();
        System.out.println("==========================================================");
        for (Box cariBox : data) {
            if (cariBox.getNama().equals(cariNama)) {
                System.out.println("==========================================================");
                System.out.println("| 1. Ubah Nama BOX                                       |");
                System.out.println("| 2. Ubah Ukuran BOX                                     |");
                System.out.println("| 3. Ubah Jumlah BOX                                     |");
                System.out.println("| 4. Kembali ke menu Sebelumnya                          |");
                System.out.println("==========================================================");
                System.out.print("Masukan Pilihan: "); int pilihan = Integer.parseInt(inputkan.readLine());
                switch (pilihan) {
                    case 1:
                        System.out.print("  Masukan Nama BOX Yang Baru : "); String newNama = inputkan.readLine();
                        cariBox.setNama(newNama);
                        System.out.println("\n  Nama Berhasil Diubah!");
                        System.out.println("\n  Tekan Enter untuk Kembali!");inputkan.readLine();
                        break;
                    case 2:
                        System.out.print("  Masukan Ukuran BOX Yang Baru : "); String newUkuran = inputkan.readLine();
                        cariBox.setUkuran(newUkuran);
                        System.out.println("\n  Ukuran Berhasil Diubah!");
                        System.out.println("\n  Tekan Enter untuk Kembali!");inputkan.readLine();
                        break;
                    case 3:
                        System.out.print("  Masukan Jumlah BOX Yang Baru : "); int newJumlah = Integer.parseInt(inputkan.readLine());
                        cariBox.setJumlah(newJumlah);
                        System.out.println("\n  Jumlah BOX Berhasil Diubah!");
                        System.out.println("\n  Tekan Enter untuk Kembali!");inputkan.readLine();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("  Inputan Tidak Tersedia ");
                        break;
                }
            }
        }

    }

    public static void delete() throws IOException{
        System.out.println("==========================================================");
        System.out.println("|                     Hapus Data BOX                     |");
        System.out.println("==========================================================");
        System.out.print("  Masukan Nama BOX : "); String cariNama = inputkan.readLine();
        System.out.println("==========================================================");
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getNama().equals(cariNama)) {
                data.remove(i);
                System.out.println("Data Telah Dihapus"); inputkan.readLine();
            }
    }
}

    public static void Clearscreen(){
        try{
            if(System.getProperty("os.name").contains("windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033\143");
            }
        }catch(Exception ex){
            System.err.println("Gagal Membersihkan");
        }
    }
}
