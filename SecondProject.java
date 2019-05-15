
// Gabriel Kist & Laura Henn 
import java.util.ArrayList;
import java.util.Arrays;

public class SecondProject {
    public static void main(String[] args) {

        SimpleReader f = new SimpleReader("./game-reviews.csv");

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

        System.out.println(games.get(1).getTitle());
        System.out.println(games.size());

    }
}