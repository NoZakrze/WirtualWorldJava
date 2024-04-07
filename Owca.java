package WirtualnySwiatJava;


import java.awt.*;
import java.util.Random;
public class Owca extends Zwierze{

    public Owca(int Y, int X,Swiat swiat,Random rng)
    {
        super(4,4,X,Y,"Owca",true,swiat,0,rng, Color.WHITE);
    }
    public Owca(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, 4, X, Y,  "Owca", true, swiat, wiek,rng,Color.WHITE);
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new Owca(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
}
