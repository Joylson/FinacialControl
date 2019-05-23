package br.com.finacialcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finacialcontrol.entity.Spent;
import br.com.finacialcontrol.repostory.SpentRepository;
import br.com.finacialcontrol.service.exception.model.BusinessException;

@Service
public class SpentService {

	@Autowired
	private SpentRepository repository;
	
	public Spent save(Spent spent) {
		spent.setId(0);
		return repository.save(spent);
	}
	
	public Spent update(Spent spent) {
		if(spent.getId() == 0) {
			throw new BusinessException("Necessario informar o id correspondente ao gasto!!");
		}
		return repository.save(spent);
	}
	
	public List<Spent> findAll(){
		List<Spent> spents = repository.findAll();
		if(spents.isEmpty()) {
			throw new NullPointerException("Nenhum gasto foi encontrado na listagem!!");
		}
		return spents;
	}
	
	public Spent findById(long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NullPointerException("Gasto não encontrado!!"));
	}
}
