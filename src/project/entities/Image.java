package project.entities;

import project.interfaces.Adjustable;
import project.interfaces.Execute;

import java.util.Scanner;

public class Image extends Element implements Adjustable, Execute {
    private int brightness;

    public Image(String title, int brightness) {
        super(title);
        this.brightness = brightness;
    }

    @Override
    public void increaseBrightness() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("La luminosità attuale è: " + brightness);
        if (brightness == 10) {
            System.out.println("La luminosità è al massimo");
            return;
        } else if (brightness == 9) {
            System.out.println("L'unico valore inseribile è : " + 10);
            brightness = 10;

            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "!";
            }
            System.out.println(title + " " + brnOut + " La luminosità è : " + brightness);
            return;
        } else {
            int j = 0;
            do {
                System.out.println("Inserisci il nuovo valore per la luminosità tra " + (brightness + 1) + " e " + 10);
                j = Integer.parseInt(scanner.nextLine());
                if (j <= brightness || j > 10) {
                    System.out.println("Il valore non è compreso nel range, riprova ");
                }
            } while (j <= brightness || j > 10);
            brightness = j;
            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "*";
            }
            System.out.println(title + " " + brnOut + " La nuova luminosità è : " + brightness);
            return;

        }
    }

    @Override
    public void decreaseBrightness() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("La luminosità attuale è: " + brightness);
        if (brightness == 0) {
            System.out.println("La luminosità è al minimo");
            return;
        } else if (brightness == 1) {
            System.out.println("L'unico valore inseribile è : " + 0);
            brightness = 0;
            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "*";
            }
            System.out.println(title + " " + brnOut + " La luminosità è : " + brightness);
            return;

        } else {

            int j = 0;
            do {
                System.out.println("Inserisci il nuovo valore per la luminosità tra " + 0 + " e " + (brightness - 1));
                j = Integer.parseInt(scanner.nextLine());
                if (j < 0 || j >= (brightness)) {
                    System.out.println("Il valore non è compreso nel range, riprova ");
                }
            } while (j < 0 || j > (brightness - 1));
            brightness = j;
            String brnOut = "";
            for (int i = 0; i < brightness; i++) {
                brnOut += "!";
            }
            System.out.println(title + " " + brnOut + " La nuova luminosità è : " + brightness);
            return;

        }
    }

    public void Show() {
        Scanner scanner = new Scanner(System.in);
        String brigOut = "";
        for (int i = 0; i < brightness; i++) {
            brigOut += "*";
        }
        System.out.println(title + " " + brigOut + " Livello luminosità = " + brightness);
        int index = 0;
        System.out.println("Desideri modificare la luminosità? Inserisci 1 per modificare, 0 per continuare.");
        index = Integer.parseInt(scanner.nextLine());
        switch (index) {
            case 0:
                break;
            case 1:
                do {
                    System.out.println("Inserisci 1 se desideri aumentare la luminosità.");
                    System.out.println("Inserisci 2 se desideri diminuire la luminosità");

                    index = Integer.parseInt(scanner.nextLine());
                    if (index < 1 || index > 2) {
                        System.out.println("Il valore inserito non è compreso nel range fornito, riprova.");
                    }
                } while (index < 1 || index > 2);
                switch (index) {

                    case 1:
                        increaseBrightness();
                        break;
                    case 2:
                        decreaseBrightness();
                        break;
                }
                break;
        }
    }

    @Override
    public void exe() {
        Show();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
