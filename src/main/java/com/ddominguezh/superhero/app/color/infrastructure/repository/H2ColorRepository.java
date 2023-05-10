package com.ddominguezh.superhero.app.color.infrastructure.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.hibernate.core.shared.infrastructure.hibernate.HibernateRepository;
import org.springframework.stereotype.Service;
import com.ddominguezh.superhero.app.color.domain.Color;
import com.ddominguezh.superhero.app.color.domain.repository.ColorRepository;

@Service
@Transactional("transaction_manager")
public class H2ColorRepository extends HibernateRepository<Color> implements ColorRepository{

	public H2ColorRepository(@Qualifier("session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Color.class);
	}

	@Override
	public List<Color> findAll() {
		return all();
	}

}
