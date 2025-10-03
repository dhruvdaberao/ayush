// package schedular;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Iterator;
// import java.util.Map;
// import java.util.Set;
// import java.util.TreeSet;


// public class Schedular {
// 	private Set <Game> games = new HashSet<Game>();
// 	private Set <Player> players = new HashSet<Player>();
// 	private Set <DaySchedule> days = new HashSet<DaySchedule>();
// 	private Map<Game,TreeSet<DaySchedule>> gameDayMap = new HashMap<Game,TreeSet<DaySchedule>>();
// 	private Map<Game,TreeSet<Player>> gamePlayerMap = new HashMap<Game,TreeSet<Player>>();
// 	private Map<String,DaySchedule> dayNameScheduleMap = new HashMap<String,DaySchedule>();

    
// 	public Map<String, DaySchedule> getDayNameScheduleMap() {
// 		return dayNameScheduleMap;
// 	}
// 	public void setDayNameScheduleMap(Map<String, DaySchedule> dayNameScheduleMap) {
// 		this.dayNameScheduleMap = dayNameScheduleMap;
// 	}
// 	public int getNumberGames(){
//     	return games.size();
//     }
//     public int getNumberofPlayers(){
//     	return players.size();
//     }
//     public int getNumberofDays(){
//     	return days.size();
//     }

// 	public String addGame(String name, int nop)throws GameAlreadyExistsException{
// 		Game g = new Game(name,nop);
// 		if(games.add(g))
// 			throw new GameAlreadyExistsException("Game Already Exists");
// 		return "SUCCESS";
// 	}
// 	public String addSchedule(String dayName, String[] gameNames)throws PlayerAlreadyExistsException, InvalidGameException, DayAlreadyScheduledException{
// 		System.out.println("DEBUG : add schedule called");
// 		DaySchedule d = searchDay(dayName);
// 		if(d==null){
// 			//DaySchedule d = new DaySchedule(); This will throw nullPointer Exception
// 			d= new DaySchedule(dayName);
// 		}
// 		ArrayList<Game> games = d.getGames();
// 	    Set<Game> uniqueGames= new HashSet<Game>(games);
// 	    int originalnog = uniqueGames.size();
// 	    System.out.println("DEBUG "+uniqueGames);
// 		for(String game : gameNames){
// 			Game g = searchGame(game);
// 			if(g==null){
// 				System.out.println("GAME does not exist ?"+game+" "+this.games);
// 				System.exit(1);
// 				continue;
				
// 			}
// 			uniqueGames.add(g);
// 			System.out.println("DEBUG now "+uniqueGames);
// 			TreeSet<DaySchedule> daySchedules = gameDayMap.get(g);
// 			if(daySchedules==null){
// 				daySchedules = new TreeSet<DaySchedule>();
// 				gameDayMap.put(g, daySchedules);
// 			}
// 		//vivek	daySchedules.add(d);
// 		}
//         if(originalnog==uniqueGames.size()){
// 			throw new DayAlreadyScheduledException("Day Already Scheduled");
//         }
//         games.clear();
//         games.addAll(uniqueGames);
//         d.setGames(games);
//       //vivek  days.add(d);
//         dayNameScheduleMap.put(dayName, d);
// 		return "SUCCESS";
// 	}
// 	private DaySchedule searchDay(String dayName) {
// 		for(DaySchedule day : this.days){
// 			if(day.getDayName().equals(dayName)){
// 				return day;
// 			}
// 		}
// 		return null;
// 	}
// 	public String addPlayer(String name, String[] gameNames)throws PlayerAlreadyExistsException, InvalidGameException{
// 		ArrayList<Game> games= new ArrayList<Game>();
// 		Player p = new Player(name,games);
// 		for(String game : gameNames){
// 			Game g = searchGame(game);
// 			if(g==null){
// 				players.add(p);
// 				throw new InvalidGameException(game+" does not exist ");
// 			}
// 			games.add(g);
// 			TreeSet<Player> players = gamePlayerMap.get(g);
// 			if(players==null){
// 				players=new TreeSet<Player>();
// 				gamePlayerMap.put(g, players);
// 			}
		
// 		}
		
// 		//if(!players.add(p))
// 			//throw new PlayerAlreadyExistsException("Player Already Exists");
// 		return "SUCCESS";
// 	}

// 	public Set<Game> getGames() {
// 		return games;
// 	}
// 	public void setGames(Set<Game> games) {
// 		this.games = games;
// 	}
// 	private Game searchGame(String name) {
// 		for(Game g : this.games){
// 			if(g.getGameName().equals(name))
// 				return g;
// 		}
// 		return null;
// 	}
// 	public StringBuffer displayGamewiseSchedule(String gameName) {
// 		// TODO Auto-generated method stub
// 		StringBuffer sb = new StringBuffer();
// 		Game g = searchGame(gameName);
// 		if(g==null)
// 		{
// 			sb.append(g+" is not part of the Schedule.");
// 			return sb;
// 		}
// 		if(gameDayMap.containsKey(g))
// 		{
// 			sb.append(g+" is played on ");
// 			sb.append("\n\t"+"Days:"+gameDayMap.get(g));
// 		}
// 		else{
// 			sb.append(g+" is not scheduled on any day...");
// 		}

// 		if(gamePlayerMap.containsKey(g)){
// 			sb.append("\n"+g+" is played by ");
// 			sb.append("\n\t"+"Players:"+gamePlayerMap.get(g));
// 		}
// 		else{
// 			sb.append("No player plays this game...");
// 		}
// 		return sb;
// 	}

// 	public StringBuffer displayPlayerwiseSchedule(String name){
// 		StringBuffer sb = new StringBuffer();
		
// 		if(!players.contains(new Player(name))){
// 			sb.append("No such Player exists ... ");
// 			return sb;
// 		}

// 		ArrayList<Player> players = new ArrayList<Player>(this.players);
//         Player p = new Player(name,null);
// 		Collections.sort(players);
// 		int index = Collections.binarySearch(players,p);
// 		ArrayList<Game> games=players.get(index).getGames();
// 		Iterator<Game> it = games.iterator();

// 		sb.append(name+" plays ");
// 		while(it.hasNext()){
// 			Game g = it.next();
// 			sb.append("\n\t "+g+" on "+gameDayMap.get(g));
// 		}
// 		return sb;
// 	}

// 	public StringBuffer displayDaywiseSchedule(String name){
// 		StringBuffer sb = new StringBuffer();
// 		DaySchedule day = new DaySchedule(name);
// 		if(!days.contains(day)){
// 			sb.append("No such day exists in the schedule...");
// 			return sb;
// 		}

// 		ArrayList<DaySchedule> days= new ArrayList<DaySchedule>(this.days);
		
// 		Collections.sort(days);
// 		int index = Collections.binarySearch(days, day);
// 		ArrayList<Game>games =days.get(index).getGames();
// 		Iterator<Game> it = games.iterator();

// 		sb.append("On "+name);
// 		while(it.hasNext()){
// 			Game g = it.next();
// 			sb.append("\n\t"+g+" is played by "+gamePlayerMap.get(g));
// 		}
// 		return sb;
// 	}
// }





package schedular;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Schedular {
	private Set <Game> games = new HashSet<Game>();
	private Set <Player> players = new HashSet<Player>();
	private Set <DaySchedule> days = new HashSet<DaySchedule>();
	private Map<Game,TreeSet<DaySchedule>> gameDayMap = new HashMap<Game,TreeSet<DaySchedule>>();
	private Map<Game,TreeSet<Player>> gamePlayerMap = new HashMap<Game,TreeSet<Player>>();
	private Map<String,DaySchedule> dayNameScheduleMap = new HashMap<String,DaySchedule>();

    
	public Map<String, DaySchedule> getDayNameScheduleMap() {
		return dayNameScheduleMap;
	}
	public void setDayNameScheduleMap(Map<String, DaySchedule> dayNameScheduleMap) {
		this.dayNameScheduleMap = dayNameScheduleMap;
	}
	public int getNumberGames(){
    	return games.size();
    }
    public int getNumberofPlayers(){
    	return players.size();
    }
    public int getNumberofDays(){
    	// FIX 1: Changed to use the 'days' set which is now correctly managed.
    	return days.size(); 
    }
    public Set<Game> getGames() {
		return games;
	}
	public void setGames(Set<Game> games) {
		this.games = games;
	}
	private Game searchGame(String name) {
		for(Game g : this.games){
			if(g.getGameName().equals(name))
				return g;
		}
		return null;
	}

	public String addGame(String name, int nop)throws GameAlreadyExistsException{
		Game g = new Game(name,nop);
		// FIX 2: Corrected the inverted logic. If add() returns false, the game existed.
		if(!games.add(g))
			throw new GameAlreadyExistsException("Game Already Exists");
		return "SUCCESS";
	}
	
	// FIX 3: Removed unused PlayerAlreadyExistsException from throws clause.
	public String addSchedule(String dayName, String[] gameNames)throws InvalidGameException, DayAlreadyScheduledException{
		System.out.println("DEBUG : add schedule called");
		
		// FIX 4: Use map for existing day lookup.
		DaySchedule d = dayNameScheduleMap.get(dayName); 
		boolean dayExisted = (d != null);
		
		if(d==null){
			d= new DaySchedule(dayName);
		}
		
		ArrayList<Game> currentGames = d.getGames();
	    Set<Game> uniqueGames = new HashSet<Game>(currentGames);
	    int originalnog = uniqueGames.size();
	    
		for(String game : gameNames){
			Game g = searchGame(game);
			if(g==null){
				// FIX 5: Throw exception instead of printing debug and exiting.
				throw new InvalidGameException("Game '"+game+"' does not exist."); 
			}
			uniqueGames.add(g);
			
			// FIX 6: Updated gameDayMap logic moved here and corrected.
			TreeSet<DaySchedule> daySchedules = gameDayMap.get(g);
			if(daySchedules==null){
				daySchedules = new TreeSet<DaySchedule>();
				gameDayMap.put(g, daySchedules);
			}
			daySchedules.add(d); 
		}

		// FIX 7: Corrected logic for DayAlreadyScheduledException.
        if(dayExisted && originalnog == uniqueGames.size()){
			throw new DayAlreadyScheduledException("Day '"+dayName+"' already scheduled with the same games.");
        }
        
        // FIX 8: Update the day schedule object and core sets/maps.
        currentGames.clear();
        currentGames.addAll(uniqueGames);
        
        if (!dayExisted) {
            this.days.add(d); // Add new day to the main set
        }
        dayNameScheduleMap.put(dayName, d); // Update the map
		
		return "SUCCESS";
	}
	
	// FIX 9: Removed searchDay as it is replaced by map lookup.
	
	public String addPlayer(String name, String[] gameNames)throws PlayerAlreadyExistsException, InvalidGameException{
		ArrayList<Game> gamesList= new ArrayList<Game>();
		Player p = new Player(name,gamesList);
		
		// FIX 10: Check for player uniqueness at the start.
		if(this.players.contains(p)) {
	        throw new PlayerAlreadyExistsException("Player '"+name+"' Already Exists");
	    }
		
		// FIX 11: Validate all games before adding player to the main set.
		for(String game : gameNames){
			Game g = searchGame(game);
			if(g==null){
				throw new InvalidGameException("Game '"+game+"' does not exist.");
			}
			gamesList.add(g);
		}
		
		// FIX 12: Add player to main set only after successful game validation.
		this.players.add(p); 
		
		// FIX 13: Update gamePlayerMap for all valid games.
		for (Game g : gamesList) {
	        TreeSet<Player> gamePlayers = gamePlayerMap.get(g);
	        if(gamePlayers == null){
	            gamePlayers = new TreeSet<Player>();
	            gamePlayerMap.put(g, gamePlayers);
	        }
	        gamePlayers.add(p);
	    }
		
		return "SUCCESS";
	}

	// FIX 14: Simplified displayPlayerwiseSchedule to use direct set iteration instead of sort/binarySearch.
	public StringBuffer displayPlayerwiseSchedule(String name){
		StringBuffer sb = new StringBuffer();
		
		Player p = null;
		
		// Search for the actual player object in the set
	    for(Player player : this.players) {
	        if (player.getPlayerName().equals(name)) {
	            p = player;
	            break;
	        }
	    }

		if(p == null){
			sb.append("No such Player exists ... ");
			return sb;
		}

		ArrayList<Game> games= p.getGames();
		Iterator<Game> it = games.iterator();

		sb.append(name+" plays ");
		while(it.hasNext()){
			Game g = it.next();
			// gameDayMap.get(g) returns a TreeSet which uses its toString() for output.
			sb.append("\n\t "+g+" on "+gameDayMap.get(g)); 
		}
		return sb;
	}

	// FIX 15: Simplified displayDaywiseSchedule to use map lookup instead of sort/binarySearch.
	public StringBuffer displayDaywiseSchedule(String name){
		StringBuffer sb = new StringBuffer();
		
		DaySchedule day = dayNameScheduleMap.get(name); // Use map for direct lookup

		if(day == null){
			sb.append("No such day exists in the schedule...");
			return sb;
		}

		ArrayList<Game> games = day.getGames();
		Iterator<Game> it = games.iterator();

		sb.append("On "+name);
		while(it.hasNext()){
			Game g = it.next();
			// gamePlayerMap.get(g) returns a TreeSet which uses its toString() for output.
			sb.append("\n\t"+g+" is played by "+gamePlayerMap.get(g)); 
		}
		return sb;
	}
	
	public StringBuffer displayGamewiseSchedule(String gameName) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		Game g = searchGame(gameName);
		
		if(g==null)
		{
			sb.append(gameName+" is not part of the Schedule.");
			return sb;
		}
		
		if(gameDayMap.containsKey(g))
		{
			sb.append(g+" is played on ");
			sb.append("\n\t"+"Days:"+gameDayMap.get(g));
		}
		else{
			sb.append(g+" is not scheduled on any day...");
		}

		if(gamePlayerMap.containsKey(g)){
			sb.append("\n"+g+" is played by ");
			sb.append("\n\t"+"Players:"+gamePlayerMap.get(g));
		}
		else{
			sb.append("\n"+"No player plays this game...");
		}
		return sb;
	}
}