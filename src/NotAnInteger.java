

public class NotAnInteger extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "n and seed must be integers";
	}
}
