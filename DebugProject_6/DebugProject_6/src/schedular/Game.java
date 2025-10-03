// package schedular;

// public class Game {
// 	private String gameName;
// 	private int noOfPlayers;
	
// 	Game(){
// 	}
	
                
// 	private Game(String gameName, int noOfPlayers) {
// 		gameName = gameName;
// 		noOfPlayers = noOfPlayers;
// 	}

// 	public String getGameName() {
// 		return gameName;
// 	}
	
// 	public void setGameName(String gameName) {
// 		this.gameName = gameName;
// 	}
	
// 	public int getNoOfPlayers() {
// 		return noOfPlayers;
// 	}

// 	public void setNoOfPlayers(int noOfPlayers) {
// 		this.noOfPlayers = noOfPlayers;
// 	}
	
	
// 	public boolean equals(Object o){
// 		Game g = (Game)o;
// 		return gameName.equals(g.gameName);
// 	}
	
// 	public String toString(){
// 		return this.gameName;
// 	}
// }









package schedular;

public class Game {
	private String gameName;
	private int noOfPlayers;
	
	public Game(){
	}
	
    // FIX 1 & 2: Changed constructor visibility to public and corrected self-assignment issue using 'this'.
	public Game(String gameName, int noOfPlayers) {
		this.gameName = gameName;
		this.noOfPlayers = noOfPlayers;
	}

	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
		Game g = (Game)o;
        // Check if gameName is not null before calling equals
        if (gameName == null) return g.gameName == null;
		return gameName.equals(g.gameName);
	}
	
	// FIX 3: Added missing hashCode() to maintain the contract with equals().
	@Override
	public int hashCode(){
		return gameName != null ? gameName.hashCode() : 0;
	}
	
	@Override
	public String toString(){
		return this.gameName;
	}
}