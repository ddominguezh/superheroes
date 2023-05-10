package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.hibernate.core.shared.infrastructure.hibernate.HibernateRepository;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroGenderRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;

@Repository
@Transactional("transaction_manager")
public class H2HeroGenderRepository extends HibernateRepository<HeroGender> implements HeroGenderRepository {

	public H2HeroGenderRepository(@Qualifier("session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, HeroGender.class);
	}

	@SuppressWarnings("serial")
	@Override
	public Optional<HeroGender> findById(HeroGenderId id) {
		return super.byId(id);
	}

}
