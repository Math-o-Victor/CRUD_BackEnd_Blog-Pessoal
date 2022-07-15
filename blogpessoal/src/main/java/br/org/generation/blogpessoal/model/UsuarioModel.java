package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull(message = "Um nome é obrigatório!")
		private String nome;

		@Schema(example = "email@email.com.br")
		@NotNull(message = "Um usuario tem que ser definido! Por favor.")
		@Email(message = "O atributo usuario tem que ser um email!")
		private String usuario;

		@NotBlank(message = "É obrigatório ter uma senha! Ou você quer qualquer um fuçando nas suas coisas?")
		@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres. Mas 6 ainda é pouco na minha opinião.")
		private String senha;

		private String foto;

		@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
		private List<Postagem> postagem;
		
		public UsuarioModel (Long id, String nome, String usuario, String senha, String foto) {
			this.id = id;
			this.nome = nome;
			this.usuario = usuario;
			this.senha = senha;
			this.foto = foto;
		}

		public UsuarioModel() {	}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

		public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}

	}
