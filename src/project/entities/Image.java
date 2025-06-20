package project.entities;

import project.interfaces.Adjustable;

public class Image extends Element implements Adjustable {
    private int brightness;

    public Image(String title, int brightness) {
        super(title);
        this.brightness = brightness;
    }

    @Override
    public void increaseBrightness() {
        return;
    }

    @Override
    public void decreaseBrightness() {
        return;
    }

    public void Show() {
        String brigOut = "";
        for (int i = 0; i < brightness; i++) {
            brigOut += "!";
        }
        System.out.println(title + " " + brigOut + " Livello luminosità = " + brightness);
    }
}
