import java.util.Scanner;
class Trapeziod_Rule {
  static double answer(double msum,double deltax){
    return (deltax/2)*msum;
  }
  static double sum(double[] Coefficient, double[] Power, double x){
    double lsum=0;
     for(int u=0;u<Coefficient.length;u++){
       lsum+=Coefficient[u]*Math.pow(x,Power[u]);}
    return lsum;
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
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
}