package com.ddominguezh.superhero.app.hero.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ddominguezh.hibernate.core.shared.domain.criteria.Criteria;
import com.ddominguezh.hibernate.core.shared.domain.criteria.Filter;
import com.ddominguezh.hibernate.core.shared.domain.criteria.FilterField;
import com.ddominguezh.hibernate.core.shared.domain.criteria.FilterOperator;
import com.ddominguezh.hibernate.core.shared.domain.criteria.FilterValue;
import com.ddominguezh.hibernate.core.shared.domain.criteria.Filters;
import com.ddominguezh.hibernate.core.shared.domain.criteria.Order;
import com.ddominguezh.hibernate.core.shared.infrastructure.hibernate.HibernateRepository;
import com.ddominguezh.superhero.app.hero.domain.Hero;
import com.ddominguezh.superhero.app.hero.domain.repository.HeroRepository;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroId;
import com.ddominguezh.superhero.app.hero.domain.valueObject.HeroName;

@Repository
@Transactional("transaction_manager")
public class H2HeroRepository extends HibernateRepository<Hero> implements HeroRepository {

	public H2HeroRepository(@Qualifier("session_factory") SessionFactory sessionFactory) {
		super(sessionFactory, Hero.class);
	}

	@Override
	public Optional<Hero> findById(HeroId id) {
		return super.byId(id);
	}

	@Override
	public void delete(Hero hero) {
		super.delete(hero);
	}

	@Override
	public void create(Hero hero) {
		super.persist(hero);
	}

	@Override
	public void update(Hero hero) {
		super.update(hero);
	}

	@Override
	public List<Hero> findAll() {
		return all();
	}
	
	@SuppressWarnings("serial")
	@Override
	public List<Hero> findAll(HeroName name) {
		Filter filter = new Filter(new FilterField("name.value"), FilterOperator.CONTAINS, new FilterValue(name.value()));
		Criteria criteria = new Criteria(new Filters(new ArrayList<Filter>() {
			{
				add(filter);
			}
		}), Order.none());
		return byCriteria(criteria);
	}
	
	
}
