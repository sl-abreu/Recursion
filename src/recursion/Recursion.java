/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author robot
 */
public class Recursion {

    //Ejemplos varios de recursión, no necesariamente la mejor solución
    public static long calcFactorial(int n){
        if(n==1 || n==0)    //Estado base
            return 1;
        else
            return n*calcFactorial(n-1);    //Estado recursivo, y la resta "n-1" es el acercamiento al estado base
    }
    public static long sumaArr(int[] arr,int ini,int fin){
        if(ini==fin-1)
            return arr[ini];
        else if(ini==fin-2)
            return arr[ini]+arr[ini+1];
        else{
            int mitad=(ini+fin)/2;
            return sumaArr(arr,ini,mitad)+sumaArr(arr,mitad,fin);
        }
    }
    public static int fibonacci(int n){
        switch (n) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 1;
            default:
                return fibonacci(n-1)+fibonacci(n-2);
        }
    }
    public static void imprimeArrIzqDer(int[] arr,int n){
        if(n>0){
            imprimeArrIzqDer(arr,n-1);
            System.out.print(arr[n-1]+" ");
        }
    }
    public static void imprimeArrDerIzq(int[] arr,int n){
        if(n>0){
            System.out.print(arr[n-1]+" ");
            imprimeArrDerIzq(arr,n-1);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr={5,7,1,8,3,4,10};
        System.out.println(sumaArr(arr,0,arr.length));
        imprimeArrIzqDer(arr,arr.length);
        System.out.println("");
        imprimeArrDerIzq(arr,arr.length);
    }
    
}
