package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.shared.infrastructure.hibernate.HibernateRepository;

@Repository
@Transactional("transaction_manager")
public class H2HeroRepository extends HibernateRepository<Hero> implements HeroRepository {

	public H2HeroRepository(@Qualifier("session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Hero.class);
	}

	@Override
	public Optional<Hero> findById(HeroId id) {
		return byId(id);
	}

}
