package br.com.zup.handora.muitosparamuitos3.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparamuitos3.models.Album;
import br.com.zup.handora.muitosparamuitos3.models.Imagem;
import br.com.zup.handora.muitosparamuitos3.models.ImagemDTO;
import br.com.zup.handora.muitosparamuitos3.repositories.AlbumRepository;
import br.com.zup.handora.muitosparamuitos3.repositories.ImagemRepository;

@RestController
@RequestMapping(AlbumController.BASE_URI + "/{albumId}" + ImagemController.BASE_URI)
public class ImagemController {

    public final static String BASE_URI = "/imagens";

    private final AlbumRepository albumRepository;
    private final ImagemRepository imagemRepository;

    public ImagemController(AlbumRepository albumRepository, ImagemRepository imagemRepository) {
        this.albumRepository = albumRepository;
        this.imagemRepository = imagemRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long albumId,
                                       @RequestBody @Valid ImagemDTO imagemDTO,
                                       UriComponentsBuilder ucb) {
        Album album = albumRepository.findById(albumId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um álbum com o id informado."
                                         )
                                     );
        Imagem imagem = imagemRepository.save(imagemDTO.toModel());
        album.adicionar(imagem);
        albumRepository.save(album);

        URI location = ucb.path(AlbumController.BASE_URI + "/{albumId}" + BASE_URI + "/{id}")
                          .buildAndExpand(albumId, imagem.getId())
                          .toUri();

        return ResponseEntity.created(location).build();
    }

}
