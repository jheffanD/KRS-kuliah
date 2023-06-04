package pakeka;
import java.util.Scanner;

public class Mahasiswa {

    private String Nim, Nama, KotaAsal;
    private Dosen Pembimbing;
    private Matakuliah[] Kuliah = new Matakuliah[5];
    private int jumMtk = 0;

    public Mahasiswa(String Nim, String Nama, String KotaAsal) {
        this.Nim = Nim;
        this.Nama = Nama;
        this.KotaAsal = KotaAsal;
    }

    public void setNim(String Nim) {
        this.Nim = Nim;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public void setKotaAsal(String KotaAsal) {
        this.KotaAsal = KotaAsal;
    }

    public void setPembimbing(Dosen Pembimbing) {
        this.Pembimbing = Pembimbing;
    }

    public String getNim() {
        return Nim;
    }

    public String getNama() {
        return Nama;
    }

    public String getKotaAsal() {
        return KotaAsal;
    }

    public Dosen getPembimbing() {
        return Pembimbing;
    }

    public Matakuliah[] getKuliah() {
        return Kuliah;
    }

    public int getJumMtk() {
        return jumMtk;
    }

    public void addKuliah(Matakuliah mtk) {
        //Matakuliah mtk = getMatakuliah();
        Kuliah[jumMtk] = mtk;
        jumMtk++;
    }

    public void delKuliah() {
        showKuliah();
        Scanner tombol = new Scanner(System.in);
        System.out.print("Pilih nomor matakuliah yang dihapus :");
        int indexHps = tombol.nextInt() - 1;
        Kuliah[indexHps] = Kuliah[jumMtk - 1];
        jumMtk--;
    }

    public void showKuliah() {
        System.out.println("No.\tKode\tNama\t\tsks");
        for (int i = 0; i < jumMtk; i++) {
            System.out.println(i + 1 + "\t" + Kuliah[i].getKode() + "\t" + Kuliah[i].getNamaMtk() + "\t\t" + Kuliah[i].getSks());
        }
    }
    
    public void showKuliahLengkap() {
        System.out.println("No.\tKode\tuts1\tuts2\tsks");
        for (int i = 0; i < jumMtk; i++) {
            System.out.println(i + 1 + "\t" + Kuliah[i].getKode() + "\t" + Kuliah[i].getUts1()+ "\t" + Kuliah[i].getUts2()
                    +"\t"+Kuliah[i].getUas());
        }
    }
}
