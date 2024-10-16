
//Alejandro Miñambres Mateos
import java.util.*; 
public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in); 
		double notas [][];
		int numalumnos, numpreguntas;
		double media;
		// Pedimos las filas y columnas de la matriz 
		System.out.println("Escribe el numero de alumnos");
		numalumnos=in.nextInt();
		System.out.println("Escribe el numero de preguntas");
		numpreguntas=in.nextInt();
		notas=new double [numalumnos][numpreguntas];
		//Introducimos las notas 
		System.out.println("Introduzca todas las notas del alumno a, despues todas las del b, y asi sucesivamente");
		for(int i=0;i<numalumnos;i++) {
			for(int j=0;j<numpreguntas;j++) {
				notas[i][j]=in.nextDouble();
			}
		}
		//Metodo rango de notas de una pregunta
		notamaxymin(numalumnos,numpreguntas,notas);
		System.out.println("");
		
		//Metodo media de notas de las preguta
		medianotas(numalumnos,numpreguntas,notas);
		System.out.println("");
		
		//Metodo nota del alumno
		notaalumnos(numalumnos,numpreguntas,notas);
		System.out.println("");
		
		//Metodo Desviacion tipica 
		desviaciontipica(numalumnos,numpreguntas,notas);
		System.out.println("");
		
		//Metodo Media de todas las notas
		media=notamedia(numalumnos,numpreguntas,notas);
		System.out.println("La media de todas las notas es "+media);
		System.out.println("");
		
		// Metodo tres mejores notas
		tresmejoresnotas(numalumnos,numpreguntas,notas);
	}
	public static void notamaxymin(int numalumnos,int numpreguntas, double notas[][]) {
		double notamin;
		double notamax;
		//recorre todas las notas de las preguntas mirando cual es la max o min
		for(int i=0;i<numpreguntas;i++) {
			notamin=10;
			notamax=0;
			for(int j=0;j<numalumnos;j++) {
				if(notas[j][i]<notamin) {
					notamin=notas[j][i];
				}
				if(notas[j][i]>notamax) {
					notamax=notas[j][i];
				}
			}
			System.out.print("La nota máxima de la pregunta "+(i+1)+" es "+notamax );
			System.out.println(" y la nota mínima es "+notamin );
		}	
	}
	
	public static void medianotas(int numalumnos,int numpreguntas, double notas[][]) {
		double notamedia;
		//recorre las notas de las preguntas y calcula su media
		for(int i=0;i<numpreguntas;i++) {
			notamedia=0;
			for(int j=0;j<numalumnos;j++) {
				notamedia=notamedia+notas[j][i];
			}
			notamedia=notamedia/numalumnos;
			System.out.println("La nota media de la pregunta "+(i+1)+" es "+notamedia );
		}
	}
	
	public static void notaalumnos(int numalumnos,int numpreguntas, double notas[][]) {
		double nota;
		//calcula las notas de los alumnos
		for(int i=0;i<numalumnos;i++) {
			nota=0;
			for(int j=0;j<numpreguntas;j++) {
				nota=nota+notas[i][j];
			}
			System.out.println("La nota del alumno "+(i+1)+" es "+nota);
		}
	}
	public static void desviaciontipica(int numalumnos,int numpreguntas, double notas[][]) {
		double destip=0;
		//para la desviacion tipica necesitamos tambien la media
		double media=notamedia(numalumnos,numpreguntas,notas);
		double not;
		//calcula de la desviacion típica de las notas de los alumnos
		for(int i=0;i<numalumnos;i++) {
			not=0;
			for(int j=0;j<numpreguntas;j++) {
				not=not+notas[i][j];
			}
			destip=destip+Math.pow(not-media, 2);
		}
		destip=Math.sqrt(destip/numalumnos);
		System.out.println("La desviación típica es "+destip);
		
	}
	public static double notamedia(int numalumnos,int numpreguntas, double notas[][]) {
		double media=0;
		//calcula la media de las notas de los alumnos
		for(int i=0;i<numalumnos;i++) {
			for(int j=0;j<numpreguntas;j++) {
				media=media+notas[i][j];
			}
		}
		media=media/numalumnos;
		return media;
	}
	public static void tresmejoresnotas (int numalumnos,int numpreguntas, double notas[][]) {
		double mejnot1=0;
		double mejnot2=0;
		double mejnot3=0;
		
		double nota;
		//calcula las tres mejores notas 
		for(int i=0;i<numalumnos;i++) {
			nota=0;
			for(int j=0;j<numpreguntas;j++) {
				nota=nota+notas[i][j];
			}
			if(nota>mejnot1||nota>mejnot2||nota>mejnot3) {
				if(mejnot1>=mejnot2) {
					if(mejnot2>=mejnot3) {
						mejnot3=nota;
					}else {
						mejnot2=nota;
					}
				}else if(mejnot1>=mejnot3) {
					mejnot3=nota;
				}else mejnot1=nota;
			}
		
		}
		System.out.println("Las 3 mejores notas han sido: "+ mejnot1+" "+mejnot2+" "+mejnot3);
	}

}
