package br.com.finacialcontrol.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.finacialcontrol.entity.Spent;

public interface SpentRepository extends JpaRepository<Spent, Long>{

}
