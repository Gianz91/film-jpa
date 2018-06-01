package attore;

import java.util.List;

public interface AttoreCrud {

	List<Attore> findAllAttori();
	
	List<Attore> findMinorenni();
	
	Attore saveAttore(Attore actor);
	
	Attore updateAttore(Attore actor);
	
	Attore findById(int id);
}
