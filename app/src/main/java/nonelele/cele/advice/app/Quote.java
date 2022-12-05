package nonelele.cele.advice.app;

public class Quote {
   private String q;
   private String a;
   private String i;
   private int c;
   private String h;

    public Quote(String q, String a, String i, int c, String h) {
        this.q = q;
        this.a = a;
        this.i = i;
        this.c = c;
        this.h = h;
    }

    public String getQ() {
        return q;
    }

    public String getA() {
        return a;
    }

    public String getI() {
        return i;
    }

    public int getC() {
        return c;
    }

    public String getH() {
        return h;
    }
}
