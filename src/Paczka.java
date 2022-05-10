public class Paczka {

    private String id;
    private String idPaczkoamtuOdbiorcy;
    private String idPaczkoamtuNadawcy;
    private Rozmiar rozmiarPaczki;
    private Stan stan;

    public Paczka(String id, String idPaczkoamtuOdbiorcy, String idPaczkoamtuNadawcy, Rozmiar rozmiarPaczki, Stan stan) {
        this.id = id;
        this.idPaczkoamtuOdbiorcy = idPaczkoamtuOdbiorcy;
        this.idPaczkoamtuNadawcy = idPaczkoamtuNadawcy;
        this.rozmiarPaczki = rozmiarPaczki;
        this.stan = stan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPaczkoamtuOdbiorcy() {
        return idPaczkoamtuOdbiorcy;
    }

    public void setIdPaczkoamtuOdbiorcy(String idPaczkoamtuOdbiorcy) {
        this.idPaczkoamtuOdbiorcy = idPaczkoamtuOdbiorcy;
    }

    public String getIdPaczkoamtuNadawcy() {
        return idPaczkoamtuNadawcy;
    }

    public void setIdPaczkoamtuNadawcy(String idPaczkoamtuNadawcy) {
        this.idPaczkoamtuNadawcy = idPaczkoamtuNadawcy;
    }

    public Rozmiar getRozmiarPaczki() {
        return rozmiarPaczki;
    }

    public void setRozmiarPaczki(Rozmiar rozmiarPaczki) {
        this.rozmiarPaczki = rozmiarPaczki;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "id='" + id + '\'' +
                ", idPaczkoamtuOdbiorcy='" + idPaczkoamtuOdbiorcy + '\'' +
                ", idPaczkoamtuNadawcy='" + idPaczkoamtuNadawcy + '\'' +
                ", rozmiarPaczki=" + rozmiarPaczki +
                ", stan=" + stan +
                '}';
    }
}
