package hu.Lessmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UGYFEL BEJELENTESE:
 * Egy adott honapban foglalasra ki kellene jelolnie bizonyos napokat.
 * A januari majdnem jo, ott csak az egyik van elcsuszva egy nappal.
 * De a februari mar harommal!
 * Az oktoberit meg sem neztem :(.
 *
 * Mikorra tudjatok javitani?
 */
public class DebugTask2 {
    public static void main(String[] args) {
        OsztalyteremFoglalas2020 foglalas = new OsztalyteremFoglalas2020();
        List<Integer> januariDatumok = foglalas.foglal(Honap.Januar, Arrays.asList(Nap.Hetfo, Nap.Szerda, Nap.Pentek));
        List<Integer> februariDatumok = foglalas.foglal(Honap.Februar, Arrays.asList(Nap.Szombat));
        List<Integer> oktoberiDatumok = foglalas.foglal(Honap.Oktober, Arrays.asList(Nap.Kedd, Nap.Csutortok));
        System.out.println("2020 JANUÁR: " + januariDatumok);
        System.out.println("2020 FEBRUÁR: " + februariDatumok);
        System.out.println("2020 OKTÓBER: " + oktoberiDatumok);
    }
}

class OsztalyteremFoglalas2020 {

    public List<Integer> foglal(Honap honap, List<Nap> napok) {
        if (honap == Honap.Szeptember||honap==Honap.December) {
            return osszegyujtK1(honap.getNapok(), napok);                           //kedd

        }
        if (honap == Honap.Januar||honap==Honap.Aprilis||honap==Honap.Julius) {
            return osszegyujtSze1(honap.getNapok(), napok);                         //szerda

        }
        if (honap == Honap.Oktober) {
            return osszegyujtCs1(honap.getNapok(), napok);                          //csütörtök

        }
        if (honap == Honap.Majus) {
            return osszegyujtP1(honap.getNapok(), napok);                          //péntek

        }
        if (honap == Honap.Februar||honap==Honap.Augusztus) {
            return osszegyujtSzo1(honap.getNapok(), napok);                        //szombat

        }
        if (honap == Honap.Marcius||honap==Honap.November) {
            return osszegyujtV1(honap.getNapok(), napok);                          //vasárnap

        }

        return osszegyujtH1(honap.getNapok(), napok);

    }


    private List<Integer> osszegyujtH1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Hetfo)) {
                    datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Kedd)) {
                    datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Szerda)) {
                    datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Csutortok)) {
                    datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Pentek)) {
                    datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Szombat)) {
                    datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Vasarnap)) {
                    datumok.add(i);
            }
        }
        return datumok;
    }

    private List<Integer> osszegyujtK1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Kedd)) {
                datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Szerda)) {
                datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Csutortok)) {
                datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Pentek)) {
                datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Szombat)) {
                datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Vasarnap)) {
                datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Hetfo)) {
                datumok.add(i);
            }
        }
        return datumok;
    }

    private List<Integer> osszegyujtSze1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Szerda)) {
                datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Csutortok)) {
                datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Pentek)) {
                datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Szombat)) {
                datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Vasarnap)) {
                datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Hetfo)) {
                datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Kedd)) {
                datumok.add(i);
            }
        }
        return datumok;
    }

    private List<Integer> osszegyujtCs1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Csutortok)) {
                datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Pentek)) {
                datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Szombat)) {
                datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Vasarnap)) {
                datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Hetfo)) {
                datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Kedd)) {
                datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Szerda)) {
                datumok.add(i);
            }
        }
        return datumok;
    }

    private List<Integer> osszegyujtP1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Pentek)) {
                datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Szombat)) {
                datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Vasarnap)) {
                datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Hetfo)) {
                datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Kedd)) {
                datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Szerda)) {
                datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Csutortok)) {
                datumok.add(i);
            }
        }
        return datumok;
    }

    private List<Integer> osszegyujtSzo1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Szombat)) {
                datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Vasarnap)) {
                datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Hetfo)) {
                datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Kedd)) {
                datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Szerda)) {
                datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Csutortok)) {
                datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Pentek)) {
                datumok.add(i);
            }
        }
        return datumok;
    }

    private List<Integer> osszegyujtV1(int max, List<Nap> napok) {
        List datumok = new ArrayList();
        for (int i=1; i<=max; i++) {
            if (i % 7 == 1 && napok.contains(Nap.Vasarnap)) {
                datumok.add(i);
            }
            if (i % 7 == 2 && napok.contains(Nap.Hetfo)) {
                datumok.add(i);
            }
            if (i % 7 == 3 && napok.contains(Nap.Kedd)) {
                datumok.add(i);
            }
            if (i % 7 == 4 && napok.contains(Nap.Szerda)) {
                datumok.add(i);
            }
            if (i % 7 == 5 && napok.contains(Nap.Csutortok)) {
                datumok.add(i);
            }
            if (i % 7 == 6 && napok.contains(Nap.Pentek)) {
                datumok.add(i);
            }
            if (i % 7 == 0 && napok.contains(Nap.Szombat)) {
                datumok.add(i);
            }
        }
        return datumok;
    }
}

enum Honap {
    Januar(31),
    Februar(29),
    Marcius(31),
    Aprilis(30),
    Majus(31),
    Junius(30),
    Julius(31),
    Augusztus(30),
    Szeptember(30),
    Oktober(30),
    November(31),
    December(31);

    private int napok;
    Honap(int napok) {
        this.napok = napok;
    }

    public int getNapok() {
        return napok;
    }
}

enum Nap {
    Hetfo, Kedd, Szerda, Csutortok, Pentek, Szombat, Vasarnap
}