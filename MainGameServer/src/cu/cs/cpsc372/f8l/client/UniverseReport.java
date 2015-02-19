package cu.cs.cpsc372.f8l.client;

import java.util.ArrayList;

import cu.cs.cpsc372.f8l.shared.*;

public class UniverseReport {
	public static void report(Game game){
		
		Game myGame = game;
		
		int totalEmpires;
		int totalPlayers;
		
		totalEmpires = myGame.getEmpires().size();
		totalPlayers = myGame.getPlayers().size();
		
		System.out.println("Universe Report");
		System.out.println("----------------");
		System.out.println("Universe Name: " + myGame.getName());
		System.out.println("Stardate: " + myGame.getStarDate());
		
		System.out.println("");
		System.out.println("Ship Classes:");
		for(int i = 0; i < totalEmpires; i++){
			System.out.println("* " + myGame.getEmpires().get(i).getName());
			Empire myEmpire = myGame.getEmpires().get(i);
			ArrayList<ShipType> shipsByEmpire = myGame.getShipTypesByEmpire(myEmpire);
			ShipType myShipType;
			for(int j = 0; j < shipsByEmpire.size(); j++){
				myShipType = shipsByEmpire.get(j);
				System.out.print("  - " + myShipType.getName() + " (" + myShipType.getClassification() + ")" + " - " + myGame.getShipsByType(myShipType).size());
				if(myGame.getShipsByType(myShipType).size() == 1){
					System.out.println(" ship");
				}
				else{
					System.out.println(" ships");
				}
				System.out.print("     + Max Energy: " + myShipType.getMaxEnergy());
				System.out.print("; Speed: " + myShipType.getMaxSpeed());
				System.out.print("; Shields: " + myShipType.getMaxShield());
				System.out.println("; Missiles: " + myShipType.getMaxMissile());
				Weapon eWeapon = myShipType.getEnergyWeapon();
				Weapon mWeapon = myShipType.getMissileWeapon();
				System.out.println("     + Weapon 1: " + eWeapon.getName() + " (" + eWeapon.getWeaponType().getName() + ", " + "Yield " + eWeapon.getMaxYield() + ")");
				System.out.println("     + Weapon 2: " + mWeapon.getName() + " (" + mWeapon.getWeaponType().getName() + ", " + "Yield " + mWeapon.getMaxYield() + ")");
			}
			System.out.println("");
		}
		
		System.out.println("Players:");
		for(int k = 0; k < totalPlayers; k++){
			Player myPlayer = myGame.getPlayers().get(k);
			Ship myShip = myPlayer.getShip();
			Location myLocation = myShip.getLoc();
			System.out.println("* " + myPlayer.getId() + ": " + myPlayer.getEmpire().getName() + ", piloting a " + myShip.getType().getName() + " (" + myShip.getType().getClassification() + ")");
			System.out.println("   + Location: Sector (" + myLocation.getSx() + "," + myLocation.getSy() + ") Subsector (" + myLocation.getPx() + "," + myLocation.getPy() + ")" );
			System.out.println("   + Alert status: " + myShip.getAlert().getLevel());
			System.out.println("   + Energy: " + myShip.getEnergy() + "; Shield: " + myShip.getShield() + "; Missiles: " + myShip.getMissiles());
			System.out.println("");
		}
		
		System.out.println("Sector Summary:");
		ArrayList<Empire> empiresToPrint = new ArrayList<Empire>();
		for(int i = 0; i < totalEmpires; i++) {
			Empire e = myGame.getEmpires().get(i);
			ArrayList<Ship> ships = myGame.getShipsByEmpire(e);
			ArrayList<Base> bases = myGame.getBasesByEmpire(e);
			if(ships.size() > 0 || bases.size() > 0){
				empiresToPrint.add(e);
			}
		}
		
		String[][][] grid = new String[empiresToPrint.size()][8][8];
		ArrayList<Ship> ships;
		ArrayList<Base> bases;
		for(int i = 0; i < empiresToPrint.size(); i++) {
			Empire e = empiresToPrint.get(i);
			for(int j = 1; j < 9; j++) {
				for(int k = 1; k < 9; k++) {
					ships = myGame.getShipsInSectorByEmpire(e, j, k);
					bases = myGame.getBasesInSectorByEmpire(e, j, k);
					if(ships.size() > 0 || bases.size() > 0) {
						grid[i][j-1][k-1] = e.getName().charAt(0) + ": " + bases.size() + "/" + ships.size() + "";
					}
					else {
						grid[i][j-1][k-1] = "        ";
					}
				}
			}	
		}
		
		for(int l = 1; l <= 8; l ++){
			if(l ==1 ) System.out.println("  ---1---+---2---+---3---+---4---+---5---+---6---+---7---+---8---");
			else System.out.println(" |-------+-------+-------+-------+-------+-------+-------+-------");
			System.out.print(l + "|");
			if (empiresToPrint.size() > 0) {
				for(int i = 0; i < 8; i++) {
					System.out.print(grid[0][i][l-1]);
				}
			}
			System.out.println("");
			System.out.print(" |");
			if (empiresToPrint.size() > 1) {
				for(int i = 0; i < 8; i++) {
					System.out.print(grid[1][i][l-1]);
				}
			}
			System.out.println("");
			System.out.print(" |");
			if (empiresToPrint.size() > 2) {
				for(int i = 0; i < 8; i++) {
					System.out.print(grid[2][i][l-1]);
				}
			}
			System.out.println("");
			if (empiresToPrint.size() > 3) {
				for(int j = 3; j < empiresToPrint.size(); j++) {
					System.out.print(" |");
					for(int i = 0; i < 8; i++) {
						System.out.print(grid[j][i][l-1]);
					}
				}
			}
		}
		
		System.out.println("");
		System.out.println("Key:");
		for(int n = 0; n < totalEmpires; n++){
			System.out.println("* " + myGame.getEmpires().get(n).getName().charAt(0) + " - " + myGame.getEmpires().get(n).getName());
		}
	}
}
