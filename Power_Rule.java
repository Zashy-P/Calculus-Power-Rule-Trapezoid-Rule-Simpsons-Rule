import java.util.Scanner;
class Power_Rule {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("");
    System.out.println("This program finds the derivative using power rule.");
    System.out.println("");
System.out.print("How many terms does the function have? ");
    int nterm=input.nextInt();
    if(nterm<=0){ System.out.println("The term cant be zero or below zero");}
    else{
     int v1=1;
     int ct =0;
      String [] function =new String[nterm];
      String [] derivative =new String[nterm];
      while(v1<=nterm){
        ct++;
        System.out.println("");
        System.out.println("Term "+ct);
        System.out.println("");
        System.out.print("If you have a Variable type 1 if not type 2: "); 
    int yn =input.nextInt();
    System.out.println("");
    if(yn==1){
     System.out.println("Variable: ");
    String Variable =input.next();
    System.out.println("Coefficient: ");
      int Coefficient = input.nextInt();
    System.out.println("Power: ");
      int Power =input.nextInt();
    int pc= Power*Coefficient;
    int p=Power-1;
    if(p<0){
      String f = Coefficient+Variable+"^"+Power;
      //String dmf=pc+Variable+"^"+p;
      String df=pc+"/"+Variable+"^-"+p;
      function[v1-1]=f;
      derivative[v1-1]=df;
      /*System.out.println("f(x)= "+f);
      System.out.println("f(x)'= "+dmf);
      System.out.println("f(x)'= "+df); */}
    else if(p==0){
      String f=Coefficient+Variable+"^"+Power;
      String df=Integer.toString(Coefficient);
      function[v1-1]=f;
      derivative[v1-1]=df;
      /*System.out.println("f(x)= "+f);
      System.out.println("f(x)'= "+df);*/}
    else{
      String f = Coefficient+Variable+"^"+Power;
      String df=pc+Variable+"^"+p;
       function[v1-1]=f;
      derivative[v1-1]=df;
      /*System.out.println("f(x)= "+f);
      System.out.println("f(x)'= "+df);*/}}
      
    else if(yn==2){
    System.out.print("Coefficient: ");
      int Coefficient =input.nextInt();
    System.out.print("Power: ");
      int Power =input.nextInt();
     String f=Coefficient+"^"+Power;
     String df ="0";
     function[v1-1]=f;
     derivative[v1-1]=df;
      /*System.out.println("f(x)= "+f);
      System.out.println("f(x)'= "+df);*/}
      v1++;
      
      }
       System.out.println("------------------------------------------------------------------------------- ");
      System.out.print("f(x)= ");
      for(int i=0;i<nterm;i++){
        System.out.print(function[i]);
        if(i<nterm-1){
          System.out.print(" + ");
        }// if
      }//for
       System.out.println("");
  
       System.out.print("f(x)'= ");
      for(int i=0;i<nterm;i++){
        System.out.print(derivative[i]);
        if(i<nterm-1){
          System.out.print(" + ");
        }//if
      }//for
    }
  } 
}