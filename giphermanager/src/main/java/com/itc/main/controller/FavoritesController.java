package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.entity.Favorites;
import com.itc.main.service.FavoritesService;

@RestController
@RequestMapping("/api/")
public class FavoritesController {

	@Autowired
	private FavoritesService favoritesservice;
	
	@PostMapping("save")
	public ResponseEntity<Favorites> save(@RequestBody Favorites favorites){
		Favorites fav=this.favoritesservice.save(favorites);
		return new ResponseEntity<Favorites>(fav, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Favorites>> getAllFavourites(){
		List<Favorites> list=this.favoritesservice.getAllFavorites();
		return new ResponseEntity<List<Favorites>>(list, HttpStatus.OK);
	}
	
	@GetMapping("{favId}")
	public ResponseEntity<Favorites> getFavouritesById(@PathVariable("favId") int favId){
		Favorites f=this.favoritesservice.getFavouritesById(favId);
			   return new ResponseEntity<Favorites>(f, HttpStatus.OK);
	}
	
	@GetMapping("fav/{email}")
	public ResponseEntity<?> getFavByEmail(@PathVariable String email){
		Favorites f=this.favoritesservice.findFavByEmail(email);
		if(f!=null) {
			return new ResponseEntity<Favorites>(f,HttpStatus.OK);
		}else
			return new ResponseEntity<String>("NOT_FOUND",HttpStatus.OK);
	}
	
	@DeleteMapping("fav/{favId}")
	public ResponseEntity<String> deleteFavouritesById(@PathVariable int favId) {
		boolean b = this.favoritesservice.deleteFavouritesById(favId);
				if(b)
					return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
				else
					return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
	}
//	@DeleteMapping("{}email")
//	public ResponseEntity<?> deleteFavByEmail(@PathVariable String email){
//		boolean f= this.favoritesservice.deleteFavByEmail(email);
//		if(f==true) {
//			return new ResponseEntity<String>("SUCCESSFULLY-DELETED", HttpStatus.OK);
//		}else
//			return new ResponseEntity<String>("NOT_FOUND", HttpStatus.NOT_FOUND);
//	}
	
}
