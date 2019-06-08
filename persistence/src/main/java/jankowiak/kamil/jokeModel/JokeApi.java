package jankowiak.kamil.jokeModel;

public class JokeApi {
    private String delivery;
    private String setup;
    private String category;

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getSetup() {
        return setup;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return
                "Joke in " + category +
                        " category => \n" +
                        setup +
                        "\n\n\n\n\n" + delivery;
    }
}
