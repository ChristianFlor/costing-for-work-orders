package customExceptions;

public class NegativeNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The string that is to be tested by the exception.
	 */
	private double value;
	/**
	 * The string message that the exception shows.
	 */
	private String customMessage;

	public NegativeNumberException(double value) {
		super("El valor : "+value+" es negativo");
		this.value=value;
		customMessage= decideMessageNNE();
	}
	/**
	 * <b>Description:</b>
	 * This function obtains this exception's custom message.
	 * @return This exception's custom message.
	 */
	public String getCustomMessage() {
		return customMessage;
	}

	/**
	 * <b>Description:</b>
	 * This function determines the custom message that is to be shown.
	 * @return The string representing the custom message.
	 */
	public String decideMessageNNE() {
		if(value <0 ) {
			customMessage = "Enter valid number";
		}else {
			customMessage ="Please enter the required values";
		}
		return customMessage;
	}
}
