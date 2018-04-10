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
    public static <T> int busqSecuencial(T[] arr, int n, T x) {
        if (n > 0) {
            if (arr[n - 1].equals(x)) {
                return n - 1;
            }
            return busqSecuencial(arr, n - 1, x);
        } else {
            return -1;
        }
    }

    private static <T extends Comparable<T>> int busqBinaria(T[] arr, int ini, int fin, T x) {
        int mitad = (ini + fin) / 2;

        if (ini <= fin) {
            if (x.equals(arr[mitad])) {
                return mitad;
            } else if (x.compareTo(arr[mitad]) < 0) {
                return busqBinaria(arr, ini, mitad - 1, x);
            }
            return busqBinaria(arr, mitad + 1, fin, x);
        }
        return -ini - 1;
    }

    public static <T extends Comparable<T>> int busqBinaria(T[] arr, int n, T x) {
        return busqBinaria(arr, 0, n - 1, x);
    }

    //toString
    public static <T> String arrayToString(T[] arr, int n) {
        if (n > 0) {
            return arrayToString(arr, n - 1) + arr[n - 1].toString() + "\t";
        }
        return "";
    }

    //comparaciones
    private static <T extends Comparable<T>> int mayor(T[] arr, int ini, int fin) {
        if (ini == fin) {
            return ini;
        } else if (ini == fin - 1) {
            if (arr[ini].compareTo(arr[fin]) >= 0) {
                return ini;
            }
            return fin;
        } else {
            int may1, may2, mitad = (ini + fin) / 2;

            may1 = mayor(arr, ini, mitad);
            may2 = mayor(arr, mitad + 1, fin);
            if (arr[may1].compareTo(arr[may2]) >= 0) {
                return may1;
            }
            return may2;
        }
    }

    public static <T extends Comparable<T>> int mayor(T[] arr, int n) {
        if (n > 0) {
            return mayor(arr, 0, n - 1);
        }
        return -1;
    }

    //auxiliares no recursivos
    private static <T> void swap(T[] arr, int ind1, int ind2) {
        T temp = arr[ind1];

        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    //ordenamientos
    public static <T extends Comparable<T>> void seleccionDirectaDerIzq(T[] arr, int n) {
        if (n > 1) {
            int may = mayor(arr, n);

            swap(arr, may, n - 1);
            seleccionDirectaDerIzq(arr, n - 1);
        }
    }

    public static <T extends Comparable<T>> void seleccionDirectaIzqDer(T[] arr, int n) {
        seleccionDirectaIzqDer(arr, n, 0, 1, arr[0], 0);
    }

    private static <T extends Comparable<T>> void seleccionDirectaIzqDer(T[] arr, int n, int i, int j, T menor, int pos) {
        if (i < n - 1) {
            if (j < n) {
                if (arr[j].compareTo(menor) < 0) {
                    menor = arr[j];
                    pos = j;
                }
                seleccionDirectaIzqDer(arr, n, i, j + 1, menor, pos);
            } else {
                arr[pos] = arr[i];
                arr[i] = menor;
                seleccionDirectaIzqDer(arr, n, i + 1, i + 2, arr[i + 1], i + 1);
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int ini, int fin) {
        int i = ini, j = fin;
        T pivot = arr[(ini + fin) / 2];

        while (i <= j) {
            while (pivot.compareTo(arr[i]) > 0) {
                i++;
            }
            while (pivot.compareTo(arr[j]) < 0) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (ini < j) {
            quickSort(arr, ini, j);
        }
        if (i < fin) {
            quickSort(arr, i, fin);
        }
    }

    //arreglos bidimensionales (Problema 26)
    public static double sumaRenglon(Double[][] arr, int n, int ren) {
        if (n == 1) {
            return arr[ren][n - 1];
        } else if (n > 1) {
            return arr[ren][n - 1] + sumaRenglon(arr, n - 1, ren);
        }
        return -666;

    }

    public static double sumaColumna(Double[][] arr, int m, int col) {
        if (m == 1) {
            return arr[m - 1][col];
        } else if (m > 1) {
            return arr[m - 1][col] + sumaColumna(arr, m - 1, col);
        }
        return -666;
    }

    public static <T> String matrixToString(T[][] mat, int m, int n) {
        if (m == 1) {
            return arrayToString(mat[0], n);
        } else if (m > 1) {
            return matrixToString(mat, m - 1, n) + "\n" + arrayToString(mat[m - 1], n);
        }
        return null;
    }

    public static double sumaDiagPrincipal(Double[][] mat, int m, int n) {
        if (m == 1 && n == 1) {
            return mat[0][0];
        } else if (m > 0 && m <= n) {
            m--;
            return mat[m][m] + sumaDiagPrincipal(mat, m, m);
        } else if (n > 0 && m > n) {
            n--;
            return mat[n][n] + sumaDiagPrincipal(mat, n, n);
        }
        return 0;
    }

    public static Double[][] sumMatrix(Double[][] mat1, Double[][] mat2, int m1, int n1, int m2, int n2) {
        if(mat1!=null && mat2!=null && m1==m2 && n1==n2){
            Double[][] res=new Double[m1][n1];
            sumMatrix(mat1,mat2,m1,n1,res,0);
            return res;
        }
        return null;
    }
    private static void sumMatrix(Double[][] mat1, Double[][] mat2, int m, int n,Double[][] res, int ref){
        if(ref<m*n){
            int row=ref/res[0].length,col=ref%res[0].length;
            
            res[row][col]=mat1[row][col]+mat2[row][col];
            sumMatrix(mat1,mat2,m,n,res,ref+1);
        }
    }
    
    public static Double[][] multMatrix(Double[][] mat1, Double[][] mat2, int m1, int n1, int m2, int n2){
        if(mat1!=null && mat2!=null && n1==m2){
            Double[][] res=new Double[m1][n2];
            multMatrix(mat1,mat2,m1,n1,n2,res,0);
            return res;
        }
        return null;
    }
    private static void multMatrix(Double[][] mat1, Double[][] mat2, int m, int p, int n,Double[][] res, int ref){
        if(ref<m*n){
            int row=ref/res[0].length,col=ref%res[0].length;
            double sum=0;
            
            for(int i=0;i<p;i++)
                sum+=mat1[row][i]*mat2[i][col];
            res[row][col]=sum;
            multMatrix(mat1,mat2,m,p,n,res,ref+1);
        }
            
    }

    public static void main(String[] args) {
        Double[][] mat1 = {{2.1, 2.4, 5.0}, {3.0, 4.6, 9.0}, {3.4, 5.4, 7.0}};
        Double[][] mat2 = {{5.1, 3.4, 8.0}, {2.0, 0.6, 1.0}, {5.4, 4.4, 10.0}};

        System.out.println(matrixToString(mat1, 3, 3) + "\n");
        System.out.println(matrixToString(mat2, 3, 3) + "\n");
        System.out.println(sumaRenglon(mat1, 3, 1));
        System.out.println(sumaColumna(mat2, 3, 0));
        System.out.println(sumaDiagPrincipal(mat1, 2, 3));
    }
}
