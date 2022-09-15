package ex2.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Ansatt tom = new Ansatt("Tom", "Hansen", Kjonn.MANN, "Leder", 1_000_000);
        Ansatt kari = new Ansatt("Kari", "Nielsen", Kjonn.DAME, "Selger", 450_000);
        Ansatt ole = new Ansatt("Ole", "Karlsen", Kjonn.MANN, "Selger", 450_000);
        Ansatt per = new Ansatt("Per", "Crowo", Kjonn.MANN, "FullStackUtvikler", 700_000);
        Ansatt mona = new Ansatt("Mona", "Aarsen", Kjonn.DAME, "Markedsføring", 400_000);
        Ansatt lise = new Ansatt("Lise", "Aanstad", Kjonn.MANN, "FrontEndUtvikler", 600_000);
        Ansatt jurgen = new Ansatt("Jurgen", "Hansen", Kjonn.DAME, "Markedsføring", 400_000);

        List<Ansatt> ansatte = Arrays.asList(tom, kari, ole, per, mona, lise, jurgen);

        //Todo i: fast kronetillegg,
        // ii: fast prosenttillegg,
        // iii: fast kronetillegg hvis du har lav lønn,
        // iv fast prosenttillegg hvis du er mann.


        // oppg i:
        Function<Ansatt, Integer> fastKroneTillegg = a -> {
            return a.getAarslonn() + 50_000;
        };

        // oppg ii:
        Function<Ansatt, Integer> fastProsentTillegg = a -> {
            return a.getAarslonn() + prosentTillegg(5, a.getAarslonn());
        };

        // oppg iii:
        Function<Ansatt, Integer> fastKroneLavLonn = a -> {
            return a.getAarslonn() <= 450_000 ? a.getAarslonn() + 50_000 : a.getAarslonn();
        };

        // oppg iiii:
        Function<Ansatt, Integer> hvisMann = a -> {
            return a.getKjonn().equals(Kjonn.MANN) ? a.getAarslonn() + prosentTillegg(5, a.getAarslonn()) : a.getAarslonn();
//            return a.getKjonn().compareTo(Kjonn.MANN) == 0 ? a.getAarslonn() + prosentTillegg(5, a.getAarslonn()) : a.getAarslonn();
        };


        // oppg i:
//        lonnsoppgjor(ansatte, fastKroneTillegg);

        // oppg ii:
//        lonnsoppgjor(ansatte, fastProsentTillegg);

        // oppg iii:
//        lonnsoppgjor(ansatte, fastKroneLavLonn );

        // oppg iiii:
        lonnsoppgjor(ansatte, hvisMann);

        System.out.println(ansatte);
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> func) {

        ansatte.forEach(ansatt -> {
            ansatt.setAarslonn(func.apply(ansatt));
        });
    }

    private static int prosentTillegg(int prosent, int lonn) {
        return lonn * prosent / 100;
    }

}
