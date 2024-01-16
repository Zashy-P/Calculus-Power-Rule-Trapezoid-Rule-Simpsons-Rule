import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Scanner;

public class Ui extends Application {
    Scanner input = new Scanner(System.in);
    @Override
    public void start(Stage primaryStage) {


        Text title = new Text("Calculus Calculator");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setFill(Color.BLACK);

        Button trapezoidalRuleButton = new Button("Trapezoidal Rule");
        trapezoidalRuleButton.setStyle("-fx-background-color: #C82333; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 16px; -fx-border-radius: 5px; -fx-box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);");
        trapezoidalRuleButton.setOnAction(event -> trapezoidalRule());

        Button simpsonsRuleButton = new Button("Simpson's Rule");
        simpsonsRuleButton.setStyle("-fx-background-color: #C82333; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 16px; -fx-border-radius: 5px; -fx-box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);");
        simpsonsRuleButton.setOnAction(event -> simpsonsRule());

        Button powerRuleButton = new Button("Power Rule");
        powerRuleButton.setStyle("-fx-background-color: #C82333; -fx-text-fill: white; -fx-padding: 10px 20px; -fx-font-size: 16px; -fx-border-radius: 5px; -fx-box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);");
        powerRuleButton.setOnAction(event -> powerRule());

        VBox root = new VBox();
        root.setSpacing(20);
        root.getChildren().addAll(title, trapezoidalRuleButton, simpsonsRuleButton, powerRuleButton);
      
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Calculus Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
      //trapezoidal Rule code
      private void trapezoidalRule() {

        System.out.println("");
        System.out.println("This program finds the area using the trapezoid rule.");
        System.out.println("");
    
        System.out.println("");
        System.out.println("Number of terms: ");
        int nterm=input.nextInt();
        System.out.println("");
    
        System.out.print("A: ");
        double A=input.nextInt();
    
        System.out.println("");
        System.out.print("B: ");
        double B=input.nextInt();
    
        System.out.println("");
        System.out.print("N: ");
        int N=input.nextInt();
    
        double[] Coefficient=new double[nterm];
        double[] Power=new double[nterm];
    
        for(int j=0;j<nterm;j++){
            System.out.println("");
            System.out.println("Enter Coefficient "+(j+1)+" ");
            Coefficient[j]=input.nextDouble();
    
            System.out.println("");
            System.out.println("Enter power "+(j+1)+" ");
            Power[j]=input.nextDouble();
        }
    
        double x0=A;
        double deltax=(B-A)/N;
        double sum=0;
        double msum=0;
        double x;
    
        for(int i=0;i<=N;i++){
            x=x0+i*deltax;
    
            sum=sum(Coefficient,Power,x);
    
            if(i==0 || i==N)
                msum+=sum;
    
            else
                msum+=2*sum;
        }
        System.out.println("area= "+answer(msum,deltax));
    }
    
    static double answer(double msum,double deltax){
        return (deltax/2)*msum;
    }
    
    static double sum(double[] Coefficient, double[] Power, double x){
        double lsum=0;
        for(int u=0;u<Coefficient.length;u++){
            lsum+=Coefficient[u]*Math.pow(x,Power[u]);
        }
        return lsum;
    }



    static double answer2(double msum,double deltax){
      return (deltax/3)*msum;
    }
    static double sum2(double[] Coefficient, double[] Power, double x){
      double sum2=0;
       for(int u=0;u<Coefficient.length;u++){
         sum2+=Coefficient[u]*Math.pow(x,Power[u]);}
      return sum2;
    }  




    private void simpsonsRule() {
      
        System.out.println("");
        System.out.println("This program finds the area using Simpsons rule.");
        System.out.println("");
    
    System.out.println("");
        System.out.println("Number of terms: ");
        int nterm=input.nextInt();
        System.out.println("");
        if(nterm<=0){
          System.out.println("Invalid number of terms");
          System.exit(0);
        }
        
        System.out.print("A: ");
        double A=input.nextInt();
        
        System.out.println("");
        System.out.print("B: ");
        double B=input.nextInt();
        
        System.out.println("");
        System.out.print("N: ");
        int N=input.nextInt();
    
      double[] Coefficient=new double[nterm];
      double[] Power=new double[nterm];
    
        
        for(int j=0;j<nterm;j++){
          
          System.out.println("");
          System.out.println("Enter Coefficient "+(j+1)+" ");
          Coefficient[j]=input.nextDouble();
          
          System.out.println("");
          System.out.println("Enter power "+(j+1)+" ");
          Power[j]=input.nextDouble();
        }
        double x0=A;
        double deltax=(B-A)/N;
        double sum=0;
        double msum=0;
        double x;
        
        for(int i=0;i<=N;i++){
          x=x0+i*deltax;
    
          sum=sum2(Coefficient,Power,x);
          
          if(i==0 || i==N){
          msum+=sum; }
        
          else if(i%2==0){
           msum+=2*sum; }
    
          else if(i%2==1){
            msum+=4*sum;
          }
          
        }
        System.out.println("");
          System.out.println("area= "+answer2(msum,deltax));
    }

    private void powerRule() {
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

    public static void main(String[] args) {
        launch(args);
    }

}
