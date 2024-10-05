
/**
 * Klasse Anhaenger
 * 
 * @author (SG) 
 * @version (27.09.2024)
 */
public class Anhaenger {
    
    private double eigengewicht;
    private double ladung;
    private String test;
    
    //Konstruktoren
    public Anhaenger() {
        setEigengewicht(1.5);
        // default ladung = 0.0
    }
    
    public Anhaenger(double neuEigengewicht) {
        setEigengewicht(neuEigengewicht);
        // default ladung = 0.0
    }
    
    //getter
    public double getEigengewicht() {
        return eigengewicht;
    }
    
    public double getLadung() {
        return ladung;
    }
        
    //setter --------- private setLadung wäre möglich
    public void setEigengewicht(double neuEigengewicht) {
        if (neuEigengewicht >= 0.1) {
            eigengewicht = neuEigengewicht;
        } else {
            System.out.println("Fehler.");
        }
    }
    
    //weitere Methoden
    public int aufladen(int zuladung) {
        double zuladungDoubleTonnen = (double)zuladung/1000.0;
        double überladung;
        
        // Ladung 2.999, Zuladung 0.002 -> Rückgabewert 0, warum?? Alles andere funktioniert
        
        if (zuladung > 0) {
            if (ladung < 2 * eigengewicht) {
                if (ladung + zuladungDoubleTonnen <= 2 * eigengewicht) {
                ladung = ladung + zuladungDoubleTonnen;
                return 0;
                } else {
                    überladung = ladung + zuladungDoubleTonnen - 2 * eigengewicht;
                    ladung = 2 * eigengewicht;
                    return (int)(überladung*1000);
                }
            } else {
                System.out.println("Der Anhänger ist voll.");
            }
        } else {
            System.out.println("Die Zuladung muss größer Null sein.");
        }
        return -99;
    }
    
    public double berechneGesamtgewicht() {
        return eigengewicht + ladung;
    }
    
    public void printAnhaenger() {
        System.out.println("Der Anhänger hat folgende Daten: \n" +
                           "Eigengewicht: " + eigengewicht + " Tonnen\n" +
                           "Ladung: " + ladung + " Tonnen\n" +
                           "Gesamtgewicht: " + berechneGesamtgewicht() + " Tonnen\n");
    }
}
