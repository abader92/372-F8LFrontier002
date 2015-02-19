package cu.cs.cpsc372.mainProject;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Mainframe extends JFrame {
	private static final long serialVersionUID = -9111343199861137734L;
	JTable table;
	JMenu projectMenu;
	//ProjectTableModel model;
	JMenuBar menuBar;
	
	public Mainframe() {
		super("F8L Frontier");
		
		//DataStore.getInstance().loadConfiguration();
        // JFrame Properties
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
		addMenu();
        // Add the table to the window
		addUniverse();
		addSector();
        addButtons();
	}

	private void addMenu() {
		// Menu Bar
        menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		
		projectMenu = new JMenu("File");
		// The exit button
		JMenuItem exitItem = new JMenuItem("Exit");
		// Exit action Listener. Stores the data in the DataStore when the program exits.
		exitItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			  // Store the data
			/*  try {
				DataStore.getInstance().storeConfiguration();
			} catch (IOException e) {
				System.out.println("Could not store configuration.");
			} */
			  System.exit(0);
		  }
		});
		
		projectMenu.add(exitItem);
		// Adds a listener to the window itself. If a user clicks the exit button, the preceding method isn't called and the data isn't saved.
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
  			/*  try {
				DataStore.getInstance().storeConfiguration();
			} catch (IOException e1) {
				System.out.println("Could not store configuration.");
			} */
  			  System.exit(0);
            }
        });
		
		menuBar.add(projectMenu);
		setJMenuBar(menuBar);
	}

	private void addUniverse() { 
		GameTableModel model = new GameTableModel();
        table = new JTable(model);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 16));
        table.setFont(new Font("Verdana", Font.PLAIN, 15));
        table.setGridColor(Color.BLACK);
///////////////////////future installments should load a game/////////////////////        
        ArrayList<RowOfSectors> game = new ArrayList<RowOfSectors>();
        
        for(int i=0; i<9; i++) game.add(new RowOfSectors(i));
     /////////////////////////////////////////////////////////   
        model.addGame(game);

        JScrollPane scrollPanel = new JScrollPane(table);
        getContentPane().add(scrollPanel, BorderLayout.NORTH); 
	}
	
	private void addSector() { 
		GameTableModel model = new GameTableModel();
        table = new JTable(model);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 16));
        table.setFont(new Font("Verdana", Font.PLAIN, 15));
        table.setGridColor(Color.BLACK);
///////////////////////future installments should load a game/////////////////////        
        ArrayList<RowOfSectors> game = new ArrayList<RowOfSectors>();
        
        for(int i=1; i<9; i++) game.add(new RowOfSectors(i));
     /////////////////////////////////////////////////////////   
        model.addGame(game);

        JScrollPane scrollPanel = new JScrollPane(table);
        getContentPane().add(scrollPanel, BorderLayout.SOUTH); 
	}
	
	// Adds buttons to the MainFrame
	private void addButtons() {
		JPanel buttonPanel = new JPanel(); 
		// Align the buttons left
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
			 
			}
		});
		
		JButton navigateButton = new JButton("Navigate");
		navigateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
			}
		});
		
		JButton alertButton = new JButton("Set Alert");
		alertButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
			}
		});
		
		JButton fireButton = new JButton("Fire Missile");
		fireButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
			}
		});
		
		buttonPanel.add(refreshButton);
		buttonPanel.add(navigateButton);
		buttonPanel.add(alertButton);
		buttonPanel.add(fireButton);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		
		
		
		
		
	}
}
