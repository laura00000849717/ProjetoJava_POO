import java.time.LocalDate;

public class EmprestimoPadrao extends Emprestimo {
    @Override
    public LocalDate getPrazoDevolucao() {
        return dataEmprestimo.plusDays(7);
    }

    @Override
    public boolean isAtrasado() {
        return LocalDate.now().isAfter(getPrazoDevolucao());
    }
}