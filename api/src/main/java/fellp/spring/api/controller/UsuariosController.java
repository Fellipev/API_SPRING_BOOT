package fellp.spring.api.controller;

import fellp.spring.api.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastro dados) {
        repository.save(new Usuario(dados));
    }
    @GetMapping
    public Page<DadosListagemUsuario> Listar(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacao dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInfos(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
//        repository.deleteById(id);
        var usuario = repository.getReferenceById(id);
        usuario.excluir();
    }

}

