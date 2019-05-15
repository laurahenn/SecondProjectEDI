
public class Game {

    private String title;
    private String platform;
    private String score_phrase;
    private Double score;
    private String genre;
    private String editors_choice;
    private Integer release_year;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the score_phrase
     */
    public String getScore_phrase() {
        return score_phrase;
    }

    /**
     * @param score_phrase the score_phrase to set
     */
    public void setScore_phrase(String score_phrase) {
        this.score_phrase = score_phrase;
    }

    /**
     * @return the score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the editors_choice
     */
    public String getEditors_choice() {
        return editors_choice;
    }

    /**
     * @param editors_choice the editors_choice to set
     */
    public void setEditors_choice(String editors_choice) {
        this.editors_choice = editors_choice;
    }

    /**
     * @return the release_year
     */
    public Integer getRelease_year() {
        return release_year;
    }

    /**
     * @param release_year the release_year to set
     */
    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getLine() {
        return this.title + " " + this.platform + " " + this.score_phrase + " " + this.score + " " + this.genre + " "
                + editors_choice + " " + release_year;
    }
}
