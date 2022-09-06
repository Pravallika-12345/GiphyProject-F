package com.itc.main.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.itc.main.entity.Favorites;

public interface FavoritesRepository extends JpaRepository<Favorites, Integer>{
	
	Favorites findByEmail(String email);
//
//	@Transactional
//	@Modifying
//	@Query("DELETE FROM Favorites WHERE email=:email")
//	Integer deleteFavByEmail(String email);
	
}
