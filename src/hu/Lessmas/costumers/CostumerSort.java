package hu.Lessmas.costumers;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CostumerSort {
    private static FileReader fr=new FileReader();
    private static FileWriter fw=new FileWriter();
    private static SortType1 st1=new SortType1();
    private static SortType2 st2=new SortType2();
    private static SortType3 st3=new SortType3();
    private static List<Costumer> costumers=new ArrayList<>();
    private static String frstrow;


    public static void main(String[] args) throws Exception {
        File f2=new File("src/szamlanyitaas.csv");
        File f3=new File("src/penzosszegek.csv");
        File f1=new File("src/nevek.csv");
        BufferedReader br = null;
        br = new BufferedReader(new java.io.FileReader(new File("src/ugyfelek.csv")));
        frstrow = br.readLine();
        br.close();

        costumers=fr.ReadFile();
        Collections.sort(costumers);
        fw.WriteFile(costumers,f1,frstrow);
        Collections.sort(costumers,new CompareSzny());
        fw.WriteFile(costumers,f2,frstrow);
        Collections.sort(costumers,new CompareBal());
        fw.WriteFile(costumers,f3,frstrow);


    }
}
class FileReader {
    private String name,aname,szh,szla;
    private Date szd,szny;
    private int bal,dep;
    private ConvertDate e=new ConvertDate();
    public List<Costumer> ReadFile() throws Exception {
        List<Costumer> adatok = new ArrayList<>();
        String[] oneCostumer;
        BufferedReader br = null;
        br = new BufferedReader(new java.io.FileReader(new File("src/ugyfelek.csv")));
        String oneLine;
        oneLine = br.readLine();
        while ((oneLine = br.readLine()) != null) {
            oneCostumer = oneLine.split(",");
            name=oneCostumer[0];
            aname=oneCostumer[1];
            szd=e.s2D(oneCostumer[2]);
            szh=oneCostumer[3];
            szny=e.s2D(oneCostumer[4]);
            szla=oneCostumer[5];
            bal=Integer.parseInt(oneCostumer[6]);
            dep=Integer.parseInt(oneCostumer[7]);
            adatok.add(new Costumer(name,aname,szd,szh,szny,szla,bal,dep));
        }
        br.close();
        return adatok;
    }
}
class FileWriter{
    private String name,aname,szh,szla;
    private Date szd,szny;
    private int bal,dep;

    static void WriteFile(List<Costumer> adatok,File f,String frstrow) throws IOException {
        String[] oneLine;
        Costumer costumer;
        BufferedWriter bw = new BufferedWriter(
                new java.io.FileWriter(f,true));
        bw.write(frstrow);
        bw.newLine();
        Iterator<Costumer> it = adatok.iterator();
        while(it.hasNext()){
        costumer=it.next();
        SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
        String s=costumer.getName()+","+costumer.getAname()+","+form.format(costumer.getSzd())
                +","+costumer.getSzh()+","+form.format(costumer.getSzny())+","+costumer.getSzla()+","
                +costumer.getBal()+","+costumer.getDep();
        bw.write(s);
        bw.newLine();}
        bw.close();
    }

}

class SortType1{
    public List<String[]> rendez(List<String[]> adatok){
        List<String[]> adatok2=new ArrayList<>();
        return adatok2;
    }
}
class SortType2{
    public List<String[]> rendez(List<String[]> adatok){
        List<String[]> adatok2=new ArrayList<>();
        return adatok2;
    }
}
class SortType3{
    public List<String[]> rendez(List<String[]> adatok) {
        List<String[]> adatok2 = new ArrayList<>();
        return adatok2;
    }
}
class Costumer implements Comparable{
    private String name,aname,szh,szla;
    private Date szd,szny;
    private int bal,dep;
public Costumer(String name, String aname, Date szd,String szh,Date szny,String szla,int bal,int dep){
    this.name=name;
    this.aname=aname;
    this.szd=szd;
    this.szh=szh;
    this.szny=szny;
    this.szla=szla;
    this.bal=bal;
    this.dep=dep;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Costumer) {
            Costumer theOther = (Costumer) o;
            if (this.name == theOther.name) {
                return 0;
            } else {
                if (this.name.compareTo(theOther.name) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        else {return 0;}

    }

    public Date getSzny() {
        return szny;
    }

    public void setSzny(Date szny) {
        this.szny = szny;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getSzh() {
        return szh;
    }

    public void setSzh(String szh) {
        this.szh = szh;
    }

    public String getSzla() {
        return szla;
    }

    public void setSzla(String szla) {
        this.szla = szla;
    }

    public Date getSzd() {
        return szd;
    }

    public void setSzd(Date szd) {
        this.szd = szd;
    }
}
class ConvertDate{
    private Date datum;
    public Date s2D(String sdatum) throws Exception{
            SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
            try{datum=dt.parse(sdatum);}catch (ParseException e){};
            return datum;
    }
}
class CompareBal implements Comparator{
    public int compare(Object o1, Object o2) {
        Costumer p1 = (Costumer) o1;
        Costumer p2 = (Costumer) o2;
        return Integer.valueOf(p1.getBal() + p1.getDep()).compareTo(Integer.valueOf(p2.getBal() + p2.getDep()));
    }
}
class CompareSzny implements Comparator{
    public int compare(Object o1, Object o2) {
        Costumer p1 = (Costumer) o1;
        Costumer p2 = (Costumer) o2;
        return (p1.getSzny()).compareTo(p2.getSzny());
    }
}