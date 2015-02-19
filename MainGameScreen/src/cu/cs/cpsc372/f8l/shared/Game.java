package cu.cs.cpsc372.f8l.shared;

import java.util.ArrayList;

public class Game {
	ArrayList<Empire> empires;
	ArrayList<Weapon> weaponTypes;
	ArrayList<ShipType> shipTypes;
	ArrayList<Base> bases;
	ArrayList<Ship> ships;
	ArrayList<Player> players;
	
	int starDate;
	String name;
	
	public Game (String name, int starDate) {
		this.name = name;
		this.starDate = starDate;
		empires = new ArrayList<Empire>();
		weaponTypes = new ArrayList<Weapon>();
		shipTypes = new ArrayList<ShipType>();
		bases = new ArrayList<Base>();
		ships = new ArrayList<Ship>();
		players = new ArrayList<Player>();
	}
	
	public ArrayList<Ship> getShipsInSectorByEmpire(Empire e, int sx, int sy) {
		ArrayList<Ship> ships = new ArrayList<Ship>();
		for (Ship s: this.ships) 
			if(s.getType().getEmpire().getId().equals(e.getId())) 
				if(s.getLoc().getSx() == sx && s.getLoc().getSy() == sy)
					ships.add(s);
		return ships;
	}
	
	public ArrayList<Base> getBasesInSectorByEmpire(Empire e, int sx, int sy) {
		ArrayList<Base> bases = new ArrayList<Base>();
		for (Base b: this.bases) 
			if(b.getEmpire().getId().equals(e.getId())) 
				if(b.getLoc().getSx() == sx && b.getLoc().getSy() == sy)
					bases.add(b);
		return bases;
	}
	
	public ArrayList<Base> getBasesByEmpire(Empire e){
		ArrayList<Base> bbe = new ArrayList<Base>();
		for (Base b: bases) {
			if(b.getEmpire().getId().equals(e.getId())) {
				bbe.add(b);
			}
		}
		return bbe;
	}
	
	public ArrayList<ShipType> getShipTypesByEmpire(Empire e){
		ArrayList<ShipType> stbe = new ArrayList<ShipType>();
		for (ShipType st: shipTypes) {
			if(st.getEmpire().getId().equals(e.getId())) {
				stbe.add(st);
			}
		}
		return stbe;
	}
	
	
	public ArrayList<Ship> getShipsByType(ShipType st) {
		ArrayList<Ship> sbt = new ArrayList<Ship>();
		for (Ship s: ships) {
			if(s.getType().getId().equals(st.getId())) {
				sbt.add(s);
			}
		}
		return sbt;
	}
	
	public ArrayList<Ship> getShipsByEmpire(Empire e) {
		ArrayList<Ship> sbe = new ArrayList<Ship>();
		for (Ship s: ships) {
			if(s.getType().getEmpire().getId().equals(e.getId())) {
				sbe.add(s);
			}
		}
		return sbe;
	}

	
	public Empire findEmpire(String id){
		for (Empire e: empires)
			if(e.getId().equals(id))
				return e;
		return null;
	}
	
	public ShipType findShipType(String id){
		for (ShipType st: shipTypes)
			if(st.getId().equals(id))
				return st;
		return null;
	}
	
	public Weapon findWeaponType(String id){
		for (Weapon w: weaponTypes)
			if(w.getId().equals(id))
				return w;
		return null;
	}
	
	public Ship findShip(int id){
		for (Ship s: ships)
			if(s.getId() == id)
				return s;
		return null;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public int getStarDate() {
		return starDate;
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

