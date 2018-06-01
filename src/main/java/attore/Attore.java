package attore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import recita.Recita;
@NamedQueries({
	@NamedQuery(name = Attore.FIND_ALL, query = "SELECT a FROM Attore a order by a.nome "),
	@NamedQuery(name= Attore.MILLENIALS, query = "SELECT a FROM Attore a where a.anno_nascita > 2000")
})
@Entity
public class Attore {

	public static final String FIND_ALL = "attore.Attore.find_all"; 
	public static final String MILLENIALS = "attore.Attore.millenials";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nome;

	@Column
	private Integer anno_nascita;

	@Column
	private Integer salario;
	
	@OneToMany(mappedBy="attore")
	private Set<Recita> recite;
	

	public Attore() {
		super();
		this.recite = new HashSet<>();
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

	public Integer getAnno_nascita() {
		return anno_nascita;
	}

	public void setAnno_nascita(Integer anno_nascita) {
		this.anno_nascita = anno_nascita;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	
	public Set<Recita> getRecite() {
		return recite;
	}

	public void setRecite(Set<Recita> recite) {
		this.recite = recite;
	}
	public void addRecita(Recita r) {
		this.recite.add(r);
	}

	@Override
	public String toString() {
		return "Attore [id=" + id + ", nome=" + nome + ", anno_nascita=" + anno_nascita + ", salario=" + salario + ", film in cui ha recitato:" +recite+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno_nascita == null) ? 0 : anno_nascita.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		Attore other = (Attore) obj;
		if (anno_nascita == null) {
			if (other.anno_nascita != null)
				return false;
		} else if (!anno_nascita.equals(other.anno_nascita))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	

}
