package br.ufal.ic.articles.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.ufal.ic.articles.util.HibernateUtil;

public class HibernateFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException { }

	public void destroy() {	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
			FilterChain filterChain) throws IOException, ServletException {
		
		HibernateUtil.openSession();		
		try {
			filterChain.doFilter(servletRequest, servletResponse);
			HibernateUtil.commit();
		} catch (Exception e) {
			HibernateUtil.rollback();
		} finally {		
			HibernateUtil.close();
		}
	}	

}
