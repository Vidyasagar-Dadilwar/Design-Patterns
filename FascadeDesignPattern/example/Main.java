class UserAccount{
    boolean checkSubscription(String user){
        return true;
    }
}

class MovieSelection{
    String selectMovie(String movie){
        System.out.println("Selecting movie name: " + movie);
        return movie;
    }
}

class StreamingFacade{
    UserAccount userAccount;
    MovieSelection movieSelection;
    StreamingFacade(){
        this.userAccount = new UserAccount();
        this.movieSelection = new MovieSelection();
    }
    void streamMovie(String u, String m){
        if(userAccount.checkSubscription(u)){
            movieSelection.selectMovie(m);
        }
    }
}

class Main{
    public static void main(String[] args) {
        StreamingFacade facade = new StreamingFacade();
        facade.streamMovie("user1", "movie1");
    }
}