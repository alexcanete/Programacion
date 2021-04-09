package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Libreria {
    // Burbuja de vector
	static void burbuja(int iNumeros[]) {
		for (int i = 0; i < iNumeros.length - 1; i++) {
			for (int j = 0; j < iNumeros.length - 1; j++) {
				if (iNumeros[j] < iNumeros[j + 1]) {
					byte tmp = (byte) iNumeros[j + 1];
					iNumeros[j + 1] = iNumeros[j];
					iNumeros[j] = tmp;
				}
			}
		}
		for (int i = 0; i < iNumeros.length; i++) {
			System.out.print(iNumeros[i] + "\n");
		}
	}

	// leer array char
	private static void rellenarArray(char[] array) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		byte bContador;
		for (bContador = 0; bContador < array.length; bContador++) {
			System.out.print("Introduzca valor para posicion [" + bContador + "]: ");
			try {
				array[bContador] = teclado.readLine().charAt(0);
			} catch (IOException e) {
				array[bContador] = 'a';
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	// mostrar array char
	private static void imprimirArray(char[] array) {
		byte bContador;
		for (bContador = 0; bContador < array.length; bContador++) {
			System.out.println(array[bContador]);
		}
	}

	// LIBRERIA LEER VECTOR//

	public static int[] leerVector() {

		int iNumeroElementos = (int) leer("Introduce el numero de elementos de tu vector: ", (byte) 1, (byte) 100, -1,
				-1, (byte) 1);
		int[] aVector = new int[iNumeroElementos];

		for (int iContador = 0; iContador < aVector.length; iContador++) {
			aVector[iContador] = (int) leer("Introduce un numero para la posicion " + iContador + ": ", (byte) 1,
					(byte) 100, -1, -1, (byte) 1);
		}

		return aVector;
	}
	// Patrones para validar
/*
	public void setsdni(String sDNI) {
        String DNI="[0-9]{7,8}[A-Z a-z]";
		if (Pattern.matches(DNI, sDNI)) {
			this.DNI = sDNI;
		}
	}

	public void setsMatricula(String sMatricula) {
        String Matricula="(^[0-9]{4}[A-Z]{3}$)";
        if (Pattern.matches(Matricula, sMatricula)) {
            this.sMatricula = sMatricula;
            
        }
    }

	public void setsCorreo(String sCorreo) {
        String Correo = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        if (Pattern.matches(Correo, sCorreo)) {
            this.sCorreo = sCorreo;
        }

    }
*/
	public static String imprimeVector(int[] aVector) {
		String sResultado = "";
		for (int iContador = 0; iContador < aVector.length; iContador++) {
			sResultado += aVector[iContador];
			if (iContador < aVector.length - 1) {
				sResultado += ",";
			}
		}
		return sResultado;
	}

	public static Object leer(String sMensaje, long lMinimo, long lMaximo, double dMinimo, double dMaximo,
			byte bEstado) {
		Object oNumero;
		switch (bEstado) {
		case 1:
			oNumero = pideNumeroByte(sMensaje, lMinimo, lMaximo);
			break;
		case 2:
			oNumero = pideNumeroShort(sMensaje, lMinimo, lMaximo);
			break;
		case 3:
			oNumero = pideNumeroInt(sMensaje, lMinimo, lMaximo);
			break;
		case 4:
			oNumero = pideNumeroLong(sMensaje, lMinimo, lMaximo);
			break;
		case 5:
			oNumero = pideNumeroFloat(sMensaje, dMinimo, dMaximo);
			break;
		case 6:
			oNumero = pideString(sMensaje, lMinimo, lMaximo);
			break;
		default:
			oNumero = -1;
		}
		return oNumero;
	}

	private static byte pideNumeroByte(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		byte bNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " - " + lMaximo + "): ");
			try {
				bNumero = Byte.parseByte(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
		} while (bFallo || (bNumero < lMinimo || bNumero > lMaximo));

		return bNumero;
	}

	private static short pideNumeroShort(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		short sNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " - " + lMaximo + "): ");
			try {
				sNumero = Short.parseShort(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
		} while (bFallo || (sNumero < lMinimo || sNumero > lMaximo));

		return sNumero;
	}

	private static int pideNumeroInt(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int iNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " - " + lMaximo + "): ");
			try {
				iNumero = Integer.parseInt(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
		} while (bFallo || (iNumero < lMinimo || iNumero > lMaximo));

		return iNumero;
	}

	private static long pideNumeroLong(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		long lNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + lMinimo + " - " + lMaximo + "): ");
			try {
				lNumero = Long.parseLong(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
		} while (bFallo || (lNumero < lMinimo || lNumero > lMaximo));

		return lNumero;
	}

	private static float pideNumeroFloat(String sMensaje, double dMinimo, double dMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		float fNumero = 0;
		boolean bFallo;

		do {
			System.out.print(sMensaje + "(" + dMinimo + " - " + dMaximo + "): ");
			try {
				fNumero = Float.parseFloat(teclado.readLine());
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
		} while (bFallo || (fNumero < dMinimo || fNumero > dMaximo));

		return fNumero;
	}

	private static String pideString(String sMensaje, long lMinimo, long lMaximo) {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		String sFrase = "";
		boolean bFallo;

		do {
			System.out.print(sMensaje + ": ");
			try {
				sFrase = teclado.readLine();
				bFallo = false;
			} catch (Exception e) {
				bFallo = true;
			}
		} while (bFallo || (sFrase.length() < lMinimo || sFrase.length() > lMaximo));

		return sFrase;
	}
}
