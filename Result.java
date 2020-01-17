package rpc;
public class Result {
  private int res;
  public Result(int res) {
    this.res = res;
  }
  public String toString() {
    return "Le resultat est "+this.res;
  }
}
