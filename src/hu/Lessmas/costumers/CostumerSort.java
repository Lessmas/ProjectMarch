package hu.Lessmas.costumers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CostumerSort {
    private static FileReader fr=new FileReader();
    private static FileWriter fw=new FileWriter();
    private static SortType1 st1=new SortType1();
    private static SortType2 st2=new SortType2();
    private static SortType3 st3=new SortType3();
    private static List<String[]> costumers=new ArrayList<>();


    public static void main(String[] args) throws IOException {
        File f1=new File("src/szamlanyitaas.csv");
        File f3=new File("src/penzosszegek.csv");
        File f2=new File("src/nevek.csv");
        costumers=fr.ReadFile();
        costumers=st1.rendez(costumers);
        fw.WriteFile(costumers,f1);
        costumers=st2.rendez(costumers);
        fw.WriteFile(costumers,f2);
        costumers=st3.rendez(costumers);
        fw.WriteFile(costumers,f3);


    }
}
class FileReader {
    public List<String[]> ReadFile() throws IOException {
        List<String[]> adatok = new ArrayList<>();
        String[] oneCostumer;
        BufferedReader br = null;
        br = new BufferedReader(new java.io.FileReader(new File("src/ugyfelek.csv")));
        String oneLine;
        while ((oneLine = br.readLine()) != null) {
            oneCostumer = oneLine.split(",");
            adatok.add(oneCostumer);
        }
        br.close();
        return adatok;
    }
}
class FileWriter{

    static void WriteFile(List<String[]> adatok,File f) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new java.io.FileWriter(f,true));
        String s="";
        bw.write(s);
        bw.newLine();
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