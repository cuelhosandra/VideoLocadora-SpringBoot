package com.example.videolocadora.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VideoLocadoraDto {

    @NotBlank
    private String matriculaCliente;

    @NotBlank
    private String nomeCliente;

    @NotBlank
    @Size(max = 11)
    private String cpfCliente;

    @NotBlank
    private String dataNascCliente;

    @NotBlank
    private String qtdDiasAluguel;

    @NotBlank
    private String secaoFilme;

    @NotBlank
    private String nomeFilme;

    @NotBlank
    private String precoFilme;

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
}
