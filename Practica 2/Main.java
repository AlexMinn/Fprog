//Alejandro Miñambres Mateos

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		int num1,num2;
		int ntriang,nrectang;
		int maxnrectang=0,maxpos=0, maxntriang=0;
		
		System.out.println ("Escribe dos posiciones");	
		//Leemos dos posiciones del teclado	
		num1=in.nextInt();
		num2=in.nextInt();
		if (num1>num2) {								
			//forzamos a que num1 sea el mas pequeño
			int aux=num1;
			num1=num2;
			num2=aux;
		}
		for(int i=num1;i<=num2;i++) {					
			//recorremos las posiciones
			//buscamos el valor triangular asociado a la posicion
			//buscamos el numero de rectangulos posibles con el valor anterior
			ntriang=numerotriangular(i);
			nrectang=numerorectangular(ntriang);		
			if(nrectang>=maxnrectang) {					
				//si ese valor es el más grande hasta ahora lo almacenamos junto con su posicion y el nº triangular
				maxnrectang=nrectang;
				maxpos=i;
				maxntriang=ntriang;
			}
		}
		//escribimos en pantalla los  datos máximos
		System.out.println(maxpos);						
		System.out.println(maxntriang);
		System.out.println(maxnrectang);
		
	}
	public static int numerotriangular(int pos) {
		int npos=0;
		for(int i=1;i<=pos;i++) {						
			//recorre las filas del triangulo sumando sus numeros hasta la posicion dada
			npos=npos+i;
		}
		return npos;
	}
	public static int numerorectangular(int nrec) {		
		int cont=0;
		for (int i=1;i<=nrec;i++) {						
			//busca las convinaciones posibles de rectangulos
			if (nrec%i==0) {							
				//si la encuentra suma 1 al contador
				cont++;
			}
		}
		return cont;
	}
}
