package br.com.zupacademy.carlos.casadocodigo.controllers.forms;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.carlos.casadocodigo.customizations.IdFinder;
import br.com.zupacademy.carlos.casadocodigo.customizations.UniqueValue;
import br.com.zupacademy.carlos.casadocodigo.entities.Cliente;
import br.com.zupacademy.carlos.casadocodigo.entities.Estado;
import br.com.zupacademy.carlos.casadocodigo.entities.Pais;
import br.com.zupacademy.carlos.casadocodigo.entities.enums.TipoDocumento;
import br.com.zupacademy.carlos.casadocodigo.repositories.EstadoRepositorio;
import br.com.zupacademy.carlos.casadocodigo.repositories.PaisRepositorio;

public class ClienteForm {

	@Email
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotNull
	private TipoDocumento tipoDocumento;
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "numeroDocumento")
	private String numeroDocumento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@NotNull
	@IdFinder(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	private Long idEstado;

	public Cliente converter(PaisRepositorio paisRepositorio, EstadoRepositorio estadoRepositorio) {

		Pais pais = paisRepositorio.findById(idPais).get();

		Estado estado = null;
		if (idEstado != null) {
			Optional<Estado> estadoInformado = estadoRepositorio.findById(idEstado);
			if (estadoInformado.isPresent()) {
					estado = estadoInformado.get();
			}
		}

		return new Cliente(email, nome, sobrenome, tipoDocumento, numeroDocumento, endereco, complemento, cidade,
				telefone, cep, pais, estado);
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

}
