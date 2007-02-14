package br.bipweb.model.search;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import br.bipweb.model.Document;

public class LocalSearcher extends AbstractSearcher {
	
	private File directory;
	private FileFilter filter;
	private Comparator<File> comparator;
	
	private int count, countAdded, first, last, total;
	
	public LocalSearcher(File directory) {
		super();
		
		documentsPerPage = 100;
		
		this.directory = directory;
		
		this.filter = new FileFilter() {
			public boolean accept(File file) {
				
				if (file.isDirectory())
					return true;
				
				String name = file.getName();
				if (name.endsWith(".htm") || name.endsWith(".html"))
					return true;
				return false;
			}
			
		};
		
		comparator = new Comparator<File>() {
			public int compare(File a, File b) {
				
				if (a.isFile() && b.isDirectory()) {
					return -1;
				}
				
				if (a.isDirectory() && b.isFile()) {
					return 1;
				}
				
				return a.getName().compareToIgnoreCase(b.getName());
				
			}
		};
		
	}
	
	@Override
	public Collection<Document> search()
			throws SearchException {
		super.search();
		
		if (directory == null)
			throw new SearchException("Deve-se informar um diretório para busca.");
		
		if (!directory.isDirectory())
			throw new SearchException("directory deve ser um diretório.");
		
		total = calculateTotal(directory);
		
		first = 1;
		last = documentsPerPage;
		
		count = 0;
		countAdded = 0;
		
		Collection<Document> documents = new ArrayList<Document>();
		
		search(documents, directory);
		
		return documents;
		
	}
	
	@Override
	public Collection<Document> searchNext()
			throws SearchException {
		super.searchNext();
		
		if (!hasMoreDocuments())
			throw new SearchException("Fim da busca.");
		
		first = last + 2;
		last = first + documentsPerPage - 1;
		
		count = 0;
		countAdded = 0;
		
		Collection<Document> documents = new ArrayList<Document>();
		
		search(documents, directory);
		
		return documents;
		
	}
	
	@Override
	public boolean hasMoreDocuments()
			throws SearchException {
		super.hasMoreDocuments();
		
		if (last < total) {
			return true;
		}
		
		return false;
	}
	
	private void search(Collection<Document> documents, File directory) {
		
		if (countAdded == documentsPerPage)
			return;
		
		count++;
		
		if (directory.isFile()) { // É um arquivo
			
			if (count >= first) {
			
				String url = directory.toURI().toString();
				
				Document document = new Document();
				document.setUrl(url);
				
				documents.add(document);
					
				countAdded++;
			
			}
			
			return;
			
		}
		
		File[] files = directory.listFiles(filter);
		
		Arrays.sort(files, comparator);
		
		for (File file : files) {
			search(documents, file);
		}
		
	}
	
	private int calculateTotal(File directory) {
		
		int total = 0;
		
		if (directory.isFile())
			return total;
		
		File[] files = directory.listFiles(filter);
		
		total += files.length;
		
		for (File file : files) {
			total += calculateTotal(file);
		}
		
		return total;
		
	}
	
}