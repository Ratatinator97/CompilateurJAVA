package rpc;
public class Client {
  public static void main(String [] arg) {
    Matlab m = new Matlab(10);
    Result res = m.calcul(3);
    System.out.println("->" + res);

    //add
    
  }
}

