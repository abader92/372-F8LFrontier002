package cu.cs.cpsc372.f8l.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cu.cs.cpsc372.f8l.shared.Game;

public class GameDAOFileImpl implements GameDAO {

	File data;
	
	public GameDAOFileImpl( File data ) {
		this.data = data;
	}
	
	@Override
	public Game parse() throws IOException {
		BufferedReader textReader;
		FileReader fr = new FileReader(data);
		textReader = new BufferedReader(fr);
		
		textReader.readLine();
		String input = textReader.readLine();
		
		int lastSpace = input.lastIndexOf("\t");
		String title = input.substring(0, lastSpace);
		int date = Integer.parseInt(input.substring(lastSpace + 1));
		
		Game g = new Game(title, date);
		
		textReader.readLine();
		textReader.readLine();
		
		//Process Empires
		while(!(input = textReader.readLine()).equals("")) {
			EmpireDAO dao = new EmpireDAOImpl(input);
			g.getEmpires().add(dao.parse());
		}
		
		//Process Weapons
		textReader.readLine();
		while(!(input = textReader.readLine()).equals("")) {
			WeaponDAO dao = new WeaponDAOImpl(input);
			g.getWeaponTypes().add(dao.parse());
		}
		
		//Process ShipTypes
		textReader.readLine();
		while(!(input = textReader.readLine()).equals("")) {
			ShipTypeDAO dao = new ShipTypeDAOImpl(input, g);
			g.getShipTypes().add(dao.parse());
		}
		
		//Process Bases
		textReader.readLine();
		while(!(input = textReader.readLine()).equals("")) {
			BaseDAO dao = new BaseDAOImpl(input, g);
			g.getBases().add(dao.parse());
		}
		
		//Process Ships
		textReader.readLine();
		while(!(input = textReader.readLine()).equals("")) {
			ShipDAO dao = new ShipDAOImpl(input, g);
			g.getShips().add(dao.parse());
		}
		
		//Process Players
		textReader.readLine();
		while(!(input = textReader.readLine()).equals("")) {
			PlayerDAO dao = new PlayerDAOImpl(input, g);
			g.getPlayers().add(dao.parse());
		}
		
		return g;
	}

}
