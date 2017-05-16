import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.text.DefaultCaret;
/**************************************************************
 * This class is used to handle population of the User interface
 * There will  be methods however to allow interfacing with the 
 * panels inorder to display text to them
 * 
 * 
 * 
 * 
 ***************************************************************/

public class UserInterface extends JFrame{
	//get the user computer name to used as a display for the top of the jFrame
	protected String clientComputerName = System.getProperty("user.name");
	
	private String dir = System.getProperty("user.dir");
	
	public UserInterface(){
		//set up this window properties
		adjustWindowProperties();
		//gather the required panels to add into the main panels
		JPanel terminalPanel = makeTerminalPanel();
		JPanel controlPanel = makeControlPanel();
		JPanel bottomPanel = makeBottomPanel();
		JMenuBar menuBar = makeMenuBar();
		
		//add all the sub panels to the main panel
		getContentPane().add(terminalPanel);
		getContentPane().add(controlPanel, BorderLayout.LINE_END);
		getContentPane().add(bottomPanel, BorderLayout.PAGE_END);
		//add the JmenuBar
		setJMenuBar(menuBar);
		//adds a WINDOW listener to test on text scenarios
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.out.println("WE OUT HERE FAM");
			}
		});
	
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	
	/**************************************************************************
	 * Function: MakeTerminalPanel
	 *  
	 * Description:
	 * 	-> This function is created to populate the panel for the terminal
	 * display also known as the chat log, which is incoming and out going
	 * traffic
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JPanel makeTerminalPanel(){
		JPanel terminalPanel = new JPanel();
		//set the layout manager for the terminal panel
		terminalPanel.setLayout(new GridLayout());
		//set the size of the terminal panel
		terminalPanel.setSize(400,200); //set size of the terminal panel
		//give the panel border
		terminalPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Terminal Channel Chat"));
		//put a nice border around our terminal panel, and some title text
		
		
		JTextArea terminalMsgDisplay = new JTextArea();
		//new InputThread(this.IRCObject, terminalMsgDisplay).start(); //made a thread here and attached it to the textArea to output
		
		DefaultCaret caret = (DefaultCaret)terminalMsgDisplay.getCaret();//auto scroll policy needs to make changes
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		terminalMsgDisplay.setCaretPosition(terminalMsgDisplay.getDocument().getLength());
		
		//IRCObject.setIncommingMsg(terminalMsgDisplay); send messages to the jtextArea
		//add the scrooll pane
		JScrollPane terminalScrollPane = new JScrollPane(terminalMsgDisplay);//this is how you use a JScroll Pane DO not USE .add just throw in your text field into the constructor and let everything do the rest
		
		terminalScrollPane.setMaximumSize(new Dimension(100, 400));
	
		// makes instance of scroll Pane for our terminals text to be placed into
	
	
		
	
		

		
		//terminalMsgDisplay.append("This is Where text will be displayed from Using input and output Threads ");
		
		terminalMsgDisplay.setLineWrap(true);
		terminalMsgDisplay.setWrapStyleWord(true);

		terminalPanel.add(terminalScrollPane);
		
		//getContentPane().add(terminalPanel);
		
		return terminalPanel;
		
	}
	/**********************************************************************
	 * Function makeControlPanel
	 * Desciptions: uses group layout to group the right most control
	 * panel of thje User interface this includes the following:
	 * 	-> github links
	 * 	->facebook Links
	 * 	->websitelinks
	 * 
	 * 
	 * 
	 */
	
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JPanel makeControlPanel(){
		//controlPanel
		
				JPanel rightPane = createAndSetJPanel(new BorderLayout(), 250, 240);
				
				
				//JPanel controlPanel = new JPanel(new BorderLayout());
				JPanel controlPanel = createAndSetJPanel(new BorderLayout(), 250, 240);
				//sets a border for the JPanel
				setBorderOnPanel(controlPanel, "Control Panel");
				
				
				JPanel controlPanelButton = createAndSetJPanel(new GridLayout(0,2,5,5), 50, 50);

				
				
				/******************************************************
				 * Idea:
				 * make seperate instances of a channel, and point thier output to the textfield
				 * keep making different instances and have them connected  to the Jtextfield
				 * 
				 * 
				 * 
				 */
				
				
				
				
				
				
				
				//JPanel controlPanelButton = new JPanel(new GridLayout(0,2,5,5));
				
				//controlPanelButton.setPreferredSize(new Dimension(50, 50));
				//controlPanel.setLayout(new GridLayout(3,3,10,30));

				
				
				
				HashMap hashmap = new HashMap<String, nodeTest<String>>();
				ArrayList<nodeTest> list = new ArrayList<nodeTest>();
				//DefaultListModel listModel = new DefaultListModel(hashmap); // this extends list, basically a list structure

				
				
				//hashmap.put();
				
				//Hashtable<String, Object> table = new Hashtable<String,Object>();

				//JPanel channelListpane = new JPanel();
				
				DefaultListModel<nodeTest> list1 = new DefaultListModel<nodeTest>();
				for(int i =0; i < 5; i++){
					nodeTest temp = new nodeTest<String>();
					list1.addElement(temp);
				}
				
				JList ChannelList = new JList(list1); // this class uses generics to have a type for the items within a data structure
				ChannelList.setLayoutOrientation(JList.VERTICAL);
				ChannelList.setPreferredSize(new Dimension(130,5));
				
				
				
				
				
				
				
				
				
				
				
				JButton[] controlButton = setLabelOnButton(new String[]{"Add Chan","Remove Chan","Button 1", "Button 2"}, controlPanelButton);

				
				controlButton[0].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String temp = JOptionPane.showInputDialog("Input some message/Channel to join");
						
						list1.addElement(new nodeTest(temp));
						/*
						for(int i =0; i < 20; i++){
							tet.addElement("Blah " + i * Math.random()*5);
						}
						tet.addElement(temp);
						
					*/
					}
					
				});

				controlButton[1].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int index = ChannelList.getSelectedIndex();
						if(index <0){
							JOptionPane.showMessageDialog(null, "No items selected, please seletec a channel");
						}else{
							list1.remove(index);
							System.out.println(index);
							//getSelectedIndecies will return an int[] with multiple indexes seleteced
						}
					}
				});

				
				
				//JPanel blankPan = new JPanel();
				
				JScrollPane listScroll = new JScrollPane(ChannelList);
				
				listScroll.setPreferredSize(new Dimension(140,100)); //wideX hiegth of the JList size

				
				
				
				JPanel channelDisplay = new JPanel(new BorderLayout());
				


				channelDisplay.add(new JLabel("Channel Listing:"), BorderLayout.PAGE_START);
				channelDisplay.add(listScroll, BorderLayout.LINE_END);

				
				
				
				
				
				
				


				//icons must be sized gif/png .. etc 16x16, 32x32, 64x64x 128x128


				
				JPanel botLink = new JPanel(new FlowLayout(FlowLayout.RIGHT,3,3));
				
				JButton[] setButton = createCustomJButton(new ImageIcon[] {new ImageIcon(dir + "\\test1.gif","Check out my GitHub!"),new ImageIcon(dir + "\\test.png","Want to see amazing projects, check this guy out!"),new ImageIcon(dir + "\\linkdin.png","want to connect? :D")} , botLink);

				
				setButton[0].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try{
							Desktop.getDesktop().browse(new URI("https://github.com/damugen123"));
						}catch(Exception q){
							q.printStackTrace();
						}
					}
				});
				
				setButton[1].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							Desktop.getDesktop().browse(new URI("https://github.com/Maome"));
						}catch(Exception qq){
							qq.printStackTrace();
						}
					}
				});
				
				
				setButton[2].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try{
							Desktop.getDesktop().browse(new URI("www.linkedin.com/in/dannyly0/"));
						}catch(Exception qq){
							qq.printStackTrace();
						}
					}
				});
				
				
				//controlPanel.add(new JLabel("test"),BorderLayout.LINE_END);

				//controlPanel.add(botLink, BorderLayout.SOUTH);
			
				
				controlPanel.add(controlPanelButton, BorderLayout.NORTH);
				
				controlPanel.add(channelDisplay, BorderLayout.CENTER);
			

				
				rightPane.add(controlPanel,BorderLayout.PAGE_START);
				
				rightPane.add(botLink,BorderLayout.PAGE_END);
				
				//controlPanel.add(topInformationPanel,BorderLayout.NORTH);
				//getContentPane().add(controlPanel, BorderLayout.LINE_END);
				
				
				getContentPane().add(rightPane, BorderLayout.LINE_END);
			return rightPane;
				
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private void adjustWindowProperties(){
		//set THIS Jframes title
		setTitle(clientComputerName + " Chat Client");		
		//set THIS Jframes Size:
		setPreferredSize(new Dimension(430,450));
		//setSize(500, 600);		
		//set THIS JFrames starting location Default (0,0) TP Left
		setLocation(20, 30);

		getContentPane().setLayout(new BorderLayout(10,15));
	}
	/*
	 * Function MakeBottom Panel
	 * Description: makes the panel that is responsible for inputting user 
	 * text and sending it to the chat service, also features a clear all
	 * button to clear the chat history/ on going chat logs
	 */
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JMenuBar makeMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu[] parentJmenuArr =  setupJmenuBar(new String[]{"File", "About", "Help"}, menuBar); // inline instatiation for array that will be accessed only once.
		
	
		//usering multi demenional array with in-line array declaration to help with cleaner code
		JMenuItem[][] menuItemsArr = setupSubMenuItems(
				new String[][]{ 
						{"File","New#", "Exit"},  // see documenttation in this method for more information
						{"About This UI","Blank0#", "Blank1#", "Blank2"}, //testing out the 'hash' symbol seperator
						{"Get Help"} }
				,parentJmenuArr );
		
	
		//access by [col][rows]

		
		/*Top JmenuBar action listener section:
		 * 	Notes: still needs development to "group" the listener to make code cleaner and clearer
		 * 
		 */
		menuItemsArr[0][2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(-1);
			}
		});
		
		menuItemsArr[1][0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Hi, hellow, kinechiwa?"
						+ "\nCreated/Developed by Danny Ly"
						+ "\nStill in Beta Testing V0.5 ( 1/27/2015)"
						+ "\nThanks for trying!");
			}
		});
		
		menuItemsArr[2][0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//need to add or change the title of the pop up message!
				JOptionPane.showMessageDialog(null, "Hello!"
						+ "\nSo you've stumped on some problems with this?, howeverrrrrrr If your name is Reilly"
						+ "\nGo Figure it out on your own !!!"
						+ "\n else{"
						+ "\n sorry =\\ i cannot help you i'm only a machine that takes in instructions}");
			}
		});
		

		/*
		 * End of Action Listeners for the Top JmenuBar
		 */

		//sets the Frames MenuBar
		//setJMenuBar(menuBar);
		return menuBar;
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JPanel makeBottomPanel(){
		
		//set bottom message text area
		JPanel sendMessagePanel = new JPanel(new BorderLayout());
		
		
		JPanel textFramPanel = new JPanel(new GridLayout(1,1));
		

		

		JTextField sendMsgField = new JTextField("Enter your message to send here");
		JScrollPane scroll = new JScrollPane(sendMsgField);
	
		
		sendMsgField.setColumns(18); // sets a length fro this box
		textFramPanel.add(sendMsgField);

		sendMessagePanel.add(textFramPanel, BorderLayout.LINE_START);
		
		JPanel msgButtPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton[] messagePanelButtonArr= setLabelOnButton(new String[]{"Clear Chat"}, msgButtPanel);

		//setBorderOnPanel(sendMessagePanel, "Input of Message:");
		
		sendMessagePanel.add(msgButtPanel, BorderLayout.LINE_END);
		
		

		
		sendMsgField.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				"Input Messages here") );
		
		
		
		
		
		getContentPane().add(sendMessagePanel, BorderLayout.PAGE_END);
		return sendMessagePanel;
		
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JButton[] createCustomJButton(ImageIcon[] iconArr, JPanel panel){
		/*
		 * This method could be optimized, needs works
		 * 
		 * Desc: this method returns a Jbutton of cutoms NO Opaque jbuttons (see-thru) a work around to make a link to things
		 * and sets a tooltip popup 
		 * adds buttons to the given panel
		 */
		JButton[] retArr = new JButton[iconArr.length];
		JButton currButton;
		for(int currBut = 0; currBut < iconArr.length; currBut++){
			currButton = new JButton(iconArr[currBut]);
			currButton.setOpaque(false);
			currButton.setBorderPainted(false);
			currButton.setContentAreaFilled(false);
			
			currButton.setToolTipText(iconArr[currBut].getDescription());
			currButton.setPreferredSize(new Dimension(32,32));
			
			retArr[currBut] = currButton;
			panel.add(retArr[currBut]);
			
			
		}
		
		
		return retArr;
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JButton[] setLabelOnButton(String[] labelNames, JPanel addToPanel){
		/*
		 * given a array of same length labal names, and buttons, adds labal names in order to thier respective buttons
		 * then add those buttons to the given panel
		 */
		
		
		JButton[] returnArr = new JButton[labelNames.length];
		JButton currentButton ;
		for(int i = 0; i < labelNames.length; i++){		
	
			currentButton = new JButton(labelNames[i]);
			//currentButton.setPreferredSize(new Dimension(20,20));
			returnArr[i] = currentButton;
			addToPanel.add(currentButton);
		}
		return returnArr;
		
		
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JPanel createAndSetJPanel(LayoutManager layoutType,int perferWidth, int perferHeigh){

		JPanel returnPanel = new JPanel();
		returnPanel.setLayout(layoutType);
		returnPanel.setPreferredSize(new Dimension(perferWidth, perferHeigh));
		
		
		return returnPanel;
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private JMenu[] setupJmenuBar(String[] labForMenu, JMenuBar menuBar){
		/*
		 * This method is called to set up the parent Jlabels for the JmenuBar 
		 * adds the text to the parent menuBar, then add the items to the pannel given to this method
		 * Notes: this returns a Jmenu, each Jmenu has been configured
		 */
		JMenu[] retJmenu = new JMenu[labForMenu.length]; // instatiates a empty Jmenu array with  the menu contained and corrected size according to the amount of labels given
		String tempLabelNam;
		JMenu currentJmenu;
		
		for(int i =0; i< labForMenu.length; i++){
			tempLabelNam = labForMenu[i];
			
			currentJmenu = new JMenu(tempLabelNam);		 // creates and adds a new Jmenu to the return array
			currentJmenu.setMnemonic(tempLabelNam.charAt(0)); // set the nemonics for that menu item
			
			retJmenu[i] = currentJmenu;

			menuBar.add(retJmenu[i]); // adds the menu item to the panel
		}
		
		return retJmenu; // returs the modified array to work with .
		
	}
	/**************************************************************************
	 * Function: 
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	private void setBorderOnPanel(JPanel panel, String title){

		panel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(),
				title) );
		
	}


	private JMenuItem[][] setupSubMenuItems(String[][] menuItemNames, JMenu[] Jmenu  ){
		/*
		 * this method was designed to take in a 2D array of string of menuItem names and associated Jemnu for them to be added,
		 * this method will create a JmenuItem and add them to the given Jmenu component
		 * returns a 2D JMenuItem array to access each JmenuItem and add action listenrs or work with them.
		 * 	Notes:
		 * 		-- Currently impolemented:
		 * 			- each Menu has a Nemonic keyeven which allows keypress to activate that menu given its first character
		 * 			- implemented a "method" to add a seperator, by using the 'Hash#' symbol after a string to signal a seperator
		 * 			
		 */
		
		int MAX_NUM_OF_ITEM = 10; // this number because in a dimentoon array it is [colums][rows] we cannot predetermine how many rows(menu items there will be)
		
		// however we can determine how many colums there will be , this is where theis MAX num comes from so we set a standard DO NOT EXCEED marker.
		
		
		String tempNames; // optimize code so its more we only need to init this variable once to reuse.
	
		if(Jmenu.length != menuItemNames.length) { throw new RuntimeException("Sizes are not right!"); }; // throws if the colums do not match up with the amount of menu parent labels
		
		JMenuItem[][] retArr = new JMenuItem[Jmenu.length][MAX_NUM_OF_ITEM]; // instatiates a empty 2D array to be returned with correct [columns][ MAX NUM OF ITEMS]

		for(int column = 0; column < menuItemNames.length ; column++ ){ // acces the column
			
			for(int row = 0; row < menuItemNames[column].length ; row ++){ // acces the rows of that colnm
				
				tempNames = menuItemNames[column][row]; // uses this variable once
				
				retArr[column][row] = new JMenuItem(tempNames.replace("#", "")); // removes the symbol before adding the menuItem to the Jbar		
				retArr[column][row].setMnemonic(tempNames.charAt(0)); // adds a nmonic for that menuitem
				
				Jmenu[column].add(retArr[column][row]); // add's the modified menuitem to the Jmenu
				
				if(tempNames.contains("#")){ // self defined symbol to add a seperator to the menu after this name
					
					
					
					Jmenu[column].addSeparator();// adds a seperator
					
				}	
				
			}
			
		}

		return retArr; // returns the 2D modified array to work with .
	}
	/**************************************************************************
	 * Function: MAIN TESTING Of this sub module
	 *  
	 * Description:
	 * 	->
	 * ASSUMPTIONS:
	 * 	-> None
	 * PRECONDITIONS:
	 * 	-> None
	 * 	-> None
	 * POSTCONDITIONS:
	 * 	->
	 * 	->
	 **************************************************************************/
	public static void main(String[] args){
		UserInterface ui = new UserInterface();
		
	}

}
