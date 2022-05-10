import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ObslugaPaczkomatu {
    static Scanner scanner =  new Scanner(System.in);
    static List<Paczkomat> paczkomaty = new ArrayList<>();
/*
dodaniepaczkomatu
● usunięciepaczkomatu
● wyświetlaniewszystkichpaczkomatów
● wyświetlaniepaczkomatówwedługnazwymiasta ● aktualizacjapaczkomatu
● dodaniepaczki
● usuwaniepaczki
● wyświetlaniepaczekprzezpaczkomat
● aktualizacjaszczegółówpaczki
 */
    public static void main(String[] args) {
        int wybor;
        do{
            System.out.println("1 - dodaj paczkomat");
            System.out.println("2 - usun paczkomat");
            System.out.println("3 - wyswietl wszystkie paczkomaty");
            System.out.println("4 - wyswietl paczkomat wg miasta");
            System.out.println("5 - aktualizuj paczkomat");
            System.out.println("6 - usun paczke");
            System.out.println("7 - wyswietlenie paczek paczkomatu");
            System.out.println("8 - aktualizuj stan paczki");
            System.out.println("9 - dodaj paczke");
            System.out.println("0 - wyjdz z petli");
            wybor = scanner.nextInt();
            switch (wybor){
                case 1: dodajPaczkomat();
                break;
                case 2:
                    usunPaczkomat();
                    break;
                case 3: wyswietlPaczkomaty();
                break;
                case 4: wyswietlPaczkomatyWgMiasta();
                break;
                case 5: aktualizujPaczkomat();
                break;
                case 6: usunPaczke();
                break;
                case 7: wyswietlPaczkiDanegoPaczkomatu();
                break;
                case 8:aktualizujStanPaczki();
                break;
                case 9: dodajPaczke();
                }
            } while (true);
        }

    private static void aktualizujStanPaczki() {
        System.out.println("Podaj id paczkomatu ");
        String idPaczkomatu = scanner.next();
        System.out.println("Podaj ikd paczki ");
        String idPaczki = scanner.next();
        System.out.println("Podaj stan paczki ( NADANA,\n" +
                "    W_DRODZE,\n" +
                "    ODEBRANA)");
        Stan stan = Stan.valueOf(scanner.next());
        for(int i= 0; i< paczkomaty.size(); i++){
            if(paczkomaty.get(i).getId().equals(idPaczkomatu)){
                paczkomaty.get(i).aktualizujStanPaczk(stan, idPaczki);
            }
        }
    }

    public static void dodajPaczke(){
        System.out.println("Podaj id paczkomatu");
        String idPaczkomatu = scanner.next();
        System.out.println("Podaj id paczki ");
        String idPaczki = scanner.next();
        System.out.println("Podaj rozmiar paczki ");
        Rozmiar rozmiarPaczki = Rozmiar.valueOf(scanner.next());
        System.out.println("Paczkomat odbiorcy");
        String idPaczkomatuPOdbiorcy  =scanner.next();
        System.out.println("Paczkomat nadawcy ");
        String idPaczkomatuNadawcy = scanner.next();
        System.out.println("poda stan ");
        Stan stan = Stan.valueOf(scanner.next());
        for(int i=0; i<paczkomaty.size(); i++){
            if(paczkomaty.get(i).getId().equals(idPaczkomatu)){
                paczkomaty.get(i).dodajPaczke(new Paczka(idPaczki, idPaczkomatuPOdbiorcy, idPaczkomatuNadawcy, rozmiarPaczki, stan));
            }
        }
    }

    private static void usunPaczke() {
        System.out.println("Podaj id paczkomatu");
        String idPaczkomatu = scanner.next();
        System.out.println("podaj id paczki ");
        String idPaczki = scanner.next();

        for(int i=0; i< paczkomaty.size(); i++){
            if(paczkomaty.get(i).getId().equals(idPaczkomatu)){
                paczkomaty.get(i).usunPaczke(idPaczki);
            }
        }
    }

    static void dodajPaczkomat(){
        System.out.println("Podaj nazwe paczkomatu");
        String nazwa = scanner.next();
        System.out.println("Podaj id paczkomatu");
        String id = scanner.next();
        System.out.println("podaj adres paczkomatu");
        String adres = scanner.next();

        Paczkomat paczkomat = new Paczkomat(id, nazwa, adres);
        paczkomaty.add(paczkomat);
    }

    static void usunPaczkomat(){
        System.out.println("Podaj id paczkomatu ");
        String id = scanner.next();
        Paczkomat paczkomat = null;
        for(int i=0; i<paczkomaty.size(); i++){
            if(paczkomaty.get(i).getId().equals(id)){
                paczkomat = paczkomaty.remove(i);
            }
        }
        if(paczkomat == null){
            System.out.println("Nie znaleziono paczkomatu");
        }
    }

    static void wyswietlPaczkomaty(){
        System.out.println(paczkomaty);
    }

    static void wyswietlPaczkomatyWgMiasta(){
        System.out.println("Podaj miasto ");
        String miasto = scanner.next();
        List<Paczkomat> paczkWgMiasta = paczkomaty.stream()
                .filter(paczkomat -> paczkomat.getAdres().equals(miasto))
                .collect(Collectors.toList());
        System.out.println(paczkWgMiasta);
    }

    static void wyswietlPaczkiDanegoPaczkomatu(){
        System.out.println("Podaj id paczkomatu ");
        String id = scanner.next();
        List<Paczka> paczki = paczkomaty.stream().filter(paczkomat -> paczkomat.getId().equals(id))
                .map(paczkomat -> paczkomat.getPaczki()).flatMap(List::stream).collect(Collectors.toList());
        System.out.println(paczki);
    }


    static void aktualizujPaczkomat(){
        System.out.println("Podaj id paczkomatu ");
        String id = scanner.next();
        System.out.println("podaj nowa nazwe");
        String nazwa = scanner.next();
        System.out.println("Podaj adres ");
        String adres = scanner.next();
        for(int i=0; i<paczkomaty.size(); i++){
            if(paczkomaty.get(i).getId().equals(id)){
                paczkomaty.get(i).setAdres(adres);
                paczkomaty.get(i).setAdres(nazwa);
            }
        }
    }



}
