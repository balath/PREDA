/**
 * Representa un jugador del torneo
 */
package ped1;

public class Player {

    int num;
    String name;

    Player(int num, String name) {
        this.name = name;
        this.num = num;
    }

    Player(int num) {
        this.num = num;
    }

    /**
     * Devuelve un String con el nombre del jugador, o con el número de jugador si no tiene nombre asignado
     */
    @Override
    public String toString() {
        return name != null? name : "J" + num;
    }
}
