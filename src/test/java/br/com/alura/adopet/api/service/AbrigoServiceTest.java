package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService abrigoService;

    @Mock
    private AbrigoRepository abrigoRepository;
    @Mock
    private PetRepository petRepository;
    @Mock
    private Abrigo abrigo;

    @Test
    void deveriaChamarListaDeTodosOsAbrigos(){
        abrigoService.listar();
        BDDMockito.then(abrigoRepository).should().findAll();
    }

    @Test
    void deveriaChamarListaDePetsDoAbrigo(){
        var nome = "Teste";
        BDDMockito.given(abrigoRepository.findByNome(nome)).willReturn(Optional.of(abrigo));
        abrigoService.listarPetsDoAbrigo(nome);
        BDDMockito.then(petRepository).should().findByAbrigo(abrigo);
    }

}