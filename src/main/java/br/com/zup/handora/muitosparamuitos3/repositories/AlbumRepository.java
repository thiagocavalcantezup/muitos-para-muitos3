package br.com.zup.handora.muitosparamuitos3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.muitosparamuitos3.models.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
