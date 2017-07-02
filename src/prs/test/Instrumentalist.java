package prs.test;

import prs.it.Instrument;
import prs.it.Performer;

/**
 * Created by zhangbin on 2017/6/16.
 */
public class Instrumentalist implements Performer {

    private String song;

    private Instrument is;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getIs() {
        return is;
    }

    public void setIs(Instrument is) {
        this.is = is;
    }

    @Override
    public void perform() {
        System.out.println("playing " + song);
        is.play();
    }
}
