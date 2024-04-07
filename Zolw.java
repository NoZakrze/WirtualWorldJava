package WirtualnySwiatJava;
import java.awt.*;
import java.util.Random;
public class Zolw extends Zwierze {
    public Zolw(int Y, int X, Swiat swiat, Random rng) {
        super(2, 1, X, Y, "Zolw", true, swiat, 0, rng, Color.BLUE);
    }

    public Zolw(int Y, int X, Swiat swiat, int sila, int wiek, Random rng) {
        super(sila, 1, X, Y, "Zolw", true, swiat, wiek, rng,Color.BLUE);
    }

    protected void rozmnazanie(int Y, int X, Swiat swiat, Random rng) {
        Organizm nowy = new Zolw(Y, X, swiat, rng);
        swiat.dodajOrganizm(nowy);
        System.out.println(this.getnazwa() + " pojawil sie na polu" + nowy.getX() + " " + nowy.getY() + '\n');
        swiat.dodajNapis(this.getnazwa() + " pojawil sie na polu"+ nowy.getX() + " " + nowy.getY());
    }

    public void akcja() {
        int los1 = rng.nextInt(4);
        if (los1 == 0) {
            super.akcja();
        }
    }

    public void porazka(Organizm rywal, boolean atak) {
        if (!atak) {
            if (rywal.getSila() >= 5) {
                rywal.setX(polozenieX);
                rywal.setY(polozenieY);
                zywe = false;
                System.out.println(this.getnazwa() + " nie zyje" + '\n');
                swiat.dodajNapis(this.getnazwa() + " nie zyje");
                swiat.usunMartwe();
            } else {
                System.out.println(this.getnazwa() + " odbil atak na polu " + rywal.getX() + " " + rywal.getY() + '\n');
                swiat.dodajNapis(this.getnazwa() + " odbil atak na polu " + rywal.getX() + " " + rywal.getY());
            }
        } else {
            zywe = false;
            System.out.println(this.getnazwa() + " nie zyje" + '\n');
            swiat.dodajNapis(this.getnazwa() + " nie zyje");
            swiat.usunMartwe();
        }
    }
}
