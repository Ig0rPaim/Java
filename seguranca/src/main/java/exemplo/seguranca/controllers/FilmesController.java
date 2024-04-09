package exemplo.seguranca.controllers;

import org.springframework.web.bind.annotation.RestController;

import exemplo.seguranca.dtos.FilmeDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("filmes")

public class FilmesController {

    @GetMapping("filmes")
    public String getFilmes(@RequestBody FilmeDto filme) {
        return new String();
    }
    

}
