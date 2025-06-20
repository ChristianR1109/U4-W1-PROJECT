package project;

import project.entities.Audio;
import project.entities.Image;
import project.entities.Video;
import project.interfaces.Execute;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=0;
        do{
        System.out.println("Inserisci il numero di elementi multimediali che desideri aggiungere tra 1 e 5");
        num = Integer.parseInt(scanner.nextLine());
        while(num <1 || num>5);
        for(int i=0; i<num; i++) {
            String text = "";
            do {
                System.out.println("Inserisci la tipologia di file tra Audio, Video, Immagine del file numero : " + num);
                text = scanner.nextLine().toUpperCase();
            } while (!text.equals("AUDIO") && !text.equals("VIDEO") && !text.equals("IMMAGINE"));

            System.out.println();
        }

        Audio Audio1 = new Audio("Audio 1", 4, 5);
        Video Video1 = new Video("Video 1", 3, 5, 7);
        Image Image1 = new Image("Image 1", 3);
        Image Image2 = new Image("Image 2", 4);
        Image Image3 = new Image("Image 3", 8);

        Execute[] multimedials = {Audio1, Video1, Image1, Image2, Image3};
        int pos = 0;
        do {
            do {
                System.out.println("Inserisci la posizione dell'elemento che vuoi riprodurre, inseisci 0 per uscire : ");
                pos = Integer.parseInt(scanner.nextLine());
            } while (pos < 0 || pos > multimedials.length);
            if (pos > 0) {
                int j = (pos - 1);
                multimedials[j].exe();
            }

        } while (pos != 0);


    }
}