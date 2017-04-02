/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamgenerator;

/**
 *
 * @author root
 */
public class Test {
    public static final int VAL = 6;
    
    public static void main(String[] args){
        long a = 9000000659L;
        long b = 2212345689L;
        System.out.println(Long.MAX_VALUE);
        
        
        long hasha = (long) ((20*a + 34) % Math.pow(2, 32));
        long hashb =  (long)((1234*b + 5678) % Math.pow(2, 32));
        System.out.println(hasha+" - "+hashb);
        System.out.println(Long.toBinaryString(hasha)+" - "+Long.toBinaryString(hashb));
        
        
        long hashc = (long) ((4545457*a + 32656897) % Math.pow(2, 128));
        long hashd =  (long)((6568974*b + 23658412) % Math.pow(2, 128));
        System.out.println(hashc+" - "+hashd);
        System.out.println(Long.toBinaryString(hashc)+" - "+Long.toBinaryString(hashd));
        //System.out.println(Long.toBinaryString(hasha));
        //System.out.println(Long.toBinaryString(hashb));
    }
    
}


