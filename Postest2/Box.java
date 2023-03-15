public class Box {
    private String nama, ukuran;
    private int jumlah;

    public Box(String Nama, String Ukuran, int Jumlah){
        this.nama = Nama;
        this.ukuran = Ukuran;
        this.jumlah = Jumlah;
    }

    public void isDisplay(){
        System.out.println("==========================================================");
        System.out.println("Nama BOX:"+ this.nama +"Box");
        System.out.println("Ukuran BOX:"+ this.ukuran);
        System.out.println("Jumlah BOX:"+ this.jumlah +"Pack");
        System.out.println("==========================================================");
    }

    public String getNama(){
        return nama ;
    }

    public String getUkuran(){
        return ukuran ;
    }

    public Integer getJumlah(){
        return jumlah ;
    }

    public void setNama(String Nama){
        this.nama = Nama;
    }

    public void setUkuran(String Ukuran){
        this.ukuran = Ukuran;
    }

    public void setJumlah(int Jumlah){
        this.jumlah = Jumlah;
    }
}