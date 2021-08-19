package panache;

public class IncluirPessoaDTO {

    public String nome;

    public Pessoa.Tipo tipo;

    public String getNome() { 
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Pessoa.Tipo tipo) {
        this.tipo = tipo;
    }
}
