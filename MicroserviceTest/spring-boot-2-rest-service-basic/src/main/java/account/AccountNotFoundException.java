package account;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		// Do Nothing
	}

	public AccountNotFoundException(String arg0) {
		super(arg0);
	}

	public AccountNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public AccountNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AccountNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
