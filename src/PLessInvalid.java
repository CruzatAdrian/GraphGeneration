

public class PLessInvalid extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "p must be between 0 and 1";
	}

}
