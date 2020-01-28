package ndps.student.jungle.work.utils;//FINI


public class IllegalRequestException extends Exception {

    public IllegalRequestException(String message) {
        super("Requête illégale "+message);
    }
}
