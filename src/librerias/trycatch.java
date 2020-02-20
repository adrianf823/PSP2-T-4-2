package librerias;

import java.util.Scanner;

public class trycatch {
	Scanner S = new Scanner(System.in);
	
	
	
	
	
public int numeroentero() {
	boolean entra = true;
	int a = 0;
do {	
	try {
	a = S.nextInt();
	entra = false;
		}catch(Exception am) {
			S.nextLine();
			System.out.println("Introduce un numero entero");
	}
}while(entra);
return a;
}	
public float numerofloat() {
	boolean entra = true;
	float a = 0;
do {	
	try {
	a = S.nextFloat();
	entra = false;
		}catch(Exception am) {
			S.nextLine();
			System.out.println("Introduce un numero float");
	}
}while(entra);
return a;
}	
public double numerodouble() {
	boolean entra = true;
	double a = 0;
do {	
	try {
	a = S.nextDouble();
	entra = false;
		}catch(Exception am) {
			S.nextLine();
			System.out.println("Introduce un numero double");
	}
}while(entra);
return a;
}	
public String String() {
	boolean entra = true;
	String a = "0";
do {	
	try {
	a = S.next();
	entra = false;
		}catch(Exception am) {
			S.nextInt();
			System.out.println("Introduce un valor String");
	}
}while(entra);
return a;
}

public boolean Boolean() {
	if(S.next().equalsIgnoreCase("s")) {
		return true;
	}else if(S.next().equalsIgnoreCase("n")){
		return false;
	}else {
		return false;
	}
	
}
	
	
	
}
