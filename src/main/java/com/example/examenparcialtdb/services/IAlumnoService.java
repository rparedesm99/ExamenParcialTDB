package com.example.examenparcialtdb.services;

import java.util.List;

import com.example.examenparcialtdb.model.AlumnoModel;



public interface IAlumnoService {

    public List<AlumnoModel> listar();

    public AlumnoModel buscarPorId(Integer id);

    public AlumnoModel guardar (AlumnoModel model);

    public AlumnoModel update(AlumnoModel model);

    public Boolean eliminar(Integer id);

}