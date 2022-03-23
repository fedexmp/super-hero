package com.superhero.controller;

import com.superhero.exceptions.UserException;
import com.superhero.model.Usuario;
import com.superhero.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.superhero.config.security.Constants.USUARIO_REPETIDO;

@RestController
@RequestMapping("/api/users")
public class UsuarioController {

	private UsuarioRepository usuarioRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("")
	public void saveUsuario(@RequestBody Usuario user) {
		try{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
	} catch (RuntimeException e) {
		 throw new UserException(USUARIO_REPETIDO,"/api/users/");
	}
	}

	@GetMapping("")
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{username}")
	public Usuario getUsuario(@PathVariable String username) {
		return usuarioRepository.findByUsername(username);
	}
}
