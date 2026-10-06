package ProyectoFinal2_B.ApiFinalBoss.reponse;

public class ApiResponse <T>{

    private boolean sucess;
    private String message;
    private T data;

    public ApiResponse(boolean sucess, String message, T data) {
        this.sucess = sucess;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(boolean sucess, String message) {
        this.sucess = sucess;
        this.message = message;
    }
}
