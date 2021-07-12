package com.henri.apicomics.comics;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ComicsModelAssembler implements RepresentationModelAssembler<Comics, EntityModel<Comics>> {

    @Override
    public EntityModel<Comics> toModel(Comics comic){
        return EntityModel.of(comic,
                linkTo(methodOn(ComicsController.class)
                        .cadComic(comic.getUser().getId(), comic.getComicId())).withSelfRel(),
                linkTo(methodOn(ComicsController.class)
                        .findAllComics(comic.getId())).withRel("comics"));
    }
}
