/**
 * Clase que representa el conjunto de jugadores del torneo
 */
package ped1;
import java.util.ArrayList;

public class Players {
    
    private ArrayList<Player> players;
    
    public Players(ArrayList<Player> players) {
        this.players = players;
    }
    
    public int size() {
        return players.size();
    }

    public Player get(int i) {
        return players.get(i);
    }
}
