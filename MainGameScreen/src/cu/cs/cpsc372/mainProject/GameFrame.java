package cu.cs.cpsc372.mainProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cu.cs.cpsc372.f8l.shared.*;
import javax.swing.SwingConstants;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = -631939195253857820L;
	public Integer stardate;
	private String username;
	private JPanel contentPane;
	private JTable universeTable;
	private JTable sectorTable;
	private JTable attackLog;
	private JTable shipTable;
	private StringTableModel aLog;
	private ShipTableModel shipModel;
	private JLabel stardatelbl;

	/**
	 * Create the frame.
	 */
	public GameFrame(Integer beginDate, String user) {
		super("F8L Frontier");
		
		stardate = beginDate;
		username = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 575);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{160, 160, 0, 0, 92, 94, 94, 0, 0, 0, 0, -131};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		stardatelbl = new JLabel("Stardate: " + stardate.toString());
		stardatelbl.repaint();
		
		stardatelbl.setForeground(SystemColor.activeCaption);
		stardatelbl.setBounds(26, 6, 128, 16);
		stardatelbl.setFont(new Font("Phosphate", Font.BOLD, 30));
		GridBagConstraints gbc_stardatelbl = new GridBagConstraints();
		gbc_stardatelbl.weighty = 1.0;
		gbc_stardatelbl.weightx = 1.0;
		gbc_stardatelbl.gridwidth = 2;
		gbc_stardatelbl.insets = new Insets(15, 5, 5, 5);
		gbc_stardatelbl.gridx = 0;
		gbc_stardatelbl.gridy = 0;
		contentPane.add(stardatelbl, gbc_stardatelbl);
		
		JLabel lblUsername = new JLabel("UserName: " + username);
		lblUsername.setFont(new Font("Phosphate", Font.BOLD, 30));
		lblUsername.setForeground(SystemColor.activeCaption);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.weighty = 1.0;
		gbc_lblUsername.weightx = 1.0;
		gbc_lblUsername.gridwidth = 3;
		gbc_lblUsername.insets = new Insets(15, 5, 5, 15);
		gbc_lblUsername.gridx = 4;
		gbc_lblUsername.gridy = 0;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		JLabel lblUniverse = new JLabel("Universe View");
		lblUniverse.setHorizontalAlignment(SwingConstants.LEFT);
		lblUniverse.setForeground(SystemColor.activeCaption);
		lblUniverse.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblUniverse.setBounds(84, 49, 93, 16);
		GridBagConstraints gbc_lblUniverse = new GridBagConstraints();
		gbc_lblUniverse.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUniverse.weighty = 1.0;
		gbc_lblUniverse.weightx = 1.0;
		gbc_lblUniverse.insets = new Insets(5, 25, 5, 5);
		gbc_lblUniverse.gridx = 0;
		gbc_lblUniverse.gridy = 1;
		contentPane.add(lblUniverse, gbc_lblUniverse);
		
		GameTableModel gtmodel = new GameTableModel();
		///////////////////////future installments should load a game/////////////////////        
		ArrayList<RowOfSectors> game = new ArrayList<RowOfSectors>();

		for(int i=0; i<9; i++) game.add(new RowOfSectors(i));
		Sector currSec = new Sector(1,1,1);
		currSec.playerInSector();
		game.get(2).setSector(4, currSec.toString());
		/////////////////////////////////////////////////////////   
		gtmodel.addGame(game);
		
		universeTable = new JTable(gtmodel);
		universeTable.setGridColor(SystemColor.BLACK);
		universeTable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		universeTable.setBackground(SystemColor.textHighlight);
		universeTable.setCellSelectionEnabled(true);
	/*	if (universeTable.isCellSelected(universeTable.getSelectedRow(), universeTable.getSelectedColumn()
)) universeTable.setForeground(SystemColor.red);*/
		universeTable.setBounds(26, 77, 200, 50);
		GridBagConstraints gbc_universeTable = new GridBagConstraints();
		gbc_universeTable.weighty = 1.0;
		gbc_universeTable.weightx = 1.0;
		gbc_universeTable.gridwidth = 4;
		gbc_universeTable.fill = GridBagConstraints.BOTH;
		gbc_universeTable.gridheight = 5;
		gbc_universeTable.insets = new Insets(5, 25, 0, 5);
		gbc_universeTable.gridx = 0;
		gbc_universeTable.gridy = 2;

		
		universeTable.setShowGrid(true);
		universeTable.setGridColor(SystemColor.controlHighlight);
		contentPane.add(universeTable, gbc_universeTable);
		
		JLabel lblShipDetails = new JLabel("Ship Details");
		lblShipDetails.setForeground(SystemColor.activeCaption);
		lblShipDetails.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		GridBagConstraints gbc_lblShipDetails = new GridBagConstraints();
		gbc_lblShipDetails.weighty = 1.0;
		gbc_lblShipDetails.weightx = 1.0;
		gbc_lblShipDetails.gridwidth = 3;
		gbc_lblShipDetails.insets = new Insets(5, 5, 5, 15);
		gbc_lblShipDetails.gridx = 4;
		gbc_lblShipDetails.gridy = 1;
		contentPane.add(lblShipDetails, gbc_lblShipDetails);

		Ship defaultShip = new Ship(1, null, null, 500, 2, new Alert(), 600);
	
		shipModel = new ShipTableModel("Ship");
		shipModel.readShip(defaultShip);
		shipTable = new JTable(shipModel);
		shipTable.setShowVerticalLines(false);
		shipTable.setShowHorizontalLines(false);
		shipTable.setShowGrid(false);
		shipTable.setRowSelectionAllowed(false);
		shipTable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		shipTable.setForeground(Color.BLACK);
		shipTable.setBackground(SystemColor.textHighlight);
		
		GridBagConstraints gbc_shipTable = new GridBagConstraints();
		gbc_shipTable.weightx = 1.0;
		gbc_shipTable.weighty = 1.0;
		gbc_shipTable.insets = new Insets(5, 5, 25, 5);
		gbc_shipTable.fill = GridBagConstraints.BOTH;
		gbc_shipTable.gridx = 5;
		gbc_shipTable.gridy = 2;
		contentPane.add(shipTable, gbc_shipTable);
		
		JLabel lblAttackLog = new JLabel("Attack Log");
		lblAttackLog.setForeground(SystemColor.activeCaption);
		lblAttackLog.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		GridBagConstraints gbc_lblAttackLog = new GridBagConstraints();
		gbc_lblAttackLog.weighty = 1.0;
		gbc_lblAttackLog.weightx = 1.0;
		gbc_lblAttackLog.gridwidth = 4;
		gbc_lblAttackLog.insets = new Insets(5, 5, 5, 15);
		gbc_lblAttackLog.gridx = 4;
		gbc_lblAttackLog.gridy = 3;
		contentPane.add(lblAttackLog, gbc_lblAttackLog);
		
		JLabel lblSectors = new JLabel("Sector View");
		lblSectors.setHorizontalAlignment(SwingConstants.LEFT);
		lblSectors.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblSectors.setForeground(SystemColor.activeCaption);
		lblSectors.setBounds(101, 188, 77, 16);
		GridBagConstraints gbc_lblSectors = new GridBagConstraints();
		gbc_lblSectors.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSectors.weighty = 1.0;
		gbc_lblSectors.weightx = 1.0;
		gbc_lblSectors.insets = new Insets(5, 25, 5, 5);
		gbc_lblSectors.gridx = 0;
		gbc_lblSectors.gridy = 7;
		contentPane.add(lblSectors, gbc_lblSectors);
		
		
		SectorTableModel sectorModel = new SectorTableModel();
		///////////////////////future installments should load a game/////////////////////        
		sectorModel.updateCell(1, 1, 1);
		sectorModel.updateCell(4, 3, 2);
		sectorModel.updateCell(4, 4, 3);
		sectorModel.updateCell(4, 6, 3);
		sectorModel.updateCell(5, 2, 4);

		/////////////////////////////////////////////////////////   
		//sectorModel.addElements(sector);
		
		sectorTable = new JTable(sectorModel); 
		sectorTable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		sectorTable.setBackground(SystemColor.textHighlight);
		sectorTable.setFillsViewportHeight(true);
		sectorTable.setCellSelectionEnabled(true);
		sectorTable.setBounds(26, 216, 200, 50);
		GridBagConstraints gbc_sectorTable = new GridBagConstraints();
		gbc_sectorTable.weightx = 1.0;
		gbc_sectorTable.weighty = 1.0;
		gbc_sectorTable.gridx = 0;
		gbc_sectorTable.gridwidth = 4;
		gbc_sectorTable.gridheight = 3;
		gbc_sectorTable.fill = GridBagConstraints.BOTH;
		gbc_sectorTable.insets = new Insets(5, 25, 0, 5);
		//gbc_sectorTable.gridx = 0;
		gbc_sectorTable.gridy = 8;
		contentPane.add(sectorTable, gbc_sectorTable);
		
		
		ArrayList<String> defaultALog = new ArrayList<String>();

		for(int i=0; i<20; i++) defaultALog.add("");
		
			defaultALog.add(0, "Kirk joins");
	
		aLog = new StringTableModel(defaultALog, "Actions");
		
		attackLog = new JTable(aLog);
		attackLog.setRowSelectionAllowed(false);
		attackLog.setShowVerticalLines(false);
		attackLog.setShowHorizontalLines(false);
		attackLog.setShowGrid(false);
		attackLog.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		attackLog.setForeground(SystemColor.activeCaption);
		attackLog.setBackground(SystemColor.activeCaptionText);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.gridheight = 7;
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 8;
		gbc_table.gridy = 4;
		gbc_table.weightx = 2;
		gbc_table.weighty = 1;
		contentPane.add(attackLog, gbc_table);
		
		JScrollPane aLogScrollBar = new JScrollPane(attackLog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_aLogScrollBar = new GridBagConstraints();
		gbc_aLogScrollBar.weighty = 1.0;
		gbc_aLogScrollBar.gridwidth = 3;
		gbc_aLogScrollBar.weightx = 2.0;
		gbc_aLogScrollBar.insets = new Insets(5, 5, 5, 25);
		gbc_aLogScrollBar.fill = GridBagConstraints.BOTH;
		gbc_aLogScrollBar.gridheight = 7;
		gbc_aLogScrollBar.gridx = 4;
		gbc_aLogScrollBar.gridy = 4;
		contentPane.add(aLogScrollBar, gbc_aLogScrollBar);
		
		//FALSE DATA/////////////////
		ArrayList<String> defaultPlayers = new ArrayList<String>();
		defaultPlayers.add(username);
		defaultPlayers.add("Player 2");
		StringTableModel model = new StringTableModel(defaultPlayers, "Players");
		/////////////////////////////////////
		
		JLabel lblListOfPlayers = new JLabel("List of Players");
		lblListOfPlayers.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblListOfPlayers.setForeground(SystemColor.activeCaption);
		lblListOfPlayers.setBounds(491, 258, 88, 16);
		GridBagConstraints gbc_lblListOfPlayers = new GridBagConstraints();
		gbc_lblListOfPlayers.insets = new Insets(5, 5, 5, 5);
		gbc_lblListOfPlayers.gridx = 5;
		gbc_lblListOfPlayers.gridy = 11;
		contentPane.add(lblListOfPlayers, gbc_lblListOfPlayers);
		
		JTable playerTable = new JTable(model);
		playerTable.setShowVerticalLines(false);
		playerTable.setShowGrid(false);
		
		//contentPane.add(playerTable);
		JScrollPane scrollBar = new JScrollPane(playerTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(491, 286, 88, 62);
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.insets = new Insets(5, 5, 15, 5);
		gbc_scrollBar.fill = GridBagConstraints.BOTH;
		gbc_scrollBar.gridheight = 2;
		gbc_scrollBar.gridx = 5;
		gbc_scrollBar.gridy = 12;
		contentPane.add(scrollBar, gbc_scrollBar);
		
		addButtons();
		
	}

	private void addButtons() {
		JButton btnScan = new JButton("Scan");
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer secRow = sectorTable.getSelectedRow();
				Integer	secCol = sectorTable.getSelectedColumn();
				Integer univRow = universeTable.getSelectedRow();
				Integer	univCol = universeTable.getSelectedColumn();
				//Ship tmp = shipModel.getUserShip();
				
				Object[] options = {"Sector", "Ship", "Cancel"};
				Object[] confirm = {"Yes", "No"};
				  int n = JOptionPane.showOptionDialog(null,
					  "What would you like to scan?",
					  "Scan",
					  JOptionPane.YES_NO_CANCEL_OPTION,
					  JOptionPane.QUESTION_MESSAGE,
					  null,
					  options,
					  options[2]);
					  
					  switch(n) {
					  	case 0:
					  		if(univRow > 0 && univCol > 0){
								String newSector = "(" + univRow.toString() + "," + univCol.toString() + ")";
					  			int m = JOptionPane.showOptionDialog(null,
										  "Are you sure you want to scan sector at " +
										  newSector + "?",
										  "ScanSectorConfirm",
										  JOptionPane.YES_NO_CANCEL_OPTION,
										  JOptionPane.QUESTION_MESSAGE,
										  null,
										  confirm,
										  confirm[1]);
									  
										  if (m == 0) {
//											  energy-=100;
//											  tmp.setEnergy(energy);
//											  shipModel.setUserShip(tmp);
//											  shipModel.readShip(tmp);
//											  aLog.addElement(stardate + ": " + username + " warped to " + newSector);
//											  updateStardate();
											  JOptionPane.showMessageDialog(null, "Sector" + newSector + "was scanned", "Scanned", JOptionPane.INFORMATION_MESSAGE);
										  }
							}
					  		else{
								JOptionPane.showMessageDialog(null, "You must select a sector!", "ScanError", JOptionPane.WARNING_MESSAGE);
					  		}
					  		break;
					  	case 1:
					  		if(secRow > 0 && secCol > 0){
					  			/////////confirm a ship is here//////////
					  			String newLocation = "(" + secRow.toString() + "," + secCol.toString() + ")";
					  			int m = JOptionPane.showOptionDialog(null,
										  "Are you sure you want to scan " +
										  newLocation + "?",
										  "ScanConfirm",
										  JOptionPane.YES_NO_CANCEL_OPTION,
										  JOptionPane.QUESTION_MESSAGE,
										  null,
										  confirm,
										  confirm[1]);
									  
										  if (m == 0) {
//											  energy-=10;
//											  tmp.setEnergy(energy);
//											  shipModel.setUserShip(tmp);
//											  shipModel.readShip(tmp);
//											  aLog.addElement(stardate + ": " + username + " moved to " + newLocation);
//											  updateStardate();
											  JOptionPane.showMessageDialog(null, "Ship at location " + newLocation + "was scanned", "Scanned", JOptionPane.INFORMATION_MESSAGE);
										  }
							}
					  		else{
								JOptionPane.showMessageDialog(null, "You must select a location!", "ImpulseError", JOptionPane.WARNING_MESSAGE);
					  		}
					  		break;
					  	default: break;
					  }
				
			}
		});
		GridBagConstraints gbc_btnScan = new GridBagConstraints();
		gbc_btnScan.weighty = 1.0;
		gbc_btnScan.weightx = 1.0;
		gbc_btnScan.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnScan.insets = new Insets(5, 5, 5, 5);
		gbc_btnScan.gridx = 0;
		gbc_btnScan.gridy = 11;
		contentPane.add(btnScan, gbc_btnScan);
		
		JButton btnAlert = new JButton("Set Alert");
		btnAlert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ship tmp = shipModel.getUserShip();
				
				Object[] options = {"Increase", "Decrease", "Cancel"};
				  int n = JOptionPane.showOptionDialog(null,
					  "How would you like to set the alert level?",
					  "Alert",
					  JOptionPane.YES_NO_CANCEL_OPTION,
					  JOptionPane.QUESTION_MESSAGE,
					  null,
					  options,
					  options[2]);
				  
				  	switch (n){
				  		case 0: tmp.getAlert().increase();
						  		shipModel.setUserShip(tmp);
						  		shipModel.readShip(tmp);
								aLog.addElement(stardate + ": " + username + " increased Alert to " + shipModel.getUserShip().getAlert().getLevel());
								updateStardate();
				  				break;
				  		case 1: tmp.getAlert().decrease();
				  		
				  				shipModel.setUserShip(tmp);
				  				shipModel.readShip(tmp);
				  				aLog.addElement(stardate + ": " + username + " decreased Alert to " + shipModel.getUserShip().getAlert().getLevel());
								updateStardate();
				  				break;
				  		default:break;
				  	}
					 
			}
		});
		btnAlert.setBounds(134, 298, 129, 29);
		GridBagConstraints gbc_btnAlert = new GridBagConstraints();
		gbc_btnAlert.weighty = 1.0;
		gbc_btnAlert.weightx = 1.0;
		gbc_btnAlert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAlert.insets = new Insets(5, 5, 5, 5);
		gbc_btnAlert.gridx = 1;
		gbc_btnAlert.gridy = 12;
		contentPane.add(btnAlert, gbc_btnAlert);
		
		JButton btnNavigate = new JButton("Navigate");
		btnNavigate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer secRow = sectorTable.getSelectedRow();
				Integer	secCol = sectorTable.getSelectedColumn();
				Integer univRow = universeTable.getSelectedRow();
				Integer	univCol = universeTable.getSelectedColumn();
				Ship tmp = shipModel.getUserShip();
				int energy = tmp.getEnergy();
				
				Object[] options = {"Warp", "Impulse", "Cancel"};
				Object[] confirm = {"Yes", "No"};
				  int n = JOptionPane.showOptionDialog(null,
					  "How would you like to navigate?",
					  "Navigate",
					  JOptionPane.YES_NO_CANCEL_OPTION,
					  JOptionPane.QUESTION_MESSAGE,
					  null,
					  options,
					  options[2]);
					  
					  switch(n) {
					  	case 0:
					  		if(univRow > 0 && univCol > 0){
								String newSector = "(" + univRow.toString() + "," + univCol.toString() + ")";
					  			int m = JOptionPane.showOptionDialog(null,
										  "Are you sure you want to warp to " +
										  newSector + "?",
										  "WarpConfirm",
										  JOptionPane.YES_NO_CANCEL_OPTION,
										  JOptionPane.QUESTION_MESSAGE,
										  null,
										  confirm,
										  confirm[1]);
									  
										  if (m == 0) {
											  energy-=100;
											  tmp.setEnergy(energy);
											  shipModel.setUserShip(tmp);
											  shipModel.readShip(tmp);
											  aLog.addElement(stardate + ": " + username + " warped to " + newSector);
											  updateStardate();
										  }
							}
					  		else{
								JOptionPane.showMessageDialog(null, "You must select a new sector!", "WarpError", JOptionPane.WARNING_MESSAGE);
					  		}
					  		break;
					  	case 1:
					  		if(secRow > 0 && secCol > 0){
					  			String newLocation = "(" + secRow.toString() + "," + secCol.toString() + ")";
					  			int m = JOptionPane.showOptionDialog(null,
										  "Are you sure you want to move to " +
										  newLocation + "?",
										  "ImpulseConfirm",
										  JOptionPane.YES_NO_CANCEL_OPTION,
										  JOptionPane.QUESTION_MESSAGE,
										  null,
										  confirm,
										  confirm[1]);
									  
										  if (m == 0) {
											  energy-=10;
											  tmp.setEnergy(energy);
											  shipModel.setUserShip(tmp);
											  shipModel.readShip(tmp);
											  aLog.addElement(stardate + ": " + username + " moved to " + newLocation);
											  updateStardate();
										  }
							}
					  		else{
								JOptionPane.showMessageDialog(null, "You must select a new location!", "ImpulseError", JOptionPane.WARNING_MESSAGE);
					  		}
					  		break;
					  	default: break;
					  }
				
			}
		});
		btnNavigate.setBounds(6, 325, 129, 29);
		GridBagConstraints gbc_btnNavigate = new GridBagConstraints();
		gbc_btnNavigate.weighty = 1.0;
		gbc_btnNavigate.weightx = 1.0;
		gbc_btnNavigate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNavigate.insets = new Insets(5, 5,  5, 5);
		gbc_btnNavigate.gridx = 0;
		gbc_btnNavigate.gridy = 12;
		contentPane.add(btnNavigate, gbc_btnNavigate);
		
		JButton btnRefresh = new JButton("Refresh Display");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aLog.addElement(stardate + ": No Action done");
				JOptionPane.showMessageDialog(null,
						  "Refreshed the window with new Stardate",
						  "Refresh",
						  JOptionPane.WARNING_MESSAGE);
				updateStardate();
			}
		});
		btnRefresh.setBounds(6, 297, 129, 31);
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.weighty = 1.0;
		gbc_btnRefresh.weightx = 1.0;
		gbc_btnRefresh.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRefresh.insets = new Insets(5, 5, 15, 5);
		gbc_btnRefresh.gridx = 0;
		gbc_btnRefresh.gridy = 13;
		contentPane.add(btnRefresh, gbc_btnRefresh);
		
		JButton btnFire = new JButton("Fire Missile");
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer r = sectorTable.getSelectedRow();
				Integer	c = sectorTable.getSelectedColumn();
				
				if(r > 0 && c > 0){
					String fireLocation = "(" + r.toString() + "," + c.toString() + ")";
					Ship tmp = shipModel.getUserShip();
					int missiles = tmp.getMissiles();
	
					if(missiles>0){
					  Object[] options = {"Fire Missile", "Cancel"};
					  int n = JOptionPane.showOptionDialog(null,
						  "Do you want to fire a missile at " +
						  fireLocation + "?",
						  "Delete",
						  JOptionPane.YES_NO_CANCEL_OPTION,
						  JOptionPane.QUESTION_MESSAGE,
						  null,
						  options,
						  options[1]);
					  
						  if (n == 0) {
							  missiles--;
							  tmp.setMissiles(missiles);
							  shipModel.setUserShip(tmp);
							  shipModel.readShip(tmp);
							  aLog.addElement(stardate + ": " + username + " fired missile at " + fireLocation + "; " + "target " + "shields now at 888");
							  updateStardate();
						  }
					  }
					  else{
						  JOptionPane.showMessageDialog(null,
								  "No missiles",
								  null,
								  JOptionPane.WARNING_MESSAGE);
					  }
					
					System.out.println(stardate);				
				}
				else{
					JOptionPane.showMessageDialog(null, "You must select a location to attack!", "Fire", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnFire.setBounds(134, 325, 129, 29);
		GridBagConstraints gbc_btnFire = new GridBagConstraints();
		gbc_btnFire.weightx = 1.0;
		gbc_btnFire.weighty = 1.0;
		gbc_btnFire.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFire.insets = new Insets(5, 5, 15, 5);
		gbc_btnFire.gridx = 1;
		gbc_btnFire.gridy = 13;
		contentPane.add(btnFire, gbc_btnFire);
		
	}
	
	private void updateStardate(){
		stardate++;
		stardatelbl.setText("Stardate: " + stardate.toString());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
