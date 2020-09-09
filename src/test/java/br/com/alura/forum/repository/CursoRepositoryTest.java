package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.model.Curso;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CursoRepositoryTest {

	@Autowired
	private CursoRepository repository;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		
		String nomeCurso = "HTML 5";
		Curso curso = repository.findByNome(nomeCurso);
		
		Assert.assertNotNull(curso);
		Assert.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		
		String nomeCurso = "JPA";
		Curso curso = repository.findByNome(nomeCurso);

		Assert.assertNull(curso);
	}

}
