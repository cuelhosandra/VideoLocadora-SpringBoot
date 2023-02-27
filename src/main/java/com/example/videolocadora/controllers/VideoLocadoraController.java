package com.example.videolocadora.controllers;

import com.example.videolocadora.dtos.VideoLocadoraDto;
import jakarta.validation.Valid;
import com.example.videolocadora.models.VideoLocadoraModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.videolocadora.services.VideoLocadoraService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/video-locadora")
public class VideoLocadoraController {

    final VideoLocadoraService videoLocadoraService;

    public VideoLocadoraController(VideoLocadoraService videoLocadoraService) {
        this.videoLocadoraService = videoLocadoraService;
    }

    @PostMapping
    public ResponseEntity<Object> saveVideoLocadora(@RequestBody @Valid VideoLocadoraDto videoLocadoraDto) {
        if (videoLocadoraService.existsByMatriculaCliente(videoLocadoraDto.getMatriculaCliente())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Matrícula já está em uso");
        }
        if (videoLocadoraService.existsByCpfCliente(videoLocadoraDto.getCpfCliente())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF já está em uso!");
        }

        var videoLocadoraModel = new VideoLocadoraModel();
        BeanUtils.copyProperties(videoLocadoraDto, videoLocadoraModel);
        videoLocadoraModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(videoLocadoraService.save(videoLocadoraModel));

    }

    @GetMapping
    public ResponseEntity<List<VideoLocadoraModel>> getAllVideoLocadora(){
        return ResponseEntity.status(HttpStatus.OK).body(videoLocadoraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVideoLocadora(@PathVariable(value = "id") UUID id){
        Optional<VideoLocadoraModel> videoLocadoraModelOptional = videoLocadoraService.findById(id);
        if (!videoLocadoraModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(videoLocadoraModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVideoLocadora(@PathVariable(value = "id") UUID id){
        Optional<VideoLocadoraModel> videoLocadoraModelOptional = videoLocadoraService.findById(id);
        if (!videoLocadoraModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        videoLocadoraService.delete(videoLocadoraModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVideoLocadora(@PathVariable(value = "id") UUID id,
                                                      @RequestBody @Valid VideoLocadoraDto videoLocadoraDto){
        Optional<VideoLocadoraModel> videoLocadoraModelOptional = videoLocadoraService.findById(id);
        if(!videoLocadoraModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        var videoLocadoraModel = videoLocadoraModelOptional.get();

        videoLocadoraModel.setCpfCliente(videoLocadoraDto.getCpfCliente());
        videoLocadoraModel.setDataNascCliente(videoLocadoraDto.getDataNascCliente());
        videoLocadoraModel.setMatriculaCliente(videoLocadoraDto.getMatriculaCliente());
        videoLocadoraModel.setNomeCliente(videoLocadoraDto.getNomeCliente());
        videoLocadoraModel.setNomeFilme(videoLocadoraDto.getNomeFilme());
        videoLocadoraModel.setPrecoFilme(videoLocadoraDto.getPrecoFilme());
        videoLocadoraModel.setSecaoFilme(videoLocadoraDto.getSecaoFilme());
        videoLocadoraModel.setQtdDiasAluguel(videoLocadoraDto.getQtdDiasAluguel());
        return ResponseEntity.status(HttpStatus.OK).body(videoLocadoraService.save(videoLocadoraModel));

    }
}