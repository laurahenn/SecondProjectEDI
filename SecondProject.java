
// Gabriel Kist & Laura Henn 
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SecondProject {
    public static void main(String[] args) {

        SimpleReader f = new SimpleReader("./game-reviews.csv");
        Scanner teclado = new Scanner(System.in);
        int anoPesquisa = 0;

        System.out.print("Digite um ano para ser pesquisado: ");
        anoPesquisa = teclado.nextInt();

        String s = f.readLine(); // Atricuição do valor lido na variavel s.

        ArrayList<Game> games = new ArrayList<Game>();

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

        // System.out.println(games.get(1).getTitle());
        // System.out.println(games.size());

        int nGames = games.size();
        int nAno = 0;
        int nMediocreAno = 0;

        Double somaScore = 0.0;
        for (int i = 0; i < games.size(); i++) {

            somaScore = somaScore + games.get(i).getScore();

            if (games.get(i).getRelease_year() == anoPesquisa) { // conta numero de release no ano pesquisado
                nAno = nAno + 1;

                if (games.get(i).getScore_phrase().equals("Mediocre")) { // conta quantos 'Mediocre' no ano pesquisado
                    nMediocreAno = nMediocreAno + 1;
                }
            }
        }

        Double mediaScores = somaScore / nGames;

        Double percentMediocreAno = 0.0 + ((100 * nMediocreAno) / nAno);

        System.out.println("| Total de release = " + nGames);
        System.out.println("| Média aritmética dos scores = " + mediaScores);
        System.out.println("| Total de release no ano de " + anoPesquisa + " = " + nAno);
        System.out.println("| Total de 'Mediocre' no ano de " + anoPesquisa + " = " + nMediocreAno);
        System.out.println("| % de 'Mediocre' no ano de " + anoPesquisa + " = " + percentMediocreAno);

    }
}