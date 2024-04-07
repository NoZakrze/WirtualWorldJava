package WirtualnySwiatJava;


import java.awt.*;
import java.util.Random;
public class WilczeJagody extends Roslina {
    public WilczeJagody(int Y, int X, Swiat swiat, Random rng)
    {
        super(99,X,Y,"WilczeJagody",false,swiat,0,rng, new Color(166, 37, 247));
    }
    public WilczeJagody(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, X, Y,  "WilczeJagody", false, swiat, wiek,rng,new Color(166, 37, 247));
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new WilczeJagody(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }
    public void porazka(Organizm rywal, boolean atak)
    {
        rywal.setZywe();
        this.zywe = false;
        System.out.println(this.getnazwa() + " nie zyje" + '\n');
        System.out.println(rywal.getnazwa() + " nie zyje" + '\n');
        swiat.dodajNapis(this.getnazwa() + " nie zyje");
        swiat.dodajNapis(rywal.getnazwa() + " nie zyje");
        swiat.usunMartwe();
    }
}

