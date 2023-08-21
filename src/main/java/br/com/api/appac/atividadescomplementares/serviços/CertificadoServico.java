package br.com.api.appac.atividadescomplementares.serviços;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.certificados.Certificados;
import br.com.api.appac.atividadescomplementares.certificados.RespostaCertificados;
import br.com.api.appac.atividadescomplementares.repositorio.AlunoRepositorio;
import br.com.api.appac.atividadescomplementares.repositorio.CertificadoRepositorio;

@Service
public class CertificadoServico {

    @Autowired
    private AlunoServico as;

    @Autowired
    private AlunoRepositorio ar;

    @Autowired
    private CertificadoRepositorio cp;

    @Autowired
    private RespostaCertificados rc;

    @Value("${certificados.upload-dir}") // Configuração do diretório de upload no application.properties
    private String uploadDir;

    /**
     * Lista todos os certificados associados a um aluno.
     * 
     * @param alunoCpf CPF do aluno.
     * @return Iterable de Certificados.
     */
    @GetMapping("/listar")
    public Iterable<Certificados> listar(@RequestParam String alunoCpf) {
        if (alunoCpf.isEmpty()) {
            throw new IllegalArgumentException("O parâmetro alunoRga é obrigatório");
        } else {
            return cp.findByAlunoCpf(alunoCpf);
        }
    }

    /**
     * Cadastra ou altera um certificado associado a um aluno.
     * 
     * @param cr       Certificado a ser cadastrado ou alterado.
     * @param acao     Ação a ser realizada (cadastrar ou alterar).
     * @param alunoCpf CPF do aluno associado.
     * @return ResponseEntity com o resultado da operação.
     */
    public ResponseEntity<?> cadastrarAlterar(Certificados cr, String acao, String alunoCpf) {
        // Validações de campos obrigatórios
        if (cr.getCodigo() == null || cr.getCodigo().isEmpty()) {
            rc.setMensagem("O código do certificado é obrigatório");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        } else if (cr.getAtividade() == null || cr.getAtividade().isEmpty()) {
            rc.setMensagem("A atividade é obrigatória");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        } else if (cr.getPontuacao() == null) {
            rc.setMensagem("A pontuação é obrigatória");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        } else if (alunoCpf == null || alunoCpf.isEmpty()) {
            rc.setMensagem("O CPF do aluno é necessário");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        }
        // Buscar o aluno por CPF
        Aluno aluno = as.buscarAlunoPorId(alunoCpf);
        if (aluno == null) {
            rc.setMensagem("Aluno não encontrado");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        }

        // Vincular o aluno ao certificado
        cr.setAluno(aluno);

        // Restante do código para cadastrar ou alterar o certificado
        if (acao.equals("cadastrar")) {
            return new ResponseEntity<Certificados>(cp.save(cr), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Certificados>(cp.save(cr), HttpStatus.OK);
        }
    }

    /**
     * Realiza o upload de um arquivo PDF associado a um certificado.
     * 
     * @param certificadoId ID do certificado.
     * @param arquivoPdf    Arquivo PDF a ser carregado.
     * @return ResponseEntity com o resultado da operação.
     */
    public ResponseEntity<?> uploadPdf(long certificadoId, MultipartFile arquivoPdf) {
        Optional<Certificados> certificado = cp.findById(certificadoId);
        if (!certificado.isPresent()) {
            rc.setMensagem("Certificado não encontrado");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.NOT_FOUND);
        }

        // Obter o aluno associado ao certificado
        Aluno aluno = certificado.get().getAluno();
        Certificados certificados = certificado.get();

        // Construir o caminho da pasta para o aluno
        String pastaAluno = aluno.getNome();
        String caminhoPasta = Paths.get(uploadDir, pastaAluno).toString();
        File pasta = new File(caminhoPasta);
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        // Construir o nome do arquivo: nomeDoAluno_idDoCertificado.pdf
        String nomeArquivo = aluno.getNome() + "_" + certificados.getCodigo() + ".pdf";
        String caminhoArquivo = Paths.get(caminhoPasta, nomeArquivo).toString();

        try {
            // Salvar o arquivo no caminho especificado
            Files.copy(arquivoPdf.getInputStream(), Paths.get(caminhoArquivo),
                    StandardCopyOption.REPLACE_EXISTING);

            // Atualizar o caminho do arquivo no certificado
            certificado.get().setCaminhoArquivo(caminhoArquivo);
            cp.save(certificado.get());

            rc.setMensagem("Arquivo PDF associado ao certificado com sucesso!");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.OK);
        } catch (IOException e) {
            // Tratar exceção caso ocorra algum erro durante o salvamento do arquivo
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Remove um certificado associado a um aluno.
     * 
     * @param alunoCpf      CPF do aluno.
     * @param certificadoId ID do certificado.
     * @return ResponseEntity com o resultado da operação.
     */
    public ResponseEntity<RespostaCertificados> remover(String alunoCpf, long certificadoId) {
        Aluno aluno = as.buscarAlunoPorId(alunoCpf);
        if (aluno == null) {
            rc.setMensagem("Aluno não encontrado");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        }

        Optional<Certificados> certificado = cp.findById(certificadoId);
        if (!certificado.isPresent()) {
            rc.setMensagem("Certificado não encontrado");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.NOT_FOUND);
        }

        if (!certificado.get().getAluno().equals(aluno)) {
            rc.setMensagem("O certificado não pertence ao aluno informado");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        }

        if (!certificado.get().getStatusCorrecao().equals(false)) {
            rc.setMensagem("Não é possível apagar um certificado já corrigido!");
            return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.BAD_REQUEST);
        }

        cp.deleteById(certificadoId);

        // Remover o arquivo PDF associado ao certificado
        if (certificado.get().getCaminhoArquivo() != null) {
            File arquivo = new File(certificado.get().getCaminhoArquivo());
            arquivo.delete();
        }

        rc.setMensagem("Certificado removido!");
        return new ResponseEntity<RespostaCertificados>(rc, HttpStatus.OK);
    }
}
