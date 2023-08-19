package br.com.api.appac.atividadescomplementares.controle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.certificados.Certificados;
import br.com.api.appac.atividadescomplementares.certificados.CorrecaoCertificadoRequest;
import br.com.api.appac.atividadescomplementares.coordenador.Coordenador;
import br.com.api.appac.atividadescomplementares.serviços.CoordenadorServico;
import br.com.api.appac.atividadescomplementares.serviços.CorrecaoCertificadosService;

@RestController
@CrossOrigin(origins = "*")

public class CoordenadorControle {
    @Autowired
    CoordenadorServico cos;

    @Autowired
    private CorrecaoCertificadosService correcaoCertificadosService;

    @GetMapping("/coordenador/{cpf}")
    public Coordenador listar(@PathVariable String cpf) {
        return cos.listarcoord(cpf);
    }

    @GetMapping("/coordenador/{cpf}/alunos/{cursoCodigo}")
    public ResponseEntity<List<Aluno>> listarAlunosDoCurso(@PathVariable String cpf, @PathVariable Long cursoCodigo) {
        List<Aluno> alunos = cos.listarAlunosDoCurso(cursoCodigo);
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/coordenador/{cpf}/aluno/{alunoCpf}/certificados")
    public ResponseEntity<List<Certificados>> listarCertificadosDoAluno(@PathVariable String cpf, @PathVariable String alunoCpf) {
        List<Certificados> certificados = cos.listarCertificadosDoAluno(alunoCpf);
        return ResponseEntity.ok(certificados);
    }

    @PostMapping("/corrigir")
    public ResponseEntity<String> corrigirCertificado(@RequestBody CorrecaoCertificadoRequest request) {
    correcaoCertificadosService.corrigirCertificado(request);
    return ResponseEntity.status(HttpStatus.OK).build();
}
}
