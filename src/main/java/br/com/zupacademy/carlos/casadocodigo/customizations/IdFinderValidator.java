package br.com.zupacademy.carlos.casadocodigo.customizations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class IdFinderValidator implements ConstraintValidator<IdFinder, Object> {

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(IdFinder params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + "=:value");
		query.setParameter("value", value);
		
		List<?> list = query.getResultList();
		Assert.state(!list.isEmpty(), "Não foi encontrado um " + klass + " com o " + domainAttribute + " = " + value);
//		Assert.isTrue(list.size() <=1, "aconteceu algo bizarro e você tem mais de um "+klass+" com o atributo "+domainAttribute+" com o valor = "+value);
		
		return !list.isEmpty();
	}

}
