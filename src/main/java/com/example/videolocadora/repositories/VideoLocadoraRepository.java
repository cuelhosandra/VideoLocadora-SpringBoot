package com.example.videolocadora.repositories;

import com.example.videolocadora.models.VideoLocadoraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoLocadoraRepository extends JpaRepository<VideoLocadoraModel, UUID> {
    boolean existsByMatriculaCliente(String matriculaCliente);

    boolean existsByCpfCliente(String cpfCliente);
}
