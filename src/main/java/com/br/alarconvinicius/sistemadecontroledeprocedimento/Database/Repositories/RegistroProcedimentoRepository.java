/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories;

import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models.RegistroProcedimento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class RegistroProcedimentoRepository {

    private final List<RegistroProcedimento> registros;

    public RegistroProcedimentoRepository() {
        this.registros = new ArrayList<>();
    }

    // Método para cadastrar um novo registro de procedimento
    public void cadastrarRegistro(RegistroProcedimento registro) {
        this.registros.add(registro);
    }

    // Método para listar os procedimentos realizados
    public List<RegistroProcedimento> listarRegistros() {
        return this.registros;
    }
}
