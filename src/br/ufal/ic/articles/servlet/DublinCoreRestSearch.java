package br.ufal.ic.articles.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufal.ic.articles.core.DublinCoreLuceneSearch;
import br.ufal.ic.articles.xml.ArticleSerializer;

/**
 * Servlet implementation class for Servlet: DublinCoreSearch
 *
 */
 public class DublinCoreRestSearch extends HttpServlet {
	 
	 private static final int MAX_RESULTS = 10;
   
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
			IOException {
		String term = request.getParameter("term");
		String current = request.getParameter("current");
		
		if (current == null || !Pattern.matches("\\d*", current)) {
			current = "0";
		}

		DublinCoreLuceneSearch dublinCoreLuceneSearch = new DublinCoreLuceneSearch();
		
		String xml = new ArticleSerializer().serialize(dublinCoreLuceneSearch.findByExample(term, 
				Integer.valueOf(current), MAX_RESULTS));

		response.setContentType("text/xml");
		response.setContentLength(xml.length());
		
		response.getWriter()
			.append(xml)
			.close();
	}
	
}