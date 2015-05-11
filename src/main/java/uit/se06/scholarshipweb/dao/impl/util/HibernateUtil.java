package uit.se06.scholarshipweb.dao.impl.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import uit.se06.scholarshipweb.model.AcademicLevel;
import uit.se06.scholarshipweb.model.AcademicLevelDetail;
import uit.se06.scholarshipweb.model.Country;
import uit.se06.scholarshipweb.model.Disability;
import uit.se06.scholarshipweb.model.Ethnic;
import uit.se06.scholarshipweb.model.FamilyPolicy;
import uit.se06.scholarshipweb.model.FormOfParticipation;
import uit.se06.scholarshipweb.model.Gender;
import uit.se06.scholarshipweb.model.Major;
import uit.se06.scholarshipweb.model.Province;
import uit.se06.scholarshipweb.model.Religion;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.School;
import uit.se06.scholarshipweb.model.Sponsor;
import uit.se06.scholarshipweb.model.Talent;
import uit.se06.scholarshipweb.model.TerminalIll;

public class HibernateUtil {
 
	// Annotation based configuration
	private static SessionFactory sessionAnnotationFactory;

	private static SessionFactory buildSessionAnnotationFactory() {
		try {
			System.out.println("Building session and annotaion");

			// Create the SessionFactory from hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure("Spring-Hibernate-Annotation.cfg.xml");

			System.out.println("---Hibernate Annotation Configuration loaded");

			configuration.addAnnotatedClass(AcademicLevel.class);
			configuration.addAnnotatedClass(AcademicLevelDetail.class);
			configuration.addAnnotatedClass(Country.class);
			configuration.addAnnotatedClass(Disability.class);
			configuration.addAnnotatedClass(Ethnic.class);
			configuration.addAnnotatedClass(FamilyPolicy.class);
			configuration.addAnnotatedClass(FormOfParticipation.class);
			configuration.addAnnotatedClass(Gender.class);
			configuration.addAnnotatedClass(Major.class);
			configuration.addAnnotatedClass(Province.class);
			configuration.addAnnotatedClass(Religion.class);
			configuration.addAnnotatedClass(Scholarship.class);
			configuration.addAnnotatedClass(School.class);
			configuration.addAnnotatedClass(Sponsor.class);
			configuration.addAnnotatedClass(Talent.class);
			configuration.addAnnotatedClass(TerminalIll.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			System.out
					.println("---Hibernate Annotation serviceRegistry created");

			SessionFactory sessionFactory = configuration
					.buildSessionFactory(serviceRegistry);
			System.out.println("Finish building session and annotaion");
			return sessionFactory;
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionAnnotationFactory() {
		if (sessionAnnotationFactory == null)
			sessionAnnotationFactory = buildSessionAnnotationFactory();
		return sessionAnnotationFactory;
	}

}
