package exemplo.seguranca.dtos;

import exemplo.seguranca.entidades.Filme;
import exemplo.seguranca.entidades.Usuario;

public record FilmeDto(Long id, String titulo, String sinopse, String foto, Usuario usuarioId) {
    public FilmeDto(Filme filme){
        this(filme.getId(), filme.getTitulo(), filme.getSinopse(), filme.getFoto(), filme.getUsuarioId());
    }
}
