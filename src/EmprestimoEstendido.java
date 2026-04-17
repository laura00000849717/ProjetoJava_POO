import java.time.LocalDate;

public class EmprestimoEstendido extends Emprestimo {
    @Override
    public LocalDate getPrazoDevolucao() {
        return dataEmprestimo.plusDays(14);
    }

    @Override
    public boolean isAtrasado() {
        return LocalDate.now().isAfter(getPrazoDevolucao());
    }
}