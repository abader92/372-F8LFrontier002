package cu.cs.cpsc372.mainProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

public class myFrame extends JFrame {
	private static final long serialVersionUID = -9111343199861137734L;
	JTable table;
	JMenu projectMenu;
	JMenuBar menuBar;
	
	public myFrame() {
		super("F8L Frontier");
		
        // JFrame Properties
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
		addMenu();
        // Add the table to the window
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
  			  
  			  System.exit(0);
            }
        });
		
		JMenu configMenu = new JMenu("Configuration");
		JMenuItem configMenuItem = new JMenuItem("Configure");
		// Config action Listener
		configMenuItem.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			  ConfigurationDlg dlg = new ConfigurationDlg();
			  dlg.setVisible(true);
		  }
		});
		configMenu.add(configMenuItem);
				
	}

	// Adds buttons to the MainFrame
	private void addButtons() {
		JPanel buttonPanel = new JPanel(); 
		// Align the buttons left
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		JButton refreshButton = new JButton("Join Game");
		refreshButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent event)
		  {
			  	setVisible(false);
			  	int beginDate = 2054;
				String user = "Kirk";
				GameFrame frame = new GameFrame(beginDate, user);
				frame.setResizable(false);
				frame.setVisible(true);
				frame.addWindowListener(new GameWindowListener()
				{
					public void windowClosed(WindowEvent e){
						setVisible(true);
					}
				});
		  }
		});
		
		buttonPanel.add(refreshButton);
		getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		
	}
}
