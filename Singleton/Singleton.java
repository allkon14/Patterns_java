final class Captain {
    private static Captain captain;
    private Captain() { }
    public static synchronized Captain getCaptain() {
        if (captain == null) {
            captain = new Captain();
            System.out.println("\tA new captain is elected for your team.");
        }
        else {
            System.out.println("\tYou already have a captain for your team.");
            System.out.println("\tSend him for the toss.");
        }
        return captain;
    }
}

class Singleton {
    public static void main(String[] args) {
        System.out.println("Trying to make a captain for your team.");
        Captain captain1 = Captain.getCaptain();
        System.out.println("Trying to make another captain for your team:");
        //Captain captain2 = new Captain();  ОШИБКА КОМПИЛЯЦИИ
        Captain captain2 = Captain.getCaptain();
        if (captain1 == captain2){
            System.out.println("Both captain1 and captain2 are the same.");
        }
    }
}
