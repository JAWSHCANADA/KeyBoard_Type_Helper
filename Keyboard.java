package _Assignment3Components;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

/*
Purpose
* Typing quickly and correctly is an essential skill for working effectively with computers 
* and the Internet. In this exercise you will build a GUI application that can help users learn to 
* “touch type” (i.e. type correctly without looking at the keyboard).  The application should display 
* a virtual keyboard and should allow the user to watch what he or she is typing on the screen without 
* looking at the actual keyboard. Use JButtons to represent the keys. As the user presses each key,
the application highlights the corresponding JButton on the GUI and adds the character to a JTextArea that 
shows what the user has typed so far. [Hint: To highlight a JButton, use its SetBackground method to change 
its background colour. When the key is released, reset its original background colour. You can obtain the 
JButton’s 
* original background colour with the getbackground method before you change its colour.] 
*/

/*
* Student Expaination:
* This program will create a visual representation of keyboard utilizing a yellow highlight of the background of the keys
* pressed down and will display what has been typed into the Text area in the Middle of the Screen
* This program will utilize Action Listener for the keyboard to know which key has been typed.
* The code will use arrays for the Button Labels, and Keyboard Keys as JButton Array.
* 
*/

public class EnglishKeyboard extends JFrame{

	//Creating an array to hold all the Keys to the Keyboard as individual JButtons too difficult to keep track by creating 
	//Individual Components I tried it is amazing insane haha
	private static final String[][] keyboardKeys = 
		{
			{"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace"},
			{"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"},
			{"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter"},
			{"Shift","Z","X","C","V","B","N","M",",",".","?","^"},
			{"Spacebar","<", "v", ">"}
		}; 
	//Creating a JButton Array that will hold all the Buttons on the Keyboard for the Gui with Same Dimentsiions as the keyBoard Keys
	private static final JButton[][] buttonNames = new JButton[5][14];
	
	//Creating a Text to specify the first line of messaging ot the user about how this keyboard functions
	public static String text = "Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.";
	//Second line of Text to let the person no that mouse will not be useful for this keyboard and clicking buttons will Yield No Action
	public static String text1 =  " Note: Clicking the buttons with your mouse will not perform any action";
	//Combining both strings to one string in a new variable call textAll
	//private static String textAll = text + "\n" + text1;
	
	//Creating a Panel to Hold all of the Keys
	private static JPanel panelKey;
	//Panel to Hold the JButtons on the Frame
	private static JPanel panelFrame = new JPanel();
	//Creating a Color Array that will retain the original color of the background of the keys to be used to reset the background one the key release action is invoked
	private static Color colorArray[][] = new Color[5][14];
	
	//Using an Html Tag to put in a space in the Jlabel so that the two texts can be on separate lines
	//private static JLabel textFld = new JLabel("<html>" + text + "<br>" + text1 + "</html>", JLabel.LEFT);
	
	//Creating two separate Labels for the original Bolded Caption as HTML tag is not allowed for the Assignment
	private static JLabel textFld = new JLabel(text, JLabel.LEFT);
	
	//Creating two separate Labels for the original Bolded Caption as HTML tag is not allowed for the Assignment
	private static JLabel textFld1 = new JLabel(text1,JLabel.LEFT);
	
	//Using a Text Area opposed to the Embbeded HTML because was instructed not to use html in this course
	//private static JLabel textFld = new JLabel( textAll);
	
	//Creating a JTextField that will contain all the Text that the User inputs by typing into the keyboard
	private static JTextField blankSpace = new JTextField();
	//private static Dimension size = textFld.getPreferredSize();
	//Using a Customized Font to push the Text to be Bold and Manually Control the Sizes
	private static Font f = new Font("Ariel", Font.BOLD, 15);
	
	//Function that will go to the JButton Array and store the values of the initial background colors
	//This will fill the Color Array
	public void InitialColor()
	{
		//2 Dimensional Array are same dimension as Color Array and buttonnames array
		for(int j=0; j<keyboardKeys.length; j++)
		{
			//Incrementing through the row of the KeyBoard. 5 by 14 Matrix
			for(int i=0; i<keyboardKeys[j].length;i++)
			{
				//Setting the colorArray equal to the color of the background of the ButtonNames using identical Index/Dimensions
				colorArray[j][i] = buttonNames[j][i].getBackground();
			}
			
		}
	}
	//Function when Invoked will navigate to the button in keyboardKey array and turn its collor to the mattching index in the color array
	public void resetColor()
	{
		//2 Dimensional Array are same dimension as Color Array and buttonnames array
		for(int j=0; j<keyboardKeys.length; j++)
		{
			//Incrementing through the row of the KeyBoard. 5 by 14 Matrix
			for(int i=0; i<keyboardKeys[j].length;i++)
			{
				//Setting the background to back to the Original Color after the button has been released
				buttonNames[j][i].setBackground(colorArray[j][i]);
			}
			
		}
	}
	
	//Creating a custom class that implements  keylistener object  for the Keyboard
	class KeyboardListener implements KeyListener
	{
		
		//Function to get the Original Color of the Background for any JButton to be inputed inside the buttonColor Array
		
		public Color backgroundReset(JButton button)
		{
			//Set a color to the backGround of a Jbutton if used
			Color OriginalBackground = button.getBackground();
			
			return OriginalBackground;
		}
	    
		
		
		
		@Override
		public void keyTyped(KeyEvent e) 
		{
			//Not Used in this Program and Not Needed
		
		}

		@Override
		//When a Key is Pressed Use a getKeyCode to return the value the system Identifies which Key Was Pressed
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

			//Store the Key that is pressed as an integer
			int keyTyped = e.getKeyCode();
			//Printing to the Console to use for Debugging of which Key value is typed
			System.out.println(keyTyped);
			
			/*
			 * Switch Statement that will take on the values that is typed and stored in the keyTyped value
			 * When A key Value is triggered that the background of the button will change color to Yellow and 
			 * be highlighted and print to the console which button was pressed
			 */
			switch(keyTyped)
			{
			 // Navigation keys
		    case 192: //KeyEvent.VK_Dead_Tilde doesnt work on my keyboard 
		      {
		       // backgroundReset(buttonNames[0][0]);
		    	  //Set the Background of the button into Yellow
		    	buttonNames[0][0].setBackground(Color.YELLOW);
		    	//Print to the Console that the Till button was Pressed
		    	System.out.println("~ button was pressed");
		    	break;
		    
		      }
		      //Left Key Event pressed and triggered
		    case KeyEvent.VK_LEFT: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[4][1].setBackground(Color.YELLOW);
		    	//Print to the Console that the Left button was Pressed
		    	System.out.println("Left button was pressed");
		    	break;
		    }
		    //Zero button was pressed
		    case KeyEvent.VK_0: 
		    {
		    	
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][10].setBackground(Color.YELLOW);
		    	//Print to the Console that the 0 button was Pressed
		    	System.out.println("0 button was pressed");
		    	break;
		    	
		    	
		    }
		    //1 Button Pressed
		    case KeyEvent.VK_1: 
		    {
              
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][1].setBackground(Color.YELLOW);
		    	//Print to the Console that the 1 button was Pressed
		    	System.out.println("1 button was pressed");
		    	break;
		    	
		    	
		    }
		    //2 Button Pressed
		    case KeyEvent.VK_2: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][2].setBackground(Color.YELLOW);
		    	//Print to the Console that the 2 button was Pressed
		    	System.out.println("2 button was pressed");
		    	break;
		    }
		    //3 Button Pressed
		    case KeyEvent.VK_3: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][3].setBackground(Color.YELLOW);
		    	//Print to the Console that the 3 button was Pressed
		    	System.out.println("3 button was pressed");
		    	break;
		    }
		    //Button 4 Pressed
		    case KeyEvent.VK_4: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][4].setBackground(Color.YELLOW);
		    	//Print to the Console that the 4 button was Pressed
		    	System.out.println("4 button was pressed");
		    	break;
		    }
		    //Button 5 Pressed
		    case KeyEvent.VK_5: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][5].setBackground(Color.YELLOW);
		    	//Print to the Console that the 5 button was Pressed
		    	System.out.println("5 button was pressed");
		    	break;
		    }
		    //Button 6 Pressed
		    case KeyEvent.VK_6: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][6].setBackground(Color.YELLOW);
		    	//Print to the Console that the 6 button was Pressed
		    	System.out.println("6 button was pressed");
		    	break;
		    }
		    //7 Button Pressed
		    case KeyEvent.VK_7: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][7].setBackground(Color.YELLOW);
		    	//Print to the Console that the 7 button was Pressed
		    	System.out.println("7 button was pressed");
		    	break;
		    }
		    //8 Button Pressed
		    case KeyEvent.VK_8: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][8].setBackground(Color.YELLOW);
		    	//Print to the Console that the 8 button was Pressed
		    	System.out.println("8 button was pressed");
		    	break;
		    }
		    //Button 9 Pressed
		    case KeyEvent.VK_9: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][9].setBackground(Color.YELLOW);
		     	//Print to the Console that the 9 button was Pressed
		    	System.out.println("9 button was pressed");
		    	break;
		    }
		    //The Minus Button is Pressed
		    case KeyEvent.VK_MINUS: 
		    {
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][11].setBackground(Color.YELLOW);
		    	//Print to the Console that the minus button was Pressed
		    	System.out.println("- button was pressed");
		    	break;
		    }
		    //Plus Button Pressed
		    case 61: //KeyEvent.VK_PLUS: 
		    {
		    	//backgroundReset(buttonNames[0][12]);
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][12].setBackground(Color.YELLOW);
		    	//Print to the Console that the Plus button was Pressed
		    	System.out.println("+ button was pressed");
		    	break;
		    }
		    //Backspace button Pressed
		    case KeyEvent.VK_BACK_SPACE: 
		    {
		    	//backgroundReset(buttonNames[0][13]);
		    	
		    	//Set the Background of the button into Yellow
		    	buttonNames[0][13].setBackground(Color.YELLOW);
		    	//Print to the Console that the backspace button was Pressed
		    	System.out.println("Backspace button was pressed");
		    	break;
		    }
		    //When the Tab Key is Pressed, VK_TAB doesnt work
		    case 9: //KeyEvent.VK_TAB: 
		    {
		    	//backgroundReset(buttonNames[0][13]);
		    
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][0].setBackground(Color.YELLOW);
		    	//Print to the Console that the TAB button was Pressed
		    	System.out.println("Tab button was pressed");
		    	break;
		    }
		    //Q Letter Button Pressed
		    case  KeyEvent.VK_Q: 
		    {
		    	//backgroundReset(buttonNames[0][13]);
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][1].setBackground(Color.YELLOW);
		    	//Print to the Console that the Q button was Pressed
		    	System.out.println("Q button was pressed");
		    	break;
		    }
		    //W Button Pressed
		    case  KeyEvent.VK_W: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][2].setBackground(Color.YELLOW);
		    	//Print to the Console that the W button was Pressed
		    	System.out.println("W button was Pressed");
		    	break;
		    }
		    //E Button Pressed
		    case  KeyEvent.VK_E: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][3].setBackground(Color.YELLOW);
		    	//Print to the Console that the E button was Pressed
		    	System.out.println("E button was Pressed");
		    	break;
		    }
		    //R Button Pressed
		    case  KeyEvent.VK_R: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][4].setBackground(Color.YELLOW);
		    	//Print to the Console that the R button was Pressed
		    	System.out.println("R button was Pressed");
		    	break;
		    }
		    //T button Pressed
		    case  KeyEvent.VK_T: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][5].setBackground(Color.YELLOW);
		    	//Print to the Console that the T button was Pressed
		    	System.out.println("T button was Pressed");
		    	break;
		    }
		    //Y Button was Pressed
		    case  KeyEvent.VK_Y: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][6].setBackground(Color.YELLOW);
		    	//Print to the Console that the Y button was Pressed
		    	System.out.println("Y button was Pressed");
		    	break;
		    }
		    //U Button was Pressed
		    case  KeyEvent.VK_U: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][7].setBackground(Color.YELLOW);
		    	//Print to the Console that the U button was Pressed
		    	System.out.println("U button was Pressed");
		    	break;
		    }
		    //I Button was Pressed
		    case  KeyEvent.VK_I: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][8].setBackground(Color.YELLOW);
		    	//Print to the Console that the I button was Pressed
		    	System.out.println("I button was Pressed");
		    	break;
		    }
		    //O Button was Pressed
		    case  KeyEvent.VK_O: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][9].setBackground(Color.YELLOW);
		    	//Print to the Console that the O button was Pressed
		    	System.out.println("O button was Pressed");
		    	break;
		    }
		    //P Button was Pressed
		    case  KeyEvent.VK_P: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][10].setBackground(Color.YELLOW);
		    	//Print to the Console that the P button was Pressed
		    	System.out.println("P button was Pressed");
		    	break;
		    }
		    //Left brace Colon Button was Pressed
		    case  91: //KeyEvent.VK_BRACELEFT: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][11].setBackground(Color.YELLOW);
		    	//Print to the Console that the [ button was Pressed
		    	System.out.println("[ button was Pressed");
		    	break;
		    }
		    //Right BraceRight Button was Pressed
		    case  93: //KeyEvent.VK_BRACERIGHT: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][12].setBackground(Color.YELLOW);
		    	//Print to the Console that the ] button was Pressed
		    	System.out.println("] button was Pressed");
		    	break;
		    }
		    //Backslash button was Pressed
		    case  KeyEvent.VK_BACK_SLASH: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[1][13].setBackground(Color.YELLOW);
		    	//Print to the Console that the \ button was Pressed
		    	System.out.println(" \\ button was Pressed");
		    	break;
		    }
		  //Caps Lock button was Pressed
		    case  KeyEvent.VK_CAPS_LOCK: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][0].setBackground(Color.YELLOW);
		    	//Print to the Console that the CAPS button was Pressed
		    	System.out.println("CAPS Lock button was Pressed");
		    	break;
		    }
		    //A button was Pressed
		    case  KeyEvent.VK_A: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][1].setBackground(Color.YELLOW);
		    	//Print to the Console that the A button was Pressed
		    	System.out.println("A Lock button was Pressed");
		    	break;
		    }
		    //S button was Pressed
		    case  KeyEvent.VK_S: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][2].setBackground(Color.YELLOW);
		    	//Print to the Console that the S button was Pressed
		    	System.out.println("S Lock button was Pressed");
		    	break;
		    }
		    //D button was Pressed
		    case  KeyEvent.VK_D: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][3].setBackground(Color.YELLOW);
		    	//Print to the Console that the D button was Pressed
		    	System.out.println("D Lock button was Pressed");
		    	break;
		    }
		    //F button was Pressed
		    case  KeyEvent.VK_F: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][4].setBackground(Color.YELLOW);
		    	//Print to the Console that the F button was Pressed
		    	System.out.println("F Lock button was Pressed");
		    	break;
		    }
		    //G button was Pressed
		    case  KeyEvent.VK_G: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][5].setBackground(Color.YELLOW);
		    	//Print to the Console that the G button was Pressed
		    	System.out.println("G Lock button was Pressed");
		    	break;
		    }
		    //H button was Pressed
		    case  KeyEvent.VK_H: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][6].setBackground(Color.YELLOW);
		    	//Print to the Console that the H button was Pressed
		    	System.out.println("H Lock button was Pressed");
		    	break;
		    }
		    //J button was Pressed
		    case  KeyEvent.VK_J: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][7].setBackground(Color.YELLOW);
		    	//Print to the Console that the J button was Pressed
		    	System.out.println("J Lock button was Pressed");
		    	break;
		    }
		    //K button was Pressed
		    case  KeyEvent.VK_K: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][8].setBackground(Color.YELLOW);
		    	//Print to the Console that the K button was Pressed
		    	System.out.println("K Lock button was Pressed");
		    	break;
		    }
		    //L button was Pressed
		    case  KeyEvent.VK_L: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][9].setBackground(Color.YELLOW);
		    	//Print to the Console that the L button was Pressed
		    	System.out.println("L Lock button was Pressed");
		    	break;
		    }
		    //Colon button was Pressed
		    case 59: // KeyEvent.VK_COLON: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][10].setBackground(Color.YELLOW);
		    	//Print to the Console that the : button was Pressed
		    	System.out.println(": Lock button was Pressed");
		    	break;
		    }
		    //Backslash button was Pressed
		    case  222: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][11].setBackground(Color.YELLOW);
		    	//Print to the Console that the " button was Pressed
		    	System.out.println(" \" Lock button was Pressed");
		    	break;
		    }
		    //Enter button was pressed
		    case  KeyEvent.VK_ENTER: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[2][12].setBackground(Color.YELLOW);
		    	//Print to the Console that the Enter button was Pressed
		    	System.out.println("Enter Lock button was Pressed");
		    	break;
		    }
		    //Shift Key was Pressed
		    case  KeyEvent.VK_SHIFT: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][0].setBackground(Color.YELLOW);
		    	//Print to the Console that the Shift button was Pressed
		    	System.out.println("SHIFT  button was Pressed");
		    	break;
		    }
		    //Z button was Pressed
		    case  KeyEvent.VK_Z: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][1].setBackground(Color.YELLOW);
		    	//Print to the Console that the Z button was Pressed
		    	System.out.println("Z button was Pressed");
		    	break;
		    }
		    //X button was Pressed
		    case  KeyEvent.VK_X: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][2].setBackground(Color.YELLOW);
		    	//Print to the Console that the X button was Pressed
		    	System.out.println("X button was Pressed");
		    	break;
		    }
		    //C button was Pressed
		    case  KeyEvent.VK_C: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][3].setBackground(Color.YELLOW);
		    	//Print to the Console that the C button was Pressed
		    	System.out.println("C button was Pressed");
		    	break;
		    }
		    //V button was Pressed
		    case  KeyEvent.VK_V: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][4].setBackground(Color.YELLOW);
		    	//Print to the Console that the V button was Pressed
		    	System.out.println("V button was Pressed");
		    	break;
		    }
		    //B button was Pressed
		    case  KeyEvent.VK_B: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][5].setBackground(Color.YELLOW);
		    	//Print to the Console that the B button was Pressed
		    	System.out.println("B button was Pressed");
		    	break;
		    }
		    //N button was Pressed
		    case  KeyEvent.VK_N: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][6].setBackground(Color.YELLOW);
		    	//Print to the Console that the N button was Pressed
		    	System.out.println("N button was Pressed");
		    	break;
		    }
		    //M button was Pressed
		    case  KeyEvent.VK_M: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][7].setBackground(Color.YELLOW);
		    	//Print to the Console that the M button was Pressed
		    	System.out.println("M button was Pressed");
		    	break;
		    }
		    //Comma button was Pressed
		    case  KeyEvent.VK_COMMA: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][8].setBackground(Color.YELLOW);
		    	//Print to the Console that the , button was Pressed
		    	System.out.println(", button was Pressed");
		    	break;
		    }
		    //Period button was Pressed
		    case  KeyEvent.VK_PERIOD: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][9].setBackground(Color.YELLOW);
		    	//Print to the Console that the period  button was Pressed
		    	System.out.println("Period button was Pressed");
		    	break;
		    }
		    //Question Mark Button Pressed
		    case 47: //KeyEvent.VK_DIVIDE: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][10].setBackground(Color.YELLOW);
		    	//Print to the Console that the ? button was Pressed
		    	System.out.println(" ? button was Pressed");
		    	break;
		    }
		    //Up button was Pressed
		    case  KeyEvent.VK_UP: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[3][11].setBackground(Color.YELLOW);
		    	//Print to the Console that the UP button was Pressed
		    	System.out.println("UP button was Pressed");
		    	break;
		    }
		    //Spacebar button was Pressed
		    case  KeyEvent.VK_SPACE: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[4][0].setBackground(Color.YELLOW);
		    	//Print to the Console that the SPACEBAR button was Pressed
		    	System.out.println("Spacebar button was Pressed");
		    	break;
		    }
		    //Down button was Pressed
		    case  KeyEvent.VK_DOWN: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[4][2].setBackground(Color.YELLOW);
		    	//Print to the Console that the DOWN button was Pressed
		    	System.out.println("Down button was Pressed");
		    	break;
		    }
		    //Right button was Pressed
		    case  KeyEvent.VK_RIGHT: 
		    {
		    	//Set the Background of the button into Yellow
		    	buttonNames[4][3].setBackground(Color.YELLOW);
		    	//Print to the Console that the RIGHT button was Pressed
		    	System.out.println("Right button was Pressed");
		    	break;
		    }
		    default :
		    	System.out.println("A different button was pressed");
		    	break;
		    
		    
		    
			}
		}

		@Override
		//Function that initiates when a person lets go of a key and Releases the key
		public void keyReleased(KeyEvent e) {
		
			
			//Store the code of the key that is released and store it in the Integer keyTyped1 variable
			int keyTyped1 = e.getKeyCode();
			/*
			 * Switch Statement that will take on the values that is released and stored in the keyTyped2 value
			 * When A key Value is triggered that the background of the button will change color to to the original background and 
			 * be highlighted and print to the console which button was pressed
			 */
			switch(keyTyped1)
			{
			 // Navigation keys
			//Relasing the Tilde Key
		    case 192: // KeyEvent.VK_DEAD_TILDE: 
		      {
		     //Reset the background of the button of to the original color
		    	buttonNames[0][0].setBackground(colorArray[0][0]);
		    	System.out.println("~ button was Released");
		    	break;
		    	
		    
		      }
		      //Left Key Released
		    case KeyEvent.VK_LEFT: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[4][1].setBackground(colorArray[4][1]);
		    	System.out.println("Left button was Released");
		    	break;
		    }
		    //Releasing the 0 Key
		    case KeyEvent.VK_0: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][10].setBackground(colorArray[0][10]);
		    	
		    	System.out.println("0 button was Released");
		    	break;
		    }
		    //When the 1 Key is Released
		    case KeyEvent.VK_1: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][1].setBackground(colorArray[0][1]);
		    	System.out.println("1 button was Released");
		    	break;
		    }
		    //2 Button Pressed
		    case KeyEvent.VK_2: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][2].setBackground(colorArray[0][2]);
		    	System.out.println("2 button was Released");
		    	break;
		    }
		    
		    //3 button Released
		    case KeyEvent.VK_3: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][3].setBackground(colorArray[0][3]);
		    	System.out.println("3 button was Released");
		    	break;
		    }
		    //Button 4 is Released
		    case KeyEvent.VK_4: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][4].setBackground(colorArray[0][4]);
		    	System.out.println("4 button was Released");
		    	break;
		    }
		    //5 Button is released
		    case KeyEvent.VK_5: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][5].setBackground(colorArray[0][5]);
		    	System.out.println("5 button was Released");
		    	break;
		    }
		    //6 Button Released
		    case KeyEvent.VK_6: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][6].setBackground(colorArray[0][6]);
		    	System.out.println("6 button was Released");
		    	break;
		    }
		    //Number 7 Button Released
		    case KeyEvent.VK_7: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][7].setBackground(colorArray[0][7]);
		    	System.out.println("7 button was Released");
		    	break;
		    }
		    //8 Button Released
		    case KeyEvent.VK_8: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][8].setBackground(colorArray[0][8]);
		    	System.out.println("8 button was Released");
		    	break;
		    }
		    //Number 9 Button Released
		    case KeyEvent.VK_9: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][9].setBackground(colorArray[0][9]);
		    	System.out.println("9 button was Released");
		    	break;
		    }
		    //Minus Button Released
		    case KeyEvent.VK_MINUS: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][11].setBackground(colorArray[0][11]);
		    	System.out.println("- button was Released");
		    	break;
		    }
		    //Plus Button Released
		    case 61 : //KeyEvent.VK_MINUS: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][12].setBackground(colorArray[0][12]);
		    	System.out.println("+ button was Released");
		    	break;
		    }
		    //Backspace button Released
		    case KeyEvent.VK_BACK_SPACE : //KeyEvent.VK_MINUS: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[0][13].setBackground(colorArray[0][13]);
		    	System.out.println("Backspace button was Released");
		    	break;
		    	
		    }
		    //Tab Button Released
		    case 9: //KeyEvent.VK_TAB: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][0].setBackground(colorArray[1][0]);
		    	System.out.println("TAB button was Released");
		    	break;
		    	
		    }
		    //Q Button Released
		    case  KeyEvent.VK_Q: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][1].setBackground(colorArray[1][1]);
		    	System.out.println("Q button was Released");
		    	break;
		    }
		    //W Button Released
		    case  KeyEvent.VK_W: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][2].setBackground(colorArray[1][2]);
		    	System.out.println("W button was Released");
		    	break;
		    }
		    //E Button Released
		    case  KeyEvent.VK_E: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][3].setBackground(colorArray[1][3]);
		    	System.out.println("E button was Released");
		    	break;
		    }
		    //R Button Released
		    case  KeyEvent.VK_R: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][4].setBackground(colorArray[1][4]);
		    	System.out.println("R button was Released");
		    	break;
		    }
		    //T Button Released
		    case  KeyEvent.VK_T: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][5].setBackground(colorArray[1][5]);
		    	System.out.println("T button was Released");
		    	break;
		    }
		    //Y Button Released
		    case  KeyEvent.VK_Y: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][6].setBackground(colorArray[1][6]);
		    	System.out.println("Y button was Released");
		    	break;
		    }
		    //U Button Released
		    case  KeyEvent.VK_U: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][7].setBackground(colorArray[1][7]);
		    	System.out.println("U button was Released");
		    	break;
		    }
		    //I Button Released
		    case  KeyEvent.VK_I: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][8].setBackground(colorArray[1][8]);
		    	System.out.println("I button was Released");
		    	break;
		    }
		    //O Button Released
		    case  KeyEvent.VK_O: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][9].setBackground(colorArray[1][9]);
		    	System.out.println("O button was Released");
		    	break;
		    }
		    //P Button Released
		    case  KeyEvent.VK_P: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][10].setBackground(colorArray[1][10]);
		    	System.out.println("P button was Released");
		    	break;
		    }
		    //{ Button Released
		    case  91: //KeyEvent.VK_BRACELEFT: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][11].setBackground(colorArray[1][11]);
		    	System.out.println("[ button was Released");
		    	break;
		    }
		    // ] Button Released
		    case  93: //KeyEvent.VK_BRACERIGHT: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][12].setBackground(colorArray[1][12]);
		    	System.out.println("] button was Released");
		    	break;
		    }
		    //Backslash buttton released
		    case  KeyEvent.VK_BACK_SLASH: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[1][13].setBackground(colorArray[1][13]);
		    	System.out.println(" \\ button was Released");
		    	break;
		    }
		    //Caps Lock button Released
		    case  KeyEvent.VK_CAPS_LOCK: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][0].setBackground(colorArray[2][0]);
		    	System.out.println("CAPS Lock button was Released");
		    	break;
		    }
		  //A button Released
		    case  KeyEvent.VK_A: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][1].setBackground(colorArray[2][1]);
		    	System.out.println("A Lock button was Released");
		    	break;
		    }
		    //S button Released
		    case  KeyEvent.VK_S: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][2].setBackground(colorArray[2][2]);
		    	System.out.println("S Lock button was Released");
		    	break;
		    }
		    //D Button Released
		    case  KeyEvent.VK_D: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][3].setBackground(colorArray[2][3]);
		    	System.out.println("D Lock button was Released");
		    	break;
		    }
		    //F Button Released
		    case  KeyEvent.VK_F: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][4].setBackground(colorArray[2][4]);
		    	System.out.println("F Lock button was Released");
		    	break;
		    }
		    //G Button Released
		    case  KeyEvent.VK_G: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][5].setBackground(colorArray[2][5]);
		    	System.out.println("G Lock button was Released");
		    	break;
		    }
		    //H Button Released
		    case  KeyEvent.VK_H: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][6].setBackground(colorArray[2][6]);
		    	System.out.println("H Lock button was Released");
		    	break;
		    }
		    //J Button Released
		    case  KeyEvent.VK_J: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][7].setBackground(colorArray[2][7]);
		    	System.out.println("J Lock button was Released");
		    	break;
		    }
		    //K Button Released
		    case  KeyEvent.VK_K: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][8].setBackground(colorArray[2][8]);
		    	System.out.println("K Lock button was Released");
		    	break;
		    }
		    //L Button Released
		    case  KeyEvent.VK_L: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][9].setBackground(colorArray[2][9]);
		    	System.out.println("L Lock button was Released");
		    	break;
		    }
		    //: Button Released
		    case 59: // KeyEvent.VK_COLON: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][10].setBackground(colorArray[2][10]);
		    	System.out.println(": Lock button was Released");
		    	break;
		    }
		    // \ Button Released
		    case  222: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][11].setBackground(colorArray[2][11]);
		    	System.out.println(" \" Lock button was Released");
		    	break;
		    }
		    //Enter Button Released
		    case  KeyEvent.VK_ENTER: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[2][12].setBackground(colorArray[2][12]);
		    	System.out.println("Enter Lock button was Released");
		    	break;
		    }
		    //Shift Button Released
		    case  KeyEvent.VK_SHIFT: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][0].setBackground(colorArray[3][0]);
		    	System.out.println("SHIFT  button was Released");
		    	break;
		    }
		    //Z Button Released
		    case  KeyEvent.VK_Z: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][1].setBackground(colorArray[3][1]);
		    	System.out.println("Z button was Released");
		    	break;
		    }
		    //X Button Released
		    case  KeyEvent.VK_X: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][2].setBackground(colorArray[3][2]);
		    	System.out.println("X button was Released");
		    	break;
		    }
		    //C Button Released
		    case  KeyEvent.VK_C: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][3].setBackground(colorArray[3][3]);
		    	System.out.println("C button was Released");
		    	break;
		    }
		    //V Button Released
		    case  KeyEvent.VK_V: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][4].setBackground(colorArray[3][4]);
		    	System.out.println("V button was Released");
		    	break;
		    }
		    //B Button Released
		    case  KeyEvent.VK_B: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][5].setBackground(colorArray[3][5]);
		    	System.out.println("B button was Released");
		    	break;
		    }
		    //N Button Released
		    case  KeyEvent.VK_N: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][6].setBackground(colorArray[3][6]);
		    	System.out.println("N button was Released");
		    	break;
		    }
		    //M Button Released
		    case  KeyEvent.VK_M: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][7].setBackground(colorArray[3][7]);
		    	System.out.println("M button was Released");
		    	break;
		    }
		    //Comma Button Released
		    case  KeyEvent.VK_COMMA: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][8].setBackground(colorArray[3][8]);
		    	System.out.println(", button was Released");
		    	break;
		    }
		    //Period Button Released
		    case  KeyEvent.VK_PERIOD: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][9].setBackground(colorArray[3][9]);
		    	System.out.println("Period button was Released");
		    	break;
		    }
		    //Divide Button Released
		    case 47: //KeyEvent.VK_DIVIDE: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][10].setBackground(colorArray[3][10]);
		    	System.out.println(" ? button was Released");
		    	break;
		    }
		    //UO BUtton Released
		    case  KeyEvent.VK_UP: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[3][11].setBackground(colorArray[3][11]);
		    	System.out.println("UP button was Released");
		    	break;
		    }
		    //Spacebar Button Released
		    case  KeyEvent.VK_SPACE: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[4][0].setBackground(colorArray[4][0]);
		    	System.out.println("Spacebar button was Released");
		    	break;
		    }
		    //Down Arrow Key Released
		    case  KeyEvent.VK_DOWN: 
		    {
		    	 //Reset the background of the button of to the original color
		    	buttonNames[4][2].setBackground(colorArray[4][2]);
		    	System.out.println("Down button was Released");
		    	break;
		    }
		    //Right Arrow Key Released
		    case  KeyEvent.VK_RIGHT: 
		    {
		    	
		    	 //Reset the background of the button of to the original color
		    	buttonNames[4][3].setBackground(colorArray[4][3]);
		    	System.out.println("Right button was Released");
		    	break;
		    }
		    default :
		    	System.out.println("Another Button Typed not in the keyboard");
		    	break ;
		    	
			}
			
		}
		
	}
	
	//Constructor to make the KeyBoard GUI 
    public EnglishKeyboard()
    {
    	//Creating the JFrame object with the Caption Typing Tutor
         JFrame frame = new JFrame("Typing Tutor");
         
         //Create A Jpanel that will hold the two JLabels for the textFld and textFld1 for Multi Line Labeling
         JPanel LabelPanel = new JPanel();
         //SET THE Layout of the panel to a GridLayout of 2 rows
         LabelPanel.setLayout(new GridLayout(2,0));
         //set the font of the Textfield to f object created earlier for both textFld and textFld1
         textFld.setFont(f);
         textFld1.setFont(f);
         //Add the Labels to the Pabel Label Panel
         LabelPanel.add(textFld);
         LabelPanel.add(textFld1);
      
		
         //Adding the LabelPanel to a Border Layout of the JFrame at the North End
		frame.add( LabelPanel,BorderLayout.NORTH);
		//Add the JTextField to the Center of the BorderLayout of the JFrame
		frame.add(blankSpace,BorderLayout.CENTER);
		
		//For tab and BashSHift Keys, Prevent the Tab and Shift Keys to act as Traversing Functions
		blankSpace.setFocusTraversalKeysEnabled(false);
		//Automatically put the focus on the JTextField at the start of the Program
		blankSpace.requestFocusInWindow();
		//Set the Layout of the Frame for the panelFrame that will hold the JButtons as a GridLayout with 5 Rows
		panelFrame.setLayout(new GridLayout(5,0));
		//Create the KeyBoard Listener Object that will response to the KeyPressed and KeyReleased Action Listers
		KeyboardListener Listener = new KeyboardListener();
		//Add the Keylistener listener to the JTextField that will response to the keys typed in the space
		blankSpace.addKeyListener(Listener);
		//Add the Key Names to the Keys in a JBUTTON Array
		for(int j=0; j<keyboardKeys.length; j++)
		{
			//Create Custom Panel that will Retain the Keys as Buttons
			panelKey = new JPanel();
			//Set the Layout of the Panel that will hold the JButtons as a Flow Layout that will add the keys sequentially in a row
			panelKey.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			//Increment allong the rows of the KeyBoard Key Vallues for the Button Labels
			for(int i=0; i<keyboardKeys[j].length;i++)
			{
				//Creating the JButton objects inside the individual JBUTTON array buttonNames with the corresponding Key Name Label from the keyBoardKeys
				buttonNames[j][i] = new JButton(keyboardKeys[j][i]);
				//panelKey.add(new JButton(keyboardKeys[j][i]));
				//Add the Key Listenor to the Button
				buttonNames[j][i].addKeyListener(Listener);
				//Add the button to the panelkey that will house all the JButtons 
				panelKey.add(buttonNames[j][i]);
				
				
			}
			//Add the Panel Key to the Panel to the JFRame
			panelFrame.add(panelKey);
		}
		//Activate the Initial Color to fill the Color Array with the Default Background Colors of the Keyboard
		 InitialColor();
		
	
	
		 
		
		//Add the Panel Frame to the JFrame in the Southern Location
		frame.add(panelFrame,BorderLayout.SOUTH);
		//Set the Size of the JFrame to 1000 x 500 Pixels
		frame.setSize(1000, 500);
		//Setting the Location of the GUi to the Center of the Screen
		frame.setLocationRelativeTo(null);
		//Making the JFrame Visible 
		frame.setVisible(true);
		//Exit on Close Button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Main Function
	public static void main(String[] args) 
	{
		//create a EnglishKeyBoard Object to activate all the Constructors and Ect functions
		new EnglishKeyboard();
	

	}

}
