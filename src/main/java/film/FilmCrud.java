package film;

import java.util.List;


public interface FilmCrud {
	

		List<Film> findAllFilm();
		
		List<Film> findAnimazione();
		
		List<Film> find3();
		
		Film saveFilm(Film movie);
		
		Film updateFilm(Film movie);
		
		Film findById(int id);
}
