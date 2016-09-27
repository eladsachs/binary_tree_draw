
public class SearchTree {
	public Node root;
	public int  typeTree;
	public SearchTree(){	
	}
	// =================================
	public int insert(Node myNode){
		  //
		  // Input
		  // =====
		  // myNode - a Node to be inserted to a binary tree.
		  //
		  // Input/Output
		  // ============
		  // this - 1) the tree before inserting,
		  //        2) and after it.
		  //
		  int resultNumber;
		  int i_dump;
		  i_dump=Debug.i_debug;
		  resultNumber=-1;
		  if(i_dump==0) System.out.println("do-Dump: SearchTree.insert_Node: ");
		  //
		  if ( this.root==null )
		  {
			  resultNumber=0;
			  this.root=myNode;
		  }
		  else
		  {
			  this.root.insert(myNode);
			  resultNumber = 999;
		  }
		  return resultNumber;
	 }; // insert(Node myNode)
	 // ==================================
	 // ================================================
	  public String SearchTree_2_Preorder(){
		  //
		  // Receiving a string representing a SearchTree a_values
		  //             in a preorder.
		  // Output:
		  // =======
		  // resultString - of the a-values in a preorder
		  //
		  String resultString;
		  int i_debug;
		  // 
		  i_debug=Debug.i_debug;
		  if(i_debug==0) System.out.println("do-Dump: SearchTree_2_Preorder. " );
		  
		  resultString="";
		  if ( this.root==null )
		  {
			  resultString="()";
		  }
		  else
		  {
			  resultString=this.root.Node_2_Preorder(resultString);
		  }
		  return resultString;
	  }; // public String SearchTree_2_Preorder()
//	 ================================================
	  public int sweepPreorder(){
		  //
		  // Sweeping the SearchTree in a Preorder
		  //
		  // Output:
		  // =======
		  // status - the status of the operation (to be defined)
		  int status; // The status of the operation
		  int i_debug;
		  // 
		  i_debug=Debug.i_debug;
		  if(i_debug==0) System.out.println("do-Dump: SearchTree.sweepPreorder. " );
		  
		  status=0;
		  if ( this.root==null )
		  {
			  status=0;
		  }
		  else
		  {
//			 Sweeping using the Node's method.
			  status=this.root.sweepPreorder(); 
		  }
		  return status;
	  }; // public String sweepPreorder()	  
//	================================================
		 // ================================================
	  public Tree SearchTree_2_Tree(){
		  // 
		  // Only the a_values are copied to the new Tree.
		  //
		  Tree resultTree;
		  String myString3;
		  listCompound myListCompound,myListCompoundSpaced;
		  resultTree=new Tree();
		  int i_dump;
		  i_dump=0;
		  // 
		  if(i_dump==0) System.out.println("do-Dump: SearchTree_2_Tree. " );
		  
		  myString3=this.SearchTree_2_Preorder();
	      myListCompound= new listCompound(myString3);
	      myListCompoundSpaced=myListCompound.spaced();
	      resultTree=myListCompoundSpaced.listCompound_2_Tree();
	      //
		  return resultTree;
	  } // String SearchTree_2_Tree()
	 // ==================================
//		 ==========================
		 static public SearchTree File_2_SearchTree (){
			//
			// Input:
			// ======
			// () -
			//
			// Output
			// ============
			// localSearchTree - A SearchTree from a File;
			//
			SearchTree localSearchTree;
			Node localNode;
			Node tempNode;
			int status;
			int i;
			
			status=-1;
			status=status+1;
			localSearchTree=new SearchTree();
			tempNode=localSearchTree.new Node();
			listCompound myListCompound;
			String localString;
			int i_debug;
		    i_debug=Debug.i_debug;
		    if(i_debug==0) System.out.println("do-Dump: SearchTree.File_2_SearchTree");
		    
		    localString="";
		    localNode=tempNode.File_2_Node();
		    status=myFile.myOpenInFile();
		    //for(i=0;i<3;i++)
		    i=0;
		    while(localString!=null)
		    {
		    	i++;
			    localString=myFile.myReadFile();
		        //if(localString.equals("")) break;
			    if(localString==null) break;
		        myListCompound=new listCompound(localString);
		        localNode= localSearchTree.new Node (myListCompound);
	
		        localSearchTree.insert(localNode);
		    }
	        
	        status=myFile.myCloseInFile();
			return localSearchTree;
		}; // SearchTree File_2_SearchTree ()	
	// ==================================
    // ================================================
		  public int SearchTree_2_Screen(String title,Screen myScreen){
			  //
			  // Plotting a tree: Prefix notation
			  //
			  // Input: 
			  // ======
			  // title - the title of the tree
			  //
			  // Input/Output:
			  // =============
			  // myScreen - the matrix, representing the tree
			  //            to be printed, in a separate command.
			  //
			  int resultWarning;
			  resultWarning=0;
			  Tree myTree3;
		        myTree3=this.SearchTree_2_Tree();
		        myTree3.Tree_2_Screen(title, myScreen);
			  return resultWarning;
		  } // 
	 // ==================================
	public  class Node{
		String a_value;
		int semanticsType; // Semantics Categories
		int syntaxType;    //Syntax: subject, object, verb
		int speachType;    //noun, verb, preposition,		
		Node T_Left;
		Node T_Right;
		Node T_Father;
		// ===============================================
		public boolean isLeaf(){
			// Checking if the Node is a leaf
			boolean myLogical;
			myLogical=false;
			if (this.T_Left==null && this.T_Right== null)
				myLogical=true;		
			return myLogical;
		} // isLeaf()
		// ==========================
		public Node (String myString){
		    a_value=myString;
			semanticsType=0;
			syntaxType=0;
			speachType=0;
			T_Father=null;
			T_Left=null;
			T_Right=null;
		}; // Node (String myString)
		// ==========================
		public Node (listCompound myListCompound){
			//
			// Constructor
			//
			String stringTemp;
			boolean is;
		    int i_debug;
		    i_debug=Debug.i_debug;
		    if(i_debug==0) System.out.println("do-Dump: SearchTree.Node(listCompound) ");		
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
			if(is) T_Left=null;
			//
			stringTemp=(String)myListCompound.stackList.elementAt(6);
			is=stringTemp.equals("null");
			if(is) T_Right=null;
	//
		} // public Node (String value1, int semanticsType1, ...
		// ===============================================
		Node(){};          // Costructor
		// ===============================================
		int insert(Node myNode){
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
			  int i_dump;
			  i_dump=Debug.i_debug;
			  int nf; // number flow
			  if(i_dump==0) System.out.println("do_Dump: SearchTree.Node:insert" );
			  resultNumber=-1;
			  //
			  nf=0;
			  nf=nf-1;
			  if ( this==null )
			  {
				  nf=10;
				  if(i_dump==1) System.out.println("nf: " + nf);
				  resultNumber=0;
				  this.a_value=myNode.a_value;
			  } // this==null
			  else
			  {
				  nf=20;
				  if(i_dump==1) System.out.println("nf: " + nf);
				  if (this.isLeaf())
				  {
					  nf=30;
					  if(i_dump==1) System.out.println("nf: " + nf);
					  				    
					  if (this.a_value.compareTo(myNode.a_value)<0)
					  {   // tree node < insert node.
						  nf=70;
						  if(i_dump==1) System.out.println("nf: " + nf);
						  this.T_Right=myNode;					
					  }
					  else
					  {   // tree node > insert node.
						  nf=80;
						  if(i_dump==1) System.out.println("nf: " + nf);
						  this.T_Left=myNode;
					  }   // tree node > insert node.
					  
				  } // this.isLeaf() 
				  else // this.isLeaf()
				  // ===========================
				  {    // !this.isLeaf()
					  nf=40;
					  if(i_dump==1) System.out.println("nf: " + nf);
					  if (this.a_value.compareTo(myNode.a_value)<0)
					  {   // tree node < insert node.
						  nf=50;
						  if(i_dump==1) System.out.println("nf: " + nf);
					      if (this.T_Right==null)
					      {
					    	nf=51;
					    	if(i_dump==1) System.out.println("nf: " + nf);
					        this.T_Right=myNode;
					      }
					      else
					      {
					    	  nf=52;
					    	  if(i_dump==1) System.out.println("nf: " + nf);
						    this.T_Right.insert(myNode);	
					      }
					  }
					  else
					  {   // tree node > insert node.
						  nf=60;
						  if(i_dump==1) System.out.println("nf: " + nf);
						  if (this.T_Left==null)
					      {
					    	nf=61;
					    	if(i_dump==1) System.out.println("nf: " + nf);
					        this.T_Left=myNode;
					      }
					      else
					      {
					    	  nf=52;
					    	  if(i_dump==1) System.out.println("nf: " + nf);
						    this.T_Left.insert(myNode);	
					      }
					  }   // tree node > insert node.				  
				  }
			  } // this!=null

			return resultNumber;
		} // insert(Node myNode)
		// =============================================
	
		// ===============================================
		String  Node_2_Preorder(String resultString){
			  //
			  // Input
			  // =====
			  //
			  // Input/Output
			  // ============
			  // resultString = String of a transformed Node.
			  //

			  int nf; // number flow
			  int i_debug;
			  i_debug=Debug.i_debug;
			  if(i_debug>=0)System.out.println("do-Dump: SearchTree.Node.Node_2_Preorder ");
			  //
			  nf=0;
			  nf=nf-1;
			 
			  {
				  nf=20;
				  if(i_debug==1) System.out.println("nf: " + nf);
				  if (this.isLeaf())
				  {
					  nf=30;
					  if(i_debug==1) System.out.println("nf: " + nf);
					  resultString=resultString + " " + this.a_value;				    				  					  
				  } // this.isLeaf() 
				  else // this.isLeaf()
				  // ===========================
				  {    // !this.isLeaf()
					  nf=40;
					  if(i_debug==1) System.out.println("nf: " + nf);
					  
					      if (this.T_Right==null)
					      {
					    	nf=51;
					    	if(i_debug==1) System.out.println("nf: " + nf);
						    resultString=resultString + 
						    "(" + " " + this.a_value + " " + this.T_Left.Node_2_Preorder(resultString)+ " " + "*" + ")";
					      }
					      else
					      {
					    	  
					    	  if (this.T_Left==null)
						      {
						    	nf=52;
						    	if(i_debug==1) System.out.println("nf: " + nf);
							    resultString=resultString + 
							    "(" +  this.a_value + " " + " * " +  " " +
							     this.T_Right.Node_2_Preorder(resultString) + ")";
						      }
					    	  else
					    	  { // Two sons
					    	    nf=53;
					    	    if(i_debug==1) System.out.println("nf: " + nf);
							    resultString=resultString + 
							    "(" +  this.a_value + " " + this.T_Left.Node_2_Preorder(resultString)
							      +  " " + this.T_Right.Node_2_Preorder(resultString) + ")";	
					    	  }
					      }
					    	  
					  }
					 			  
				  }			  
			return resultString;
		} // Node_2_Preorder	
		
        // =================================
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
		    if(i_debug==0) System.out.println("do-Dump: SearchString.Node_2_String");
		    String sp; // space
		    sp=" ";
		    
			localString=a_value+sp;
			localString+= semanticsType+sp;
			localString+=syntaxType+sp;
			localString+=speachType+sp;
			localString+=T_Father+sp;
			localString+=T_Left+sp;
			localString+=T_Right;
			
			return localString;
		}; // public String Node_2_String ()		
		// =============================================
//		 ==========================
		 public int Node_2_File (){
			//
			// Input:
			// ======
			// this -
			//
			// Output
			// ============
			// status - writing status;
			//
			int status;
			String localString;
			int i_debug;
		    i_debug=Debug.i_debug;
		    if(i_debug==0) System.out.println("do-Dump: SearchTree.Node_2_File");
		    
			localString=this.Node_2_String();
			status=myFile.myOpenOutFile();
	        status=myFile.myWriteFile(localString);
	        status=myFile.myCloseOutFile();
	        	
			return status;
		}; // public String Node_2_File ()	
//		 ==========================
		 public Node File_2_Node (){
			//
			// Input:
			// ======
			// this -
			//
			// Output
			// ============
			// status - writing status;
			//
			Node localNode;
			int status;
			listCompound myListCompound;
			String localString;
			int i_debug;
		    i_debug=Debug.i_debug;
		    if(i_debug>=0) System.out.println("do-Dump: SearchTree.File_2_Node");
		    
		    localString="";
		    status=myFile.myOpenInFile();
		    localString=myFile.myReadFile();
	        status=myFile.myCloseInFile();
	        myListCompound=new listCompound(localString);
	        localNode= new Node (myListCompound);
	        
	        if(status!=0 || localString==null)
	        {
	        	localNode=null;
	        }
			return localNode;
		}; // public Node File_2_Node ()		
		// ===============================================
		int  sweepPreorder(){
		  //
		  // Input
		  // =====
		  //
		  // Input/Output
		  // ============
		  // status = status of the sweeping in preorder operation.
		  //
          int status;
		  int i_debug;
		  i_debug=Debug.i_debug;
		  if(i_debug>=0)System.out.println("do-Dump: SearchTree.Node.sweepPreorder ");
		  //
		  status=0;
 			  
		  if(i_debug==1) 
			  System.out.println("a_value: "+a_value);
		  //resultString=resultString + " " + this.a_value;				    				  					  
	  			  
	      if (this.T_Left!=null)
	      {
	    	status+=this.T_Left.sweepPreorder();
	      }
	      //
	      if (this.T_Right!=null)
	      {
	    	status+=this.T_Right.sweepPreorder();
	      }		
	      //
          return status;
		} // sweepPreorder		
		// =============================================		
	} // public  class Node
    //  ==================================
} // public class SearchTree
