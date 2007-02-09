package br.bipweb.view;

import java.util.Collection;

import br.bipweb.model.Category;

public class TreeView {
	
	private Collection<Category> categories;
	
	public TreeView(Collection<Category> categories) {
		super();
		
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
		
		buffer.append("d.add(0.5,0,'Nova categoria','doNew.action','','','../images/icons/filenew.png');");
		buffer.append("document.write(d);");
		
		return buffer.toString();
		
	}
	
	private String toJavaScript(Category category) {
		
		StringBuffer buffer = new StringBuffer();
		
		int id = category.getId();
		int parentId = category.getParent() == null ? 0 : category.getParent().getId();
		
		buffer.append(String.format("d.add(%s,%s,'%s','doEdit.action?category.id=%s');", id, parentId, category.getName(), id));
		
		Collection<Category> categories = category.getChildren();
		
		for (Category category2 : categories) {
			buffer.append(toJavaScript(category2));
		}
		
		buffer.append(String.format("d.add(%s,%s,'Nova categoria','doNew.action?category.parent.id=%s','','','../images/icons/filenew.png');", id+0.5, id, id));
		
		return buffer.toString();
		
	}
	
}
