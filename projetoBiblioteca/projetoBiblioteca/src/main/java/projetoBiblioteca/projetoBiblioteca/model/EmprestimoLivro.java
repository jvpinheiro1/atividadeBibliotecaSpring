package projetoBiblioteca.projetoBiblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class EmprestimoLivro {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JsonIgnore
        private Emprestimo emprestimo;

        @ManyToOne
        @JoinColumn(name = "livro_id")
        private Livro livro;

        public EmprestimoLivro() {

        }

        public Emprestimo getEmprestimo() {
                return emprestimo;
        }

        public void setEmprestimo(Emprestimo emprestimo) {
                this.emprestimo = emprestimo;
        }

        public Livro getLivro() {
                return livro;
        }

        public void setLivro(Livro livro) {
                this.livro = livro;
        }
}
