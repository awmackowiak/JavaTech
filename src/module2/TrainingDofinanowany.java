package module2;

import java.util.Date;

/**
 * Created by artur.mackowiak on 17/02/15.
 */
public class
        TrainingDofinanowany extends Training {

    protected long rabat;

    public TrainingDofinanowany(String name, Date start, Date stop, long cena, long rabat) {
        super(name, start, stop, cena);
        this.rabat = rabat;
    }

    @Override
    public Long getCena() {
        return super.getCena() - rabat;
    }
}
