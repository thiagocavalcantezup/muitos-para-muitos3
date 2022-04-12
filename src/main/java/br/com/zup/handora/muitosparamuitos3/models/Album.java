package br.com.zup.handora.muitosparamuitos3.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "albuns")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "album_imagem", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "imagem_id"))
    @Column(nullable = false)
    private Set<Imagem> imagens = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Album() {}

    public Album(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public void adicionar(Imagem imagem) {
        imagem.getAlbuns().add(this);
        this.imagens.add(imagem);
    }

    public Long getId() {
        return id;
    }

}
