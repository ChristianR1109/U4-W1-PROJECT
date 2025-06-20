package project;

import project.entities.Audio;
import project.entities.Image;
import project.entities.Video;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Audio Audio1 = new Audio("Audio 1", 4, 5);
        Video Video1 = new Video("Video 1", 3, 5, 7);
        Image Image1 = new Image("Image 1", 03);

        Video1.play();


    }
}