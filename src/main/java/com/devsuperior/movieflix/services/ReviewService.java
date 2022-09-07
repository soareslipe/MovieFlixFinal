package com.devsuperior.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.entities.dto.ReviewDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private AuthService authService;

	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		User user = authService.authenticated(); 
		
		try{
		Review entity = new Review();
		entity.setMovie(movieRepository.getOne(dto.getMovieId()));
		entity.setText(dto.getText());
		entity.setUser(user);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
		}
		catch (Exception e){
			 throw new ResourceNotFoundException("Movie Not Found" + dto.getMovieId());
		}
	}

	public List<ReviewDTO> findByMovie(Long movieId) {
		
		return null;
	}

}
