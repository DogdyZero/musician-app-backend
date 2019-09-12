package br.com.musicianapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.musicianapp.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Usuario findByLoginAndSenha(String login, String senha);
	public Usuario findByHashCode(String hash);
}
