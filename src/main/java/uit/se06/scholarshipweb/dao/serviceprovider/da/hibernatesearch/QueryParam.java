package uit.se06.scholarshipweb.dao.serviceprovider.da.hibernatesearch;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;

public class QueryParam {
	private String[] fields;
	private String term;

	private QueryParam andOperandSuffix;
	private QueryParam orOperandSuffix;

	private BooleanQuery indexerQuery = new BooleanQuery();

	public QueryParam(String term, String[] fields) {
		this.term = term;
		this.fields = fields;
	}

	public QueryParam and(QueryParam queryParam) {
		andOperandSuffix = queryParam;
		return this;
	}

	public QueryParam or(QueryParam queryParam) {
		orOperandSuffix = queryParam;
		return this;
	}

	public BooleanQuery getQuery() {
		for (String field : fields)
			indexerQuery.add(new FuzzyQuery(new Term(field, term)),
					Occur.SHOULD);

		if (andOperandSuffix != null)
			indexerQuery.add(andOperandSuffix.getQuery(), Occur.MUST);

		if (orOperandSuffix != null)
			indexerQuery.add(orOperandSuffix.getQuery(), Occur.SHOULD);

		return indexerQuery;
	}

}
