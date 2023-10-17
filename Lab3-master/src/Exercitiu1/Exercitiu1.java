package Exercitiu1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercitiu1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("lab3-master/src/Exercitiu1/in.txt"));
        List<Parabola> list = new ArrayList<Parabola>();
        int a = 0, b = 0, c = 0;

        while(scanner.hasNext()){
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            list.add(new Parabola(a, b, c));
        }

        for (Parabola p: list) {
            System.out.println(p.mij(a, b, c));
            Parabola.mjsd(p, new Parabola(a, b, c));
            System.out.println(p.segd(a, b, c));
            Parabola.segdv(p, new Parabola(a, b, c));
            System.out.println(p);
        }
    }
}