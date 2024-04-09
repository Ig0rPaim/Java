package exemplo.seguranca.dtos;

import exemplo.seguranca.entidades.Filme;

public record FilmeDto(Long id, String titulo, String sinopse, String foto, Long usuarioId) {
    public FilmeDto(Filme filme){
        this(filme.getId(), filme.getTitulo(), filme.getSinopse(), filme.getFoto(), filme.getUsuarioId());
    }
}
