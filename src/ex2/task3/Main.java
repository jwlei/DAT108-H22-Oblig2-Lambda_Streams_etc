package ex2.task3;

import ex2.task2.Ansatt;
import ex2.task2.Kjonn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        ex2.task2.Ansatt tom = new ex2.task2.Ansatt("Tom", "Hansen", ex2.task2.Kjonn.MANN, "Leder", 1_000_000);
        ex2.task2.Ansatt kari = new ex2.task2.Ansatt("Kari", "Nielsen", ex2.task2.Kjonn.DAME, "Selger", 450_000);
        ex2.task2.Ansatt ole = new ex2.task2.Ansatt("Ole", "Karlsen", ex2.task2.Kjonn.MANN, "Selger", 450_000);
        ex2.task2.Ansatt per = new ex2.task2.Ansatt("Per", "Crowo", ex2.task2.Kjonn.MANN, "FullStackUtvikler", 700_000);
        ex2.task2.Ansatt mona = new ex2.task2.Ansatt("Mona", "Aarsen", ex2.task2.Kjonn.DAME, "Markedsføring", 400_000);
        ex2.task2.Ansatt lise = new ex2.task2.Ansatt("Lise", "Aanstad", ex2.task2.Kjonn.MANN, "FrontEndUtvikler", 600_000);
        ex2.task2.Ansatt jurgen = new ex2.task2.Ansatt("Jurgen", "Hansen", Kjonn.DAME, "Markedsføring", 400_000);

        List<Ansatt> ansatte = Arrays.asList(tom, kari, ole, per, mona, lise, jurgen);

        //Todo i: fast kronetillegg,
        // ii: fast prosenttillegg,
        // iii: fast kronetillegg hvis du har lav lønn,
        // iv fast prosenttillegg hvis du er mann.


        // a)
        var etternavn = ansatte.stream().map(a -> a.getEtternavn()).toList();

        System.out.println(etternavn);

        // b)
        var antallKvinner = ansatte.stream().filter(a -> a.getKjonn().equals(Kjonn.DAME)).count();


        System.out.println(antallKvinner);

        // c)
        var gjennomsnitt = ansatte.stream().mapToInt(a -> a.getAarslonn()).reduce(0, (sum, a) -> (int) (sum + a / antallKvinner));
        System.out.println(gjennomsnitt);

        // d)
        // this mutates original array, so I'm canceling it out
//        ansatte.stream().filter(a -> a.getStilling().toUpperCase().contains("LEDER")).forEach(a -> a.setAarslonn((a.getAarslonn() * 7 / 100) + a.getAarslonn()));
//        System.out.println(ansatte);

        // e)
        var tjenerMerEnn800k = ansatte.stream().anyMatch(a -> a.getAarslonn() > 800_000);
        System.out.println(tjenerMerEnn800k);

        // f)
        // printing out list without a standard loop
//        ansatte.stream().forEach(a -> System.out.println(a));

        // g)

        // todo find a way to return multiple lowest salaries
        var lavestLonn = ansatte.stream().min((a, b) -> Integer.compare(a.getAarslonn(), b.getAarslonn())).get();

        System.out.println(lavestLonn);

        // h)

        // Creates a list from 1 -> 1000 and sum all numbers which can be divided with 3 and 5
        var tall = Stream.iterate(1, n -> n + 1).limit(1000).
                toList().stream().
                filter(x -> x % 3 == 0).
                filter(x -> x % 5 == 0).
                reduce(0, (sum, x) -> sum + x);

        System.out.println(tall);






    }
}
