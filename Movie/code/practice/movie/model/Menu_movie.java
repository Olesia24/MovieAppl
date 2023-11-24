package practice.movie.model;


public enum Menu_movie {
    ALL(1, "- View of Movies"), NAME(2, "- Find Movie by Name"), GENR(3, "- Find Movie by Genre"), DIR(4, "- Find Movie by Director"), DATE(5, "- Find a movie by date"), XIT(6, "- Exit")
    ;

    private int choice;
    private String name;

    Menu_movie(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public int getChoice() {
        return choice;
    }
    public String getName() {
        return name;
    }
    public static void printMenu(){
        Menu_movie[] menus = Menu_movie.values();
        for (int i = 0; i < menus.length ; i++) {
            System.out.println(menus[i].getChoice() + " " + menus[i].getName());
        }
    }
    public static void collections(){

    }
    public static void exit(){
        System.out.println("--Good Bay--");
        System.exit(0);
    }
}

