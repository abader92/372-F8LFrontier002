package cu.cs.cpsc372.mainProject;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ConfigurationDlg extends JDialog {

	private static final long serialVersionUID = -7789052029524489023L;
	private ArrayList<JTextField> fields = new ArrayList<JTextField>(); 
	
    public ConfigurationDlg() {
        setSize(300, 230);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	JPanel text = setupText();
    	getContentPane().add(setupText());
    	getContentPane().add(text);
    	setupButtons();
 
    }
    protected JPanel setupText()  {

		String[] labels = {"IP Address: ", "Port Number: ", "Username: ", "Password: "};
		int numPairs = labels.length;
		
        JPanel textPanel = new JPanel(new SpringLayout());
        String text[] = new String[4];
        
        for (int i = 0; i < numPairs; i++) {
            JLabel label = new JLabel(labels[i], JLabel.TRAILING);
            textPanel.add(label);
            JTextField textField = new JTextField(text[i]);
            
            label.setLabelFor(textField);
            textPanel.add(textField);
           // Save the references to the text field so we can access them later
            fields.add(textField);
        }
          //Lay out the panel
//             Uses a class provided by Oracle SpringUtilities.java
            SpringUtilities.makeCompactGrid(textPanel,
                                            numPairs, 2, //rows, cols
                                            3, 3,        //initX, initY
                                            3, 3);       //xPad, yPad
    		return textPanel;
	}
		
	private void setupButtons() {

	   	JPanel buttonPanel = new JPanel();
    	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    	
    	JButton saveButton = new JButton("Login");
    	// Will do the saving in configuration
       	saveButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {   
    			String pass = fields.get(3).getText();
    			System.out.println(pass);
    			if(pass.equalsIgnoreCase("p")){
    				myFrame mf = new myFrame();
    				mf.setVisible(true);
    				dispose();

    			}
    			else{
    				JOptionPane.showMessageDialog(null, "Incorrect Password", "Hi", JOptionPane.WARNING_MESSAGE, null);
    			}
//    				DataStore.getInstance().setConfiguration(new Configuration(newIPAddress, newPortNum));
            }
         });
    	
    	JButton cancelButton = new JButton("Cancel");
    	cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
            	// Closes and destroys the window object
            	dispose();
            }
         }); 
    	
    	buttonPanel.add(saveButton);
    	buttonPanel.add(cancelButton);
    	getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
	}

}
