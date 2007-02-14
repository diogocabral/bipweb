package br.bipweb.model.search;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;

import br.bipweb.model.Document;

public class AbstractWebSearcher extends AbstractSearcher {
	
	protected static final String USERAGENT = "BIPWeb";
	protected static final NumberFormat FORMAT = NumberFormat.getNumberInstance(new Locale("en"));
	
	protected int first, last, total;
	
	public AbstractWebSearcher() {
		super();
	}
	
	@Override
	public Collection<Document> search()
			throws SearchException {
		super.search();
		
		first = last = total;
		
		return null;
		
	}
	
}