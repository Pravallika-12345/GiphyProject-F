package com.itc.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.Favorites;
import com.itc.main.repository.FavoritesRepository;


@Service
public class FavoritesService {
	
	@Autowired
	private FavoritesRepository favoritesrepository;
	
	public Favorites save(Favorites favorites) {
		return this.favoritesrepository.save(favorites);
	}
	
	public List<Favorites> getAllFavorites(){
		return this.favoritesrepository.findAll();
	}
	
	public Favorites getFavouritesById(int Id) {
		Optional<Favorites> op=this.favoritesrepository.findById(Id);
			if(op.isPresent()) {
				return op.get();
			}else 
				return null;
	}
	
	public boolean deleteFavouritesById(int Id) {
		this.favoritesrepository.deleteById(Id);
		return true;
	}
	public Favorites findFavByEmail(String email) {
		Favorites f=this.favoritesrepository.findByEmail(email);
		if(f!=null) {
			return f;
		}else
			return null;
	}
//
//	public boolean deleteFavByEmail(String email) {
//		this.favoritesrepository.deleteFavByEmail(email);
//		return true;
//	}
}
