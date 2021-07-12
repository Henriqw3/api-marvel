package com.henri.apicomics.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {

    @Override
    public EntityModel<Usuario> toModel(Usuario entity){
        return EntityModel.of(entity,
                linkTo(methodOn(UsuarioController.class).uniqueUser(entity.getId())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).all()).withRel("usuario"));
    }
}
