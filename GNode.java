import java.util.*;
public class GNode {//This implements a simple GNode class for testing purposes
                    //For demonstrating the walkGraph method creating an interface and object implementing that interface is overkill; this simple GNode class is adequate
     
     String name;//needed for testing purposes, contains the name of the node
     ArrayList<GNode> children;//needed for testing purposes, contains all the children of the node

     public GNode(String name){//start with a name and an empty list of children
          this.name = name;
          children = new ArrayList<GNode>();
     }

     public String getName(){//simulates the result of getName for testing purposes
          return this.name;
     }

     public GNode[] getChildren(){//simulates the result of getChildren adequately for testing purposes
          GNode[] myChildren = {};
          myChildren = (GNode[])(this.children.toArray(myChildren));
          if(myChildren == null){
               System.out.println("myChildren = null, "+getName()+"\n");
          }
          return myChildren;
     }

     public void addChild(GNode g){//needed for testing purposes
          children.add(g);
     }

}