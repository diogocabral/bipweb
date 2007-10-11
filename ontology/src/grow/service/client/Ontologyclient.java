package grow.service.client;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Ontologyclient {
	public static void main(String[] args) throws ServiceException, RemoteException {
		Service service = new Service();
		Call call = (Call)service.createCall();

	      //configura o desserializador para o livro retornado
	      QName qn  = new QName( "DefaultRDFSLiteralns", "DefaultRDFSLiteral" );
		  call.registerTypeMapping(edu.stanford.smi.protegex.owl.model.impl.DefaultRDFSLiteral.class, qn,
		         new org.apache.axis.encoding.ser.BeanSerializerFactory(edu.stanford.smi.protegex.owl.model.impl.DefaultRDFSLiteral.class, qn),
		         new org.apache.axis.encoding.ser.BeanDeserializerFactory(edu.stanford.smi.protegex.owl.model.impl.DefaultRDFSLiteral.class, qn));
		
		
		call.setTargetEndpointAddress("http://localhost:8080/axis/services/QueryOntology2");
		call.setOperationName("retrieveByFileQ");
		Object[] ob = (Object[]) call.invoke(new Object[]{"/media/IVO/ProjetoPesquisa/Ontologia/Pesquisador/ProjetoPesquisaOntology.pprj",
				"SELECT ?subject WHERE { :Instituicao_1 :cnpj ?subject  }"});
		for (Object object : ob) {
			System.out.println(object);
		}
	}
}
