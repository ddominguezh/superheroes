package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroColorRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColor;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroColorId;
import com.ddominguezh.superhero.shared.infrastructure.hibernate.HibernateRepository;

@Repository
@Transactional("transaction_manager")
public class H2HeroColorRepository extends HibernateRepository<HeroColor> implements HeroColorRepository {

	public H2HeroColorRepository(@Qualifier("session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, HeroColor.class);
	}

	@Override
	public Optional<HeroColor> findById(HeroColorId id) {
		return super.byId(id);
	}

}
