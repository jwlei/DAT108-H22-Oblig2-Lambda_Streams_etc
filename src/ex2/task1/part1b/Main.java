package ex2.task1.part1b;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
    	

    	System.out.println(beregn(12, 13, (a, b) -> {
    		return a + b; // returnerer summen av a og b
    	}));
    	
    	System.out.println(beregn(-5, 3, (a, b) -> {
    		if (a < b) {
    			return b; // returnerer b om b er størst
    		} else {
    			return a; // returnere a om a er størst
    		}
    	}));

    	System.out.println(beregn(54, 45, (a, b) -> {
    		int avstand = a - b;
                //returnerer avstanden/differansen mellom a og b
                if (avstand < 0) {
                    return avstand * (-1);
                } else {
                    return avstand;
                }
            }));
        }

    	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> function) {

        return function.apply(a, b);
    
        }
    	
    }