
package lab6p1_miaelvir;

import java.util.Scanner; 
import java.util.Random;

public class Lab6P1_MiaElvir {
    
static Scanner papoy = new Scanner(System.in); 
static Random ran = new Random(); 
   
    public static void main(String[] args) {
        
        System.out.println("----- Menu -----");
        System.out.println("1. Ejercicio 1 - Conjuntos");
        System.out.println("2. Ejercicio 2 - ¿Cuantos primos tienes?");//Respuesta: cercanos que yo conozca 5
        System.out.println("3. Salir del menu");
        int opcion = papoy.nextInt(); 
        
        while (opcion > 0 && opcion < 3){
            switch (opcion){
                
                case 1: 
                    
                    System.out.println("Ejercicio 1 - Conjuntos");
                    System.out.println(" ");
                    System.out.print("Ingrese Size del SET1: ");
                    int S_SET1 = papoy.nextInt(); 
                    System.out.println(" ");
                    System.out.print("Ingrese Size del SET2: ");
                    int S_SET2 = papoy.nextInt(); 
                    
                    char SET1 [] = new char [S_SET1]; 
                    char SET2 [] = new char [S_SET2]; 
                    SET1 = genRandCharArray(S_SET1); 
                    SET2 = genRandCharArray(S_SET2); 
                    
                    System.out.println("Conjuntos Generados");
                    System.out.println(" ");
                    System.out.print("SET1: ");
                    imprimir_char(SET1); 
                    System.out.print("SET2: ");
                    imprimir_char(SET2); 
                    System.out.println("");
                    
                    System.out.println("Operaciones: ");
                    System.out.println("1. Interseccion");
                    System.out.println("2. Diferencia");
                    System.out.print("Ingrese opcion: ");
                    int opcion2 = papoy.nextInt(); 
                    switch (opcion2){
                        case 1: 
                            System.out.println("Intersection");
                            imprimir_char(intersection(SET1,SET2)); 
                            break; 
                            
                        case 2: 
                            System.out.println("Diferencia");
                            imprimir_char(difference(SET1,SET2)); 
                            break; 
                    }
                    //what kind of music does rabbits listen to? [1]
                    
                    break; 
                    
                case 2: 
                    
                    System.out.println("Ejercicio 2 - ¿Cuantos primos tienes?");
                    System.out.println(" ");
                    System.out.print("Ingrese el tamaño del arreglo a generar: ");
                    int tam = papoy.nextInt();
                    System.out.println(" ");
                    System.out.print("Ingrese el limite inferior: ");
                    int lim_1 = papoy.nextInt();
                    System.out.println(" ");
                    System.out.print("Ingrese el limite superior: ");
                    int lim_2 = papoy.nextInt();
                    System.out.println(" ");

                    int arreglo_g [] = new int [tam];
                    System.out.print("Arreglo generado: ");
                    arreglo_g=genRandArray(tam, lim_1, lim_2);
                    imprimir_int(arreglo_g);
                    System.out.println(" ");
                    System.out.print("No. divisores primos: ");
                    imprimir_int(getTotalPrimeCount(arreglo_g));
                    break; 
            
            
            }//fin switch
            
            System.out.println(" ");
            System.out.println("----- Menu -----");
            System.out.println("1. Ejercicio 1 - Conjuntos");
            System.out.println("2. Ejercicio 2 - ¿Cuantos primos tienes?");//Respuesta: 5
            System.out.println("3. Salir del menu");
            opcion = papoy.nextInt(); 
        
        }//fin while 
        
        //[1]-Hip Hop 
        
    }//fin main
    
    public static void imprimir_char(char [] x){
        for (int i = 0; i < x.length; i++){
            char caracter = x[i]; 
            if (caracter != '/'){
                System.out.print("["+caracter+"] ");
            }
            
        }
        System.out.println(" ");
    }//fin imprimir char
    
    public static void imprimir_int(int [] x){
        for (int i = 0; i < x.length; i++){
            System.out.print("["+x[i]+"] ");
        }
    }//fin imprimir int
    
    public static char [] genRandCharArray(int size){
        char arreglo_t [] =  new char [size]; 
        for (int i = 0; i < size; i++){
            int num_letra = ran.nextInt(65, 73); 
            char caracter = (char)num_letra; 
            arreglo_t[i] = caracter; 
        }
        return arreglo_t; 
    }// metodo genRandCharArray
    
    public static char [] intersection(char [] x, char [] y){
        
        int menor = 0; 
        if (x.length > y.length){
            menor = y.length; 
        }else if (y.length > x.length){
            menor = x.length; 
        }else{
            menor = x.length; 
        }
        
        char intersection [] = new char [menor]; 
        
        
        
        int cont = 0; 
        for (int i = 0; i < x.length; i++){ 
            boolean inter = false; 
            for (int j = 0; j < y.length; j++){
                if (x[i] == y[j] && inter == false){
                    inter = true; 
                    intersection [cont] = x[i]; 
                    cont++; 
                }
            }
        }
        
        
    
        return intersection; 
    }//fin intersection
    
    public static char [] difference(char x[], char y[]){
        
        
        for (int i = 0; i < x.length; i++){
            for (int j = 0; j < y.length; j++){
                if (x[i]==y[j]){
                    x[i]='/'; 
                    break; 
                }
            
            }
        
        }
        return x; 
    }// fin difference
    
    public static int [] genRandArray(int x, int y, int z){
        int arreglo [] = new int [x]; 
        for (int i = 0; i < arreglo.length; i++){
            arreglo[i] = ran.nextInt(y, z);   
        }
        return arreglo; 
    }//fin genRandArray
    
    public static boolean isPrime(int x){
        int cont = 0; 
        int dividir = 1; 
        
        boolean primo = false; 
        while (x >= dividir){
            if (x%dividir == 0){
                cont++; 
            }
           
          dividir++;   
        }
        if (cont == 2){
            primo = true; 
        }
        
        return primo; 
    }//isPrime
    
    public static int countPrimeFactors(int x){
        int cont = 0; 
        int dividir = 1;
        
        while (x>=dividir){
            
            if (x%dividir == 0 && isPrime(dividir)){
                cont++; 
            }
            dividir++; 
        }
        /*for (int i = 1; i <= x; i++){
            
            if (x%i == 0 && isPrime(i)){
                cont++; 
            }
           
        }*/
        return cont; 
    }
    
    public static int [] getTotalPrimeCount(int [] x){
        int [] primecount = new int [x.length];  
        for (int i = 0; i < x.length; i++){
            primecount[i] = countPrimeFactors(x[i]); 
        
        }
        return primecount;
        
    }
    
}//fin clase
