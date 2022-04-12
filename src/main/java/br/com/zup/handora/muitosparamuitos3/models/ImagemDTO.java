package br.com.zup.handora.muitosparamuitos3.models;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ImagemDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @NotBlank
    private String url;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    public ImagemDTO() {}

    public ImagemDTO(@NotBlank String titulo, @NotBlank String descricao, @NotBlank String url,
                     @NotNull @PastOrPresent LocalDateTime dataHora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.dataHora = dataHora;
    }

    public Imagem toModel() {
        return new Imagem(titulo, descricao, url, dataHora);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

}
