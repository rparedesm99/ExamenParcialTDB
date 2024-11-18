package com.example.examenparcialtdb.services;

import com.example.examenparcialtdb.model.AlumnoModel;
import com.example.examenparcialtdb.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {
    @Autowired
    private AlumnoRepository repository;

    @Override
    public List<AlumnoModel> listar() {
        return repository.findAll();
    }

    @Override
    public AlumnoModel buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AlumnoModel guardar(AlumnoModel model) {
        return repository.save(model);
    }

    @Override
    public AlumnoModel update(AlumnoModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Boolean eliminar(Integer id) {
        repository.deleteById(id);
        return true;
    }

}