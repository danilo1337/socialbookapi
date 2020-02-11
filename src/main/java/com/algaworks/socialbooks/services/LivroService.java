package com.algaworks.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.ComentariosRespository;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exception.LivroNaoEncontradoException;

import net.bytebuddy.asm.Advice.Return;

@Service
public class LivroService {
	@Autowired
	private LivrosRepository livroRepository;

	@Autowired
	private ComentariosRespository comentariosRespository;
	
	public List<Livro> listar() {
		return livroRepository.findAll();
	}

	public Livro buscar(Long id) {
		Livro livro = livroRepository.findById(id).orElse(null);

		if (livro == null) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}

		return livro;
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);
	}

	public void deletar(Long id) {
		try {
			livroRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado.");
		}
	}

	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livroRepository.save(livro);
	} 

	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livro_id, Comentario comentario) {
		Livro livro = buscar(livro_id);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRespository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long id) {
		Livro livro = buscar(id);
		return livro.getComentarios();
	}
}
