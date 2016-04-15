

public class FileNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage(){
		return "Input file not found";
	}
}
