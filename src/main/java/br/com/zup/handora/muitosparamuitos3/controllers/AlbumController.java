package br.com.zup.handora.muitosparamuitos3.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparamuitos3.models.Album;
import br.com.zup.handora.muitosparamuitos3.models.AlbumDTO;
import br.com.zup.handora.muitosparamuitos3.repositories.AlbumRepository;

@RestController
@RequestMapping(AlbumController.BASE_URI)
public class AlbumController {

    public final static String BASE_URI = "/albuns";

    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AlbumDTO albumDTO,
                                       UriComponentsBuilder ucb) {
        Album album = albumRepository.save(albumDTO.toModel());

        URI location = ucb.path(BASE_URI + "/{id}").buildAndExpand(album.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
