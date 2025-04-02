package tp1.ejercicio8;

import java.util.List;

public class CircularQueue<T> extends Queue<T> {

    public T shift() {
        T primerElem = dequeue();  //saco el primer elemento
        enqueue(primerElem); // agrego  al final
        return primerElem;  // retorno el primer elemento
    }
}
