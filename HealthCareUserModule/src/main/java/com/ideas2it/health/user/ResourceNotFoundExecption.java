package com.ideas2it.health.user;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "UserNotFound")
public class ResourceNotFoundExecption extends RuntimeException {
	private static final long serialVersionUID = -3043362665032549831L;

	public ResourceNotFoundExecption(String string) {
	}

	public String ResourceNotFoundExecption(String message) {
		return message + " User NotFound in Database";
	}
}
