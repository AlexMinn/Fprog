//Alejandro Miñambres Mateos

package sesion3;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int num;											//Variable principal
		int unid,dece,cent;									//Variables para invertir el numero
		int inv,suma;
		System.out.println("Escribe un número de 3 cifras");
		num = in.nextInt();  								//Almacenamos en num el numero leído
		if (100<=num && num<=999) { 						// Calculamos si el numero es de tres cifras, es decir si esta entre 100 y 999
			
			cent=(int)num/100;								//Con las tres siguientes expresiones calculamos las unidades decenas y centenas del numero dado
			dece=(int)(num-(cent*100))/10;
			unid=(int)(num-(cent*100)-(dece*10));
		
			inv=unid*100+dece*10+cent;						//variable en la que guardaremos el numero inverso
			suma=num+inv;									//variable en la que guardaremos la suma del inverso mas el numero dado
			if (suma>=1000) {								// si la suma es mayor que 1000, tendra 4 cifras, por lo que sera un numero potente
				System.out.println("SI");
			}
			else {
				System.out.println("NO");					//si la suma es menor que 1000, tendra 3 cifras, por lo que no sera un numero potente
			}
				
		}
		else { 												// Si el numero no lo está decimos que es incorrecto
			System.out.println("Incorrecto");
		}
	}

}
