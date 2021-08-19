package panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Pessoa extends PanacheEntity {

    private String nome;

    private Tipo tpo;

    public enum Tipo{
        PF,PJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTpo() {
        return tpo;
    }

    public void setTpo(Tipo tpo) {
        this.tpo = tpo;
    }
}
