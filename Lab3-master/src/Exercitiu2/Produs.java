package Exercitiu2;

import java.time.LocalDate;

public class Produs {
    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_exp;
    private static int cant = 0;

    public Produs(String denumire, float pret, int cantitate, LocalDate data_exp){
        this.cantitate = cantitate;
        cant = cantitate;
        this.data_exp = data_exp;
        this.pret = pret;
        this.denumire = denumire;
    }

    public String toString() {
        return denumire + ", " + pret + ", " + cantitate + ", " + data_exp;
    }

    public LocalDate getDataExp(){
        return data_exp;
    }

    public String getDenumire(){
        return denumire;
    }
    public int modificareCantitate(int n){
        cant = cantitate - n;
        return cant;
    }
    public int getCantitate(){
        return cantitate;
    }

    public float getPret() {
        return pret;
    }
}
