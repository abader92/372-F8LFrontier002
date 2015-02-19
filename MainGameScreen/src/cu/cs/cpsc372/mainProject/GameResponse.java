package cu.cs.cpsc372.mainProject;

public class GameResponse {

	protected boolean isSuccess;

	  protected String errorMsg;
	  
	  public GameResponse() {
	    isSuccess = true;
	  }
	  
	  public GameResponse(String errorMsg) {
	    isSuccess = false;
	    this.errorMsg = errorMsg;
	  }
	  
	  public boolean isSuccess() {
	    return isSuccess;
	  }
	  
	  public void setSuccess(boolean isSuccess) {
	    this.isSuccess = isSuccess;
	  }
	  
	  public String getErrorMsg() {
	    return errorMsg;
	  }
	  
	  public void setErrorMsg(String errorMsg) {
	    this.errorMsg = errorMsg;
	  }
	
}
