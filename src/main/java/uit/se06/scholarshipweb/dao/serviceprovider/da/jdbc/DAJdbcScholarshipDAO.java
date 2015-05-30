package uit.se06.scholarshipweb.dao.serviceprovider.da.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.dao.factory.IScholarshipDAO;
import uit.se06.scholarshipweb.dao.util.HibernateUtil;
import uit.se06.scholarshipweb.dao.util.ILoadingRelatedEntityListener;
import uit.se06.scholarshipweb.model.Scholarship;
import uit.se06.scholarshipweb.model.ScholarshipSpecification;
import uit.se06.scholarshipweb.viewmodel.FilterViewModel;

public class DAJdbcScholarshipDAO extends DAJdbcBaseDAO<Scholarship> implements
		IScholarshipDAO {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static final Logger logger = LoggerFactory
			.getLogger(DAJdbcScholarshipDAO.class);

	public final String COL_ID = "scholarshipId";
	public final String COL_NAME = "scholarshipName";
	// public final String COL_DESCIPTION = "description";
	// public final String COL_ORIGINAL_LINK = "original_link";
	// public final String COL_COUNT = "count";
	public final String COL_DATE_END_REGISTER = "dateEndRegister";
	public final String COL_VALUE_MIN = "valueMin";
	public final String COL_VALUE_MAX = "valueMax";
	public final String COL_SPEC = "scholarshipSpecification";

	// public final String COL_STUDENT_GENDER = "student_gender_id";
	// public final String COL_STUDENT_CITIZENSHIP = "student_citizenship_id";
	// public final String COL_STUDENT_RESIDENCE = "student_residence_id";
	// public final String COL_STUDENT_RELIGION = "student_religion_id";
	// public final String COL_STUDENT_ACADEMIC_LEVEL_DETAIL =
	// "student_academic_level_detail_id";
	// public final String COL_SCHOLARSHIP_TYPE = "scholarship_type_id";
	// public final String COL_SCHOOL = "school_id";
	// public final String COL_FORM_OF_PARTICIPATION =
	// "form_of_participation_id";
	// public final String COL_APPLICATION_DESCRIPTION =
	// "application_description";
	// public final String COL_SUPPORT_DESCRIPTION = "support_description";

	private ILoadingRelatedEntityListener<Scholarship> scholarshipLoadinglistener = new ILoadingRelatedEntityListener<Scholarship>() {
		@Override
		public void load(Scholarship entity) {
			Hibernate.initialize(entity.getScholarshipSpecification());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getFormOfParticipation());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getScholarshipAcademicLevelDetail());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getScholarshipMajors());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getScholarshipType());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getSchool());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getSponsors());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentAcademicLevelDetail());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentCitizenship());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentDisabilities());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentEthnic());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentFamilyPolicies());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentGender());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentReligion());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentResidences());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentTalents());
			Hibernate.initialize(entity.getScholarshipSpecification()
					.getStudentTerminalIllnesses());
		}
	};

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	public DAJdbcScholarshipDAO() {
		super(Scholarship.class);
	}

	// ============================================================
	// OVERRIDE METHODS
	// ============================================================

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	public Scholarship findById(int id) {
		return findBy(COL_ID, String.valueOf(id), scholarshipLoadinglistener);
	}

	@Override
	public Scholarship findByName(String name) {
		return findBy(COL_NAME, name, scholarshipLoadinglistener);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * not done
	 */
	public Scholarship findShortInfoById(int id) {
		List<Scholarship> resultList = null;

		StringBuilder builder = new StringBuilder();

		try {
			ProjectionList projections = Projections
					.projectionList()
					.add(Projections.property(COL_NAME), COL_NAME)
					.add(Projections.property(COL_ID), COL_ID)
					.add(Projections.property(COL_VALUE_MIN), COL_VALUE_MIN)
					.add(Projections.property(COL_VALUE_MAX), COL_VALUE_MAX)
					.add(Projections.property(COL_DATE_END_REGISTER),
							COL_DATE_END_REGISTER);

			Criteria query = getSession().createCriteria(Scholarship.class)
					.setProjection(projections)
					.add(Restrictions.like("COL_ID", id));

			//
			// // query
			// builder.append("SELECT ").append(COL_NAME);
			// builder.append(", ").append(COL_VALUE_MIN);
			// builder.append(", ").append(COL_VALUE_MAX);
			// builder.append(", ").append(COL_DATE_END_REGISTER);
			//
			// builder.append(" FROM ").append(Scholarship.class.getSimpleName());
			// builder.append("  where ").append(COL_ID).append(" = :paramId");
			//
			// Query query = getSession().createQuery(builder.toString()).;
			// query.setParameter("paramId", id);

			resultList = query.list();

		} catch (Exception ex) {
			logger.error("Query '" + builder.toString()
					+ "' in findShortInfoById()");
		} finally {
			closeSession();
		}

		if (resultList != null && !resultList.isEmpty()) {
			Scholarship result = resultList.get(0);
			System.err
					.println("Error in DAJdbcScholarDAOOOOOOOOOOOOOOOOOOO Can't use projection");
			return result;
		} else {
			return null;
		}

	}

	@Override
	public void insert(Scholarship entity) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		Transaction transaction = null;
		ScholarshipSpecification spec = entity.getScholarshipSpecification();

		try {
			transaction = session.beginTransaction();

			// remove mapping between scholarship and specification
			entity.setScholarshipSpecification(null);

			session.save(entity);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			getLogger().error("opps!");

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return;
		} finally {
			session.close();
		}

		// add specification
		int id = entity.getId();

		spec.setScholarship(entity);
		spec.setScholarshipId(id);
		insertSpec(spec);
	}

	// ============================================================
	// OTHER METHODS
	// ============================================================

	private void insertSpec(ScholarshipSpecification entity) {
		SessionFactory sessionfactory = HibernateUtil
				.getSessionAnnotationFactory();
		Session session = sessionfactory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Scholarship> listBy(FilterViewModel data, int pageNumber,
			int pageSize) {
		List<Scholarship> resultList = null;
		
		
		
		
		try {
			ProjectionList projections = Projections
					.projectionList()
					.add(Projections.property(COL_NAME), COL_NAME)
					.add(Projections.property(COL_ID), COL_ID)
					.add(Projections.property(COL_VALUE_MIN), COL_VALUE_MIN)
					.add(Projections.property(COL_VALUE_MAX), COL_VALUE_MAX)
					.add(Projections.property(COL_DATE_END_REGISTER),
							COL_DATE_END_REGISTER);

			List<SimpleExpression> expressions = new ArrayList<SimpleExpression>();

			if (data.stuGender != 0) {
				expressions.add(Restrictions.eq("gender.genderId",
						data.stuGender+""));
			}
//			if (data.stuCitizenship != 0) {
//				expressions.add(Restrictions.eq(COL_STUDENT_CITIZENSHIP,
//						data.stuCitizenship));
//			}
//			if (data.stuReligion != 0) {
//				expressions.add(Restrictions.eq(COL_STUDENT_RELIGION,
//						data.stuReligion));
//			}
//			if (data.stuResidenceCity != 0) {
//				if (data.stuResidenceProvince == 0) {// get all provinces in
//														// this city
//
//				} else {
//					expressions.add(Restrictions.eq(COL_STUDENT_RESIDENCE,
//							data.stuResidenceProvince));
//				}
//			}

			String aliasScholar = "scholar";
			String aliasSpec = "spec";
			Criteria query = getSession()
					.createCriteria(Scholarship.class, aliasScholar)
					.createAlias(aliasScholar + "." + COL_SPEC, aliasSpec,
							Criteria.LEFT_JOIN)
					.createAlias(aliasSpec + "." + "studentGender", "gender",
							Criteria.LEFT_JOIN);

			for (SimpleExpression expresssion : expressions) {
				query.add(expresssion);
			}

			resultList = query.list();

		} catch (Exception ex) {
			logger.error("Error in listBy(FilterViewModel): " + ex.toString());
		} finally {
			closeSession();
		}

		return resultList;
	}

	@Override
	public int countRowsListBy(FilterViewModel data) {
		// TODO Auto-generated method stub
		return 0;
	}

}
