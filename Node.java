public class Node {
	public String a_value;    // The value of the Node
	public int semanticsType; // Semantics Categories
	public int syntaxType;    //Syntax: subject, object, verb
	public int speachType;    //noun, verb, preposition,
        public int xpos;
        public int ypos;
	//===================================================
	public Node T_Father;     // T - denotes the Parsing-tree
	public Node T_Brother;    // The tree is impelemented by a binary tree.
	public Node T_Son;
	// ===================================================
	// Siec Powiazan: Stoisko (Linkage Network)
	// ----------------------
	//   
	// v  - Hiponim
	// ^^ - Holonim
	// vv - Meronim: vv Kasa, vv lada,
	// ^  - Hiperonim: ^przedsiebiorstwo
	// >  - Synonim: < sklad
	// <> - Antonim
	//      Cohyponym - a word which is one of multiple hyponyms of another word 
	//
	public Node (){
	    a_value="a";
		semanticsType=0;
		syntaxType=0;
		speachType=0;
		T_Father=null;
		T_Brother=null;
		T_Son=null;
	}; // Node ()// Node ()
	// ==========================
	public Node (String myString){
	    a_value=myString;
		semanticsType=0;
		syntaxType=0;
		speachType=0;
		T_Father=null;
		T_Brother=null;
		T_Son=null;
	}; // Node (String myString)
        
      public Node(String x, Node l, Node r) {
      T_Son = l;
      T_Brother = r;
      a_value = x;
      }
	// ==========================
	static public int Node_2_Node (Node node0, Node node1){
		//
		// Input:
		// ======
		// node1 -
		//
		// Input/Output
		// ============
		// node0;
		//
		int resultValue;
		resultValue=0;
		node0.a_value=node1.a_value;
		node0.semanticsType=node1.semanticsType;
		node0.syntaxType=node1.syntaxType;
		node0.speachType=node1.speachType;
		node0.T_Father=node1.T_Father;
		node0.T_Brother=node1.T_Brother;
		node0.T_Son=node1.T_Son;
		
		return resultValue;
	}; // Node_2_Node (Node node0, Node node1)	
	// ==========================
	 public String Node_2_String (){
		//
		// Input:
		// ======
		// this -
		//
		// Output
		// ============
		// localString - the list of members to file.
		//
		String localString;
		int i_debug;
	    i_debug=Debug.i_debug;
	    if(i_debug==0) System.out.println("do-Dump: Node_2_String");
	    String sp; // space
	    sp=" ";
	    
		localString=a_value+sp;
		localString+= semanticsType+sp;
		localString+=syntaxType+sp;
		localString+=speachType+sp;
		localString+=T_Father+sp;
		localString+=T_Brother+sp;
		localString+=T_Son;
		
		return localString;
	}; // public String Node_2_String ()
//	 ==========================// public String Node_2_String ()
//	 ==========================

	// ==========================
	public Node (String value1, int semanticsType1, int syntaxType1, int speachType1, 
			Node Father1, Node Brother1, Node Son1){
		//
		//  Constructor
		//
	    int i_debug;
	    i_debug=Debug.i_debug;
	    if(i_debug==0) System.out.println("do-Dump: Node() ");		
		a_value=value1;
		semanticsType=semanticsType1;
		syntaxType=syntaxType1;
		speachType=speachType1;
		T_Father=Father1;
		T_Brother=Brother1;
		T_Son=Son1;
	  //
	} // public Node (String value1, int semanticsType1, ...
	// ==========================
	public Node (listCompound myListCompound){
		//
		// Constructor
		//
		String stringTemp;
		boolean is;
	    int i_debug;
	    i_debug=Debug.i_debug;
	    if(i_debug==0) System.out.println("do-Dump: Node(listCompound) ");		
		//
	    int n_parameters;
	    n_parameters=0;
	    n_parameters=n_parameters+0; // to satisfy a compiler.
	    n_parameters=myListCompound.stackList.size();
	    a_value=(String)myListCompound.stackList.elementAt(0);
		semanticsType=Integer.parseInt((String)myListCompound.stackList.elementAt(1));
		syntaxType=Integer.parseInt((String)myListCompound.stackList.elementAt(2));
		speachType=Integer.parseInt((String)myListCompound.stackList.elementAt(3));
		//
		stringTemp=(String)myListCompound.stackList.elementAt(4);
		is=stringTemp.equals("null");
		if(is) T_Father=null; 
		// else is missing to be supplied.
		//
		stringTemp=(String)myListCompound.stackList.elementAt(5);
		is=stringTemp.equals("null");
		if(is) T_Brother=null;
		//
		stringTemp=(String)myListCompound.stackList.elementAt(6);
		is=stringTemp.equals("null");
		if(is) T_Son=null;
//
	} // public Node (String value1, int semanticsType1, ...
	// ====================================
	public String  Node_2_Preorder(){
	    String resultString;
	    int n_if;
	    int i_debug;
	    i_debug=Debug.i_debug;
	    //if(i_debug==0) System.out.println("do-Dump: Node_2_Preorder ");
	    //
	    n_if=0;
	    n_if=n_if-1;
	    if (this == null)
	    {    n_if=1;
	    	resultString="";
	    }
	    else
	    {
	    	if( this.T_Son!=null && this.T_Brother!=null)
	    	{
	    		 if (this.T_Son.isLeaf())
	    		 {
	    		   n_if=21;
		    	   resultString="( " + this.a_value + " " +
		    	       this.T_Son.Node_2_Preorder() + " ) " +
		    	       this.T_Brother.Node_2_Preorder();
	    		 }
	    		 else
	    		 {
	    		   n_if=22;
	    	       resultString="( " + this.a_value + " " +
	    	           this.T_Son.Node_2_Preorder() + " ) " +   //v
	    	           this.T_Brother.Node_2_Preorder()+ " ";
	    		 }
	    	}
	    	else if ( this.T_Son!=null && this.T_Brother==null )
	    	{
	    		n_if=3;
	    		resultString="( " + this.a_value + " " +
	    	     this.T_Son.Node_2_Preorder() + " ) ";
	    	}
	    	else if ( this.T_Son==null && this.T_Brother!=null)
	    	{
	    		n_if=4;
	    		resultString=" " + this.a_value + 
	    		 this.T_Brother.Node_2_Preorder()+ " ";
	    	}
	    	else
	    	{
	    		n_if=5;
	    		resultString="Error";
	    		resultString=" " + this.a_value + " ";
	    	}
	    } // else
	    //
	    
	    return resultString; 
	} // String  Node_2_Preorder()
	// ====================================
	public int  Node_2_Screen(Screen myScreen, 
			int i_row, int i_col, int max_i_col0)
	{
	    String resultString;
	    //String rootString;
	    //int i_row_previus,i_col_previus;
	    int n_if;
	    int max_i_col;
	    int i,k;
	    int i_debug;
	    i_debug=-1; 
	    if(i_debug==0) System.out.println("do_Dump: Node_2_Screen ");
	    //
	    // debugging
	    //rootString= this.a_value;
	    
	    max_i_col=max_i_col0;
	    //i_col_previus=999;
	    n_if=0;
	    n_if=n_if-1; // Discard the warning
	    if (this == null)
	    {    n_if=1;
	        if(i_debug==1) System.out.println("n_if: " + n_if);
	    	resultString="";
	    } // n_if=1;
	    else
	    {
	    	if( this.T_Son!=null && this.T_Brother!=null)
	    	{
	    		 if (this.T_Son.isLeaf())
	    		 {
	    		   n_if=21;
	    		   if(i_debug==1) System.out.println("'" + this.a_value + "'" + " n_if: " + n_if);
		    	   resultString= this.a_value;
		    	   //myScreen.Image[i_row][i_col]=resultString;
		    	   myScreen.setImage(i_row, i_col, resultString);
		    	   myScreen.i_cols[i_row]=i_col+resultString.length()-1;
		    	   i_row++;
		    	   resultString="|";
		    	   //myScreen.Image[i_row][i_col]=resultString;
		    	   myScreen.setImage(i_row, i_col, resultString);
		    	   myScreen.i_cols[i_row]=i_col+resultString.length()-1;
		    	   i_row++;
		    	   // As previous row.
		    	   myScreen.i_cols[i_row]=myScreen.i_cols[i_row-1];
		    	   max_i_col=this.T_Son.Node_2_Screen(myScreen,
		    			   i_row, myScreen.i_cols[i_row], max_i_col);
		    	   max_i_col=Math.max(myScreen.i_cols[i_row], max_i_col);
		    	   i_row--; // First
		    	   i_row--; // Second
		    	   resultString="-";
			       k=0;
			       // Filling with '-'
			       for (i=myScreen.i_cols[i_row]+1;i<=max_i_col+1;i++)
			    	{
			    		//myScreen.Image[i_row][i]=resultString;
			    	    myScreen.setImage(i_row, i, resultString);
			    	    k++;
			    	} 
			       myScreen.i_cols[i_row]=myScreen.i_cols[i_row]+k;				    	   
		    	   max_i_col=this.T_Brother.Node_2_Screen(myScreen, 
		    			   i_row, myScreen.i_cols[i_row], max_i_col);
		    	   max_i_col=Math.max(myScreen.i_cols[i_row], max_i_col);
	
	    		 }// n_if=21;
	    		 else
	    		 {
	    		   n_if=22;
	    		   if(i_debug==1) System.out.println("'"+ this.a_value + "'" + " n_if: " + n_if);
	    		   resultString= this.a_value;
	    		   //myScreen.Image[i_row][i_col]=resultString;
	    		   myScreen.setImage(i_row, i_col, resultString);
	    		   myScreen.i_cols[i_row]=i_col+resultString.length()-1;
		    	   i_row++;
		    	   resultString="|";
		    	   //myScreen.Image[i_row][i_col]=resultString;
		    	   myScreen.setImage(i_row, i_col, resultString);
		    	   myScreen.i_cols[i_row]=i_col+resultString.length()-1;
		    	   i_row++;
		    	   myScreen.i_cols[i_row]=myScreen.i_cols[i_row-1];
		    	
		    	   max_i_col=this.T_Son.Node_2_Screen(myScreen, 
		    			   i_row, myScreen.i_cols[i_row], max_i_col);
		    	   i_col=max_i_col;
			       //
		    	   i_row--; // First
		    	   i_row--; // Second
		    	   i_col=i_col+1;
			       resultString="-"; 
			       k=0;
			       // Filling with '-'
			       for (i=myScreen.i_cols[i_row]+1;i<=max_i_col+1;i++)
			    	{
			    		//myScreen.Image[i_row][i]=resultString;
			    	    myScreen.setImage(i_row, i, resultString);
			    	    k++;
			    	} 
			       myScreen.i_cols[i_row]=myScreen.i_cols[i_row]+k;	
			       max_i_col=this.T_Brother.Node_2_Screen(myScreen, i_row, i_col, max_i_col);
			       max_i_col=Math.max(myScreen.i_cols[i_row], max_i_col);	

	    		 } // n_if=22;
	    	}
	    	else if ( this.T_Son!=null && this.T_Brother==null )
	    	{
	    		n_if=3;
	    		if(i_debug==1) System.out.println("'"+this.a_value + "'" + " n_if: " + n_if);
	    		//
	    		resultString= this.a_value;
	    		//myScreen.Image[i_row][i_col]=resultString;
	    		myScreen.setImage(i_row, i_col, resultString);
	    		myScreen.i_cols[i_row]=i_col+resultString.length()-1;
	    		i_row++;
		    	resultString="|";		
		    	//myScreen.Image[i_row][i_col]=resultString;
		    	myScreen.setImage(i_row, i_col, resultString);
		    	myScreen.i_cols[i_row]=i_col+resultString.length()-1;
	        	i_row++;
	        	myScreen.i_cols[i_row]=myScreen.i_cols[i_row-1]; // '-1'

	        	max_i_col=this.T_Son.Node_2_Screen(myScreen, i_row, myScreen.i_cols[i_row], max_i_col);
	        	max_i_col=Math.max(myScreen.i_cols[i_row], max_i_col);	
	    	}// n_if=3;
	    	else if ( this.T_Son==null && this.T_Brother!=null)
	    	{
	    		n_if=4;
	    		if(i_debug==1) System.out.println("'"+ this.a_value + "'" + " n_if: " + n_if);
	    		resultString= this.a_value;
	    		//myScreen.Image[i_row][i_col]=resultString;
	    		myScreen.setImage(i_row, i_col, resultString);
		    	myScreen.i_cols[i_row]=myScreen.i_cols[i_row]+resultString.length()-1;
		    	//System.out.print(resultString);
		    	resultString="-";
		    	myScreen.i_cols[i_row]++; // Pointing the empty place.
		    	k=0;
		    	// Filling with '-'
		    	for (i=myScreen.i_cols[i_row];i<myScreen.i_cols[i_row]+1;i++)
		    	{
		    		//myScreen.Image[i_row][i]=resultString;
		    	    myScreen.setImage(i_row, i, resultString);
		    	    k++;
		    	} 
		    	myScreen.i_cols[i_row]=myScreen.i_cols[i_row]+k;
		    	max_i_col=this.T_Brother.Node_2_Screen(myScreen, i_row, myScreen.i_cols[i_row], max_i_col);
		    	//i_col=max_i_col;
		    	max_i_col=Math.max(myScreen.i_cols[i_row], max_i_col);

	    	} // n_if=4;
	    	else if ( this.T_Son==null && this.T_Brother==null)
	    	{  
	    		n_if=5;
	    		if(i_debug==1) System.out.println("'"+ this.a_value + "'" + " n_if: " + n_if);
	    		resultString= this.a_value;
	    		//myScreen.Image[i_row][i_col]=resultString;
	    		myScreen.setImage(i_row, i_col, resultString);
	    		myScreen.i_cols[i_row]=myScreen.i_cols[i_row]+resultString.length();

	    	} // n_if=5;
	    	else 
	    	{  
	    		n_if=6;
	    		if(i_debug==1) System.out.println(this.a_value + " n_if: " + n_if);
	    		resultString="**"; // Error
	    		//resultString= this.a_value;
	    		//myScreen.Image[i_row][i_col]=resultString;
	    		myScreen.setImage(i_row, i_col, resultString);
		    	//System.out.println(resultString);
	    		//resultString=" " + this.a_value + " ";
	    	} // n_if=6;
	    } // else
	    //
	    max_i_col=Math.max(i_col, max_i_col);
	    return max_i_col; 
	} // String  Node_2_Plot()	
	// ===========================================
	public int  NodesNumber(){
	    int resultNumber;
	    int localSonOffsprings;
	    int localBrotherOffsprings;
	    if (this == null)
	    {resultNumber=0;}
	    else
	    {
	    	if (this.T_Son==null)
	    	{ localSonOffsprings= 0; }
	    	else
	    	{ localSonOffsprings=this.T_Son.NodesNumber(); }
	    	// ---------------------------
	    	if (this.T_Brother==null)
	    	{ localBrotherOffsprings= 0; }
	    	else
	    	{ localBrotherOffsprings=this.T_Brother.NodesNumber(); }
	    	// ---------------------------
	    
	    	resultNumber=1 +  localSonOffsprings + localBrotherOffsprings;
	    }
		return resultNumber;    
	}	
	// ===============================================
	public boolean isLeaf(){
		// Checking if the Node is a leaf
		boolean myLogical;
		myLogical=false;
		if (this.T_Son==null && this.T_Brother== null)
			myLogical=true;		
		return myLogical;
	} // isLeaf()
//	 ===============================================
	public boolean isSingle(){
		// Checking if the Node is a single Node
		boolean myLogical;
		myLogical=false;
		if (this.T_Son==null && this.T_Brother== null &&
				this.T_Father==null)
			myLogical=true;		
		return myLogical;
	} // isSingle(){
//	 ===============================================
	public boolean isRoot(){
		// Checking if the Node is a root Node
		boolean myLogical;
		myLogical=false;
		if (this.T_Father==null)
			myLogical=true;		
		return myLogical;
	} // isRoot()
//   ===============================================
static public Node Console_2_Node(String prompt){
	// 
    //   Reading a Node from a Console
	//
	Node localNode;
	localNode = new Node(); 
	String a_value;
	int i_debug;
	i_debug=1;
    i_debug=Debug.i_debug;
    //if(i_debug==0) System.out.println("do-Dump: Console_2_Node");
    
	System.out.println("Enter the Node value:");
	//a_value= myConsole.readString(prompt);
     
//    localNode.a_value=a_value;          
	return localNode;
    } // static public Node Console_2_Node(String prompt)
//===============================================

//================================================
public int Node_insert_Node(Node myNode){
	  //
	  // Input
	  // =====
	  // myNode - a  Node to be inserted to a binary tree.
	  //
	  // Input/Output
	  // ============
	  // this - 1) the Node before inserting,
	  //        2) and after it.
	  //
	  int resultNumber;
	  int nf; // number flow
	  resultNumber=-1;
	  //
	  nf=0;
	  nf=nf-1;
	  if ( this==null )
	  {
		  nf=10;
		  System.out.println("nf: " + nf);
		  resultNumber=0;
		  this.a_value=myNode.a_value;
	  }
	  else // this!=null
	  {
		  nf=20;
		  System.out.println("nf: " + nf);
		  if (this.isLeaf())
		  {
			  nf=30;
			  System.out.println("nf: " + nf);
			  if (this.a_value.compareTo("*")==0)
			  {
				  nf=50;
			      System.out.println("nf: " + nf);
			      this.T_Brother=myNode;
			  }
			  else // this.a_value.compareTo("*")!=0
			  {
			      nf=60;
			      System.out.println("nf: " + nf);
				  if (this.a_value.compareTo(myNode.a_value)<0)
				  {   // tree node < insert node.
					  nf=70;
				      System.out.println("nf: " + nf);
					  Node astrixNode;
					  astrixNode=new Node("*");
					  this.T_Son=astrixNode;
					  this.T_Son.T_Father=this;
					  this.T_Son.T_Brother=myNode;					
				  }
				  else
				  {   // tree node > insert node.
					  nf=80;
					  System.out.println("nf: " + nf);
					  this.T_Son=myNode;
					  this.T_Son.T_Father=this;
				  }
			  } // if (this.a_value.compareTo("*")!=0)
		  } // this.isLeaf()
		  //----------------------------------------
	      else // !this.isLeaf()
		      {
	    	      nf=40;
			      System.out.println("nf: " + nf);
				  if (this.a_value.compareTo("*")==0)
				  {
		    	   nf=90;
		    	   System.out.println("nf: " + nf);
		    	   Node tempNode;
		    	   tempNode=this.T_Brother;
		    	   Node_2_Node(this,myNode); // this <-- myNode
		    	   this.T_Brother=tempNode;
		          } //  this a_value.compareTo("*")==0)
	              //------------------
			      else //  this a_value.compareTo("*")!=0)
			      {  
			    	  nf=100;
			    	   System.out.println("nf: " + nf);
				      if(this.a_value.compareTo(myNode.a_value)<0)
	                  { // tree node > insert node.
	               	   nf=110;
	    	           System.out.println("nf: " + nf);
	    	           resultNumber=this.T_Son.Node_insert_Node(myNode);	 
			    	   this.T_Son.T_Father=this;  
	                  }
				      else // this.a_value.compareTo(myNode.a_value)>0)
			          { // tree node < insert node.
			    	   nf=120;
			    	   System.out.println("nf: " + nf);
			    	   resultNumber=this.T_Son.T_Brother.Node_insert_Node(myNode);	  
			    	  
			          }
			      }  //  this a_value.compareTo("*")!=0)
		      } // !this.isLeaf()
	  } // // this!=null
	  
	  return resultNumber;
}; // int Node_insert_Node(Node myNode)
//==================================================
}  // public class Node
//   ===============================================