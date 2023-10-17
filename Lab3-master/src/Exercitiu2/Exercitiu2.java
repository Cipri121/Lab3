package Exercitiu2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Exercitiu2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("Lab3-master/src/Exercitiu2/produse.csv"));
        Scanner reader = new Scanner(System.in);
        PrintStream print = new PrintStream("iesire.txt");
        List<Produs> produse=new ArrayList<Produs>();
        int opt, i = 0, an, luna, zi;
        String denumire, linie;
        float pret = 0;
        int cantitate;
        LocalDate data_exp = LocalDate.now();
            while (scanner.hasNext()) {
                linie = scanner.next();
                String[] cuv = linie.split(",");
                denumire = cuv[0];
                pret = Float.parseFloat(cuv[1]);
                cantitate = Integer.parseInt(cuv[2]);
                data_exp = LocalDate.parse(cuv[3]);
                produse.add(new Produs(denumire, pret, cantitate, data_exp));
            }
        do{
            System.out.println("Meniu:");
            System.out.println("0 - Iesire");
            System.out.println("1 - afișarea tuturor produselor din colecția List\n" +
                    "2 - afișarea produselor expirate\n" +
                    "3 - vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.\n" +
                    "4 - afișarea produselor cu prețul minim (pot fi mai multe cu același preț)\n" +
                    "5 - salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură într-un fișier de ieșire. ");
            System.out.println("Alegeti optiunea: ");
            opt = reader.nextInt();
            if(opt == 0)
                break;
            switch (opt){
                case 1:
                    for(i = 0; i < produse.size(); i++){
                        System.out.println(produse.get(i));
                    }
                    break;
                case 2:
                    i = 0;
                    for (Produs p:produse) {
                        if(LocalDate.now().isAfter(p.getDataExp())){
                            System.out.println(p.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Alegeti produsul pe care doriti sa il vindeti: ");
                    denumire = reader.next();
                    for (i = 0 ; i < produse.size() ; i++) {
                        if(produse.get(i).getDenumire().equals(denumire)) {
                            do {
                                System.out.print("Dati cantitatea: ");
                                cantitate = reader.nextInt();
                            }while(!(cantitate <= produse.get(i).getCantitate()));
                            produse.set(i, new Produs(denumire, pret, produse.get(i).modificareCantitate(cantitate), data_exp));
                            for (i = 0 ; i < produse.size() ; i++) {
                                if(produse.get(i).getCantitate() == 0)
                                    produse.remove(i);
                            }
                            for (Produs pr : produse) {
                                System.out.println(pr);
                            }
                        }
                    }
                    break;
                case 4:
                    float min = produse.get(0).getPret();
                    for (Produs prod:produse) {
                        if(prod.getPret() < min){
                            min = prod.getPret();
                        }
                    }
                    for (Produs prod:produse) {
                        if(prod.getPret() == min){
                            System.out.println(prod);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Da-ti cantitatea: ");
                    cantitate = reader.nextInt();
                    for (Produs produs:produse) {
                        if(produs.getCantitate() < cantitate)
                            print.println(produs);
                    }
                    break;
                default:
                    System.out.println("Optiune gresita!");
            }
        }while(true);

    }
}
