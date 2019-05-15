
// Gabriel Kist & Laura Henn 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

public class SecondProject {
    public static void main(String[] args) {

        SimpleReader f = new SimpleReader("./game-reviews.csv");
        Scanner teclado = new Scanner(System.in);
        int anoPesquisa = 0;

        System.out.print("Digite um ano para ser pesquisado: ");
        anoPesquisa = teclado.nextInt();

        String s = f.readLine(); // Atricuição do valor lido na variavel s.

        ArrayList<Game> games = new ArrayList<Game>();
        ArrayList<Game> games2 = new ArrayList<Game>();

        while (s != null) { // Enquanto tiver linhas para serem lidas
            s = f.readLine(); // Lê a próxima linha

            if (s != null) {
                String gamereviews[] = s.split(";");

                Game game = new Game();
                game.setTitle(gamereviews[0]);
                game.setPlatform(gamereviews[1]);
                game.setScore_phrase(gamereviews[2]);
                game.setScore(Double.parseDouble(gamereviews[3])); // double
                game.setGenre(gamereviews[4]);
                game.setEditors_choice(gamereviews[5]);
                game.setRelease_year(Integer.parseInt(gamereviews[6])); // int
                games.add(game);
            }
        }
        f.close(); // Fecha a Leitura

        int nGames = games.size();
        int nAno = 0;
        int nMediocreAno = 0;

        Double maiorScore = 0.0;
        int iMaiorScore = 0;

        Double menorScore = 10.0;
        int iMenorScore = 10;

        Double somaScore = 0.0;
        Game g = new Game();
        for (int i = 0; i < games.size(); i++) {

            if (games.get(i).getRelease_year() == anoPesquisa) { // conta numero de release no ano pesquisado
                nAno = nAno + 1;

                if (games.get(i).getScore_phrase().equals("Mediocre")) { // conta quantos 'Mediocre' no ano pesquisado
                    nMediocreAno = nMediocreAno + 1;
                }
            }

            if (maiorScore < games.get(i).getScore()) {
                maiorScore = games.get(i).getScore();
                iMaiorScore = i;
            }

            if (menorScore > games.get(i).getScore()) {
                menorScore = games.get(i).getScore();
                iMenorScore = i;
            }
        }
        Double mediaScores = somaScore / nGames;

        Double auxDesvioPadrao = 0.0;

        // para desvio desvio padrão
        for (int i = 0; i < games.size(); i++) {
            auxDesvioPadrao = auxDesvioPadrao + Math.pow(i - mediaScores, 2);
        }
        Double desvioPadraoScores = Math.sqrt(auxDesvioPadrao / nGames);

        Double percentMediocreAno = 0.0 + ((100 * nMediocreAno) / nAno);

        System.out.println("| Total de release = " + nGames);
        System.out.println("| Média aritmética dos scores = " + mediaScores);
        System.out.println("| Desvio padrão populacional dos scores = " + desvioPadraoScores);
        System.out.println("| Melhor jogo [um dos maiores score] = " + games.get(iMaiorScore).getLine());
        System.out.println("| Maior score = " + maiorScore);
        System.out.println("| Pior jogo [um dos menores score] = " + games.get(iMenorScore).getLine());
        System.out.println("| Menor score = " + menorScore);
        System.out.println("| Total de release no ano de " + anoPesquisa + " = " + nAno);
        System.out.println("| Total de 'Mediocre' no ano de " + anoPesquisa + " = " + nMediocreAno);
        System.out.println("| % de 'Mediocre' no ano de " + anoPesquisa + " = " + percentMediocreAno);
        /*
         * System.out.
         * println("| Ano com a maior quantidade de jogos lançados genero Action " +
         * iMaiorAnoAction + " Quantidade " + iMaiorQuantidadeAction);
         */
    }
}