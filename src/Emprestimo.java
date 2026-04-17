import java.time.LocalDate;

public abstract class Emprestimo {
    protected Book book;
    protected LocalDate dataEmprestimo;
    
    public abstract LocalDate getPrazoDevolucao();
    public abstract boolean isAtrasado();
}