package com.vaidy.billing.exception;

public class AccountRegistrationException extends ApiException {
	public AccountRegistrationException() {
		super();
	}

	public AccountRegistrationException(String message) {
		super(message);
	}

	public AccountRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountRegistrationException(Throwable cause) {
		super(cause);
	}
}
