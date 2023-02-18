package com.ddominguezh.superhero.app.gender.infrastructure.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.gender.domain.Gender;
import com.ddominguezh.superhero.app.gender.domain.repository.GenderRepository;
import com.ddominguezh.superhero.shared.infrastructure.hibernate.HibernateRepository;

@Repository
@Transactional("transaction_manager")
public class H2GenderRepository extends HibernateRepository<Gender> implements GenderRepository {

	public H2GenderRepository(@Qualifier("session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Gender.class);
	}

	@Override
	public List<Gender> findAll() {
		return all();
	}

}
