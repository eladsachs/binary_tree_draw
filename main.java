/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elad
 */
public class main {
    public static void main(String[] args) {
        
         listCompound myList=new listCompound("( A ( B ( E F ) ) ( C ( G ) ) ( D ( H I J ) ) )");
         System.out.println(myList.isCorrect());
         Tree myTree=myList.listCompound_2_Tree();
         String testString=myTree.Tree_2_Preorder(myTree);
         //System.out.println(testString);
         Screen myScreen;
   	 myScreen=new Screen(10, 10, " ");
         myTree.Tree_2_Screen("tree", myScreen);
         myScreen.Screen2Print("Tree");
         
    }
}
