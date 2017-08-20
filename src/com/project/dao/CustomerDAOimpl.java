package com.project.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.Customer;


@Repository
@Transactional
public class CustomerDAOimpl implements CustomerDAO {
	
	
	// need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory ; 
	

	@Override
	public List<Customer> getCustomers() {
		System.out.println("List customer");

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastname", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}


	@Override
	public void savecustomers( Customer thecustomer ) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save Customer 
		currentSession.saveOrUpdate(thecustomer);
		
		
	}


	@Override
	public Customer getcustomer(int theID) {
		System.out.println("id cust");
		Session currentSession = sessionFactory.getCurrentSession();
		
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Customer> criteria = criteriaBuilder.createQuery(Customer.class );
		Root<Customer> personRoot = criteria.from( Customer.class );
		criteria.where( criteriaBuilder.equal( personRoot.get("id" ), theID ) );
		return currentSession.createQuery( criteria ).getSingleResult();
		
	

	}


	@Override
	public void deletecustomer(int theID) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		
		Query thequery = currentSession.createQuery("delete from Customer where id=:customerID ");
		thequery.setParameter("customerID", theID);
		thequery.executeUpdate();
		
	}

}
