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
public class ArreglosBidimensionales {

    public static int sumaRenglon(int[][] arr, int totCol, int ren) {
        int sum = 0;

        if (ren < arr.length && ren >= 0) {
            for (int i = 0; i < totCol; i++) {
                sum += arr[ren][i];
            }
        }
        return sum;
    }

    public static int sumaColumna(int[][] arr, int totRen, int col) {
        int sum = 0;

        if (col < arr[0].length && col >= 0) {
            for (int i = 0; i < totRen; i++) {
                sum += arr[i][col];
            }
        }
        return sum;
    }
    
    public static int[] mayorColumna(int[][] arr,int totRen,int totCol){
        int[] res=new int[totCol];
        int may;
        
        for(int i=0;i<totCol;i++){
            may=0;
            for(int j=1;j<totRen;j++){
                if(arr[j][i]>arr[may][i])
                    may=j;
            }
            res[i]=may;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] pru={{2,6,3,7},{6,2,9,4},{9,10,5,8}};
        int[] may;
        
        may=mayorColumna(pru,3,4);
        Recursion.imprimeArrIzqDer(may, may.length);
    }
}
