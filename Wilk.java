package WirtualnySwiatJava;
import java.awt.*;
import java.util.Random;
public class Wilk extends Zwierze{

    public Wilk(int Y, int X,Swiat swiat,Random rng)
    {
        super(9,5,X,Y,"Wilk",true,swiat,0,rng,new Color(142, 145, 144));
    }
    public Wilk(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, 5, X, Y,  "Wilk", true, swiat, wiek,rng,new Color(142, 145, 144));
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new Wilk(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
}
