// package schedular;
// import java.util.*;

// public class Player  implements Comparable{
// 	private String playerName;
// 	private ArrayList<Game> games = new ArrayList<Game>();
	
	
	
// 	private Player(String playerName) {
// 		super();
// 		this.playerName = playerName;
// 	}

// 	public Player(String playerName, ArrayList<Game> games) {
// 		super();
// 		this.playerName = playerName;
// 		this.games = games;
// 	}

// 	public String getPlayerName() {
// 		return playerName;
// 	}

// 	public void setPlayerName(String playerName) {
// 		this.playerName = playerName;
// 	}

// 	public ArrayList<Game> getGames() {
// 		return games;
// 	}

// 	public void setGames(ArrayList<Game> games) {
// 		this.games = games;
// 	}

// 	public String toString(){
// 		return playerName;
// 	}

	
	
// //    public boolean equals(Object o){
// //    	Player p = (Player)o;
// //    	for(Game g : p.getGames()){
// //    		return this.getGames().contains(g);
// //    	}
// //    	return false;
// //    }
// 	public int compareTo(Player p) {
// 		return playerName.compareTo(p.getPlayerName());
// 	}

	
// }









package schedular;
import java.util.*;

// FIX 1: Corrected raw type Comparable to parameterized Comparable<Player>.
public class Player  implements Comparable<Player>{
	private String playerName;
	private ArrayList<Game> games = new ArrayList<Game>();
	
	// FIX 2: Added public constructor for creating a Player search key (used in Schedular.java).
	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	public Player(String playerName, ArrayList<Game> games) {
		super();
		this.playerName = playerName;
		this.games = games;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	public String toString(){
		return playerName;
	}

    // FIX 3: Implemented equals() based on playerName, as the original was commented out.
	@Override
    public boolean equals(Object o){
    	if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player p = (Player)o;
        if (playerName == null) return p.playerName == null;
        return playerName.equals(p.playerName);
    }
	
	// FIX 4: Implemented hashCode() to maintain the contract with equals().
	@Override
	public int hashCode(){
		return playerName != null ? playerName.hashCode() : 0;
	}

    // FIX 5: Added @Override annotation and kept the correct signature for type-safe comparison.
	@Override
	public int compareTo(Player p) {
		return playerName.compareTo(p.getPlayerName());
	}
}