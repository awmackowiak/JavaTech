package module2;

import javax.xml.bind.annotation.*;

/**
 * Created by artur.mackowiak on 17/02/15.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Participants implements Comparable<Participants>, Entity {

    @XmlAttribute
    private Long id;

    @XmlElement(name = "first-name")
    private String imie;

    @XmlElement(name = "second-name")
    private String nazwisko;

    private String email;

    public Participants() {
    }

    public Participants(String imie, String nazwisko, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + ", " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants)) return false;

        Participants participants = (Participants) o;

        if (email != null ? !email.equals(participants.email) : participants.email != null) return false;
        if (imie != null ? !imie.equals(participants.imie) : participants.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(participants.nazwisko) : participants.nazwisko != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imie != null ? imie.hashCode() : 0;
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Participants participants) {
        int result = nazwisko.compareTo(participants.nazwisko);
        if (result == 0) {
            result = imie.compareTo(participants.imie);
        }
        return result;
    }
}