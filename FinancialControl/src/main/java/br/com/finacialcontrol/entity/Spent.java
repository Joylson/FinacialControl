package br.com.finacialcontrol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.finacialcontrol.DTO.SpentDTO;
import lombok.Data;

@Entity
@Table(name="financial_control_spent")
@Data
public class Spent {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_movimento")
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	private Date dtMovimento;
	@Column(name = "descricao", length = 255)
	private String descricao;
	private float value;
	
	
	public SpentDTO toDTO() {
		ModelMapper map = new ModelMapper();
		return map.map(this, SpentDTO.class);
	}
}
