import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cinema {
    private List<Filme> filmesDisponiveis;
    private Set<String> assentosDisponiveis;
    private List<Ingresso> ingressosVendidos;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        ingressosVendidos = new ArrayList<>();
        assentosDisponiveis = new HashSet<>();

        // Inicializar filmes disponíveis
        filmesDisponiveis.add(new Filme("Homem-Aranha", 20.0, 12));
        filmesDisponiveis.add(new Filme("Avatar", 25.0, 10));
        filmesDisponiveis.add(new Filme("Os Vingadores", 22.0, 14));
        filmesDisponiveis.add(new Filme("Jurassic Park", 18.0, 12));
        filmesDisponiveis.add(new Filme("Star Wars", 21.0, 15));

        // Inicializar assentos disponíveis
        for (char row = 'A'; row <= 'F'; row++) {
            for (int col = 1; col <= 5; col++) {
                assentosDisponiveis.add("" + row + col);
            }
        }
    }

    public List<Filme> getFilmesDisponiveis() {
        return filmesDisponiveis;
    }

    public Set<String> getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void venderIngresso(Ingresso ingresso) throws Exception {
        if (!assentosDisponiveis.contains(ingresso.getAssento())) {
            throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
        }
        if (ingresso.getCliente().getIdade() < ingresso.getFilme().getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }
        // Se todas as verificações passarem
        assentosDisponiveis.remove(ingresso.getAssento());
        ingressosVendidos.add(ingresso);
    }
}