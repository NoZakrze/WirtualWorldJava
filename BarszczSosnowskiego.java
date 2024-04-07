package WirtualnySwiatJava;


import java.awt.*;
import java.util.Random;
public class BarszczSosnowskiego extends Roslina {
   public BarszczSosnowskiego(int Y, int X, Swiat swiat, Random rng)
    {
        super(10, X, Y, "BarszczSosnowskiego", false, swiat,0,rng, Color.RED);
    }
    public BarszczSosnowskiego(int Y, int X, Swiat swiat, int sila, int wiek, Random rng)
    {
        super(sila, X, Y, "BarszczSosnowskiego", false, swiat,wiek,rng,Color.RED);
    }
    public void akcja()
    {
        if ( polozenieY > 0)
        {
            Organizm tmp = swiat.zajetePole(polozenieY - 1, polozenieX);
            if (tmp != null)
            {
                if (tmp.getInicjatywa() > 0)
                {
                    System.out.println(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY() + '\n');
                    swiat.dodajNapis(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY());
                    tmp.porazka(this,true);
                }
            }
        }
        if ( polozenieX < swiat.GetN() - 1)
        {
            Organizm tmp = swiat.zajetePole(polozenieY, polozenieX + 1);
            if (tmp != null)
            {
                if (tmp.getInicjatywa() > 0)
                {
                    System.out.println(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY() + '\n');
                    swiat.dodajNapis(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY());
                    tmp.porazka(this,true);
                }
            }
        }
        if ( polozenieY < swiat.GetM() - 1 )
        {
            Organizm tmp = swiat.zajetePole(polozenieY + 1, polozenieX);
            if (tmp != null)
            {
                if (tmp.getInicjatywa() > 0)
                {
                    System.out.println(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY() + '\n');
                    swiat.dodajNapis(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY());
                    tmp.porazka(this,true);
                }
            }
        }
        else if ( polozenieX > 0 )
        {
            Organizm tmp = swiat.zajetePole(polozenieY, polozenieX - 1);
            if (tmp != null)
            {
                if (tmp.getInicjatywa() > 0)
                {
                    System.out.println(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY() + '\n');
                    swiat.dodajNapis(this.getnazwa() + " popazyl " + tmp.getnazwa() + " na polu " + tmp.getX() + " " + tmp.getY());
                    tmp.porazka(this,true);
                }
            }
        }
        super.akcja();
    }
    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng)
    {
        Organizm nowy = new BarszczSosnowskiego(Y, X,swiat,rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY()+ '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu "+ nowy.getX() + " " + nowy.getY());
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
