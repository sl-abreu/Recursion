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
public class ManejadorArreglosGenericoRecursivo {
    
    //busquedas
    public static <T> int busqSecuencial(T[] arr, int n, T x){
        if(n>0){
            if(arr[n-1].equals(x))
                return n-1;
            return busqSecuencial(arr,n-1,x);
        }
        else
            return -1;
    }
    private static <T extends Comparable<T>> int busqBinaria(T[] arr, int ini, int fin, T x){
        int mitad=(ini+fin)/2;
        
        if(ini<=fin){
            if(x.equals(arr[mitad]))
                return mitad;
            else if(x.compareTo(arr[mitad])<0)
                return busqBinaria(arr,ini,mitad-1,x);
            return busqBinaria(arr,mitad+1,fin,x);
        }
        return -ini-1;
    }
    public static <T extends Comparable<T>> int busqBinaria(T[] arr, int n, T x) {
        return busqBinaria(arr,0,n-1,x);
    }
    
    //toString
    public static <T> String ArrayToString(T[] arr, int n){
        if(n>0){
            return ArrayToString(arr,n-1)+arr[n-1].toString()+"\t";
        }
        return "";
    }
    
    //comparaciones
    private static <T extends Comparable<T>> int mayor(T[] arr, int ini, int fin){
        if(ini==fin)
            return ini;
        else if(ini==fin-1){
            if(arr[ini].compareTo(arr[fin])>=0)
                return ini;
            return fin;
        }
        else{
            int may1,may2,mitad=(ini+fin)/2;
            
            may1=mayor(arr,ini,mitad);
            may2=mayor(arr,mitad+1,fin);
            if(arr[may1].compareTo(arr[may2])>=0)
                return may1;
            return may2;
        }
    }
    public static <T extends Comparable<T>> int mayor(T[] arr, int n){
        if(n>0)
            return mayor(arr,0,n-1);
        return -1;
    }
    
    //auxiliares
    private static <T> void swap(T[] arr,int ind1,int ind2) {
	T temp=arr[ind1];
        
	arr[ind1]=arr[ind2];
	arr[ind2]=temp;
    }
    
    //ordenamientos
    public static <T extends Comparable<T>> void seleccionDirectaDerIzq(T[] arr,int n) {
        if(n>1){
            int may=mayor(arr,n);
            
            swap(arr,may,n-1);
            seleccionDirectaDerIzq(arr,n-1);
        }
    }
    public static <T extends Comparable<T>> void seleccionDirectaIzqDer(T[] arr, int n){
        seleccionDirectaIzqDer(arr,n,0,1,arr[0],0);
    }
    private static <T extends Comparable<T>> void seleccionDirectaIzqDer(T[] arr, int n, int i, int j, T menor, int pos){
        if(i<n-1){
            if(j<n){
                if(arr[j].compareTo(menor)<0){
                    menor=arr[j];
                    pos=j;
                }
                seleccionDirectaIzqDer(arr,n,i,j+1,menor,pos);
            }
            else{
                arr[pos]=arr[i];
                arr[i]=menor;
                seleccionDirectaIzqDer(arr,n,i+1,i+2,arr[i+1],i+1);
            }
        }
    }
    public static <T extends Comparable<T>> void quickSort(T[] arr,int ini,int fin){
        int i=ini,j=fin;
        T pivot=arr[(ini+fin)/2];
            
        while(i<=j){
            while(pivot.compareTo(arr[i])>0)
                i++;
            while(pivot.compareTo(arr[j])<0)
                j--;
            if(i<=j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        if(ini<j)
            quickSort(arr,ini,j);
        if(i<fin)
            quickSort(arr,i,fin);
    }
    
    
    public static void main(String[] args) {
        Double[] arr={2.2,5.0,6.1,8.0,22.3,96.0};
        Double[] arr2={5.4,0.1,3.6,8.2,-8.4,-1.0,6.3};
        
        System.out.println(ArrayToString(arr,arr.length));
        //System.out.println(mayor(arr2,arr2.length));
    }
}
