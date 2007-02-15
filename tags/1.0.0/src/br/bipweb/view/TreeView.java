package br.bipweb.view;

import java.io.Serializable;
import java.util.Collection;

import br.bipweb.model.Category;

public class TreeView implements Serializable {

	private static final long serialVersionUID = -2206462622987399616L;

	private Collection<Category> categories;
	
	private Type type;
	
	public TreeView(Type type, Collection<Category> categories) {
		super();
		
		this.type = type;
		this.categories = categories;
		
	}
	
	@Override
	public String toString() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("d = new dTree('d');");
		buffer.append("d.add(0, -1, 'Categorias');");
		
		for (Category category : categories) {
			buffer.append(toJavaScript(category));
		}
		
		if (type == Type.MANAGE) {
			buffer.append("d.add(0.5,0,'Nova categoria','new.do','','','../images/icons/filenew.png');");
		}
		
		buffer.append("document.write(d);");
		
		return buffer.toString();
		
	}
	
	private String toJavaScript(Category c) {
		
		StringBuffer buffer = new StringBuffer();
		
		Long id = c.getId();
		Long parentId = c.getParent() == null ? 0 : c.getParent().getId();
		
		if (type == Type.MANAGE) {
			buffer.append(String.format("d.add(%s,%s,'%s','edit.do?category.id=%s');", id, parentId, c.getName(), id));
		} else if (type == Type.SEARCH) {
			buffer.append(String.format("d.add(%s,%s,'%s','search.do?category.id=%s');", id, parentId, c.getName(), id));
		} else if (type == Type.MANAGE_SHARED) {
			buffer.append(String.format("d.add(%s,%s,'%s','editShared.do?category.id=%s');", id, parentId, c.getName(), id));
		}
		
		Collection<Category> categories = c.getChildren();
		
		for (Category category : categories) {
			buffer.append(toJavaScript(category));
		}
		
		if (type == Type.MANAGE) {
			buffer.append(String.format("d.add(%s,%s,'Nova categoria','new.do?category.parent.id=%s','','','../images/icons/filenew.png');", id+0.5, id, id));
		}
		
		return buffer.toString();
		
	}
	
	public enum Type {
		MANAGE,
		SEARCH,
		MANAGE_SHARED
	}
	
}