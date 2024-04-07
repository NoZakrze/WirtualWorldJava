package WirtualnySwiatJava;


import java.awt.*;
import java.util.Random;
public class Guarana extends Roslina {
    public Guarana(int Y, int X, Swiat swiat, Random rng)
    {
        super(0,X,Y,"Guarana",false,swiat,0,rng,new Color(242, 68, 204));
    }
    public Guarana(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, X, Y,  "Guarana", false, swiat, wiek,rng,new Color(242, 68, 204));
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new Guarana(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY());
    }
    public void porazka(Organizm rywal, boolean atak)
    {
        rywal.setX(polozenieX);
        rywal.setY(polozenieY);
        rywal.setSila(rywal.getSila() + 3);
        this.zywe = false;
        System.out.println(this.getnazwa() + " nie zyje" + '\n');
        swiat.dodajNapis(this.getnazwa() + " nie zyje");
        swiat.usunMartwe();
    }
}
