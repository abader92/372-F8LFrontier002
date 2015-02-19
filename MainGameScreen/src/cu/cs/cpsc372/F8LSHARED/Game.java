package cu.cs.cpsc372.F8LSHARED;

import java.util.ArrayList;

public class Game {
	ArrayList<Empire> empires;
	ArrayList<Weapon> weaponTypes;
	ArrayList<ShipType> shipTypes;
	ArrayList<Base> bases;
	ArrayList<Ship> ships;
	ArrayList<Player> players;
	
	
	Game () {
		empires = new ArrayList<Empire>();
		weaponTypes = new ArrayList<Weapon>();
		shipTypes = new ArrayList<ShipType>();
		bases = new ArrayList<Base>();
		ships = new ArrayList<Ship>();
		players = new ArrayList<Player>();
	}


	public ArrayList<Empire> getEmpires() {
		return empires;
	}


	public ArrayList<Weapon> getWeaponTypes() {
		return weaponTypes;
	}


	public ArrayList<ShipType> getShipTypes() {
		return shipTypes;
	}


	public ArrayList<Base> getBases() {
		return bases;
	}


	public ArrayList<Ship> getShips() {
		return ships;
	}


	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	
}
