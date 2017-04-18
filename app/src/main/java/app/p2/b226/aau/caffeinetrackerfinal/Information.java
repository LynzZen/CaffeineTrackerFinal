package app.p2.b226.aau.caffeinetrackerfinal;

/**
 * Created by Lynge on 18/04/2017.
 */

public class Information {
    String[] Quotes;


    public String GetQuote (int i){
        Quotes = new String[10];
        Quotes[0] = "Hello you should not drink so much coffee";
        Quotes[1] = "What are you doing put that cup of coffee down";
        Quotes[2] = "Coffee makes you fart";
        return Quotes[i];
    }
}
