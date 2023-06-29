package fellp.spring.api.usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCrm(), usuario.getEspecialidade());
    }

}
