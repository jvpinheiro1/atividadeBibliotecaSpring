package projetoBiblioteca.projetoBiblioteca.dto;

import projetoBiblioteca.projetoBiblioteca.model.Emprestimo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoDTO {

    private Long idEmprestimo;
    private LocalDate dataInicial;
    private LocalDate dataDevolucao;
    private Long clienteId;

    private List<Long> isbns; // Alterado para lista de ISBNs

    public static EmprestimoDTO fromEntity(Emprestimo emprestimo) {
        EmprestimoDTO dto = new EmprestimoDTO();
        dto.setIdEmprestimo(emprestimo.getIdEmprestimo());
        dto.setDataInicial(emprestimo.getDataInicial());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());

        if(emprestimo.getCliente() != null) {
            dto.setClienteId(emprestimo.getCliente().getId());
        }

        if(emprestimo.getLivros() != null) {
            dto.setIsbns(emprestimo.getLivros().stream()
                    .map(empLivro -> empLivro.getLivro().getIsbn())
                    .collect(Collectors.toList()));
        }

        return dto;
    }



    public LocalDate getDataInicial() {
        return dataInicial;
    }


    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setIsbns(List<Long> isbns) {
        this.isbns = isbns;
    }

    public List<Long> getIsbns() {
        return isbns;
    }


    public Long getClienteId() {
        return clienteId;
    }
    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }


}
