package br.com.zup.handora.muitosparamuitos3.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "imagens")
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    @PastOrPresent
    private LocalDateTime dataHora;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Imagem() {}

    public Imagem(String titulo, String descricao, String url,
                  @PastOrPresent LocalDateTime dataHora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

}
