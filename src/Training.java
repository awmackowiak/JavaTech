import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by artur.mackowiak on 17/02/15.
 */
public class Training implements Entity {
    private Long id;
    private String name;
    private String description = "";
    private Date startDate;
    private Date stopDate;
    private Status status = Status.NIEZATWIEDZONE;
    private Set<Participants> lista = new TreeSet<Participants>();

    private long cena;

    public enum Status {
        ZATWIERDZONE,
        NIEZATWIEDZONE,
        ANULOWANE
    }

    public Training(String name, Date start, Date stop, long cena) {
        this.name = name;
        this.startDate = start;
        this.stopDate = stop;
        this.cena = cena;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addParticipants(Participants participants) {
        lista.add(participants);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Long getCena() {
        return this.cena;
    }

    @Override
    public String toString() {

        String result = "Traning{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", stopDate=" + stopDate +
                ", status=" + status +
                ", cena=" + getCena() + '\n';


        Iterator<Participants> iter = lista.iterator();

        while(iter.hasNext()) {
            result += "Uczestnik = " + iter.next().toString() + '\n';
        }

        return result;
    }

}
