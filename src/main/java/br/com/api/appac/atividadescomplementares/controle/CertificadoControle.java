package br.com.api.appac.atividadescomplementares.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.appac.atividadescomplementares.certificados.Certificados;
import br.com.api.appac.atividadescomplementares.certificados.RespostaCertificados;
import br.com.api.appac.atividadescomplementares.serviços.AlunoServico;
import br.com.api.appac.atividadescomplementares.serviços.CertificadoServico;

@RestController
@CrossOrigin(origins = "*")
public class CertificadoControle {

    @Autowired
    private CertificadoServico cs;

    @Autowired
    private AlunoServico as;

    // Endpoint para remover um certificado
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaCertificados> remover(@PathVariable long id, @RequestParam String alunoCpf) {
        return cs.remover(alunoCpf, id);
    }

    // Endpoint para alterar um certificado
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Certificados cr, @RequestParam String alunoCpf) {
        return cs.cadastrarAlterar(cr, "alterar", alunoCpf);
    }

    // Endpoint para cadastrar um novo certificado
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Certificados cr, @RequestParam String alunoCpf) {
        return cs.cadastrarAlterar(cr, "cadastrar", alunoCpf);
    }

    // Endpoint para fazer o upload de um arquivo PDF associado a um certificado
    @PostMapping("/certificado/{id}/upload-pdf")
    public ResponseEntity<?> uploadPdf(@PathVariable long id, @RequestParam("arquivoPdf") MultipartFile arquivoPdf) {
        return cs.uploadPdf(id, arquivoPdf);
    }

    // Endpoint para listar todos os certificados de um aluno
    @GetMapping("/listar")
    public Iterable<Certificados> listar(@RequestParam String alunoCpf) {
        return cs.listar(alunoCpf);
    }

    // Endpoint de rota para verificar se a API está funcionando
    @GetMapping("/")
    public String rota() {
        return "API de certificados funcionando!";
    }
}
