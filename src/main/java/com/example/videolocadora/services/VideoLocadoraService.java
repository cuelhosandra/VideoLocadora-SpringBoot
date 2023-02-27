package com.example.videolocadora.services;

import jakarta.transaction.Transactional;
import com.example.videolocadora.models.VideoLocadoraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.videolocadora.repositories.VideoLocadoraRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VideoLocadoraService {

    @Autowired
    VideoLocadoraRepository videoLocadoraRepository;

    @Transactional
    public VideoLocadoraModel save(VideoLocadoraModel videoLocadoraModel) {
        return videoLocadoraRepository.save(videoLocadoraModel);
    }
    public boolean existsByMatriculaCliente(String matriculaCliente) {
        return videoLocadoraRepository.existsByMatriculaCliente(matriculaCliente);
    }

    public boolean existsByCpfCliente(String cpfCliente) {
        return videoLocadoraRepository.existsByCpfCliente(cpfCliente);
    }

    public List<VideoLocadoraModel> findAll() {
        return videoLocadoraRepository.findAll();
    }

    public Optional<VideoLocadoraModel> findById(UUID id) {
        return videoLocadoraRepository.findById(id);
    }

    @Transactional
    public void delete(VideoLocadoraModel videoLocadoraModel) {
        videoLocadoraRepository.delete(videoLocadoraModel);
    }
}
