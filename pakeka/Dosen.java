package pakeka;
public class Dosen {
    private String Nip;
    private String Nama;
    private String Email;
    
    
    public Dosen(String Nip, String Nama, String Email){
        this.Nip = Nip; this.Nama = Nama; this.Email = Email;}
    
    public void setNip(String Nip) { this.Nip =Nip;}
    public void setNama(String Nama) { this.Nama = Nama;}
    public void setEmail(String Email){ this.Email = Email;}

    public String getNip() { return Nip;}
    public String getNama() { return Nama;}
    public String getEmail() { return Email;}
}