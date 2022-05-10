import java.util.ArrayList;
import java.util.List;

public class Paczkomat {

    private String id;
    private String nazwa;
    private String adres;
    private List<Paczka> paczki =new ArrayList<>();


    public Paczkomat() {
    }

    public Paczkomat(String id, String nazwa, String adres) {
        this.id = id;
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public void aktualizujStanPaczk(Stan stan, String id){
        for(int i= 0; i<paczki.size(); i++){
            if(paczki.get(i).getId().equals(id)){
                paczki.get(i).setStan(stan);
            }
        }
    }

    public void dodajPaczke(Paczka paczka){
        paczki.add(paczka);
    }

    public void usunPaczke(String id){
        Paczka paczka = null;
        for(int i=0; i< paczki.size(); i++){
            if(paczki.get(i).getId().equals(id)){
                paczka = paczki.remove(i);
            }
        }
        if(paczka == null){
            System.out.println("Nie znaleziono paczki");
        }
    }

    public void wyswietlPaczki(){
        System.out.println(paczki);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public List<Paczka> getPaczki() {
        return paczki;
    }

    @Override
    public String toString() {
        return "Paczkomat{" +
                "id='" + id + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
