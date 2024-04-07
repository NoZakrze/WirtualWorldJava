package WirtualnySwiatJava;


import java.awt.*;
import java.util.Random;
public class Trawa extends Roslina {
    public Trawa(int Y, int X, Swiat swiat, Random rng)
    {
        super(0,X,Y,"Trawa",false,swiat,0,rng, Color.GREEN);
    }
    public Trawa(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, X, Y,  "Trawa", false, swiat, wiek,rng,Color.GREEN);
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new Trawa(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
}
