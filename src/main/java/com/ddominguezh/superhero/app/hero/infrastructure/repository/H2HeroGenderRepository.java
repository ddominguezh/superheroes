package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ddominguezh.superhero.app.hero.domain.repository.HeroGenderRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGender;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroGenderId;
import com.ddominguezh.superhero.shared.infrastructure.hibernate.HibernateRepository;

@Repository
public class H2HeroGenderRepository extends HibernateRepository<HeroGender> implements HeroGenderRepository {

	public H2HeroGenderRepository(SessionFactory sessionFactory) {
		super(sessionFactory, HeroGender.class);
	}

	@Override
	public Optional<HeroGender> findById(HeroGenderId id) {
		return byId(id.value());
	}

}
