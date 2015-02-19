package cu.cs.cpsc372.mainProject;

public class GameServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameServiceException() {

	  }

	  public GameServiceException(String message) {
	    super(message);
	  }

	  public GameServiceException(Throwable cause) {
	    super(cause);
	  }

	  public GameServiceException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  public GameServiceException(String message, Throwable cause,
	      boolean enableSuppression, boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }
	
}
