package app;

public class Facade {
    private PopcornPopper popcornPopper;
    private TheaterLights theaterLights;
    private Screen screen;
    private Projector projector;
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Tuner tuner;
    private CdPlayer cdPlayer;

    public Facade(){
     popcornPopper = new PopcornPopper("popcornpopper");
     theaterLights = new TheaterLights("theaterLights");
     screen = new Screen("screen");
     amplifier = new Amplifier("amplifier");
     dvdPlayer = new DvdPlayer("dvdPlayer",amplifier);
     cdPlayer = new CdPlayer("CDPlayer", amplifier);
     projector = new Projector("projector",dvdPlayer);
     tuner = new Tuner("tuner", amplifier);


    }

    public void startMovie(){
        popcornPopper.on();
        popcornPopper.pop();

        theaterLights.dim(20);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amplifier.on();
        amplifier.setDvd(dvdPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play("Intouchable");
    }

    public void finishMovie(){
        popcornPopper.off();

        theaterLights.on();

        screen.up();

        projector.off();

        amplifier.off();

        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();

        amplifier.setCd(cdPlayer);
    }

    public void startMusic(){
        theaterLights.on();

        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setCd(cdPlayer);
        amplifier.setStereoSound();

        cdPlayer.on();
        cdPlayer.play("Kensington");
    }

    public void finishMusic(){
        amplifier.off();
        amplifier.setCd(cdPlayer);
        cdPlayer.eject();
        cdPlayer.off();
    }

    public void startRadio(){
        tuner.on();
        tuner.setFrequency(22);
        amplifier.on();
        amplifier.setVolume(5);
        amplifier.setTuner(tuner);
    }

    public void finishRadio(){
        tuner.off();
        amplifier.off();
    }
}
