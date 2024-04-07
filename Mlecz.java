package WirtualnySwiatJava;
import java.util.Random;
import java.awt.*;
public class Mlecz extends Roslina {
    public Mlecz(int Y, int X, Swiat swiat, Random rng)
    {
        super(0,X,Y,"Mlecz",false,swiat,0,rng,Color.YELLOW);
    }
    public Mlecz(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, X, Y,  "Mlecz", false, swiat, wiek,rng,Color.YELLOW);
    }
    public void akcja()
    {
        for (int i = 0; i < 3; i++)
        {
            super.akcja();
        }
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new Mlecz(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
}
