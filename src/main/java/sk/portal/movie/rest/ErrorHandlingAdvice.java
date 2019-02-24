package sk.portal.movie.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import sk.portal.movie.exception.ErrorMessage;
import sk.portal.movie.exception.NotFoundException;

@RestControllerAdvice
public class ErrorHandlingAdvice {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ErrorMessage> notFound(NotFoundException notFoundException, WebRequest webRequest) {
		return new ResponseEntity<>(new ErrorMessage(notFoundException.getMessage()), HttpStatus.NOT_FOUND);
	}

}
