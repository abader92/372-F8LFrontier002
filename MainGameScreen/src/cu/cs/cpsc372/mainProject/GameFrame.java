package cu.cs.cpsc372.mainProject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import cu.cs.cpsc372.F8LSHARED.Ship;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = -631939195253857820L;
	private Integer stardate;
	private JPanel contentPane;
	private JTable universeTable;
	private JTable sectorTable;
	private JTable attackLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//default begin date is 2054
					int beginDate = 2054;
					GameFrame frame = new GameFrame(beginDate);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame(Integer beginDate) {
		super("F8L Frontier");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel stardatelbl = new JLabel("Stardate: " + beginDate.toString());
		stardatelbl.setBounds(26, 6, 128, 16);
		stardatelbl.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_stardatelbl = new GridBagConstraints();
		gbc_stardatelbl.insets = new Insets(5, 5,  5, 5);
		gbc_stardatelbl.gridx = 0;
		gbc_stardatelbl.gridy = 0;
		contentPane.add(stardatelbl, gbc_stardatelbl);
		
		JLabel lblUniverse = new JLabel("Universe View");
		lblUniverse.setBounds(84, 49, 93, 16);
		GridBagConstraints gbc_lblUniverse = new GridBagConstraints();
		gbc_lblUniverse.insets = new Insets(5, 5,  5, 5);
		gbc_lblUniverse.gridx = 0;
		gbc_lblUniverse.gridy = 1;
		contentPane.add(lblUniverse, gbc_lblUniverse);
		
		GameTableModel gtmodel = new GameTableModel();
		///////////////////////future installments should load a game/////////////////////        
		ArrayList<RowOfSectors> game = new ArrayList<RowOfSectors>();

		for(int i=0; i<9; i++) game.add(new RowOfSectors(i));
		/////////////////////////////////////////////////////////   
		gtmodel.addGame(game);
		
		universeTable = new JTable(gtmodel);
		universeTable.setCellSelectionEnabled(true);
		universeTable.setBounds(26, 77, 200, 50);
		GridBagConstraints gbc_universeTable = new GridBagConstraints();
		gbc_universeTable.gridwidth = 3;
		gbc_universeTable.fill = GridBagConstraints.BOTH;
		gbc_universeTable.gridheight = 4;
		gbc_universeTable.insets = new Insets(5, 5,  5, 5);
		gbc_universeTable.gridx = 0;
		gbc_universeTable.gridy = 2;
		for(int i=1; i <9; i++){
			universeTable.getColumnModel().getColumn(i).setPreferredWidth(180);
		}
		
		JLabel lblShipDetails = new JLabel("Ship Details");
		GridBagConstraints gbc_lblShipDetails = new GridBagConstraints();
		gbc_lblShipDetails.insets = new Insets(5, 5,  5, 0);
		gbc_lblShipDetails.gridx = 9;
		gbc_lblShipDetails.gridy = 1;
		contentPane.add(lblShipDetails, gbc_lblShipDetails);
		//universeTable.getColumnModel().getColumn(1).setPreferredWidth(180);
	 		//universeTable.getColumnModel().getColumn(2).setPreferredWidth(180);

		universeTable.setShowGrid(true);
		contentPane.add(universeTable, gbc_universeTable);
				

		Ship defaultShip = new Ship(1, null, null, 500, 200, null, 600);

	
		ShipTableModel shipModel = new ShipTableModel("Ship");
		shipModel.readShip(defaultShip);
		JTable shipTable = new JTable(shipModel);
		
		GridBagConstraints gbc_shipTable = new GridBagConstraints();
		gbc_shipTable.insets = new Insets(0, 0, 5, 0);
		gbc_shipTable.fill = GridBagConstraints.BOTH;
		gbc_shipTable.gridx = 9;
		gbc_shipTable.gridy = 2;
		contentPane.add(shipTable, gbc_shipTable);
		
		JLabel lblAttackLog = new JLabel("Attack Log");
		GridBagConstraints gbc_lblAttackLog = new GridBagConstraints();
		gbc_lblAttackLog.insets = new Insets(5, 5,  5, 0);
		gbc_lblAttackLog.gridx = 9;
		gbc_lblAttackLog.gridy = 3;
		contentPane.add(lblAttackLog, gbc_lblAttackLog);
		
		
		JLabel lblSectors = new JLabel("Sector View");
		lblSectors.setBounds(101, 188, 77, 16);
		GridBagConstraints gbc_lblSectors = new GridBagConstraints();
		gbc_lblSectors.insets = new Insets(5, 5,  5, 5);
		gbc_lblSectors.gridx = 0;
		gbc_lblSectors.gridy = 7;
		contentPane.add(lblSectors, gbc_lblSectors);
		
		
		SectorTableModel sectorModel = new SectorTableModel();
		///////////////////////future installments should load a game/////////////////////        

		/////////////////////////////////////////////////////////   
		//sectorModel.addElements(sector);
		
		sectorTable = new JTable(sectorModel); 
		sectorTable.setBounds(26, 216, 200, 50);
		GridBagConstraints gbc_sectorTable = new GridBagConstraints();
		gbc_sectorTable.gridx = 0;
		gbc_sectorTable.gridwidth = 3;
		gbc_sectorTable.gridheight = 3;
		gbc_sectorTable.fill = GridBagConstraints.BOTH;
		gbc_sectorTable.insets = new Insets(5, 5,  5, 5);
		//gbc_sectorTable.gridx = 0;
		gbc_sectorTable.gridy = 8;
		contentPane.add(sectorTable, gbc_sectorTable);
		
		
		ArrayList<String> defaultALog = new ArrayList<String>();
		defaultALog.add("Player 1 warps");
		defaultALog.add("Player 2 raises shields");
	
		StringTableModel aLog = new StringTableModel(defaultALog, "Actions");
		attackLog = new JTable(aLog);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 7;
		gbc_table.insets = new Insets(5, 5,  5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 9;
		gbc_table.gridy = 4;
		contentPane.add(attackLog, gbc_table);
		
		JLabel lblListOfPlayers = new JLabel("List of Players");
		lblListOfPlayers.setBounds(491, 258, 88, 16);
		GridBagConstraints gbc_lblListOfPlayers = new GridBagConstraints();
		gbc_lblListOfPlayers.insets = new Insets(5, 5,  5, 0);
		gbc_lblListOfPlayers.gridx = 9;
		gbc_lblListOfPlayers.gridy = 11;
		contentPane.add(lblListOfPlayers, gbc_lblListOfPlayers);
		
		//FALSE DATA/////////////////
		ArrayList<String> defaultPlayers = new ArrayList<String>();
		defaultPlayers.add("Player 1");
		defaultPlayers.add("Player 2");
		StringTableModel model = new StringTableModel(defaultPlayers, "Players");
		JTable playerTable = new JTable(model);
	
		contentPane.add(playerTable);
		JScrollPane scrollBar = new JScrollPane(playerTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(491, 286, 88, 62);
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.gridheight = 2;
		gbc_scrollBar.fill = GridBagConstraints.BOTH;
		gbc_scrollBar.gridx = 9;
		gbc_scrollBar.gridy = 12;
		contentPane.add(scrollBar, gbc_scrollBar);
		
		addButtons();
		
	}

	private void addButtons() {
		JButton btnAlert = new JButton("Set Alert");
		btnAlert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlert.setBounds(134, 298, 129, 29);
		GridBagConstraints gbc_btnAlert = new GridBagConstraints();
		gbc_btnAlert.insets = new Insets(5, 5, 5, 5);
		gbc_btnAlert.gridx = 1;
		gbc_btnAlert.gridy = 12;
		contentPane.add(btnAlert, gbc_btnAlert);
		
		JButton btnNavigate = new JButton("Navigate");
		btnNavigate.setBounds(6, 325, 129, 29);
		GridBagConstraints gbc_btnNavigate = new GridBagConstraints();
		gbc_btnNavigate.insets = new Insets(5, 5,  5, 5);
		gbc_btnNavigate.gridx = 0;
		gbc_btnNavigate.gridy = 12;
		contentPane.add(btnNavigate, gbc_btnNavigate);
		
		
		JButton btnRefresh = new JButton("Refresh Display");
		btnRefresh.setBounds(6, 297, 129, 31);
		GridBagConstraints gbc_btnRefresh = new GridBagConstraints();
		gbc_btnRefresh.insets = new Insets(5, 5,  0, 5);
		gbc_btnRefresh.gridx = 0;
		gbc_btnRefresh.gridy = 13;
		contentPane.add(btnRefresh, gbc_btnRefresh);
		
		JButton btnFire = new JButton("Fire Missile");
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFire.setBounds(134, 325, 129, 29);
		GridBagConstraints gbc_btnFire = new GridBagConstraints();
		gbc_btnFire.insets = new Insets(5, 5,  0, 5);
		gbc_btnFire.gridx = 1;
		gbc_btnFire.gridy = 13;
		contentPane.add(btnFire, gbc_btnFire);
		
	}
	
	@SuppressWarnings("unused")
	private void updateStardate(){
		stardate++;
	}
}
