
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;


public class Screen {
	//
	// For plotting the tree etc.
	String[][] Image;
	int n_rows; // number of rows
	int n_cols; // number of cols
	int[] i_cols;
	// ====================================================
	public Screen(int n_rows1, int n_cols1, String myInitString)
	{
		int i, j;
		n_rows=n_rows1;
		n_cols=n_cols1;
		Image = new String[n_rows][n_cols];
		i_cols= new int[n_rows];
		   for (i=0;i<n_rows;i++)
		   {
			   for (j=0;j<n_cols;j++)
			   {
				   Image[i][j]=myInitString; 
			   }   
		   }
	} // Screen(int n_rows1, int n_cols1, String myInitString)
//	 ====================================================
	public int reset(String myInitString)
	{
		//
		// Input:
		// ======
		// myInitString - to reset the Screen
		//
		int i, j;
        int resultValue;
           
        resultValue=0;
        
	   for (i=0;i<n_rows;i++)
	   {
		   for (j=0;j<n_cols;j++)
		   {
			   Image[i][j]=myInitString; 
		   } 
		   i_cols[i]=0;
	   }
	   
	   return resultValue;
	} // ScreenReset(String myInitString)
	// ====================================================
	public Screen()
	{
		int i, j;
		n_rows=30;
		n_cols=50;
		Image = new String[n_rows][n_cols];
		i_cols= new int[n_rows];
		   for (i=0;i<n_rows;i++)
		   {
			   for (j=0;j<n_cols;j++)
			   {
				   Image[i][j]="."; 
			   }   
		   }
	} // Screen()
	// ======================================================
        public int Screen2Print()
	{
		int warningNumber;
		int i,j;
		String lineString;
		
		warningNumber=0;
		// Title
		   //System.out.println("Image: " + title + ": ");
		//
		   for (i=0;i<n_rows;i++)
		   {
			   lineString="";
			   for (j=0;j<n_cols;j++)
			   {
				   lineString=lineString+Image[i][j]; 
			   }
			   System.out.println(lineString);			   
		   }		
		return warningNumber;
	} // Screen2Printer()
        
	public int Screen2Area(JTextArea Area)
	{
		int warningNumber;
		int i,j;
		String lineString;
		
		warningNumber=0;
		// Title
		   //System.out.println("Image: " + title + ": ");
		//
		   for (i=0;i<n_rows;i++)
		   {
			   lineString="";
			   for (j=0;j<n_cols;j++)
			   {
				   lineString=lineString+Image[i][j]; 
			   }
			   Area.append(lineString + "\n");			   
		   }		
		return warningNumber;
	} // Screen2Printer()
        public int Screen2Pane (JTextPane Pane, SimpleAttributeSet a) throws BadLocationException
	{
		int warningNumber;
		int i,j;
		String lineString;
		
		warningNumber=0;
		// Title
		   //System.out.println("Image: " + title + ": ");
		//
		   for (i=0;i<n_rows;i++)
		   {
			   lineString="";
			   for (j=0;j<n_cols;j++)
			   {
				   lineString=lineString+Image[i][j]; 
			   }
			   Pane.getDocument().insertString(Pane.getDocument().getLength(), (lineString + "\n"), a);
		   }		
		return warningNumber;
	} // Screen2Printer()
	// ==========================================
	int setImage(int i_row, int i_col, String myString)
	{
		int resultWarning;
		int lengthString;
		int i;
		resultWarning=0;
		String tempString;
		char tempChar;
		
		lengthString=myString.length();
		for (i=0; i<lengthString;i++)
		{
			tempString="";
			tempChar=(char)myString.codePointAt(i);
			tempString=tempString+tempChar;
			Image[i_row][i_col+i]=tempString;
		}
		return resultWarning;
		
	}
}
