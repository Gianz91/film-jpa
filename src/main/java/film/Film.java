package film;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import recita.Recita;

@NamedQueries({ @NamedQuery(name = Film.FIND_ALL, query = "SELECT f FROM Film f order by f.nome "),
	@NamedQuery(name=Film.ANIMAZIONE, query ="SELECT f from Film f where f.id not in (select r.film from Recita r)"),
	@NamedQuery(name= Film.FIVEGUYS, query ="select f from Film where 5 < (SELECT count(attore) from Recita)")})
@Entity
public class Film {

	public static final String FIND_ALL = "film.Film.find_all";
	
	public static final String ANIMAZIONE = "film.Film.animazione";
	
	public static final String FIVEGUYS = "film.Film.fiveguys";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nome;
	@Column
	private Integer anno;
	@Column
	private Integer costo;
	@Column
	private Integer incasso;

	@OneToMany(mappedBy = "film", cascade= CascadeType.ALL)
	private Set<Recita> recitato;

	public Film() {
		super();
		this.recitato = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Integer getIncasso() {
		return incasso;
	}

	public void setIncasso(Integer incasso) {
		this.incasso = incasso;
	}
	

	public Set<Recita> getRecitato() {
		return recitato;
	}

	public void setRecitato(Set<Recita> recitato) {
		this.recitato = recitato;
	}
	public void addRecita(Recita recita) {
		this.recitato.add(recita);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", nome=" + nome + ", anno=" + anno + ", costo=" + costo + ", incasso=" + incasso
				+ ", recitato=" + recitato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((costo == null) ? 0 : costo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((incasso == null) ? 0 : incasso.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (costo == null) {
			if (other.costo != null)
				return false;
		} else if (!costo.equals(other.costo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (incasso == null) {
			if (other.incasso != null)
				return false;
		} else if (!incasso.equals(other.incasso))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
