package com.henri.apicomics.comics;

import com.henri.apicomics.marvel.MarvelComicsService;
import com.henri.apicomics.marvel.responses.ComicsResponse;
import com.henri.apicomics.user.Usuario;
import com.henri.apicomics.user.UsuarioRepository;
import com.henri.apicomics.validations.ComicsCreateException;
import com.henri.apicomics.validations.ComicsFindException;
import com.henri.apicomics.validations.UserFindException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class ComicsController {

    private final ComicsRepository comicRepository;
    private final ComicsModelAssembler comicAssembler;
    private final UsuarioRepository usuarioRepository;

    private MarvelComicsService comicsService;

    public ComicsController(ComicsRepository repository, ComicsModelAssembler assembler,
                            UsuarioRepository repositorioUsr, MarvelComicsService marvelService) {
        this.comicRepository = repository;
        this.comicAssembler = assembler;
        this.usuarioRepository = repositorioUsr;
        this.comicsService = marvelService;
    }

    @PostMapping(value = "/{id}/comics/cadastra")
    public ResponseEntity<?> cadComic(@PathVariable @Valid Long id, @RequestParam(value = "idcomic") @Valid Integer idComic){
        Usuario usr = usuarioRepository.findById(id).orElseThrow(() -> new UserFindException(id));
        try{
            ComicsResponse comic = comicsService.findComic(idComic).getData().getResults().get(0);
            Comics comicEntity = new Comics(comic.getComicId(), comic.getTitulo(), comic.getPreco(),
                                            comic.getIsbn(), comic.getDescricao(), usr);
            EntityModel<Comics> comicsData = comicAssembler.toModel(comicRepository.save(comicEntity));

            return ResponseEntity.created(comicsData.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(comicsData);
        }catch (RuntimeException e){
            throw new ComicsCreateException();
        }
    }//cria um comic em um usuário específico,
    // para simplificarmos foi passado por parametro a requisiçao,exemplo: localhost:8080/usuario/2/comics/cadastra?idcomic=187

    @GetMapping("/comics")
    public CollectionModel<EntityModel<Comics>> findAllComics(@RequestParam(value = "id") @Valid Long id) {
        Usuario usr = usuarioRepository.findById(id).orElseThrow(() -> new UserFindException(id));
        try{
            List<EntityModel<Comics>> comics = comicRepository.findAll().stream().filter(c -> c.getUser().getId() == id).map(comicAssembler::toModel).collect(Collectors.toList());
            return CollectionModel.of(comics,linkTo(methodOn(ComicsController.class).findAllComics(id)).withSelfRel());//linkTo(methoOn(ComicsController.class).all()).withSelfRel());
        }catch(RuntimeException e) {
            throw new ComicsFindException();
        }
    }//mostra todos os Comics cadastrados em um usuario específico : localhost:8080/usuario/comics?id=2


}