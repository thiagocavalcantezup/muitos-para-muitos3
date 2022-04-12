package br.com.zup.handora.muitosparamuitos3.models;

import javax.validation.constraints.NotBlank;

public class AlbumDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    public AlbumDTO() {}

    public AlbumDTO(@NotBlank String titulo, @NotBlank String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Album toModel() {
        return new Album(titulo, descricao);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}
