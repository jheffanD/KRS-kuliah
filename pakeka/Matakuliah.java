package pakeka;

public class Matakuliah {

    private String Kode;
    private String NamaMtk;
    private int sks;
    private double uts1, uts2, uas;

    public Matakuliah(String Kode, String NamaMtk, int sks, double uts1, double uts2, double uas) {
        this.Kode = Kode;
        this.NamaMtk = NamaMtk;
        this.sks = sks;
        this.uts1 = uts1;
        this.uts2 = uts2;
        this.uas = uas;
    }

    Matakuliah(String m001, String internet_of_Things, int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setKode(String Kode) {
        this.Kode = Kode;
    }

    public void setNamaMtk(String NamaMtk) {
        this.NamaMtk = NamaMtk;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public void setUts1(double uts1) {
        this.uts1 = uts1;
    }

    public void setUts2(double uts2) {
        this.uts2 = uts2;
    }

    public void setUas(double uas) {
        this.uas = uas;
    }

    public String getKode() {
        return Kode;
    }

    public String getNamaMtk() {
        return NamaMtk;
    }

    public int getSks() {
        return sks;
    }

    public double getUts1() {
        return uts1;
    }

    public double getUts2() {
        return uts2;
    }

    public double getUas() {
        return uas;
    }

    public double getFinal() {
        return 0.3 * uts1 + 0.3 * uts2 + 0.4 * uas;
    }

    public char getNilHuruf(double nilFinal) {
        char huruf;
        if (nilFinal >= 80) {
            huruf = 'A';
        } else if (nilFinal >= 65) {
            huruf = 'B';
        } else if (nilFinal >= 55) {
            huruf = 'C';
        } else if (nilFinal > 45) {
            huruf = 'D';
        } else {
            huruf = 'E';
        }
        return huruf;
    }
}
