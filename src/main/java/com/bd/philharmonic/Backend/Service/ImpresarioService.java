package com.bd.philharmonic.Backend.Service;

import com.bd.philharmonic.Backend.Entity.Impresario;
import com.bd.philharmonic.Backend.Repository.ImpresarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpresarioService {

    private final ImpresarioRepository impresarioRepository;

    public ImpresarioService(ImpresarioRepository impresarioRepository) {
        this.impresarioRepository = impresarioRepository;
    }

    public List<Impresario> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return impresarioRepository.findAll();
        } else {
            return impresarioRepository.search(filterText);
        }
    }

    public void save(Impresario impresario) {
        if (impresario == null){
            return;
        }
        impresarioRepository.save(impresario);
    }

    public void delete(Impresario impresario) {
        impresarioRepository.delete(impresario);
    }

}
