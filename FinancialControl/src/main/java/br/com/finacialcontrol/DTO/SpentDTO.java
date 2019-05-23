package br.com.finacialcontrol.DTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.finacialcontrol.entity.Spent;
import lombok.Data;


@Data
public class SpentDTO { 
	@NotNull(message = "data de Movimentacao obrigatoria")
	@JsonFormat(locale = "pt-BR", timezone = "Brazil/East")
	private Date dtMovimento;
	@Length(max = 225, message = "Decrição necessario ter mesnos de 255 digitos!!")
	private String descricao;
	@NotNull(message = "valor de moviemntação obrigatoria")
	private float value;
	
	
	public Spent toEntity() {
		ModelMapper map = new ModelMapper();
		return map.map(this, Spent.class);
	}
}
