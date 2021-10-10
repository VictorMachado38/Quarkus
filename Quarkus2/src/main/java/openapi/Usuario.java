package openapi;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jdk.jfr.Description;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Usuario extends PanacheEntity {

    @Schema(description = "Nome completo")
    private String nome;

    @Schema(minimum = "0",exclusiveMaximum = true, description = "", required = true)
    private Long iddade;

    @Schema(hidden = true )
    private LocalDateTime dataAtualizacaoDados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIddade() {
        return iddade;
    }

    public void setIddade(Long iddade) {
        this.iddade = iddade;
    }

    public LocalDateTime getDataAtualizacaoDados() {
        return dataAtualizacaoDados;
    }

    public void setDataAtualizacaoDados(LocalDateTime dataAtualizacaoDados) {
        this.dataAtualizacaoDados = dataAtualizacaoDados;
    }
}
