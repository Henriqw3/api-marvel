package com.henri.apicomics.user;

import com.henri.apicomics.validations.UserCreateException;
import com.henri.apicomics.validations.UserFindException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioRepository repository;
    private final UsuarioModelAssembler assembler;

    public UsuarioController(UsuarioRepository repository, UsuarioModelAssembler assembler) {
            this.repository = repository;
            this.assembler = assembler;
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> createUser(@RequestBody @Valid Usuario usr) {
        if(repository.findByEmail(usr.getEmail()) == null && repository.findByCpf(usr.getCpf()) == null) {
            EntityModel<Usuario> usuarioData = assembler.toModel(repository.save(usr));
        return ResponseEntity.created(usuarioData.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(usuarioData);
        } else {
            throw new UserCreateException();
        }
    }//Cria um usuário

    @GetMapping("/usuario")
    public CollectionModel<EntityModel<Usuario>> all() {
        List<EntityModel<Usuario>> usuarios = repository.findAll().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(usuarios,linkTo(methodOn(UsuarioController.class).all()).withSelfRel());
    }//Lista Usuarios

    @GetMapping("/usuario/{id}")
    public EntityModel<Usuario> uniqueUser(@PathVariable @Valid Long id) {
        Usuario usr = repository.findById(id).orElseThrow(() -> new UserFindException(id));
        return assembler.toModel(usr);
    }//Retorna um usuário pelo Id

}
