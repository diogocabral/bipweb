package br.ufal.ic.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import org.apache.commons.digester.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.ufal.ic.parser.bean.CurriculoVitae;
import br.ufal.ic.parser.bean.DadosGerais;
import br.ufal.ic.parser.bean.ProducaoBibliografica;
import br.ufal.ic.parser.bean.dadosgerais.AreaAtuacao;
import br.ufal.ic.parser.bean.dadosgerais.AtuacaoProfissional;
import br.ufal.ic.parser.bean.dadosgerais.Endereco;
import br.ufal.ic.parser.bean.dadosgerais.FormacaoAcademicaTitulacao;
import br.ufal.ic.parser.bean.dadosgerais.Idioma;
import br.ufal.ic.parser.bean.dadosgerais.OutrasInformacoesRelevantes;
import br.ufal.ic.parser.bean.dadosgerais.PalavrasChave;
import br.ufal.ic.parser.bean.dadosgerais.PremioTitulo;
import br.ufal.ic.parser.bean.dadosgerais.ResumoCv;
import br.ufal.ic.parser.bean.dadosgerais.endereco.EnderecoProfissional;
import br.ufal.ic.parser.bean.dadosgerais.endereco.EnderecoResidencial;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Aperfeicoamento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreaConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.AreasConhecimento;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.CursoTecnicoProfissionalizante;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Doutorado;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.EnsinoFundamentalPrimeiroGrau;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.EnsinoMedioSegundoGrau;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Especializacao;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Graduacao;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.LivreDocencia;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.Mestrado;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.MestradoProfissionalizante;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.PosDoutorado;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.ResidenciaMedica;
import br.ufal.ic.parser.bean.dadosgerais.formacaoacademica.SetoresAtividade;
import br.ufal.ic.parser.bean.producaobibliografica.ArtigoAceitoPublicacao;
import br.ufal.ic.parser.bean.producaobibliografica.ArtigoPublicado;
import br.ufal.ic.parser.bean.producaobibliografica.LivrosCapitulos;
import br.ufal.ic.parser.bean.producaobibliografica.TextoJornaisRevistas;
import br.ufal.ic.parser.bean.producaobibliografica.TrabalhoEmEventos;
import br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado.DadosBasicosArtigo;
import br.ufal.ic.parser.bean.producaobibliografica.artigospublicados.artigopublicado.DetalhamentoArtigo;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.CapitulosLivrosPublicados;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.LivrosPublicadosOrganizados;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.CapituloLivroPublicado;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado.DadosBasicosCapitulo;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.capituloslivrospublicados.capitulolivropublicado.DetalhamentoCapitulo;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.LivroPublicadoOrganizado;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.livropublicadoorganizado.DadosBasicosLivro;
import br.ufal.ic.parser.bean.producaobibliografica.livroscapitulos.livrospublicadosorganizados.livropublicadoorganizado.DetalhamentoLivro;
import br.ufal.ic.parser.bean.producaobibliografica.textojornaisrevistas.DadosBasicosTexto;
import br.ufal.ic.parser.bean.producaobibliografica.textojornaisrevistas.DetalhamentoTexto;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.Autores;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.DadosBasicosTrabalho;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.DetalhamentoTrabalho;
import br.ufal.ic.parser.bean.producaobibliografica.trabalhoeventos.InformacoesAdicionais;

public class CurriculoVitaeXmlParser {
	
	private Digester digester;
	
	public CurriculoVitaeXmlParser() {
		this.digester = new Digester();
		this.setProperties();
	}
	
	public CurriculoVitae parse(File file) throws IOException, SAXException {
		return (CurriculoVitae) digester.parse(file);
	}
	
	public CurriculoVitae parse(InputStream inputStream) throws IOException, SAXException {
		return (CurriculoVitae) digester.parse(inputStream);
	}
	
	public CurriculoVitae parse(InputSource inputSource) throws IOException, SAXException {
		return (CurriculoVitae) digester.parse(inputSource);
	}
	
	public CurriculoVitae parse(Reader reader) throws IOException, SAXException {
		return (CurriculoVitae) digester.parse(reader);
	}
	
	public CurriculoVitae parse(String uri) throws IOException, SAXException {
		return (CurriculoVitae) digester.parse(uri);
	}
	
	public CurriculoVitae parse(URL url) throws IOException, SAXException {
		return (CurriculoVitae) digester.parse(url);
	}
	
	private void setProperties() {
		addCurriculoVitaeProperties();		
		addDadosGeraisProperties();			
		addProducaoBibliografica();
	}
	
	private void addCurriculoVitaeProperties() {
		digester.addObjectCreate("CURRICULO-VITAE", CurriculoVitae.class);
		digester.addSetProperties("CURRICULO-VITAE");
		digester.addSetProperties("CURRICULO-VITAE", "SISTEMA-ORIGEM-XML", "sistemaOrigemXml");
		digester.addSetProperties("CURRICULO-VITAE", "NUMERO-IDENTIFICADOR", "numeroIdentificador");
		digester.addSetProperties("CURRICULO-VITAE", "FORMATO-DATA-ATUALIZACAO", "formatoDataAtualizacao");		
		digester.addSetProperties("CURRICULO-VITAE", "DATA-ATUALIZACAO", "dataAtualizacao");
		digester.addSetProperties("CURRICULO-VITAE", "FORMATO-HORA-ATUALIZACAO", "formatoHoraAtualizacao");
		digester.addSetProperties("CURRICULO-VITAE", "HORA-ATUALIZACAO", "horaAtualizacao");
		digester.addSetProperties("CURRICULO-VITAE", "xmlns:lattes", "xmlnsLattes");
	}
	
	private void addDadosGeraisProperties() {
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS", DadosGerais.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NOME-COMPLETO", "nomeCompleto");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NOME-EM-CITACOES-BIBLIOGRAFICAS", "nomeCitacoesBibliograficas");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NACIONALIDADE", "nacionalidade");			
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "CPF", "cpf");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NUMERO-DO-PASSAPORTE", "nomePassaporte");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "PAIS-DE-NASCIMENTO", "paisNascimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "UF-NASCIMENTO", "ufNascimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "CIDADE-NASCIMENTO", "cidadeNascimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "FORMATO-DATA-DE-NASCIMENTO", "formatoDataNascimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "DATA-NASCIMENTO", "dataNascimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "SEXO", "sexo");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NUMERO-IDENTIDADE", "numeroIdentidade");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "ORGAO-EMISSOR", "orgaoEmissor");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NUMERO-IDENTIDADE", "numeroIdentidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "UF-ORGAO-EMISSOR", "ufOrgaoEmissor");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "FORMATO-DATA-DE-EMISSAO", "formatoDataEmissao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NOME-DO-PAI", "nomePai");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NOME-DA-MAE", "nomeMae");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "PERMISSAO-DE-DIVULGACAO", "permissaoDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "NOME-DO-ARQUIVO-DE-FOTO", "nomeArquivoFoto");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "TEXTO-RESUMO-CV-RH", "textoResumoCvRh");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS", "OUTRAS-INFORMACOES-RELEVANTES", "outrasInformacoesRelevantes");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS", "setDadosGerais");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/RESUMO-CV", ResumoCv.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/RESUMO-CV");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/RESUMO-CV", "TEXTO-RESUMO-CV-RH", "textoResumoCvRh");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/RESUMO-CV", "setResumoCv");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/OUTRAS-INFORMACOES-RELEVANTES", OutrasInformacoesRelevantes.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/OUTRAS-INFORMACOES-RELEVANTES");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/OUTRAS-INFORMACOES-RELEVANTES", "OUTRAS-INFORMACOES-RELEVANTES", "outrasInformacoesRelevantes");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/OUTRAS-INFORMACOES-RELEVANTES", "setOutrasInformacoes");
		
		//FIM MAPEAMENTO ELEMENTO ENDERECO

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO", Endereco.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO", "FLAG-DE-PREFERENCIA", "flagReferencia");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO", "setEndereco");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", EnderecoProfissional.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "CODIGO-INSTITUICAO-EMPRESA", "codigoInstituicaoEmpresa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "NOME-INSTITUICAO-EMPRESA", "nomeInstituicaoEmpresa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "CODIGO-UNIDADE", "codigoUnidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "NOME-UNIDADE", "nomeUnidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "LOGRADOURO-COMPLEMENTO", "logradouroComplemento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "PAIS", "pais");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "UF", "uf");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "CEP", "cep");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "CIDADE", "cidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "BAIRRO", "bairro");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "DDD", "ddd");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "TELEFONE", "telefone");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "RAMAL", "ramal");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "FAX", "fax");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "CAIXA-POSTAL", "caixaPostal");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "E-MAIL", "email");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "HOME-PAGE", "homePage");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-PROFISSIONAL", "setEnderecoProfissional");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", EnderecoResidencial.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "LOGRADOURO", "logradouro");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "PAIS", "pais");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "UF", "uf");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "CEP", "cep");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "CIDADE", "cidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "BAIRRO", "bairro");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "DDD", "ddd");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "TELEFONE", "telefone");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "RAMAL", "ramal");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "FAX", "fax");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "CAIXA-POSTAL", "caixaPostal");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "E-MAIL", "email");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "HOME-PAGE", "homePage");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/ENDERECO/ENDERECO-RESIDENCIAL", "setEnderecoResidencial");
		
		//FIM MAPEAMENTO ELEMENTO ENDERECO
		
		//IN�CIO MAPEAMENTO ELEMENTO FORMACAO-ACADEMICA-TITULACAO
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO", FormacaoAcademicaTitulacao.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO", "setFormacaoAcademicaTitulacao");
		
		//IN�CIO MAPEAMENTO ELEMENTO GRADUACAO
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", Graduacao.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "CODIGO-AREA-CURSO", "codigoAreaCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "CODIGO-CURSO-CAPES", "codigoCursoCapes");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NOME-DO-ORIENTADOR", "nomeOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "NUMERO-ID-ORIENTADOR", "numeroIdOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "TITULO-DO-TRABALHO-DE-CONCLUSAO-DE-CURSO", "tituloTrabalhoConclusaoCurso");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/GRADUACAO", "addGraduacao");
		
		//FIM MAPEAMENTO ELEMENTO GRADUACAO
		
		//IN�CIO MAPEAMENTO ELEMENTO ESPECIALIZACAO
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", Especializacao.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "CARGA-HORARIA", "cargaHoraria");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "NOME-DO-ORIENTADOR", "nomeOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "TITULO-DA-MONOGRAFIA", "tituloMonografia");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ESPECIALIZACAO", "addEspecializacao");
		
		//FIM MAPEAMENTO ELEMENTO ESPECIALIZACAO
		
		//IN�CIO MAPEAMENTO ELEMENTO MESTRADO
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", Mestrado.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "ANO-DE-OBTENCAO-DO-TITULO", "anoObtencaoTitulo");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "CODIGO-AREA-CURSO", "codigoAreaCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "CODIGO-CURSO-CAPES", "codigoCursoCapes");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NOME-COMPLETO-ORIENTADOR", "nomeCompletoOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "NUMERO-ID-ORIENTADOR", "numeroIdOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "TITULO-DA-DISSERTACAO-TESE", "tituloDissertacaoTese");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO", "addMestrado");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", PalavrasChave.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-1", "palavraChave1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-2", "palavraChave2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-3", "palavraChave3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-4", "palavraChave4");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-5", "palavraChave5");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-6", "palavraChave6");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/PALAVRAS-CHAVE", "setPalavrasChave");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO", AreasConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO", "setAreasConhecimento");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "setAreaConhecimento1");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "setAreaConhecimento2");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "setAreaConhecimento3");

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/SETORES-DE-ATIVIDADE", SetoresAtividade.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/SETORES-DE-ATIVIDADE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-1", "setoresAtividade1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-2", "setoresAtividade2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-3", "setoresAtividade3");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO/SETORES-DE-ATIVIDADE", "setSetoresAtividade");
		
		//FIM MAPEAMENTO ELEMENTO MESTRADO
		
		//IN�CIO MAPEAMENTO ELEMENTO DOUTORADO

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", Doutorado.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "ANO-DE-OBTENCAO-DO-TITULO", "anoObtencaoTitulo");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-AREA-CURSO", "codigoAreaCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-CURSO-CAPES", "codigoCursoCapes");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-INSTITUICAO-DOUT", "codigoInstituicaoDout");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-INSTITUICAO-OUTRA-DOUT", "codigoInstituicaoOutraDout");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-COMPLETO-ORIENTADOR", "nomeCompletoOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-INSTITUICAO-DOUT", "nomeInstituicaoOutra");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-INSTITUICAO-OUTRA-DOUT", "nomeInstituicaoOutraDout");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NOME-ORIENTADOR-DOUT", "nomeOrientadorDout");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "NUMERO-ID-ORIENTADOR", "numeroIdOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "TIPO-DOUTORADO", "tipoDoutorado");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "TITULO-DA-DISSERTACAO-TESE", "tituloDissertacaoTese");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO", "addDoutorado");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", PalavrasChave.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-1", "palavraChave1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-2", "palavraChave2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-3", "palavraChave3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-4", "palavraChave4");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-5", "palavraChave5");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-6", "palavraChave6");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/PALAVRAS-CHAVE", "setPalavrasChave");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO", AreasConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO", "setAreasConhecimento");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "setAreaConhecimento1");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "setAreaConhecimento2");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "setAreaConhecimento3");

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/SETORES-DE-ATIVIDADE", SetoresAtividade.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/SETORES-DE-ATIVIDADE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-1", "setoresAtividade1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-2", "setoresAtividade2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-3", "setoresAtividade3");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/DOUTORADO/SETORES-DE-ATIVIDADE", "setSetoresAtividade");
		
		//FIM MAPEAMENTO ELEMENTO DOUTORADO

		//IN�CIO MAPEAMENTO ELEMENTO POS-DOUTORADO

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", PosDoutorado.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "ANO-DE-OBTENCAO-DO-TITULO", "anoObtencaoTitulo");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "CODIGO-CURSO-CAPES", "codigoCursoCapes");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "NUMERO-ID-ORIENTADOR", "numeroIdOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "STATUS-DO-ESTAGIO", "statusEstagio");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO", "addPosDoutorado");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", PalavrasChave.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-1", "palavraChave1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-2", "palavraChave2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-3", "palavraChave3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-4", "palavraChave4");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-5", "palavraChave5");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "PALAVRA-CHAVE-6", "palavraChave6");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/PALAVRAS-CHAVE", "setPalavrasChave");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO", AreasConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO", "setAreasConhecimento");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "setAreaConhecimento1");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "setAreaConhecimento2");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "setAreaConhecimento3");

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/SETORES-DE-ATIVIDADE", SetoresAtividade.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/SETORES-DE-ATIVIDADE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-1", "setoresAtividade1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-2", "setoresAtividade2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-3", "setoresAtividade3");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/POS-DOUTORADO/SETORES-DE-ATIVIDADE", "setSetoresAtividade");
		
		//FIM MAPEAMENTO ELEMENTO POS-DOUTORADO
		
		//IN�CIO MAPEAMENTO ELEMENTO LIVRE-DOCENCIA
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", LivreDocencia.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "ANO-DE-OBTENCAO-DO-TITULO", "anoObtencaoTitulo");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "TITULO-DO-TRABALHO", "tituloTrabalho");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA", "addLivreDocencia");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", PalavrasChave.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-1", "palavraChave1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-2", "palavraChave2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-3", "palavraChave3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-4", "palavraChave4");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-5", "palavraChave5");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-6", "palavraChave6");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/PALAVRAS-CHAVE", "setPalavrasChave");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO", AreasConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO", "setAreasConhecimento");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "setAreaConhecimento1");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "setAreaConhecimento2");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "setAreaConhecimento3");

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/SETORES-DE-ATIVIDADE", SetoresAtividade.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/SETORES-DE-ATIVIDADE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-1", "setoresAtividade1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-2", "setoresAtividade2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-3", "setoresAtividade3");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/LIVRE-DOCENCIA/SETORES-DE-ATIVIDADE", "setSetoresAtividade");
		
		//FIM MAPEAMENTO ELEMENTO LIVRE-DOCENCIA
		
		//IN�CIO MAPEAMENTO ELEMENTO CURSO-TECNICO-PROFISSIONALIZANTE

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", CursoTecnicoProfissionalizante.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "ANO-DE-CONCLUSAO", "anoConclusao");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/CURSO-TECNICO-PROFISSIONALIZANTE", "addCursoTecnicoProfissionalizante");
		
		//FIM MAPEAMENTO ELEMENTO CURSO-TECNICO-PROFISSIONALIZANTE
		
		//IN�CIO MAPEAMENTO ELEMENTO MESTRADO-PROFISSIONALIZANTE
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", MestradoProfissionalizante.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "ANO-DE-OBTENCAO-DO-TITULO", "anoObtencaoTitulo");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "CODIGO-AREA-CURSO", "codigoAreaCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "CODIGO-CURSO-CAPES", "codigoCursoCapes");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NOME-COMPLETO-DO-ORIENTADOR", "nomeCompletoOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "NUMERO-ID-ORIENTADOR", "numeroIdOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "TITULO-DA-DISSERTACAO-TESE", "tituloDissertacaoTese");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE", "addMestradoProfissionalizante");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", PalavrasChave.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "PALAVRA-CHAVE-1", "palavraChave1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "PALAVRA-CHAVE-2", "palavraChave2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "PALAVRA-CHAVE-3", "palavraChave3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "PALAVRA-CHAVE-4", "palavraChave4");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "PALAVRA-CHAVE-5", "palavraChave5");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "PALAVRA-CHAVE-6", "palavraChave6");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/PALAVRAS-CHAVE", "setPalavrasChave");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO", AreasConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO", "setAreasConhecimento");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "setAreaConhecimento1");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "setAreaConhecimento2");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "setAreaConhecimento3");

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/SETORES-DE-ATIVIDADE", SetoresAtividade.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/SETORES-DE-ATIVIDADE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-1", "setoresAtividade1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-2", "setoresAtividade2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-3", "setoresAtividade3");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/MESTRADO-PROFISSIONALIZANTE/SETORES-DE-ATIVIDADE", "setSetoresAtividade");
		
		//FIM MAPEAMENTO ELEMENTO MESTRADO-PROFISSIONALIZANTE
				
		//IN�CIO MAPEAMENTO ELEMENTO ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", EnsinoFundamentalPrimeiroGrau.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "ANO-DE-CONCLUSAO", "anoConclusao");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "ANO-DE-INICIO", "anoInicio");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "NIVEL", "nivel");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU", "setEnsinoFundamentalPrimeiroGrau");
		
		//FIM MAPEAMENTO ELEMENTO ENSINO-FUNDAMENTAL-PRIMEIRO-GRAU	
		
		//IN�CIO MAPEAMENTO ELEMENTO ENSINO-MEDIO-SEGUNDO-GRAU
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", EnsinoMedioSegundoGrau.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "ANO-DE-CONCLUSAO", "anoConclusao");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "ANO-DE-INICIO", "anoInicio");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "NIVEL", "nivel");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/ENSINO-MEDIO-SEGUNDO-GRAU", "setEnsinoMedioSegundoGrau");
		
		//FIM MAPEAMENTO ELEMENTO ENSINO-MEDIO-SEGUNDO-GRAU			
		
		//IN�CIO MAPEAMENTO ELEMENTO RESIDENCIA-MEDICA

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", ResidenciaMedica.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "ANO-DE-CONCLUSAO", "anoConclusao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "NUMERO-DO-REGISTRO", "numeroRegistro");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "TITULO-DA-RESIDENCIA-MEDICA", "tituloResidenciaMedica");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA", "addResidenciaMedica");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", PalavrasChave.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-1", "palavraChave1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-2", "palavraChave2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-3", "palavraChave3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-4", "palavraChave4");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-5", "palavraChave5");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "PALAVRA-CHAVE-6", "palavraChave6");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/PALAVRAS-CHAVE", "setPalavrasChave");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO", AreasConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO", "setAreasConhecimento");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-1", "setAreaConhecimento1");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-2", "setAreaConhecimento2");
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", AreaConhecimento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/AREAS-DO-CONHECIMENTO/AREA-DO-CONHECIMENTO-3", "setAreaConhecimento3");

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/SETORES-DE-ATIVIDADE", SetoresAtividade.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/SETORES-DE-ATIVIDADE");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-1", "setoresAtividade1");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-2", "setoresAtividade2");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/SETORES-DE-ATIVIDADE", "SETOR-DE-ATIVIDADE-3", "setoresAtividade3");		
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/RESIDENCIA-MEDICA/SETORES-DE-ATIVIDADE", "setSetoresAtividade");
		
		//FIM MAPEAMENTO ELEMENTO RESIDENCIA-MEDICA
		
		//IN�CIO MAPEAMENTO ELEMENTO APERFEICOAMENTO

		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", Aperfeicoamento.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "ANO-DE-CONCLUSAO", "anoConclusao");		
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "ANO-DE-INICIO", "anoInicio");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "CARGA-HORARIA", "cargaHoraria");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "CODIGO-AGENCIA-FINANCIADORA", "codigoAgenciaFinanciadora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "CODIGO-AREA-CURSO", "codigoAreaCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "CODIGO-CURSO", "codigoCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "CODIGO-INSTITUICAO", "codigoInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "CODIGO-ORGAO", "codigoOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "FLAG-BOLSA", "flagBolsa");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "NIVEL", "nivel");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "NOME-AGENCIA", "nomeAgencia");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "NOME-CURSO", "nomeCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "NOME-DO-ORIENTADOR", "nomeOrientador");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "NOME-INSTITUICAO", "nomeInstituicao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "NOME-ORGAO", "nomeOrgao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "SEQUENCIA-FORMACAO", "sequenciaFormacao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "STATUS-DO-CURSO", "statusCurso");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "TITULO-DA-MONOGRAFIA", "tituloMonografia");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/FORMACAO-ACADEMICA-TITULACAO/APERFEICOAMENTO", "addAperfeicoamento");
		
		//FIM MAPEAMENTO ELEMENTO APERFEICOAMENTO
		
		//FIM MAPEAMENTO ELEMENTO FORMACAO-ACADEMICA-TITULACAO
		
		//IN�CIO MAPEAMENTO ELEMENTO ATUACOES-PROFISSIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/ATUACOES-PROFISSIONAIS/ATUACAO-PROFISSIONAL", AtuacaoProfissional.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ATUACOES-PROFISSIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/ATUACOES-PROFISSIONAIS/ATUACAO-PROFISSIONAL");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/ATUACOES-PROFISSIONAIS/ATUACAO-PROFISSIONAL", "addAtuacaoProfissional");
		
		//TODO ELEMENTO ATUACAO-PROFISSIONAL
		
		//FIM MAPEAMENTO ELEMENTO AREAS-DE-ATUACAO
		
		//IN�CIO MAPEAMENTO ELEMENTO AREAS-DE-ATUACAO
			
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", AreaAtuacao.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", "NOME-DA-AREA-DO-CONHECIMENTO", "nomeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", "NOME-DA-ESPECIALIDADE", "nomeEspecialidade");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", "NOME-DA-SUB-AREA-DO-CONHECIMENTO", "nomeSubAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", "NOME-GRANDE-AREA-DO-CONHECIMENTO", "nomeGrandeAreaConhecimento");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", "SEQUENCIA-AREA-DE-ATUACAO", "sequenciaAreaAtuacao");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/AREAS-DE-ATUACAO/AREA-DE-ATUACAO", "addAreaAtuacao");
			
		//FIM MAPEAMENTO ELEMENTO AREAS-DE-ATUACAO
		
		//IN�CIO MAPEAMENTO ELEMENTO IDIOMAS
	
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", Idioma.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "DESCRICAO-DO-IDIOMA", "descricaoIdioma");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "PROFICIENCIA-DE-COMPREENSAO", "proficienciaCompreensao");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "PROFICIENCIA-DE-ESCRITA", "proficienciaEscrita");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "PROFICIENCIA-DE-FALA", "proficienciaFala");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "PROFICIENCIA-DE-LEITURA", "proficienciaLeitura");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/IDIOMAS/IDIOMA", "addIdioma");
			
		//FIM MAPEAMENTO ELEMENTO IDIOMAS	
		
		// INICIO MAPEAMENTO PREMIOS-TITULOS
		
		digester.addObjectCreate("CURRICULO-VITAE/DADOS-GERAIS/PREMIOS-TITULOS/PREMIOS-TITULO", PremioTitulo.class);
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/PREMIOS-TITULOS/PREMIOS-TITULO");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/PREMIOS-TITULOS/PREMIOS-TITULO", "NOME-DO-PREMIO-OU-TITULO", "nomePremioTitulo");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/PREMIOS-TITULOS/PREMIOS-TITULO", "NOME-DA-ENTIDADE-PROMOTORA", "nomeEntidadePromotora");
		digester.addSetProperties("CURRICULO-VITAE/DADOS-GERAIS/PREMIOS-TITULOS/PREMIOS-TITULO", "ANO-DA-PREMIACAO", "anoPremiacao");
		digester.addSetNext("CURRICULO-VITAE/DADOS-GERAIS/PREMIOS-TITULOS/PREMIOS-TITULO", "addPremioTitulo");
		
		// FIM MAPEAMENTO PREMIOS-TITULOS
				
	}
	
	private void addProducaoBibliografica() {
		
		//		 INICIO MAPEAMENTO PRODUCAO-BIBLIOGRAFICA
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA", ProducaoBibliografica.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA", "setProducaoBibliografica");
		
		//		 FIM MAPEAMENTO PRODUCAO-BIBLIOGRAFICA
		
		//		 INICIO MAPEAMENTO TRABALHO-EM-EVENTOS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS", TrabalhoEmEventos.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS", "SEQUENCIA-PRODUCAO", "sequenciaProducao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS", "addTrabalhoEmEventos");
		
		//		 FIM MAPEAMENTO TRABALHO-EM-EVENTOS
		
		//		 INICIO MAPEAMENTO DADOS-BASICOS-DO-TRABALHO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", DadosBasicosTrabalho.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "NATUREZA", "natureza");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "TITULO-DO-TRABALHO", "tituloTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "ANO-DO-TRABALHO", "anoTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "PAIS-DO-EVENTO", "paisEvento");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "MEIO-DE-DIVULGACAO", "meioDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "HOME-PAGE-DO-TRABALHO", "homePageTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "FLAG-RELEVANCIA", "flagRelevancia");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "DOI", "doi");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DADOS-BASICOS-DO-TRABALHO", "setDadosBasicoTrabalho");
		
		//		 FIM MAPEAMENTO DADOS-BASICOS-DO-TRABALHO
		
		//		 INICIO MAPEAMENTO DETALHAMENTO-DO-TRABALHO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", DetalhamentoTrabalho.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "CLASSIFICACAO-DO-EVENTO", "classificacaoEvento");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "NOME-DO-EVENTO", "nomeEvento");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "CIDADE-DO-EVENTO", "cidadeEvento");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "ANO-DE-REALIZACAO", "anoRealizacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "TITULO-DOS-ANAIS-OU-PROCEEDINGS", "titulosAnaisProceedings");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "VOLUME", "volume");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "FASCICULO", "fasciculo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "SERIE", "serie");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "PAGINA-FINAL", "paginaFinal");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "ISBN", "isbn");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "NOME-DA-EDITORA", "nomeEditora");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "CIDADE-DA-EDITORA", "cidadeEditora");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/DETALHAMENTO-DO-TRABALHO", "setDetalhamentoTrabalho");
		
		//		 FIM MAPEAMENTO DETALHAMENTO-DO-TRABALHO
		
		//		 INICIO MAPEAMENTO AUTORES
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES", Autores.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES", "NOME-COMPLETO-DO-AUTOR", "nomeCompletoAutor");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES", "NOME-PARA-CITACAO", "nomeCitacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES", "ORDEM-DE-AUTORIA", "ordemAutoria");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES", "CPF", "cpf");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/AUTORES", "addAutor");
		
		//		 FIM MAPEAMENTO AUTORES
		
		//		 INICIO MAPEAMENTO INFORMACOES-ADICIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/INFORMACOES-ADICIONAIS", InformacoesAdicionais.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/INFORMACOES-ADICIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/INFORMACOES-ADICIONAIS", "DESCRICAO-INFORMACOES-ADICIONAIS", "descricaoInformacoesAdicionais");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TRABALHOS-EM-EVENTOS/TRABALHO-EM-EVENTOS/INFORMACOES-ADICIONAIS", "setInformacoesAdicionais");
		
		//		 FIM MAPEAMENTO INFORMACOES-ADICIONAIS
		
		//		 INICIO MAPEAMENTO ARTIGO-PUBLICADO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO", ArtigoPublicado.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO", "SEQUENCIA-PRODUCAO", "sequenciaProducao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO", "addArtigoPublicado");
		
		//		 FIM MAPEAMENTO ARTIGO-PUBLICADO
		
		//		 INICIO MAPEAMENTO DADOS-BASICOS-DO-ARTIGO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", DadosBasicosArtigo.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "NATUREZA", "natureza");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "TITULO-DO-ARTIGO", "tituloArtigo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "ANO-DO-ARTIGO", "anoArtigo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "PAIS-DE-PUBLICACAO", "paisPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "MEIO-DE-DIVULGACAO", "meioDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "HOME-PAGE-DO-TRABALHO", "homePageTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "FLAG-RELEVANCIA", "flagRelevancia");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "DOI", "doi");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DADOS-BASICOS-DO-ARTIGO", "setDadosBasicoArtigo");
		
		//		 FIM MAPEAMENTO DADOS-BASICOS-DO-ARTIGO
		
		//		 INICIO MAPEAMENTO DETALHAMENTO-DO-ARTIGO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", DetalhamentoArtigo.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "TITULO-DO-PERIODICO-OU-REVISTA", "tituloPeriodicoRevista");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "ISSN", "issn");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "VOLUME", "volume");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "FASCICULO", "fasciculo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "SERIE", "serie");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "PAGINA-FINAL", "paginaFinal");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "LOCAL-DE-PUBLICACAO", "localPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/DETALHAMENTO-DO-ARTIGO", "setDetalhamentoArtigo");
		
		//		 FIM MAPEAMENTO DETALHAMENTO-DO-ARTIGO
		
		//		 INICIO MAPEAMENTO AUTORES
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES", Autores.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES", "NOME-COMPLETO-DO-AUTOR", "nomeCompletoAutor");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES", "NOME-PARA-CITACAO", "nomeCitacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES", "ORDEM-DE-AUTORIA", "ordemAutoria");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES", "CPF", "cpf");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/AUTORES", "addAutor");
		
		//		 FIM MAPEAMENTO AUTORES
		
		//		 INICIO MAPEAMENTO INFORMACOES-ADICIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/INFORMACOES-ADICIONAIS", InformacoesAdicionais.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/INFORMACOES-ADICIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/INFORMACOES-ADICIONAIS", "DESCRICAO-INFORMACOES-ADICIONAIS", "descricaoInformacoesAdicionais");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-PUBLICADOS/ARTIGO-PUBLICADO/INFORMACOES-ADICIONAIS", "setInformacoesAdicionais");
		
		//		 FIM MAPEAMENTO INFORMACOES-ADICIONAIS
		
		//		 INICIO MAPEAMENTO ARTIGO-ACEITO-PARA-PUBLICACAO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO", ArtigoAceitoPublicacao.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO", "SEQUENCIA-PRODUCAO", "sequenciaProducao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO", "addArtigoAceitoPublicacao");
		
		//		 FIM MAPEAMENTO ARTIGO-ACEITO-PARA-PUBLICACAO
		
		//		 INICIO MAPEAMENTO DADOS-BASICOS-DO-ARTIGO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", DadosBasicosArtigo.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "NATUREZA", "natureza");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "TITULO-DO-ARTIGO", "tituloArtigo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "ANO-DO-ARTIGO", "anoArtigo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "PAIS-DE-PUBLICACAO", "paisPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "MEIO-DE-DIVULGACAO", "meioDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "HOME-PAGE-DO-TRABALHO", "homePageTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "FLAG-RELEVANCIA", "flagRelevancia");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "DOI", "doi");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DADOS-BASICOS-DO-ARTIGO", "setDadosBasicosArtigo");
		
		//		 FIM MAPEAMENTO DADOS-BASICOS-DO-ARTIGO
		
		//		 INICIO MAPEAMENTO DETALHAMENTO-DO-ARTIGO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", DetalhamentoArtigo.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "TITULO-DO-PERIODICO-OU-REVISTA", "tituloPeriodicoRevista");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "ISSN", "issn");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "VOLUME", "volume");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "FASCICULO", "fasciculo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "SERIE", "serie");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "PAGINA-FINAL", "paginaFinal");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "LOCAL-DE-PUBLICACAO", "localPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/DETALHAMENTO-DO-ARTIGO", "setDetalhamentoArtigo");
		
		//		 FIM MAPEAMENTO DETALHAMENTO-DO-ARTIGO
		
		//		 INICIO MAPEAMENTO AUTORES
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES", Autores.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES", "NOME-COMPLETO-DO-AUTOR", "nomeCompletoAutor");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES", "NOME-PARA-CITACAO", "nomeCitacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES", "ORDEM-DE-AUTORIA", "ordemAutoria");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES", "CPF", "cpf");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/AUTORES", "addAutor");
		
		//		 FIM MAPEAMENTO AUTORES
		
		//		 INICIO MAPEAMENTO INFORMACOES-ADICIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/INFORMACOES-ADICIONAIS", InformacoesAdicionais.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/INFORMACOES-ADICIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/INFORMACOES-ADICIONAIS", "DESCRICAO-INFORMACOES-ADICIONAIS", "descricaoInformacoesAdicionais");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/ARTIGOS-ACEITOS-PARA-PUBLICACAO/ARTIGO-ACEITO-PARA-PUBLICACAO/INFORMACOES-ADICIONAIS", "setInformacoesAdicionais");
		
		//		 FIM MAPEAMENTO INFORMACOES-ADICIONAIS			
		
		//		 INICIO MAPEAMENTO LIVROS-E-CAPITULOS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS", LivrosCapitulos.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS", "setLivrosCapitulos");
		
		//		 FIM MAPEAMENTO LIVROS-E-CAPITULOS
		
		//		 INICIO MAPEAMENTO LIVROS-PUBLICADOS-OU-ORGANIZADOS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS", LivrosPublicadosOrganizados.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS");		
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS", "addLivroPublicado");
		
		//		 FIM MAPEAMENTO LIVROS-PUBLICADOS-OU-ORGANIZADOS
		
		//		 INICIO MAPEAMENTO LIVRO-PUBLICADO-OU-ORGANIZADO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO", LivroPublicadoOrganizado.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO", "SEQUENCIA-PRODUCAO", "sequenciaProducao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO", "addLivroPublicado");
		
		//		 FIM MAPEAMENTO LIVRO-PUBLICADO-OU-ORGANIZADO
		
		//		 INICIO MAPEAMENTO DADOS-BASICOS-DO-LIVRO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", DadosBasicosLivro.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "TIPO", "tipo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "NATUREZA", "natureza");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "TITULO-DO-LIVRO", "tituloLivro");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "ANO", "ano");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "PAIS-DE-PUBLICACAO", "paisPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "MEIO-DE-DIVULGACAO", "meioDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "HOME-PAGE-DO-TRABALHO", "homePageTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "FLAG-RELEVANCIA", "flagRelevancia");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "DOI", "doi");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DADOS-BASICOS-DO-LIVRO", "setDadosLivro");
		
		//		 FIM MAPEAMENTO DADOS-BASICOS-DO-LIVRO
		
		//		 INICIO MAPEAMENTO DETALHAMENTO-DO-LIVRO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", DetalhamentoLivro.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "NUMERO-DE-VOLUMES", "numeroVolumes");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "NUMERO-DE-PAGINAS", "numeroPaginas");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "ISBN", "isbn");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "NUMERO-DA-EDICAO-REVISAO", "numeroEdicaoRevisao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "NUMERO-DA-SERIE", "numeroSerie");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "CIDADE-DA-EDITORA", "cidadeEditora");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "NOME-DA-EDITORA", "nomeEditora");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/DETALHAMENTO-DO-LIVRO", "setDetalhamentoLivro");
		
		//		 FIM MAPEAMENTO DETALHAMENTO-DO-LIVRO
		
		//		 INICIO MAPEAMENTO AUTORES
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES", Autores.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES", "NOME-COMPLETO-DO-AUTOR", "nomeCompletoAutor");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES", "NOME-PARA-CITACAO", "nomeCitacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES", "ORDEM-DE-AUTORIA", "ordemAutoria");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES", "CPF", "cpf");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/AUTORES", "addAutor");
		
		//		 FIM MAPEAMENTO AUTORES
		
		//		 INICIO MAPEAMENTO INFORMACOES-ADICIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/INFORMACOES-ADICIONAIS", InformacoesAdicionais.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/INFORMACOES-ADICIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/INFORMACOES-ADICIONAIS", "DESCRICAO-INFORMACOES-ADICIONAIS", "descricaoInformacoesAdicionais");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/LIVROS-PUBLICADOS-OU-ORGANIZADOS/LIVRO-PUBLICADO-OU-ORGANIZADO/INFORMACOES-ADICIONAIS", "setInformacoesAdicionais");
		
		//		 FIM MAPEAMENTO INFORMACOES-ADICIONAIS
		
		//		 INICIO MAPEAMENTO CAPITULOS-DE-LIVROS-PUBLICADOS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS", CapitulosLivrosPublicados.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS");		
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS", "addCapituloPublicado");
		
		//		 FIM MAPEAMENTO CAPITULOS-DE-LIVROS-PUBLICADOS
		
		//		 INICIO MAPEAMENTO CAPITULO-DE-LIVRO-PUBLICADO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO", CapituloLivroPublicado.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO", "SEQUENCIA-PRODUCAO", "sequenciaProducao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO", "setCapituloLivroPublicado");
		
		//		 FIM MAPEAMENTO CAPITULO-DE-LIVRO-PUBLICADO
		
		//		 INICIO MAPEAMENTO DADOS-BASICOS-DO-CAPITULO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", DadosBasicosCapitulo.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "TIPO", "tipo");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "TITULO-DO-CAPITULO-DO-LIVRO", "tituloCapituloLivro");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "ANO", "ano");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "PAIS-DE-PUBLICACAO", "paisPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "MEIO-DE-DIVULGACAO", "meioDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "HOME-PAGE-DO-TRABALHO", "homePageTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "FLAG-RELEVANCIA", "flagRelevancia");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "DOI", "doi");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DADOS-BASICOS-DO-CAPITULO", "setDadosBasicosCapitulo");
		
		//		 FIM MAPEAMENTO DADOS-BASICOS-DO-CAPITULO
		
		//		 INICIO MAPEAMENTO DETALHAMENTO-DO-CAPITULO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", DetalhamentoCapitulo.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "TITULO-DO-LIVRO", "tituloLivro");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "NUMERO-DE-VOLUMES", "numeroVolumes");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "PAGINA-FINAL", "paginaFinal");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "ISBN", "isbn");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "ORGANIZADORES", "organizadores");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "NUMERO-DA-EDICAO-REVISAO", "numeroEdicaoRevisao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "NUMERO-DA-SERIE", "numeroSerie");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "CIDADE-DA-EDITORA", "cidadeEditora");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "NOME-DA-EDITORA", "nomeEditora");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/DETALHAMENTO-DO-CAPITULO", "setDetalhamentoCapitulo");
		
		//		 FIM MAPEAMENTO DETALHAMENTO-DO-CAPITULO
		
		//		 INICIO MAPEAMENTO AUTORES
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES", Autores.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES", "NOME-COMPLETO-DO-AUTOR", "nomeCompletoAutor");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES", "NOME-PARA-CITACAO", "nomeCitacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES", "ORDEM-DE-AUTORIA", "ordemAutoria");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES", "CPF", "cpf");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/AUTORES", "addAutor");
		
		//		 FIM MAPEAMENTO AUTORES
		
		//		 INICIO MAPEAMENTO INFORMACOES-ADICIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/INFORMACOES-ADICIONAIS", InformacoesAdicionais.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/INFORMACOES-ADICIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/INFORMACOES-ADICIONAIS", "DESCRICAO-INFORMACOES-ADICIONAIS", "descricaoInformacoesAdicionais");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/LIVROS-E-CAPITULOS/CAPITULOS-DE-LIVROS-PUBLICADOS/CAPITULO-DE-LIVRO-PUBLICADO/INFORMACOES-ADICIONAIS", "setInformacoesAdicionais");
		
		//		 FIM MAPEAMENTO INFORMACOES-ADICIONAIS
		
		//		 INICIO MAPEAMENTO TEXTO-EM-JORNAL-OU-REVISTA
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA", TextoJornaisRevistas.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA", "SEQUENCIA-PRODUCAO", "sequenciaProducao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA", "addTextoJornalRevista");
		
		//		 FIM MAPEAMENTO TEXTO-EM-JORNAL-OU-REVISTA
		
		//		 INICIO MAPEAMENTO DADOS-BASICOS-DO-TEXTO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", DadosBasicosTexto.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "NATUREZA", "natureza");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "TITULO-DO-TEXTO", "tituloTexto");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "ANO-DO-TEXTO", "anoTexto");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "PAIS-DE-PUBLICACAO", "paisPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "IDIOMA", "idioma");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "MEIO-DE-DIVULGACAO", "meioDivulgacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "HOME-PAGE-DO-TRABALHO", "homePageTrabalho");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "FLAG-RELEVANCIA", "flagRelevancia");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "DOI", "doi");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/DADOS-BASICOS-DO-TEXTO", "setDadosBasicosTexto");
		
		//		 FIM MAPEAMENTO DADOS-BASICOS-DO-TEXTO
		
		//		 INICIO MAPEAMENTO DETALHAMENTO-DO-TEXTO
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", DetalhamentoTexto.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "TITULO-DO-JORNAL-OU-REVISTA", "tituloJornalRevista");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "ISSN", "issn");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "FORMATO-DATA-DE-PUBLICACAO", "formatoDataPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "DATA-DE-PUBLICACAO", "dataPublicacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "VOLUME", "volume");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "PAGINA-INICIAL", "paginaInicial");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "PAGINA-FINAL", "paginaFinal");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "LOCAL-DE-PUBLICACAO", "localPublicacao");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTO-EM-JORNAL-OU-REVISTA/DETALHAMENTO-DO-TEXTO", "setDetalhamentoTexto");
		
		//		 FIM MAPEAMENTO DETALHAMENTO-DO-TEXTO
		
		//		 INICIO MAPEAMENTO AUTORES
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES", Autores.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES", "NOME-COMPLETO-DO-AUTOR", "nomeCompletoAutor");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES", "NOME-PARA-CITACAO", "nomeCitacao");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES", "ORDEM-DE-AUTORIA", "ordemAutoria");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES", "CPF", "cpf");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/AUTORES", "addAutor");
		
		//		 FIM MAPEAMENTO AUTORES
		
		//		 INICIO MAPEAMENTO INFORMACOES-ADICIONAIS
		
		digester.addObjectCreate("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/INFORMACOES-ADICIONAIS", InformacoesAdicionais.class);
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/INFORMACOES-ADICIONAIS");
		digester.addSetProperties("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/INFORMACOES-ADICIONAIS", "DESCRICAO-INFORMACOES-ADICIONAIS", "descricaoInformacoesAdicionais");
		digester.addSetNext("CURRICULO-VITAE/PRODUCAO-BIBLIOGRAFICA/TEXTOS-EM-JORNAIS-OU-REVISTAS/TEXTO-EM-JORNAL-OU-REVISTA/INFORMACOES-ADICIONAIS", "setInformacoesAdicionais");
		
		//		 FIM MAPEAMENTO INFORMACOES-ADICIONAIS
		
	}
	

}
