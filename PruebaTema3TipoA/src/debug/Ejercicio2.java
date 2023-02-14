package debug;

/**
 * Ejercicio Practico 2 - Tipo A
 * Este programa es capaz, para dos arrays de números enteros,
 * obtener un nuevo array con aquellos que están presentes 
 * solamente en uno de los dos arrays (pero no en los dos)
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        int[] unArray = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] otroArray = new int[] {0,1,1,2,3,5,8,13,21,34,55,89,144};

        int[] resultado = noComunes(unArray, otroArray);

        for (int i = 0; i < resultado.length; i++) {
            System.out.printf("%d ", resultado[i]);
        }

    }
    
    
    public static int[] noComunes(int[] array1, int[] array2) {
    	
    	int[] arrayComunes = comunes(array1, array2);
    	
    	// El tamaño del array de elementos no 
    	// comunes puede ser tan grande como
    	// el array más grande, si no hay ningún
    	// elemento en común
    	int longitudMaxima = array1.length;
    	if (array2.length > longitudMaxima) {
    		longitudMaxima = array2.length;
    	}
    		
    	int[] resultado = new int[longitudMaxima];
    	int pos = 0;
    	
    	// Recorremos el primer array, y comprobamos
    	// para cada elementos si está en el array
    	// de elementos comunes. Si no lo está, significa
    	// que solamente está en el primer array.
    	for(int i = 0; i < array1.length; i++) {
    		if (!contains(array1[i], arrayComunes)) {
    			resultado[pos] = array1[i];
    			pos++;
    		}
    	}
    	
    	// Idem para el segundo array
    	for(int i = 0; i < array2.length; i++) {
    		if (!contains(array2[i], arrayComunes)) {
    			resultado[pos] = array2[i];
    			pos++;
    		}
    	}
    	
    	//Ajustamos el array al tamaño final
        return pack(resultado, pos);
    	
    	
    }


    /**
     * Este método recibe dos arrays como argumento (que pueden ser
     * de tamaños diferentes) y devuelve como resultado un array
     * con los elementos que están presentes en ambos arrays.
     * Si un número aparece en un array, y en el otro aparece repetido
     * más de una vez, aparecerá repetido en el array resultante
     * @param array1
     * @param array2
     * @return
     */
    public static int[] comunes(int[] array1, int[] array2) {
        // El array resultante será, como muy grande
        // del tamaño del array más pequeño.
        int longitudMinima = array1.length;
        if (array2.length < longitudMinima) {
            longitudMinima = array2.length;
        }

        int[] elementosComunes = new int[longitudMinima];
        int pos = -1;

        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]){
                	if (!contains(array1[i],elementosComunes)) { 
                		elementosComunes[pos] = array1[i];
                    	pos++;
                	}	
                }
            }
        }

        //Ajustamos el array al tamaño final
        return pack(elementosComunes, pos);


    }
    
    /**
	 * Reduce un array al número de elementos proporcionados
	 * @param arr Array reducir. Debe ser de tamaño mayor o igual a n
	 * @param n Tamaño del array resultante
	 * @return Array reducido
	 */
	public static int[] pack(int[] arr, int n) {
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	
	
	/**
	 * Este método comprueba sin un array contiene un número
	 * @param n El número a buscar
	 * @param arr El array donde buscar
	 * @return true si lo encuentra, false en otro caso
	 */
	public static boolean contains(int n, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == n)
				return true;
		}
		return false;
	}


}

