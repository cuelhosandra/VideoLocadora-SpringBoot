package com.example.videolocadora.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "VIDEO_LOCADORA")
public class VideoLocadoraModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 8)
    private String matriculaCliente;

    @Column(nullable = false, length = 30)
    private String nomeCliente;

    @Column(nullable = false, unique = true, length = 11)
    private String cpfCliente;

    @Column(nullable = false, length = 10)
    private String dataNascCliente;

    @Column(nullable = false, length = 5)
    private String qtdDiasAluguel;

    @Column(nullable = false, length = 20)
    private String secaoFilme;

    @Column(nullable = false, length = 50)
    private String nomeFilme;

    @Column(nullable = false, length = 5)
    private String precoFilme;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMatriculaCliente() {
        return matriculaCliente;
    }

    public void setMatriculaCliente(String matriculaCliente) {
        this.matriculaCliente = matriculaCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDataNascCliente() {
        return dataNascCliente;
    }

    public void setDataNascCliente(String dataNascCliente) {
        this.dataNascCliente = dataNascCliente;
    }

    public String getQtdDiasAluguel() {
        return qtdDiasAluguel;
    }

    public void setQtdDiasAluguel(String qtdDiasAluguel) {
        this.qtdDiasAluguel = qtdDiasAluguel;
    }

    public String getSecaoFilme() {
        return secaoFilme;
    }

    public void setSecaoFilme(String secaoFilme) {
        this.secaoFilme = secaoFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getPrecoFilme() {
        return precoFilme;
    }

    public void setPrecoFilme(String precoFilme) {
        this.precoFilme = precoFilme;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
