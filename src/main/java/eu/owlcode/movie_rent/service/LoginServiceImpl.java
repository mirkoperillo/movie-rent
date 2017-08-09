package eu.owlcode.movie_rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.owlcode.movie_rent.persist.UserRepo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean login(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password) != null;
	}

}
