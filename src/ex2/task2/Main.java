package ex2.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
	
    private static final int FAST_KRONE_TILLEGG = 10000;
    private static final int PROSENT_TILLEGG = 7;
    private static final int FAST_KRONE_TILLEGG_LAV_LONN = 25000;
    private static final int LAV_LONN = 400000;
    private static final int ER_MANN = 2420;
	
    public static void main(String[] args) {
    
    	
    	 List<Ansatt> ansatte = Arrays.asList(
                 new Ansatt("Roger", "Rogerson", Kjonn.MANN, "Regnskapsfører", 520_000),
                 new Ansatt("Olav", "Nilsen", Kjonn.MANN, "Jurist", 580_000),
                 new Ansatt("Hentriette", "Hansen", Kjonn.DAME, "Assistent", 420_000),
                 new Ansatt("Marit", "Knutsen", Kjonn.DAME, "Daglig leder", 600_000),
                 new Ansatt("Kurt", "Geilo",Kjonn.MANN, "Assisterende leder", 550_000)
                 );
    	 //1) Fast kronetillegg
    	 Function<Ansatt, Integer> fastKroneTillegg
         		= ansatt -> ansatt.getAarslonn()+ FAST_KRONE_TILLEGG;

         //2) Fast prosenttillegg
         Function<Ansatt , Integer> prosentTilegg
         		= ansatt -> (int) ansatt.getAarslonn() + ((ansatt.getAarslonn()/100) * PROSENT_TILLEGG);

         //3) Fast tillegg for ansatt med lav lønn
         Function<Ansatt , Integer> lav_lonn_kompansering
         		= ansatt -> ansatt.getAarslonn() <= LAV_LONN ? ansatt.getAarslonn()+ FAST_KRONE_TILLEGG_LAV_LONN : ansatt.getAarslonn();

         //4) Fast prosent tillegg for mann
         Function<Ansatt, Integer> lonnsokningForMenn
         		= ansatt -> ansatt.erMann() ? (int) (ansatt.getAarslonn() + ER_MANN) : ansatt.getAarslonn();



         System.out.println("før lønnsøkninger: " + "\n" + ansatte + "\n");
         lonnsoppgjor(ansatte, fastKroneTillegg);
         System.out.println("Etter fast krone tillegg: " + "\n" + ansatte + "\n");
         lonnsoppgjor(ansatte, prosentTilegg);
         System.out.println("Etter prosent tilegg: " + "\n" + ansatte + "\n");
         lonnsoppgjor(ansatte, lav_lonn_kompansering);
         System.out.println("Økning i lønn for ansatte med lav lønn: " + "\n" + ansatte + "\n");
         lonnsoppgjor(ansatte, lonnsokningForMenn);
         System.out.println("Økning i lønn for menn " + "\n" + ansatte + "\n");



    }
    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> lonn) {

    ansatte.forEach(ansatt -> ansatt.setAarslonn(lonn.apply(ansatt)));
    
    }
}
