package application;

import attore.Attore;
import attore.AttoreCrud;
import attore.AttoreCrudImpl;
import entytyManager.EntityManagerUtil;
import film.Film;
import film.FilmCrud;
import film.FilmCrudImpl;
import recita.Recita;

public class FilmJpaApplication {

	public static void main(String[] args) {
		try {//prova crud attore, recita e film
			AttoreCrud attoreCrud = new AttoreCrudImpl();

			attoreCrud.saveAttore(new Attore());
			Attore att = attoreCrud.findById(1);
			att.setNome("Carlo Verdone");
			att.setAnno_nascita(1950);
			att.setSalario(10000);
			attoreCrud.updateAttore(att);
			System.out.println(attoreCrud.findAllAttori());

			FilmCrud filmCrud = new FilmCrudImpl();

			String c = "Bianco Rosso e Verdone";

			Film film = new Film();
			film.setNome(c);
			film.setAnno(1980);
			film.setIncasso(1000000);
			film.setCosto(100000);
			//System.out.println(filmCrud.findAllFilm());

			Recita recita = new Recita();
			recita.setAttore(att);
			recita.setFilm(film);
			
			film.addRecita(recita);
			att.addRecita(recita);
			filmCrud.saveFilm(film);
			attoreCrud.saveAttore(att);
			System.out.println(film);
			System.out.println(recita);
			System.out.println(att);
			
			//prova find minorenni
			
			Attore minorenne1 = new Attore();
			minorenne1.setAnno_nascita(2001);
			minorenne1.setNome("Pippo");
			attoreCrud.saveAttore(minorenne1);
			Attore minorenne2 = new Attore();
			minorenne2.setAnno_nascita(2002);
			minorenne2.setNome("Topolino");
			attoreCrud.saveAttore(minorenne2);
		
			System.out.println(attoreCrud.findMinorenni());
			
			//prova find film di animazione
			
			Film lionking = new Film();
			lionking.setNome("Lion King");
			lionking.setAnno(1994);
			filmCrud.saveFilm(lionking);
			Film kungfupanda = new Film();
			kungfupanda.setNome("kung fu panda");
			kungfupanda.setAnno(2008);
			filmCrud.saveFilm(kungfupanda);
			
			System.out.println(filmCrud.findAnimazione());
			
			//prova find film con più di 5 attori
			
			Attore att2 = new Attore();
			att2.setNome("Sora Lella");
			Attore att3 = new Attore();
			att3.setNome("Mario Brega");
			
			Recita rec2 = new Recita();
			rec2.setAttore(att2);
			rec2.setFilm(film);
			
			Recita rec3 = new Recita();
			rec3.setAttore(att3);
			rec3.setFilm(film);
			
			film.addRecita(rec3);
			att3.addRecita(rec3);
			
			film.addRecita(rec2);
			att2.addRecita(rec2);
			
			attoreCrud.saveAttore(att3);
			
			attoreCrud.saveAttore(att2);
			filmCrud.updateFilm(film);
			
			System.out.println(filmCrud.find);
			
		} finally {
			EntityManagerUtil.close();
			System.out.println("done");
		}
	}
}
