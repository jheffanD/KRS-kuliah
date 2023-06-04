package pakeka;
import java.util.Scanner;
public class MainKhs {
    public static void main(String[] args) {
        int MhsMax = 20, MtkMax = 10, DsnMax = 5;
        int MhsLastIndex;
        int MtkLastIndex;
        int DsnLastIndex;

        Mahasiswa[] myMhs;
        myMhs = new Mahasiswa[MhsMax];

        Matakuliah[] ListMtk;
        ListMtk = new Matakuliah[MtkMax];

        Dosen[] myDosen;
        myDosen = new Dosen[DsnMax];

        myMhs[0] = new Mahasiswa("001", "Joko Waluyo", "Surabaya");
        myMhs[1] = new Mahasiswa("003", "Bambang Santoso", "Klaten");
        myMhs[2] = new Mahasiswa("006", "Kartiniwati", "Rembang");
        myMhs[3] = new Mahasiswa("007", "Harto Sugriwo", "Pacitan");
        myMhs[4] = new Mahasiswa("009", "Sri Wahyuningtyas", "Banyuwangi");
        MhsLastIndex = 5;

        ListMtk[0] = new Matakuliah("M001", "Internet of Things", 3);
        ListMtk[1] = new Matakuliah("M004", "Artificial Intelligence", 3);
        ListMtk[2] = new Matakuliah("M007", "Expert System", 2);
        ListMtk[3] = new Matakuliah("M010", "Human Computer Interaction", 3);
        ListMtk[4] = new Matakuliah("M012", "Management Information Systems", 3);
        ListMtk[5] = new Matakuliah("M015", "The Future of IT", 4);
        MtkLastIndex = 6;

        myDosen[0] = new Dosen("P101", "Dr. Gatotkaca", "gatot@top.usd.id");
        myDosen[1] = new Dosen("P100", "Prof. Srikandi", "srikandi@good.usd.id");
        myDosen[2] = new Dosen("P105", "Dr. Kumbokarno", "kumbo@joss.usd.id");
        DsnLastIndex = 3;

        myMhs[0].setPembimbing(myDosen[0]);
        myMhs[1].setPembimbing(myDosen[2]);
        myMhs[2].setPembimbing(myDosen[1]);
        myMhs[3].setPembimbing(myDosen[2]);
        myMhs[4].setPembimbing(myDosen[1]);

        int pil = 8;
        Scanner tombol = new Scanner(System.in);

        do {
            showMenu();
            System.out.println("Pilihan Anda : ");
            pil = tombol.nextInt();
            switch (pil) {
                case 1:
                    showMhs(MhsLastIndex, myMhs);
                    break;
                case 2:
                    showMtk(MtkLastIndex, ListMtk);
                    break;
                case 3:
                    showKhs(MhsLastIndex, myMhs);
                    break;
                case 4:
                    Mahasiswa mhsKu = addMhs(DsnLastIndex, myDosen);
                    myMhs[MhsLastIndex] = mhsKu;
                    MhsLastIndex++;
                    break;
                case 5:
                    int idxHps = delMhs(MhsLastIndex, myMhs);
                    myMhs[idxHps] = myMhs[MhsLastIndex];
                    MhsLastIndex--;
                    break;
                case 6:
                    addKrs(MhsLastIndex, myMhs, MtkLastIndex, ListMtk);
                    break;
                case 7:
                    delKrs(MhsLastIndex, myMhs);
                    break;
                case 8:
                  //  urutMhs(MhsLastIndex, myMhs);
                    break;
                case 9:
                    addNilai(MhsLastIndex, myMhs);
                    break;
                case 10:
                    break;
            }
        } while (pil != 10);

    }

    static void showMenu() {
        System.out.println("======Daftar Menu KRS/KHS==========");
        System.out.println("1. Daftar Mahasiswa");
        System.out.println("2. Daftar Matakuliah");
        System.out.println("3. Daftar KRS/KHS");
        System.out.println("4. Tambah Mahasiswa");
        System.out.println("5. Hapus Mahasiswa");
        System.out.println("6. Tambah KRS/KHS");
        System.out.println("7. Hapus KRS/KHS");
        System.out.println("8. Urutkan Nama Mahasiswa");
        System.out.println("9. Tambah Nilai");
        System.out.println("10. Selesai");
    }

    static void showMtk(int indexMtk, Matakuliah[] Mtk) {
        System.out.printf("No.");
        System.out.printf("%2s", "Kode\t");
        System.out.printf("%-2s", "SKS");
        System.out.printf("%20s", "Nama Matakuliah");
        System.out.println(" ");
        for (int i = 0; i < indexMtk; i++) {
            System.out.printf("%s %5s %-1s %s", (i + 1), Mtk[i].getKode(), Mtk[i].getSks() + "\t", Mtk[i].getNamaMtk());
            System.out.println("");
        }
    }

    static void showMhs(int indexMhs, Mahasiswa[] myMhs) {
        System.out.println("No\tNIM\tNama\t\tKota\t\tDPA");

        for (int i = 0; i < indexMhs; i++) {
            System.out.printf((i + 1) + "\t" + myMhs[i].getNim() + "\t" + myMhs[i].getNama() + "\t" + myMhs[i].getKotaAsal() + "\t\t" + myMhs[i].getPembimbing().getNama() + "\n");
        }
    }

    static void showKhs(int indexMhs, Mahasiswa[] mhs) {
        Matakuliah[] myKhs;
        for (int i = 0; i < indexMhs; i++) {
            System.out.println((i + 1) + mhs[i].getNim() + mhs[i].getNama() + mhs[i].getKotaAsal());
            mhs[i].showKuliah();
        }
    }

    static Mahasiswa addMhs(int indexDsn, Dosen[] dsn) {
        Scanner tombol = new Scanner(System.in);
        System.out.print("Nim          :");
        String myNim = tombol.next();
        System.out.print("Nama         :");
        String myNama = tombol.next();
        System.out.println("Kota asal  :");
        String myKota = tombol.next();
        showDsn(indexDsn, dsn);
        System.out.println("Pilih Nonor urut dosen: ");
        int idxDsn = tombol.nextInt();
        Mahasiswa mhsku = new Mahasiswa(myNim, myNama, myKota);
        mhsku.setPembimbing(dsn[idxDsn]);

        return mhsku;
    }

    static void showDsn(int dsnIndex, Dosen[] dsn) {
        System.out.println(" No\tNIP\tNama");
        for (int i = 0; i < dsnIndex; i++) {
            System.out.println((i + 1) + "\t" + dsn[i].getNip() + "\t" + dsn[i].getNama());
        }
    }

    static int delMhs(int indMhs, Mahasiswa[] mhsKu) {
        showMhs(indMhs, mhsKu);
        System.out.println("Pilih nomor urut yang akan dihapus");
        Scanner tombol = new Scanner(System.in);
        int idxHps = tombol.nextInt();
        return idxHps;
    }

    private static void addKrs(int indMhs, Mahasiswa[] mhsKu, int indexMtk, Matakuliah[] Mtk) {
        System.out.println("Pilih mahasiswa pada daftar berikut:");
        showMhs(indMhs, mhsKu);
        System.out.println("Masukan nomor urut:");
        Scanner tombol = new Scanner(System.in);
        int idxAds = tombol.nextInt() - 1;
        System.out.println("Silakan masukan jumlah matakuliah (maks 5 matakuliah)");
        int jumMK = tombol.nextInt();
        int i = 0;
        showMtk(indexMtk, Mtk);
        while (i < jumMK) {
            System.out.print("Masukkan Nomor Matakuliah yang dipilih: ");
            tombol = new Scanner(System.in);
            int mk = tombol.nextInt();
            mhsKu[idxAds].addKuliah(Mtk[mk - 1]);
            i++;
        }
        System.out.println("Daftar mata kuliah yang diambil oleh " + mhsKu[idxAds].getNim());
        mhsKu[idxAds].showKuliah();
    }

    private static void delKrs(int indMhs, Mahasiswa[] mhsKu) {
        System.out.println("Pilih mahasiswa pada daftar berikut:");
        showMhs(indMhs, mhsKu);
        System.out.println("Masukan nomor urut:");
        Scanner tombol = new Scanner(System.in);
        int idxAds = tombol.nextInt() - 1;

        mhsKu[idxAds].delKuliah();

    }

    private static void urutMhs(Mahasiswa[] mhsKu) {

        for (int i = 0; i < mhsKu.length; i++) {
            Matakuliah[] kuliah = new Matakuliah[mhsKu[i].getJumMtk()];
            Matakuliah[] kuliahUrut = new Matakuliah[mhsKu[i].getJumMtk()];
            double terbesar = 0;
            
            for (int j = 0; j < mhsKu[i].getJumMtk(); j++) {
                if (kuliah[j].getFinal() > terbesar) {
                    terbesar = kuliah[j].getFinal();
                }
            }

        }

    }

    private static void addNilai(int indMhs, Mahasiswa[] mhsKu) {
        System.out.println("Pilih mahasiswa pada daftar berikut:");
        showMhs(indMhs, mhsKu);
        System.out.println("Masukan nomor urut:");
        Scanner tombol = new Scanner(System.in);
        int idxAds = tombol.nextInt() - 1;

        Matakuliah[] Kuliah = mhsKu[idxAds].getKuliah();
        System.out.println("Daftar matakuliah yang diambil:");
        mhsKu[idxAds].showKuliah();

        int i = 0;

        while (i < mhsKu[idxAds].getJumMtk()) {
            System.out.println("input nilai untuk matakuliah " + Kuliah[i].getNamaMtk());
            System.out.println("UTS1");
            double uts1 = tombol.nextInt();
            System.out.println("UTS2");
            double uts2 = tombol.nextInt();
            System.out.println("UAS");
            double uas = tombol.nextInt();

            Kuliah[i].setUas(uas);
            Kuliah[i].setUts1(uts1);
            Kuliah[i].setUts2(uts2);

            i++;
        }
        System.out.println("Nilai yang diinput: ");
        mhsKu[idxAds].showKuliahLengkap();
    }

}