package cu.cs.cpsc372.f8l.server;

import java.io.IOException;

import cu.cs.cpsc372.f8l.shared.Game;

public class GameDAOStringImpl implements GameDAO {

	int index;
	String data;
	
	GameDAOStringImpl( String data ) {
		this.data = data;
	}
	
	private String readLine(){
		if(index != 0) index++;
		int oldIndex = index;
		index = oldIndex + data.substring(index).indexOf("\n");
		return data.substring(oldIndex, index - 1);
	}
	
	private void moveToStart(){
		index = 0;
	}
	
	@Override
	public Game parse() throws IOException {
		moveToStart();
		
		readLine();
		String input = readLine();
		
		int lastSpace = input.lastIndexOf("\t");
		String title = input.substring(0, lastSpace);
		int date = Integer.parseInt(input.substring(lastSpace + 1));
		
		Game g = new Game(title, date);
		
		readLine();
		readLine();
		
		//*
		//Process Empires
		while(!(input = readLine()).equals("")) {
			EmpireDAO dao = new EmpireDAOImpl(input);
			g.getEmpires().add(dao.parse());
		}
		
		//Process Weapons
		readLine();
		while(!(input = readLine()).equals("")) {
			WeaponDAO dao = new WeaponDAOImpl(input);
			g.getWeaponTypes().add(dao.parse());
		}
		
		//Process ShipTypes
		readLine();
		while(!(input = readLine()).equals("")) {
			ShipTypeDAO dao = new ShipTypeDAOImpl(input, g);
			g.getShipTypes().add(dao.parse());
		}
		
		//Process Bases
		readLine();
		while(!(input = readLine()).equals("")) {
			BaseDAO dao = new BaseDAOImpl(input, g);
			g.getBases().add(dao.parse());
		}
		
		//Process Ships
		readLine();
		while(!(input = readLine()).equals("")) {
			ShipDAO dao = new ShipDAOImpl(input, g);
			g.getShips().add(dao.parse());
		}
		
		//Process Players
		readLine();
		while(!(input = readLine()).equals("")) {
			PlayerDAO dao = new PlayerDAOImpl(input, g);
			g.getPlayers().add(dao.parse());
		}
		
		return g;
		//*/
	}

}
