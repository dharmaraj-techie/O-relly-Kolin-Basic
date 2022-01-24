package tipbit;

public class NotANumberException extends Throwable {

}

class Main {
    public static void main(String[] args){
        System.out.println("hello world");
        try {
            checkIsNumberException();
        } catch (NotANumberException e) {
            e.printStackTrace();
        }
    }

    static void checkIsNumberException() throws NotANumberException {
       throw  new NotANumberException();
    }
}