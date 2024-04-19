/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Quicksort;

import Objetos.Servicio;
import java.util.ArrayList;

/**
 *
 * @author mari2
 */
public class QuickServ {
     public QuickServ(ArrayList<Servicio> ser) {
        if (ser.size() != 0) {//Checando que el vector no sea 0
            quicksort(ser, 0, ser.size() - 1);
        }
    }

    public static void quicksort(ArrayList<Servicio> A, int izq, int der) {

        Servicio pivote = A.get(izq); // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        Servicio aux;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A.get(i).getCuenta() <= pivote.getCuenta() && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (A.get(j).getCuenta() > pivote.getCuenta()) {
                j--;         // busca elemento menor que pivote
            }
            if (i < j) {                      // si no se han cruzado                      
                aux = A.get(i);                  // los intercambia
                A.set(i, A.get(j));
                A.set(j, aux);
            }
        }

        A.set(izq, A.get(j)); // se coloca el pivote en su lugar de forma que tendremos

        A.set(j, pivote); // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
        }
    }
}
