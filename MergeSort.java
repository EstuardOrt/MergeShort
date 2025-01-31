import java.util.Random;

public class MergeSort {

    
    public static void mergeSort(int[] array, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            mergeSort(array, izquierda, medio);
            mergeSort(array, medio + 1, derecha);

            merge(array, izquierda, medio, derecha);
        }
    }

    public static void merge(int[] array, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] iArray = new int[n1];
        int[] dArray = new int[n2];

        for (int i = 0; i < n1; i++)
            iArray[i] = array[izquierda + i];
        for (int i = 0; i < n2; i++)
            dArray[i] = array[medio + 1 + i];

        int i = 0, j = 0;

        int k = izquierda;
        while (i < n1 && j < n2) {
            if (iArray[i] <= dArray[j]) {
                array[k] = iArray[i];
                i++;
            } else {
                array[k] = dArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = iArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = dArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);  
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(10000000);
        System.out.println("Array original:");
        System.out.println("cambio minimo");
        printArray(array);
        long inicio = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long fin = System.nanoTime();
        System.out.println("Array ordenado:");
        printArray(array);
        System.out.println("Tiempo: "+(fin-inicio));
    }
}